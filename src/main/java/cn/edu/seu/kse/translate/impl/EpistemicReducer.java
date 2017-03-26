package cn.edu.seu.kse.translate.impl;

import cn.edu.seu.kse.exception.SyntaxErrorException;
import cn.edu.seu.kse.exception.TranslateErrorException;
import cn.edu.seu.kse.exception.UnsupportedOsTypeException;
import cn.edu.seu.kse.model.CommandLineOutput;
import cn.edu.seu.kse.model.ObjectModel;
import cn.edu.seu.kse.model.asp.*;
import cn.edu.seu.kse.model.pelp.*;
import cn.edu.seu.kse.syntax.parser.AspSyntaxParser;
import cn.edu.seu.kse.translate.ProgramTranslator;
import cn.edu.seu.kse.util.CommandLineExecute;
import cn.edu.seu.kse.util.Logger;

import java.io.*;
import java.util.*;

/**
 * 主观字的消除
 * Created by 张舒韬 on 2017/1/18.
 */
public class EpistemicReducer implements ProgramTranslator {

    @Override
    public Set<ObjectModel> translate(ObjectModel objectModel) throws TranslateErrorException {
        Set<ObjectModel> result = new HashSet<>();
        if (objectModel instanceof PelpProgram) {
            result.add(translateProgram(objectModel));
        } else if (objectModel instanceof PelpRule) {
            PelpRule pelpRule = (PelpRule) objectModel;
            if (pelpRule.isSoft()) {
                result.add(translateSoftConstrain(pelpRule));
            } else {
                result.add(replaceEpistemicLiteral(pelpRule));
            }
            result.addAll(getEpistemicSelectRules(pelpRule));
        } else {
            result.add(objectModel);
        }
        return result;
    }

    @Override
    public ObjectModel translateProgram(ObjectModel program) throws TranslateErrorException {
        Logger.debug("reducing subjective literals...\n{}", program.toString());
        Set<AspRule> rules = new HashSet<>();
        ((PelpProgram) program).getRules().forEach(pelpRule -> {
            if (pelpRule.isSoft()) {
                rules.add(translateSoftConstrain(pelpRule));
            } else {
                rules.add(replaceEpistemicLiteral(pelpRule));
            }
            rules.addAll(getEpistemicSelectRules(pelpRule));
        });

        rules.addAll(generateMixEpistemicRule((PelpProgram) program));

        AspProgram ungroundedProgram = new AspProgram(new ArrayList<>(rules));
        try {
            AspProgram result = removeEpistemicSelectBody(ungroundedProgram);
            Logger.debug("subjective literal reducing finished.\n{}", result);
            return result;
        } catch (IOException | UnsupportedOsTypeException e) {
            Logger.warn("程序实例化出错：{}", e);
            throw new TranslateErrorException(e.getMessage());
        }
    }

    private AspRule getEpistemicConstrain(PelpSubjectiveLiteral literal, boolean negation, Integer addNaf) {
        AspLiteral aspLiteral = translateSubjectiveLiteral(literal);
        aspLiteral.setNegation(negation);
        AspLiteral constrain = translateObjectiveLiteral(literal.getObjectiveLiteral());
        constrain.setNafCount(constrain.getNafCount() + addNaf);
        return new AspRule(new ArrayList<>(), Arrays.asList(aspLiteral, constrain));
    }

    private Set<PelpSubjectiveLiteral> getAllSubjectiveLiteralInProgram(PelpProgram program) {
        Set<PelpSubjectiveLiteral> subjectiveLiterals = new HashSet<>();
        program.getRules().forEach(rule ->
                rule.getBody().forEach(literal -> {
                    if (literal instanceof PelpSubjectiveLiteral) {
                        subjectiveLiterals.add((PelpSubjectiveLiteral) literal);
                    }
                })
        );
        return subjectiveLiterals;
    }

    private Set<AspRule> generateMixEpistemicRule(PelpProgram program) {
        Set<AspRule> rules = new HashSet<>();
        getAllSubjectiveLiteralInProgram(program).forEach(subjectiveLiteral -> {
            if (subjectiveLiteral.isKco01() || subjectiveLiteral.isKoc01()) {
                rules.addAll(generateMixEpistemicRule(subjectiveLiteral));
            }
        });
        return rules;
    }

