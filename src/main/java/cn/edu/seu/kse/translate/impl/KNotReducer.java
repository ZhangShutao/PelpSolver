package cn.edu.seu.kse.translate.impl;

import cn.edu.seu.kse.model.ObjectModel;
import cn.edu.seu.kse.model.pelp.*;
import cn.edu.seu.kse.translate.ModelTranslator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 消除主观字中的NAF
 * Created by 张舒韬 on 2017/1/20.
 */
public class KNotReducer implements ModelTranslator {
    @Override
    public Set<ObjectModel> translate(ObjectModel objectModel) {
        Set<ObjectModel> objectModelSet = new HashSet<>();
        if (objectModel instanceof PelpProgram) {
            objectModelSet.add(translateProgram(objectModel));
        } else if (objectModel instanceof PelpRule) {
            objectModelSet.add(translateRule((PelpRule) objectModel));
        } else if (objectModel instanceof PelpSubjectiveLiteral) {
            objectModelSet.add(translateSubjectiveLiteral((PelpSubjectiveLiteral) objectModel));
        } else {
            objectModelSet.add(objectModel);
        }
        return objectModelSet;
    }

    @Override
    public ObjectModel translateProgram(ObjectModel program) {
        List<PelpRule> rules = new ArrayList<>();
        for (PelpRule rule : ((PelpProgram) program).getRules()) {
            translate(rule).forEach(translatedRule -> rules.add((PelpRule) translatedRule));
        }
        return new PelpProgram(rules);
    }

    private PelpRule translateRule(PelpRule rule) {
        List<PelpObjectiveLiteral> head = new ArrayList<>();
        List<PelpLiteral> body = new ArrayList<>();
        rule.getHead().forEach(literal ->
            translate(literal).forEach(translatedLiteral -> head.add(((PelpObjectiveLiteral) translatedLiteral)))
        );
        rule.getBody().forEach(literal ->
            translate(literal).forEach(translatedLiteral -> body.add((PelpLiteral) translatedLiteral))
        );

        PelpRule translatedRule = new PelpRule(head, body, rule.getWeight());
        translatedRule.setId(rule.getId());
        return translatedRule;
    }

    private PelpSubjectiveLiteral translateSubjectiveLiteral(PelpSubjectiveLiteral literal) {
        if (literal.isNaf()) {
            PelpObjectiveLiteral objectiveLiteral = new PelpObjectiveLiteral(false, literal.isNegation(), literal.getPredicate(), literal.getParams());
            return new PelpSubjectiveLiteral(
                    literal.isRightClose(),
                    literal.isLeftClose(),
                    1 - literal.getRightBound(),
                    1 - literal.getLeftBound(),
                    objectiveLiteral
            );
        } else {
            return literal;
        }
    }
}