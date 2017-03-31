package cn.edu.seu.kse.translate.impl;

import cn.edu.seu.kse.exception.TranslateErrorException;
import cn.edu.seu.kse.model.ObjectModel;
import cn.edu.seu.kse.model.pelp.*;
import cn.edu.seu.kse.translate.ProgramTranslator;
import cn.edu.seu.kse.util.Logger;

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
        } else {
            throw new TranslateErrorException(objectModel.getClass().getName() + "不是一个可以翻译的类型");
        }
        return result;
    }

    @Override
    public ObjectModel translateProgram(ObjectModel program) throws TranslateErrorException {
        Logger.debug("reducing subjective literals...\n{}", program.toString());
        Set<PelpRule> rules = new HashSet<>();
        ((PelpProgram) program).getRules().forEach(pelpRule -> {
            rules.add(replaceEpistemicLiteral(pelpRule));
            rules.addAll(getEpistemicSelectRules(pelpRule));
        });

        rules.addAll(generateMixEpistemicRule((PelpProgram) program));

        return new PelpProgram(new ArrayList<>(rules));
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

    private Set<PelpRule> generateMixEpistemicRule(PelpProgram program) {
        Set<PelpRule> rules = new HashSet<>();
        getAllSubjectiveLiteralInProgram(program).forEach(subjectiveLiteral -> {
            if (subjectiveLiteral.isKco01() || subjectiveLiteral.isKoc01()) {
                rules.addAll(generateMixEpistemicRule(subjectiveLiteral));
            }
        });
        return rules;
    }

    private Set<PelpRule> generateMixEpistemicRule(PelpSubjectiveLiteral subjectiveLiteral) {
        Set<PelpRule> rules = new HashSet<>();

        List<PelpObjectiveLiteral> mixHead = Collections.singletonList(generateMixSubjectiveLiteral(subjectiveLiteral));

        List<PelpLiteral> positiveBody = Collections.singletonList(translateSubjectiveLiteral(subjectiveLiteral));
        rules.add(new PelpRule(mixHead, positiveBody));

        List<PelpLiteral> negativeBody = new ArrayList<>();

        PelpObjectiveLiteral negation = translateSubjectiveLiteral(subjectiveLiteral);
        negation.setNegation(true);
        negativeBody.add(negation);

        PelpObjectiveLiteral addition = new PelpObjectiveLiteral(subjectiveLiteral.getObjectiveLiteral());
        addition.setNafCount(addition.getNafCount() + (subjectiveLiteral.isKco01() ? 1 : 2));
        negativeBody.add(addition);

        rules.add(new PelpRule(mixHead, negativeBody));

        return rules;
    }

    private Set<PelpRule> getEpistemicSelectRules(PelpRule rule) {
        Set<PelpRule> selectRules = new HashSet<>();

        List<PelpLiteral> positiveBody = new ArrayList<>(rule.getPositiveBody());

        rule.getSubjectives().forEach(literal -> {
            List<PelpObjectiveLiteral> fact = new ArrayList<>();
            PelpObjectiveLiteral replacedLiteral;
            if (literal instanceof PelpSubjectiveLiteral) {
                replacedLiteral = translateSubjectiveLiteral((PelpSubjectiveLiteral) literal);
            } else {
                replacedLiteral = translateProbRelation((PelpProbRelation) literal);
            }
            fact.add(replacedLiteral);
            fact.add(getInverseLiteral(replacedLiteral));

            selectRules.add(new PelpRule(fact, positiveBody));
        });

        return selectRules;
    }

    private PelpRule replaceEpistemicLiteral(PelpRule rule) {
        List<PelpLiteral> body = new ArrayList<>();
        rule.getBody().forEach(pelpLiteral -> {
            if (pelpLiteral instanceof PelpSubjectiveLiteral) {
                PelpSubjectiveLiteral subjectiveLiteral = (PelpSubjectiveLiteral) pelpLiteral;

                if (subjectiveLiteral.isKco01() || subjectiveLiteral.isKoc01()) {
                    body.add(generateMixSubjectiveLiteral(subjectiveLiteral)); // 添加ekwo
                } else {
                    body.add(translateSubjectiveLiteral(subjectiveLiteral)); // 添加 kwo
                }

                if (subjectiveLiteral.isKcc11()) { // 添加 o
                    body.add(subjectiveLiteral.getObjectiveLiteral());
                } else if (subjectiveLiteral.isKcc00()) { // 添加 not o
                    PelpObjectiveLiteral addLiteral = new PelpObjectiveLiteral(subjectiveLiteral.getObjectiveLiteral());
                    addLiteral.setNafCount(addLiteral.getNafCount() + 1);
                    body.add(addLiteral);
                }
            } else if (pelpLiteral instanceof PelpProbRelation) {
                body.add(translateProbRelation((PelpProbRelation) pelpLiteral));
            } else {
                body.add(pelpLiteral);
            }
        });

        PelpRule replaced = new PelpRule(rule.getHead(), body, rule.getWeight());
        replaced.setId(rule.getId());
        return replaced;
    }

    private PelpParam translateLiteralAsParam(PelpObjectiveLiteral pelpLiteral) {
        PelpObjectiveLiteral paramLiteral = new PelpObjectiveLiteral(pelpLiteral);
        String predicateStr = String.format("_f%1d%c%s",
                pelpLiteral.getNafCount(),
                (pelpLiteral.isNegation() ? 'f' : 't'),
                pelpLiteral.getPredicate());
        paramLiteral.setPredicate(predicateStr);

        paramLiteral.setNafCount(0);
        paramLiteral.setNegation(false);

        return new PelpParam(PelpParam.LITERAL, paramLiteral);
    }

    /**
     * 翻译概率关系
     * @param probRelation PELP中的概率关系
     * @return 对应的ASP字
     */
    private PelpObjectiveLiteral translateProbRelation(PelpProbRelation probRelation) {
        PelpParam left = translateLiteralAsParam(probRelation.getLeft());
        PelpParam right = translateLiteralAsParam(probRelation.getRight());
        return new PelpObjectiveLiteral(0, false, "_pl", Arrays.asList(left, right));
    }

    /**
     * 翻译概率认知
     * @param literal PELP中形如KwO的字
     * @return 对应的ASP字
     */
    private PelpObjectiveLiteral translateSubjectiveLiteral(PelpSubjectiveLiteral literal) {
        String predicateStr = String.format("_k%s%s%04d%04d%c%c%s",
                (literal.isLeftClose() ? 'c' : 'o'),
                (literal.isRightClose() ? 'c' : 'o'),
                (int) (literal.getLeftBound() * 1000),
                (int) (literal.getRightBound() * 1000),
                (literal.getObjectiveLiteral().isNaf() ? 'f' : 't'),
                (literal.getObjectiveLiteral().isNegation() ? 'f' : 't'),
                literal.getObjectiveLiteral().getPredicate());
        return new PelpObjectiveLiteral(0, false, predicateStr, literal.getObjectiveLiteral().getParams());
    }

    private PelpObjectiveLiteral getInverseLiteral(PelpObjectiveLiteral literal) {
        return new PelpObjectiveLiteral(literal.getNafCount(), !literal.isNegation(), literal.getPredicate(), literal.getParams());
    }

    private PelpObjectiveLiteral generateMixSubjectiveLiteral(PelpSubjectiveLiteral literal) {
        PelpObjectiveLiteral mixLiteral = translateSubjectiveLiteral(literal);
        mixLiteral.setPredicate("_m" + mixLiteral.getPredicate().substring(1));
        return mixLiteral;
    }

}