    private Set<AspRule> generateMixEpistemicRule(PelpSubjectiveLiteral subjectiveLiteral) {
        Set<AspRule> rules = new HashSet<>();

        List<AspLiteral> mixHead = Collections.singletonList(generateMixSubjectiveLiteral(subjectiveLiteral));

        List<AspLiteral> positiveBody = Collections.singletonList(translateSubjectiveLiteral(subjectiveLiteral));
        rules.add(new AspRule(mixHead, positiveBody));

        List<AspLiteral> negativeBody = new ArrayList<>();

        AspLiteral negation = translateSubjectiveLiteral(subjectiveLiteral);
        negation.setNegation(true);
        negativeBody.add(negation);

        AspLiteral addition = translateObjectiveLiteral(subjectiveLiteral.getObjectiveLiteral());
        addition.setNafCount(addition.getNafCount() + (subjectiveLiteral.isKco01() ? 1 : 2));
        negativeBody.add(addition);

        rules.add(new AspRule(mixHead, negativeBody));

        return rules;
    }

    public PelpSubjectiveLiteral translateAllParamAsVariable(PelpSubjectiveLiteral literal) {
        List<PelpParam> params = new ArrayList<>();
        for (Integer i = 0; i != literal.getParams().size(); ++i) {
            params.add(new PelpParam(PelpParam.VARIABLE, "X" + i.toString()));
        }
        return new PelpSubjectiveLiteral(literal.isLeftClose(),
                literal.isRightClose(),
                literal.getLeftBound(),
                literal.getRightBound(),
                new PelpObjectiveLiteral(literal.getNafCount(),
                        literal.isNegation(),
                        literal.getPredicate(),
                        params));
    }

    private List<AspLiteral> translatePositiveBody(PelpRule rule) {
        List<AspLiteral> positiveBody = new ArrayList<>();
        rule.getPositiveBody().forEach(pelpLiteral -> {
            if (pelpLiteral instanceof PelpObjectiveLiteral) {
                positiveBody.add(translateObjectiveLiteral((PelpObjectiveLiteral) pelpLiteral));
            } else if (pelpLiteral instanceof PelpRelation) {
                positiveBody.add(translateRelation((PelpRelation) pelpLiteral));
            }
        });
        return positiveBody;
    }

    private Set<AspRule> getEpistemicSelectRules(PelpRule rule) {
        Set<AspRule> selectRules = new HashSet<>();

        List<AspLiteral> positiveBody = translatePositiveBody(rule);

        rule.getSubjectiveLiterals().forEach(literal -> {
            List<AspLiteral> fact = new ArrayList<>();
            fact.add(translateSubjectiveLiteral(literal));
            fact.add(getNegativeEpistemicLiteral(literal));

            List<AspLiteral> condition = new ArrayList<>();
            if (literal.isKcc11()) {
                condition.add(translateObjectiveLiteral(literal.getObjectiveLiteral()));
            } else if (!literal.getVariableSet().isEmpty()) {
                condition.addAll(positiveBody);
            }

            selectRules.add(new AspRule(fact, condition));
        });

        return selectRules;
    }

    private AspRule replaceEpistemicLiteral(PelpRule rule) {
        List<AspLiteral> head = new ArrayList<>();
        rule.getHead().forEach(pelpLiteral -> head.add(translateObjectiveLiteral(pelpLiteral)));

        List<AspLiteral> body = new ArrayList<>();
        rule.getBody().forEach(pelpLiteral -> {
            if (pelpLiteral instanceof PelpSubjectiveLiteral) {
                PelpSubjectiveLiteral subjectiveLiteral = (PelpSubjectiveLiteral) pelpLiteral;

                if (subjectiveLiteral.isKco01() || subjectiveLiteral.isKoc01()) {
                    body.add(generateMixSubjectiveLiteral(subjectiveLiteral));
                } else {
                    body.add(translateSubjectiveLiteral(subjectiveLiteral)); // 添加 kwo
                }

                if (subjectiveLiteral.isKcc11()) { // 添加 o
                    body.add(translateObjectiveLiteral(subjectiveLiteral.getObjectiveLiteral()));
                } else if (subjectiveLiteral.isKcc00()) { // 添加 not o
                    AspLiteral addLiteral = translateObjectiveLiteral(subjectiveLiteral.getObjectiveLiteral());
                    addLiteral.setNafCount(addLiteral.getNafCount() + 1);
                    body.add(addLiteral);
                }
            } else if (pelpLiteral instanceof PelpObjectiveLiteral) {
                body.add(translateObjectiveLiteral((PelpObjectiveLiteral) pelpLiteral));
            } else if (pelpLiteral instanceof PelpRelation) {
                body.add(translateRelation((PelpRelation) pelpLiteral));
            }
        });

        return new AspRule(head, body);
    }

