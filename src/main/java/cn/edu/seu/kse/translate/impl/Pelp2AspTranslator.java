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
 * TODO:
 * Created by 张舒韬 on 2017/3/31.
 */
public class Pelp2AspTranslator implements ProgramTranslator {
    @Override
    public Set<ObjectModel> translate(ObjectModel objectModel) throws TranslateErrorException {
        Set<ObjectModel> result = new HashSet<>();
        if (objectModel instanceof PelpProgram) {
            result.add(translateProgram(objectModel));
        } else if (objectModel instanceof PelpRule) {
            result.add(translateRule((PelpRule) objectModel));
        } else {
            throw new TranslateErrorException("翻译" + objectModel +"错误：" + objectModel.getClass().getName() + " 不是一个可翻译的类型");
        }
        return result;
    }

    @Override
    public ObjectModel translateProgram(ObjectModel program) throws TranslateErrorException {
        if (program instanceof PelpProgram) {
            PelpProgram pelpProgram = (PelpProgram) program;
            Set<AspRule> aspRules = new HashSet<>();
            pelpProgram.getRules().forEach(rule -> aspRules.add(translateRule(rule)));
            try {
                return removeEpistemicSelectBody(new AspProgram(aspRules));
            } catch (IOException | UnsupportedOsTypeException e) {
                Logger.warn("程序实例化出错：{}", e);
                throw new TranslateErrorException(e.getMessage());
            }
        } else {
            throw new TranslateErrorException("翻译" + program +"错误：" + program.getClass().getName() + " 不是一个可翻译的类型");
        }
    }

    private AspRule translateRule(PelpRule pelpRule) {
        if (pelpRule.isSoft()) {
            return translateWeightedRule(pelpRule);
        } else {
            return translateUnweightedRule(pelpRule);
        }
    }

    private AspRule translateWeightedRule(PelpRule pelpRule) {
        List<AspLiteral> constrainBody = new ArrayList<>();
        PelpObjectiveLiteral satLiteral = (PelpObjectiveLiteral) pelpRule.getBody().get(0);
        constrainBody.add(translateObjectiveLiteral(satLiteral));
        return new AspRule(constrainBody, (int)(pelpRule.getWeight() * 1000), 1, translateLiteralParam(satLiteral.getParams()));
    }

    private AspRule translateUnweightedRule(PelpRule pelpRule) {
        List<AspLiteral> head = new ArrayList<>();
        pelpRule.getHead().forEach(literal -> head.add(translateObjectiveLiteral(literal)));

        List<AspLiteral> body = new ArrayList<>();
        pelpRule.getBody().forEach(literal -> {
            if (literal instanceof PelpObjectiveLiteral) {
                body.add(translateObjectiveLiteral((PelpObjectiveLiteral) literal));
            } else if (literal instanceof PelpRelation) {
                body.add(translateRelation((PelpRelation) literal));
            }
        });
        return new AspRule(head, body);
    }

    private AspRelation translateRelation(PelpRelation pelpRelation) {
        return new AspRelation(translateLiteralParam(pelpRelation.getLeft()), pelpRelation.getOperator(), translateLiteralParam(pelpRelation.getRight()));
    }

    private AspLiteral translateObjectiveLiteral(PelpObjectiveLiteral literal) {
        return new AspLiteral(literal.getNafCount(), literal.isNegation(), literal.getPredicate(), translateLiteralParam(literal.getParams()));
    }

    private List<AspParam> translateLiteralParam(Collection<PelpParam> params) {
        List<AspParam> aspParams = new ArrayList<>();
        params.forEach(pelpParam -> aspParams.add(translateLiteralParam(pelpParam)));
        return aspParams;
    }

    private AspParam translateLiteralParam(PelpParam param) {
        if (param.getType() == PelpParam.LITERAL) {
            AspLiteral literal = translateObjectiveLiteral((PelpObjectiveLiteral) param.getValue());
            return new AspParam(AspParam.LITERAL, literal);
        } else {
            return new AspParam(param.getType(), param.getText());
        }
    }

    private boolean isEpistemicSelectRule(AspRule rule) {
        if (rule.getHead().size() == 2) {
            AspLiteral literal0 = rule.getHead().get(0);
            AspLiteral literal1 = rule.getHead().get(1);
            return ((literal0.getPredicate().startsWith("_k") || literal0.getPredicate().startsWith("_pl"))
                    && literal0.getPredicate().equals(literal1.getPredicate()) && literal0.getParams().equals(literal1.getParams()));
        }
        return false;
    }

    private AspProgram removeEpistemicSelectBody(AspProgram originAsp) throws IOException, UnsupportedOsTypeException {
        File programFile = File.createTempFile("pelpTemp", ".lp");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(programFile)));
        writer.write(originAsp.toString());
        writer.flush();
        writer.close();

        List<String> params = Arrays.asList("--mode=gringo", "--text", "--lparse-rewrite", programFile.getAbsolutePath());
        CommandLineOutput output = CommandLineExecute.callShell("clingo", params);
        programFile.deleteOnExit();

        originAsp.getRules().removeIf(this::isEpistemicSelectRule);

        String[] lines = output.getOutput().split(System.lineSeparator());
        for (String line : lines) {
            if (!line.contains("#") && !line.isEmpty()) {
                try {
                    AspRule rule  = AspSyntaxParser.parseRule(line);
                    if (isEpistemicSelectRule(rule)) {
                        rule.setBody(new ArrayList<>());
                        originAsp.getRules().add(rule);
                    }
                } catch (SyntaxErrorException e) {
                    Logger.info("实例化语法错误：", e);
                }
            }
        }
        return originAsp;
    }
}
