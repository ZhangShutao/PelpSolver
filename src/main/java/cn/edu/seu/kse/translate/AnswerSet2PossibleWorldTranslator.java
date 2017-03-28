package cn.edu.seu.kse.translate;

import cn.edu.seu.kse.model.asp.AnswerSet;
import cn.edu.seu.kse.model.asp.AspLiteral;
import cn.edu.seu.kse.model.asp.AspParam;
import cn.edu.seu.kse.model.pelp.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TODO:
 * Created by 张舒韬 on 2017/2/9.
 */
public class AnswerSet2PossibleWorldTranslator {
    public PossibleWorld translate(AnswerSet answerSet) {
        Set<PelpObjectiveLiteral> pelpLiterals = new HashSet<>();
        answerSet.getLiterals().forEach(aspLiteral -> {
            if (!aspLiteral.getPredicate().startsWith("_")) {
                pelpLiterals.add(translateLiteral(aspLiteral));
            }
        });
        return new PossibleWorld(pelpLiterals, answerSet.getWeight() * 0.001);
    }

    public Set<PelpSubjective> getSupportedEpistemic(AnswerSet answerSet) {
        Set<PelpSubjective> supportedEpistemic = new HashSet<>();
        answerSet.getLiterals().forEach(aspLiteral -> {
            if (aspLiteral.getPredicate().startsWith("_k") &&!aspLiteral.isNegation()) {
                supportedEpistemic.add(translateEpistemic(aspLiteral));
            } else if (aspLiteral.getPredicate().startsWith("_pl") && !aspLiteral.isNegation()) {
                supportedEpistemic.add(translateProbRelation(aspLiteral));
            }
        });
        return supportedEpistemic;
    }

    public Set<PelpSubjective> getNotSupportedEpistemic(AnswerSet answerSet) {
        Set<PelpSubjective> notSupportedEpistemic = new HashSet<>();
        answerSet.getLiterals().forEach(aspLiteral -> {
            if (aspLiteral.getPredicate().startsWith("_k") && aspLiteral.isNegation()) {
                notSupportedEpistemic.add(translateEpistemic(aspLiteral));
            } else if (aspLiteral.getPredicate().startsWith("_pl") && aspLiteral.isNegation()) {
                notSupportedEpistemic.add(translateProbRelation(aspLiteral));
            }
        });
        return notSupportedEpistemic;
    }

    public Set<PossibleWorld> translate(Set<AnswerSet> answerSets) {
        Set<PossibleWorld> possibleWorlds = new HashSet<>();
        answerSets.forEach(answerSet -> possibleWorlds.add(translate(answerSet)));
        return possibleWorlds;
    }

    private PelpObjectiveLiteral translateLiteral(AspLiteral aspLiteral) {
        return new PelpObjectiveLiteral(aspLiteral.getNafCount(),
                aspLiteral.isNegation(),
                aspLiteral.getPredicate(),
                translateLiteralParams(aspLiteral.getParams()));
    }

    private PelpSubjectiveLiteral translateEpistemic(AspLiteral aspLiteral) {
        String literalStr = aspLiteral.getPredicate();
        boolean leftClose = literalStr.codePointAt(2) == 'c';
        boolean rightClose = literalStr.codePointAt(3) == 'c';
        int leftBound = Integer.parseInt(literalStr.substring(4, 8));
        int rightBound = Integer.parseInt(literalStr.substring(8, 12));
        boolean naf = literalStr.codePointAt(12) == 'f';
        boolean negative = literalStr.codePointAt(13) == 'f';
        String predicate = literalStr.substring(14);
        PelpObjectiveLiteral objectiveLiteral = new PelpObjectiveLiteral((naf ? 1 : 0), negative, predicate, translateLiteralParams(aspLiteral.getParams()));
        return new PelpSubjectiveLiteral(leftClose, rightClose, leftBound * 0.001, rightBound * 0.001, objectiveLiteral);
    }

    private PelpObjectiveLiteral translateProbRelationParam(AspParam aspParam) {
        AspLiteral aspLiteral;
        if (aspParam.getType() == AspParam.LITERAL) {
            aspLiteral = (AspLiteral) aspParam.getValue();
        } else {
            aspLiteral = new AspLiteral(0, false, (String)aspParam.getValue(), new ArrayList<>());
        }

        String literalStr = aspLiteral.getPredicate();
        int nafCount = Integer.parseInt(literalStr.substring(2, 3));
        boolean negation = literalStr.codePointAt(3) == 'f';
        String predicate = literalStr.substring(4);
        return new PelpObjectiveLiteral(nafCount, negation, predicate, translateLiteralParams(aspLiteral.getParams()));
    }

    private PelpProbRelation translateProbRelation(AspLiteral aspLiteral) {
        return new PelpProbRelation(translateProbRelationParam(aspLiteral.getParams().get(0)), translateProbRelationParam(aspLiteral.getParams().get(1)));
    }

    private List<PelpParam> translateLiteralParams(List<AspParam> aspParams) {
        List<PelpParam> pelpParams = new ArrayList<>();
        aspParams.forEach(aspParam -> pelpParams.add(new PelpParam(aspParam.getType(), aspParam.getValue().toString())));
        return pelpParams;
    }
}