    private AspLiteral translateSubjectiveLiteral(PelpSubjectiveLiteral literal) {
        String predicateStr = String.format("_k%s%s%04d%04d%c%c%s",
                (literal.isLeftClose() ? 'c' : 'o'),
                (literal.isRightClose() ? 'c' : 'o'),
                (int) (literal.getLeftBound() * 1000),
                (int) (literal.getRightBound() * 1000),
                (literal.isNaf() ? 'f' : 't'),
                (literal.isNegation() ? 'f' : 't'),
                literal.getPredicate());
        return new AspLiteral(0, false, predicateStr, translateLiteralParam(literal.getParams()));
    }

    private AspLiteral generateMixSubjectiveLiteral(PelpSubjectiveLiteral literal) {
        AspLiteral aspLiteral = translateSubjectiveLiteral(literal);
        aspLiteral.setPredicate("_m" + aspLiteral.getPredicate().substring(1));
        return aspLiteral;
    }

    private AspLiteral translateObjectiveLiteral(PelpObjectiveLiteral literal) {
        return new AspLiteral(literal.getNafCount(), literal.isNegation(), literal.getPredicate(), translateLiteralParam(literal.getParams()));
    }

    private AspLiteral getNegativeEpistemicLiteral(PelpSubjectiveLiteral literal) {
        AspLiteral negativeLiteral = translateSubjectiveLiteral(literal);
        negativeLiteral.setNegation(true);
        return negativeLiteral;
    }

    private List<AspParam> translateLiteralParam(Collection<PelpParam> params) {
        List<AspParam> aspParams = new ArrayList<>();
        params.forEach(pelpParam -> aspParams.add(new AspParam(pelpParam.getType(), pelpParam.getText())));
        return aspParams;
    }

    private AspRelation translateRelation(PelpRelation pelpRelation) {
        List<AspParam> params = translateLiteralParam(pelpRelation.getParams());
        return new AspRelation(params.get(0), pelpRelation.getPredicate(), params.get(1));
    }

    private AspRule translateSoftConstrain(PelpRule pelpRule) {
        List<AspLiteral> constrainBody = new ArrayList<>();
        PelpObjectiveLiteral satLiteral = (PelpObjectiveLiteral) pelpRule.getBody().get(0);
        constrainBody.add(translateObjectiveLiteral(satLiteral));
        return new AspRule(constrainBody, (int)(pelpRule.getWeight() * 1000), 1, translateLiteralParam(satLiteral.getParams()));
    }

    private boolean isEpistemicSelectRule(AspRule rule) {
        if (rule.getHead().size() == 2) {
            AspLiteral literal0 = rule.getHead().get(0);
            AspLiteral literal1 = rule.getHead().get(1);
            return (literal0.getPredicate().startsWith("_k") &&literal0.getPredicate().equals(literal1.getPredicate()) && literal0.getParams().equals(literal1.getParams()));
        }
        return false;
    }

    private AspProgram removeEpistemicSelectBody(AspProgram originAsp) throws IOException, UnsupportedOsTypeException {
        File programFile = File.createTempFile("pelpTemp", ".lp");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(programFile)));
        writer.write(originAsp.toString());
        writer.flush();

        List<String> params = Arrays.asList("--mode=gringo", "--text", "--lparse-rewrite", programFile.getAbsolutePath());
        CommandLineOutput output = CommandLineExecute.callShell("clingo", params);
        writer.close();
        if (!programFile.delete()) {
            Logger.warn("删除文件{} 失败。", programFile.getAbsolutePath());
        }

        originAsp.getRules().removeIf(this::isEpistemicSelectRule);

        String[] lines = output.getOutput().split("\n");
        for (String line : lines) {
            if (!line.contains("#")) {
                try {
                    AspRule rule  = AspSyntaxParser.parseRule(line);
                    if (isEpistemicSelectRule(rule)) {
                        rule.setBody(new ArrayList<>());
                        originAsp.getRules().add(rule);
                    }
                } catch (SyntaxErrorException e) {
                    Logger.debug("实例化语法错误：", e);
                }
            }
        }
        return originAsp;
    }
}
