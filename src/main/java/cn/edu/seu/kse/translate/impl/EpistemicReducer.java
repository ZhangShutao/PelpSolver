package cn.edu.seu.kse.translate.impl;

import cn.edu.seu.kse.model.ObjectModel;
import cn.edu.seu.kse.model.asp.AspLiteral;
import cn.edu.seu.kse.model.asp.AspParam;
import cn.edu.seu.kse.model.asp.AspRule;
import cn.edu.seu.kse.model.pelp.*;
import cn.edu.seu.kse.translate.ModelTranslator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 主观字的消除
 * Created by 张舒韬 on 2017/1/18.
 */
public class EpistemicReducer implements ModelTranslator {
    @Override
    public Set<ObjectModel> translate(ObjectModel objectModel) {
        return null;
    }

    @Override
    public ObjectModel translateProgram(ObjectModel program) {
        return null;
    }

    private Set<AspRule> getEpistemicSelectRules(PelpRule rule) {
        Set<AspRule> selectRules = new HashSet<>();

        List<AspLiteral> positiveBody = new ArrayList<>();
        rule.getPositiveBody().forEach(pelpLiteral -> {
            if (pelpLiteral instanceof PelpObjectiveLiteral) {
                positiveBody.add(translateObjectiveLiteral((PelpObjectiveLiteral) pelpLiteral));
            }
        });

        rule.getSubjectiveLiterals().forEach(literal -> {
            List<AspLiteral> fact = new ArrayList<>();
            fact.add(translateSubjectiveLiteral(literal));
            fact.add(getNegativeEpistemicLiteral(literal));

            List<AspLiteral> condition = new ArrayList<>();
            if (literal.isEpistemicConfirm()) {
                condition.add(translateObjectiveLiteral(literal.getObjectiveLiteral()));
            } else {
                condition.addAll(positiveBody);
            }

            selectRules.add(new AspRule(fact, condition));
        });

        return selectRules;
    }

    private Set<AspRule> replaceEpistemicLiteral(PelpRule rule) {
        Set<AspRule> rules = new HashSet<>();

        List<AspLiteral> head = new ArrayList<>();
        rule.getHead().forEach(literal -> head.add(translateObjectiveLiteral(literal)));

        List<AspLiteral> commonBody = new ArrayList<>();
        rule.getBody().forEach(literal -> {
            if (literal instanceof PelpObjectiveLiteral) {
                commonBody.add(translateObjectiveLiteral((PelpObjectiveLiteral) literal));
            } else if (literal instanceof PelpSubjectiveLiteral) {
                commonBody.add(translateSubjectiveLiteral((PelpSubjectiveLiteral) literal));
                if (((PelpSubjectiveLiteral) literal).isEpistemicDeny()) {
                    AspLiteral translatedLiteral = translateSubjectiveLiteral((PelpSubjectiveLiteral) literal);
                    translatedLiteral.setNafCount(1);
                    commonBody.add(translatedLiteral);
                }
            }
        });

        List<PelpSubjectiveLiteral> subjectiveLiterals = new ArrayList<>();
        rule.getSubjectiveLiterals().forEach(subjectiveLiteral -> {
            if (!subjectiveLiteral.isEpistemicConfirm() && !subjectiveLiteral.isEpistemicDeny()) {
                subjectiveLiterals.add(subjectiveLiteral);
            }
        });

        for (int i = 0; i != 1 << subjectiveLiterals.size(); ++i) {
            List<AspLiteral> body = new ArrayList<>();
            body.addAll(commonBody);
            for (int j = 0, k = i; j != subjectiveLiterals.size(); ++j, k >>= 1) {
                AspLiteral literal = translateObjectiveLiteral(subjectiveLiterals.get(j).getObjectiveLiteral());
                if ((k & 1) == 1) {
                    literal.setNafCount(1);
                }
                body.add(literal);
            }
            rules.add(new AspRule(head, body));
        }

        return rules;
    }

    private AspLiteral translateSubjectiveLiteral(PelpSubjectiveLiteral literal) {
        String predicateStr = "_k" +
                (literal.isLeftClose() ? "c" : "o") +
                (literal.isRightClose() ? "c" : "o") +
                (int) (literal.getLeftBound() * 1000) +
                (int) (literal.getRightBound() * 1000) +
                (literal.isNegation() ? "f" : "t") +
                literal.getPredicate();
        return new AspLiteral(0, false, predicateStr, translateLiteralParam(literal.getParams()));
    }

    private AspLiteral translateObjectiveLiteral(PelpObjectiveLiteral literal) {
        return new AspLiteral(literal.isNaf() ? 1 : 0, literal.isNegation(), literal.getPredicate(), translateLiteralParam(literal.getParams()));
    }

    private AspLiteral getNegativeEpistemicLiteral(PelpSubjectiveLiteral literal) {
        AspLiteral negativeLiteral = translateSubjectiveLiteral(literal);
        literal.setNegation(true);
        return negativeLiteral;
    }

    private List<AspParam> translateLiteralParam(List<PelpParam> params) {
        List<AspParam> aspParams = new ArrayList<>();
        params.forEach(pelpParam -> aspParams.add(new AspParam(pelpParam.getType(), pelpParam.getText())));
        return aspParams;
    }
}
