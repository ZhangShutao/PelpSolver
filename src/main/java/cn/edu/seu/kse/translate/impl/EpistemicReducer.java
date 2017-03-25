package cn.edu.seu.kse.translate.impl;

import cn.edu.seu.kse.model.ObjectModel;
import cn.edu.seu.kse.model.asp.*;
import cn.edu.seu.kse.model.pelp.*;
import cn.edu.seu.kse.translate.ProgramTranslator;
import cn.edu.seu.kse.util.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * 主观字的消除
 * Created by 张舒韬 on 2017/1/18.
 */
public class EpistemicReducer implements ProgramTranslator {

    @Override
    public Set<ObjectModel> translate(ObjectModel objectModel) {
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
    public ObjectModel translateProgram(ObjectModel program) {
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

        rules.addAll(generateEpistemicConstrain((PelpProgram) program));

        AspProgram result = new AspProgram(new ArrayList<>(rules));
        Logger.debug("subjective literal reducing finished.\n{}", result.toString());
        return result;
    }

    private AspRule getEpistemicConstrain(PelpSubjectiveLiteral literal, boolean negation, Integer addNaf) {
        AspLiteral aspLiteral = translateSubjectiveLiteral(literal);
        aspLiteral.setNegation(negation);
        AspLiteral constrain = translateObjectiveLiteral(literal.getObjectiveLiteral());
        constrain.setNafCount(constrain.getNafCount() + addNaf);
        return new AspRule(new ArrayList<>(), Arrays.asList(aspLiteral, constrain));
    }

    public Set<AspRule> generateEpistemicConstrain(PelpProgram program) {
        Set<AspRule> constrainRules = new HashSet<>();

        try {
            Object[][] invokeList = {{PelpSubjectiveLiteral.class.getMethod("isKcc00"), false, 0},
                                     {PelpSubjectiveLiteral.class.getMethod("isKcc11"), true, 1},
                                     {PelpSubjectiveLiteral.class.getMethod("isKco01"), true, 1},
                                     {PelpSubjectiveLiteral.class.getMethod("isKoc01"), false, 2}};

            for (Object[] invokeItem : invokeList) {
                program.getRules().forEach(rule -> {
                    for (PelpLiteral literal : rule.getBody() ){
                        try {
                            if (literal instanceof PelpSubjectiveLiteral && (boolean) ((Method)invokeItem[0]).invoke(literal)) {
                                constrainRules.add(getEpistemicConstrain((PelpSubjectiveLiteral) literal, (boolean)invokeItem[1], (int)invokeItem[2]));
                            }
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            Logger.warn("反射调用出错：{}", e);
                        }
                    }
                });
            }
        } catch (NoSuchMethodException e) {
            Logger.warn("反射方法查询出错：{}", e);
        }
        return constrainRules;
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
                body.add(translateSubjectiveLiteral((PelpSubjectiveLiteral)pelpLiteral)); // 添加 kwo
                if (((PelpSubjectiveLiteral) pelpLiteral).isKcc11()) { // 添加 o
                    body.add(translateObjectiveLiteral(((PelpSubjectiveLiteral) pelpLiteral).getObjectiveLiteral()));
                } else if (((PelpSubjectiveLiteral) pelpLiteral).isKcc00()) { // 添加 not o
                    AspLiteral addLiteral = translateObjectiveLiteral(((PelpSubjectiveLiteral) pelpLiteral).getObjectiveLiteral());
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
}
