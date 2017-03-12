package cn.edu.seu.kse.translate;

import cn.edu.seu.kse.model.asp.AnswerSet;
import cn.edu.seu.kse.model.asp.AspLiteral;
import cn.edu.seu.kse.model.asp.AspParam;
import cn.edu.seu.kse.model.pelp.PelpObjectiveLiteral;
import cn.edu.seu.kse.model.pelp.PelpParam;
import cn.edu.seu.kse.model.pelp.PelpSubjectiveLiteral;
import cn.edu.seu.kse.model.pelp.PossibleWorld;

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
        Set<PelpSubjectiveLiteral> unsupportedEpistemic = new HashSet<>();
        answerSet.getLiterals().forEach(aspLiteral -> {
            if (!aspLiteral.getPredicate().startsWith("_")) {
                pelpLiterals.add(translateLiteral(aspLiteral));
            }
        });
        return new PossibleWorld(pelpLiterals, answerSet.getWeight() * 0.001);
    }

    public Set<PelpSubjectiveLiteral> getSupportedEpistemic(AnswerSet answerSet) {
        Set<PelpSubjectiveLiteral> supportedEpistemic = new HashSet<>();
        answerSet.getLiterals().forEach(aspLiteral -> {
            if (aspLiteral.getPredicate().startsWith("_k") &&!aspLiteral.isNegation()) {
                supportedEpistemic.add(translateEpistemic(aspLiteral));
            }
        });
        return supportedEpistemic;
    }

    public Set<PelpSubjectiveLiteral> getNotSupportedEpistemic(AnswerSet answerSet) {
        Set<PelpSubjectiveLiteral> notSupportedEpistemic = new HashSet<>();
        answerSet.getLiterals().forEach(aspLiteral -> {
            if (aspLiteral.getPredicate().startsWith("_k") && aspLiteral.isNegation()) {
                notSupportedEpistemic.add(translateEpistemic(aspLiteral));
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
        return new PelpObjectiveLiteral(aspLiteral.getNafCount() == 1,
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
        boolean negative = literalStr.codePointAt(13) == 'f';
        String predicate = literalStr.substring(13);
        PelpObjectiveLiteral objectiveLiteral = new PelpObjectiveLiteral(false, negative, predicate, translateLiteralParams(aspLiteral.getParams()));
        return new PelpSubjectiveLiteral(leftClose, rightClose, leftBound * 0.001, rightBound * 0.001, objectiveLiteral);
    }

    private List<PelpParam> translateLiteralParams(List<AspParam> aspParams) {
        List<PelpParam> pelpParams = new ArrayList<>();
        aspParams.forEach(aspParam -> pelpParams.add(new PelpParam(aspParam.getType(), aspParam.getText())));
        return pelpParams;
    }
}
