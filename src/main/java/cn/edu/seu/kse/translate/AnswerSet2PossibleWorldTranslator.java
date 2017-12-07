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
 * translate an answer set into a possible world
 *
 * @author 张舒韬
 * @date 2017/2/9
 */
public class AnswerSet2PossibleWorldTranslator {
    private final static String SUB_PREFIX = "_";
    private final static String PROB_SUB_PREFIX = "_k";
    private final static String REL_SUB_PREFIX = "_pl";

    public PossibleWorld translate(AnswerSet answerSet) {
        Set<PelpObjectiveLiteral> pelpLiterals = new HashSet<>();
        answerSet.getLiterals().forEach(aspLiteral -> {
            if (!aspLiteral.getPredicate().startsWith(SUB_PREFIX)) {
                pelpLiterals.add(translateLiteral(aspLiteral));
            }
        });
        return new PossibleWorld(pelpLiterals, answerSet.getWeight() * 0.001);
    }

    public Set<BasePelpSubjective> getSupportedEpistemic(AnswerSet answerSet) {
        Set<BasePelpSubjective> supportedEpistemic = new HashSet<>();
        answerSet.getLiterals().forEach(aspLiteral -> {
            if (aspLiteral.getPredicate().startsWith(PROB_SUB_PREFIX) &&!aspLiteral.isNegation()) {
                supportedEpistemic.add(translateEpistemic(aspLiteral));
            } else if (aspLiteral.getPredicate().startsWith(REL_SUB_PREFIX) && !aspLiteral.isNegation()) {
                supportedEpistemic.add(translateProbRelation(aspLiteral));
            }
        });
        return supportedEpistemic;
    }

    public Set<BasePelpSubjective> getNotSupportedEpistemic(AnswerSet answerSet) {
        Set<BasePelpSubjective> notSupportedEpistemic = new HashSet<>();
        answerSet.getLiterals().forEach(aspLiteral -> {
            if (aspLiteral.getPredicate().startsWith(PROB_SUB_PREFIX) && aspLiteral.isNegation()) {
                notSupportedEpistemic.add(translateEpistemic(aspLiteral));
            } else if (aspLiteral.getPredicate().startsWith(REL_SUB_PREFIX) && aspLiteral.isNegation()) {
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
