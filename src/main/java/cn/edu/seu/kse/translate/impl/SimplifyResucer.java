package cn.edu.seu.kse.translate.impl;

import cn.edu.seu.kse.exception.TranslateErrorException;
import cn.edu.seu.kse.model.ObjectModel;
import cn.edu.seu.kse.model.pelp.*;
import cn.edu.seu.kse.translate.ProgramTranslator;

import java.util.*;

/**
 * TODO:
 * Created by 张舒韬 on 2017/5/11.
 */
public class SimplifyResucer implements ProgramTranslator {

    @Override
    public Set<ObjectModel> translate(ObjectModel objectModel) throws TranslateErrorException {
        return null;
    }

    @Override
    public ObjectModel translateProgram(ObjectModel program) throws TranslateErrorException {
        PelpProgram origin = (PelpProgram) program;
        PelpProgram translated = new PelpProgram();
        translated.addRule(new PelpRule(Collections.singletonList(new PelpObjectiveLiteral(0, true, "_false", new ArrayList<>())), new ArrayList<>()));

        origin.getRules().forEach(originRule -> {
            PelpRule rule;

            PelpRule rule1 = reduceKnot(originRule);
            PelpRule rule2 = mergeProbEpisWithSameObjectiveLiterals(rule1);
            if (rule2 != null && !existConflictInBody(rule2)) {
                //PelpRule rule3 = removeConflictHead(rule2);
                rule = removeRedundantBody(rule2);
            } else {
                rule = new PelpRule(originRule.getHead(), getFalseBody());
            }
            rule.setId(originRule.getId());
            rule.setWeight(originRule.getWeight());
            translated.addRule(rule);
        });
        return translated;
    }

    /**
     * 消除规则中的概率认知字Kw not l
     * @param rule
     * @return
     */
    private PelpRule reduceKnot(PelpRule rule) {
        PelpRule translated = new PelpRule();
        translated.setHead(rule.getHead());
        List<PelpLiteral> literals = new ArrayList<>();
        rule.getBody().forEach(literal -> {
            if (literal instanceof PelpSubjectiveLiteral) {
                literals.add(reduceKnot((PelpSubjectiveLiteral) literal));
            } else {
                literals.add(literal);
            }
        });
        translated.setBody(literals);
        translated.setWeight(rule.getWeight());
        return  translated;
    }

    private PelpSubjectiveLiteral reduceKnot(PelpSubjectiveLiteral literal) {
        if (literal.getObjectiveLiteral().isNaf()) {
            PelpObjectiveLiteral objectiveLiteral = new PelpObjectiveLiteral(literal.getObjectiveLiteral());
            objectiveLiteral.setNaf(false);
            return new PelpSubjectiveLiteral(literal.isRightClose(), literal.isLeftClose(),
                    1 - literal.getRightBound(), 1 - literal.getLeftBound(), objectiveLiteral);
        } else {
            return literal;
        }
    }

    private Map<PelpObjectiveLiteral,Set<PelpSubjectiveLiteral>> getProbEpisSetWithSameObjectiveLiterals(PelpRule rule) {
        Map<PelpObjectiveLiteral, Set<PelpSubjectiveLiteral>> groups = new HashMap<>();

        Set<PelpSubjectiveLiteral> probEpisSet = rule.getSubjectiveLiterals();
        List<PelpSubjectiveLiteral> probEpisList = new ArrayList<>(probEpisSet);
        for (int i = 0; i != probEpisList.size(); ++i) {
            PelpSubjectiveLiteral a = probEpisList.get(i);
            if (!groups.containsKey(a.getObjectiveLiteral())) {
                Set<PelpSubjectiveLiteral> set = new HashSet<>();
                set.add(a);
                groups.put(a.getObjectiveLiteral(), set);
            }
            for (int j = i + 1; j != probEpisList.size(); ++j) {
                PelpSubjectiveLiteral b = probEpisList.get(j);
                if (a.getObjectiveLiteral().equals(b.getObjectiveLiteral())) {
                    groups.get(a.getObjectiveLiteral()).add(b);
                }
            }
        }
        return groups;
    }

    private PelpSubjectiveLiteral mergeProbEpis(PelpObjectiveLiteral objectiveLiteral, Set<PelpSubjectiveLiteral> probEpisSet) {
        boolean leftClose = true;
        double leftBound = 0;
        boolean rightClose = true;
        double rightBound = 1;
        for (PelpSubjectiveLiteral literal : probEpisSet) {
            if (literal.getLeftBound() > leftBound) {
                leftBound = literal.getLeftBound();
                leftClose = literal.isLeftClose();
            } else if (literal.getLeftBound() == leftBound && !literal.isLeftClose()) {
                leftClose = false;
            }
            if (literal.getRightBound() < rightBound) {
                rightBound = literal.getRightBound();
                rightClose = literal.isRightClose();
            } else if (literal.getRightBound() == rightBound && !literal.isRightClose()) {
                rightClose = false;
            }
        }
        if (leftBound > rightBound || (leftBound == rightBound && !(leftClose && rightClose))) {
            return null;
        } else {
            return new PelpSubjectiveLiteral(leftClose, rightClose, leftBound, rightBound, objectiveLiteral);
        }
    }

    /**
     * 合并客观字相同的概率认知字，无法合并则返回null
     * @param rule
     * @return
     */
    private PelpRule mergeProbEpisWithSameObjectiveLiterals(PelpRule rule) {
        PelpRule translated = new PelpRule();
        translated.setHead(rule.getHead());
        translated.setWeight(rule.getWeight());
        List<PelpLiteral> translatedBody = new ArrayList<>();
        rule.getBody().forEach(literal -> {
            if (!(literal instanceof PelpSubjectiveLiteral)) {
                translatedBody.add(literal);
            }
        });

        Map<PelpObjectiveLiteral, Set<PelpSubjectiveLiteral>> groups = getProbEpisSetWithSameObjectiveLiterals(rule);
        for (Map.Entry entry : groups.entrySet()) {
            PelpSubjectiveLiteral literal = mergeProbEpis((PelpObjectiveLiteral) entry.getKey(),
                    (Set<PelpSubjectiveLiteral>)entry.getValue());
            if (literal == null) {
                return null;
            } else {
                translatedBody.add(literal);
            }
        }
        translated.setBody(translatedBody);

        return translated;
    }

    private boolean existConflictInBody(PelpRule rule) {
        List<PelpLiteral> literals = new ArrayList<>(rule.getBody());
        for (int i = 0; i != literals.size(); ++i) {
            PelpLiteral a = literals.get(i);
            if (isProbNafNegConflict(a)) {
                return true;
            }
            for (int j = i + 1; j != literals.size(); ++j) {
                PelpLiteral b = literals.get(j);
                if (isWeakNegativeConflict(a, b)
                        || isStrongNegativeConflict(a, b)
                        || isNegEpisConflict(a, b) || isNegEpisConflict(b, a)
                        || isPosEpisConflict(a, b) || isPosEpisConflict(b, a)
                        || isPosNegEpisConflict(a, b) || isPosNegEpisConflict(b, a)
                        || isStrongInverseEpisConflict(a, b)
                        || isProbCompareConflict(a, b)
                        || isLeftProbCNafLessConflict(a, b) || isLeftProbCNafLessConflict(b, a)
                        || isRightProbCNafLessConflict(a, b) || isRightProbCNafLessConflict(b, a)
                        || isProbNafNegLessConflict(a, b) || isProbNafNegLessConflict(b, a)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 两个扩展字相矛盾
     * @param a
     * @param b
     * @return
     */
    private boolean isWeakNegativeConflict(PelpLiteral a, PelpLiteral b) {
        if (a instanceof PelpObjectiveLiteral && b instanceof PelpObjectiveLiteral) {
            PelpObjectiveLiteral literal1 = (PelpObjectiveLiteral) a;
            PelpObjectiveLiteral literal2 = (PelpObjectiveLiteral) b;
            if (literal1.getPredicate().equals(literal2.getPredicate())
                    && literal1.isNegation() == literal2.isNegation()
                    && literal1.getParams().equals(literal2.getParams())
                    && (literal1.getNafCount() ^ literal2.getNafCount()) == 1) {
                return true;
            }
        }
        return false;
    }

    private boolean isStrongNegativeConflict(PelpLiteral a, PelpLiteral b) {
        if (a instanceof PelpObjectiveLiteral && b instanceof PelpObjectiveLiteral) {
            PelpObjectiveLiteral literal1 = (PelpObjectiveLiteral) a;
            PelpObjectiveLiteral literal2 = (PelpObjectiveLiteral) b;
            if (literal1.getPredicate().equals(literal2.getPredicate())
                    && literal1.isNegation() != literal2.isNegation()
                    && literal1.getParams().equals(literal2.getParams())
                    && (literal1.getNafCount() ^ literal2.getNafCount()) == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean isNegEpisConflict(PelpLiteral a, PelpLiteral b) {
        if (a instanceof PelpObjectiveLiteral && b instanceof PelpSubjectiveLiteral) {
            PelpObjectiveLiteral literal1 = (PelpObjectiveLiteral) a;
            PelpSubjectiveLiteral literal2 = (PelpSubjectiveLiteral) b;
            if (literal1.equals(literal2.getObjectiveLiteral())
                    && literal2.isKcc00()) {
                return true;
            }
        }
        return false;
    }

    private boolean isPosEpisConflict(PelpLiteral a, PelpLiteral b) {
        if (a instanceof PelpObjectiveLiteral && b instanceof PelpSubjectiveLiteral) {
            PelpObjectiveLiteral literal1 = (PelpObjectiveLiteral) a;
            PelpSubjectiveLiteral literal2 = (PelpSubjectiveLiteral) b;

            PelpObjectiveLiteral literal3 = new PelpObjectiveLiteral(literal1);
            literal3.setNafCount(0);
            if (literal1.getNafCount() == 1
                    && literal3.equals(literal2.getObjectiveLiteral())
                    && literal2.isKcc11()) {
                return true;
            }
        }
        return false;
    }

    private boolean isPosNegEpisConflict(PelpLiteral a, PelpLiteral b) {
        if (a instanceof PelpObjectiveLiteral && b instanceof PelpSubjectiveLiteral) {
            PelpObjectiveLiteral literal1 = (PelpObjectiveLiteral) a;
            PelpSubjectiveLiteral literal2 = (PelpSubjectiveLiteral) b;
            if (isStrongNegativeConflict(literal1, literal2.getObjectiveLiteral())
                    && literal2.isKcc11()) {
                return true;
            }
        }
        return false;
    }

    private boolean isStrongInverseEpisConflict(PelpLiteral a, PelpLiteral b) {
        if (a instanceof PelpSubjectiveLiteral && b instanceof PelpSubjectiveLiteral) {
            PelpSubjectiveLiteral literal1 = (PelpSubjectiveLiteral) a;
            PelpSubjectiveLiteral literal2 = (PelpSubjectiveLiteral) b;
            if (isStrongNegativeConflict(literal1.getObjectiveLiteral(), literal2.getObjectiveLiteral())) {
                if (literal1.isLeftClose() && literal2.isLeftClose()) {
                    if (simLeq(1 - literal2.getLeftBound(), literal1.getLeftBound()) || simLeq(1 - literal1.getLeftBound(), literal2.getLeftBound())) {
                        return true;
                    }
                } else if (simLess(1 - literal2.getLeftBound(), literal1.getLeftBound()) || simLess(1 - literal1.getLeftBound(), literal2.getLeftBound())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isProbCompareConflict(PelpLiteral a, PelpLiteral b) {
        if (a instanceof PelpProbRelation && b instanceof PelpProbRelation) {
            PelpProbRelation literal1 = (PelpProbRelation) a;
            PelpProbRelation literal2 = (PelpProbRelation) b;
            if (literal1.getLeft().equals(literal2.getRight()) && literal1.getRight().equals(literal2.getLeft())) {
                return true;
            }
        }
        return false;
    }

    private boolean isLeftProbCNafLessConflict(PelpLiteral a, PelpLiteral b) {
        if (a instanceof PelpProbRelation && b instanceof PelpSubjectiveLiteral) {
            PelpProbRelation literal1 = (PelpProbRelation) a;
            PelpSubjectiveLiteral literal2 = (PelpSubjectiveLiteral) b;
            PelpObjectiveLiteral left = literal1.getLeft();
            PelpObjectiveLiteral right = literal1.getRight();
            if (isWeakNegativeConflict(left, right) && right.isNaf()
                    && right.equals(literal2.getObjectiveLiteral())
                    && (simLess(literal2.getRightBound(), 0.5) || (simLeq(literal2.getRightBound(), 0.5) && literal2.isRightClose()))) {
                return true;
            }
        }
        return false;
    }

    private boolean isRightProbCNafLessConflict(PelpLiteral a, PelpLiteral b) {
        if (a instanceof PelpProbRelation && b instanceof PelpSubjectiveLiteral) {
            PelpProbRelation literal1 = (PelpProbRelation) a;
            PelpSubjectiveLiteral literal2 = (PelpSubjectiveLiteral) b;
            PelpObjectiveLiteral left = literal1.getLeft();
            PelpObjectiveLiteral right = literal1.getRight();
            if (isWeakNegativeConflict(left, right) && left.isNaf()
                    && left.equals(literal2.getObjectiveLiteral())
                    && (simLess(0.5, literal2.getLeftBound()) || (simLeq(0.5, literal2.getLeftBound()) && literal2.isLeftClose()))) {
                return true;
            }
        }
        return false;
    }

    private boolean isProbNafNegLessConflict(PelpLiteral a, PelpLiteral b) {
        if (a instanceof PelpProbRelation && b instanceof PelpSubjectiveLiteral) {
            PelpProbRelation literal1 = (PelpProbRelation) a;
            PelpSubjectiveLiteral literal2 = (PelpSubjectiveLiteral) b;
            PelpObjectiveLiteral left = literal1.getLeft();
            PelpObjectiveLiteral right = literal1.getRight();
            if (isWeakNegativeConflict(left, right) && left.isNaf()
                    && isStrongNegativeConflict(right, literal2.getObjectiveLiteral())
                    && simLeq(0.5, literal2.getLeftBound())) {
                return true;
            }
        }
        return false;
    }

    private boolean isProbNafNegConflict(PelpLiteral a) {
        if (a instanceof PelpProbRelation) {
            PelpObjectiveLiteral left = ((PelpProbRelation) a).getLeft();
            PelpObjectiveLiteral right = ((PelpProbRelation) a).getRight();
            if (left.isNaf() && !right.isNaf()
                    && left.isNegation() != right.isNegation()) {
                return true;
            }
        }
        return false;
    }

    private boolean existSelfsupport(PelpRule rule) {
        for (PelpObjectiveLiteral literal : rule.getHead()) {
            PelpSubjectiveLiteral episSelfSupport = new PelpSubjectiveLiteral(true, true, 1, 1, literal);
            if (rule.getBody().contains(literal) || rule.getBody().contains(episSelfSupport)) {
                return true;
            }
        }
        return false;
    }

    private PelpRule removeConflictHead(PelpRule rule) {
        List<PelpObjectiveLiteral> reducedHead = new ArrayList<>();
        for (PelpObjectiveLiteral literal : rule.getHead()) {
            PelpObjectiveLiteral literal1 = new PelpObjectiveLiteral(literal);
            literal1.setNafCount(literal.getNafCount() + 1);
            PelpObjectiveLiteral literal2 = new PelpObjectiveLiteral(literal);
            literal2.setNegation(!literal.isNegation());
            PelpSubjectiveLiteral literal3 = new PelpSubjectiveLiteral(true, true, 0, 0, literal);
            PelpSubjectiveLiteral literal4 = new PelpSubjectiveLiteral(true, true, 1, 1, literal2);
            if (!(rule.getBody().contains(literal1) || rule.getBody().contains(literal2) || rule.getBody().contains(literal3) || rule.getBody().contains(literal4))) {
                reducedHead.add(literal);
            }
        }
        return new PelpRule(reducedHead, rule.getBody());
    }

    private PelpRule removeRedundantBody(PelpRule rule) {
        List<PelpLiteral> reductBody = new ArrayList<>();
        for (PelpLiteral literal: rule.getBody()) {
            if (!existK11Conflict(literal, rule.getBody())
                    && !existK00Conflict(literal, rule.getBody())
                    && !existNafConflict(literal, rule.getBody())
                    && !existPosConflict(literal, rule.getBody())
                    && !existNegNafConflict(literal, rule.getBody())
                    && !existNegK01Conflict(literal, rule.getBody())) {
                reductBody.add(literal);
            }
        }
        return new PelpRule(rule.getHead(), reductBody);
    }

    private boolean existK11Conflict(PelpLiteral literal, List<PelpLiteral> body) {
        if (literal instanceof PelpObjectiveLiteral) {
            PelpSubjectiveLiteral k11 = new PelpSubjectiveLiteral(true, true, 1, 1, (PelpObjectiveLiteral) literal);
            return body.contains(k11);
        }
        return false;
    }

    private boolean existK00Conflict(PelpLiteral literal, List<PelpLiteral> body) {
        if (literal instanceof PelpObjectiveLiteral && ((PelpObjectiveLiteral) literal).getNafCount() > 0) {
            PelpObjectiveLiteral literal1 = new PelpObjectiveLiteral((PelpObjectiveLiteral) literal);
            literal1.setNafCount(literal1.getNafCount() - 1);
            PelpSubjectiveLiteral k00 = new PelpSubjectiveLiteral(true, true, 0, 0, literal1);
            return body.contains(k00);
        }
        return false;
    }

    private boolean existNafConflict(PelpLiteral literal, List<PelpLiteral> body) {
        if (literal instanceof PelpSubjectiveLiteral && ((PelpSubjectiveLiteral) literal).isKco01()) {
            PelpObjectiveLiteral literal1 = new PelpObjectiveLiteral(((PelpSubjectiveLiteral) literal).getObjectiveLiteral());
            literal1.setNafCount(literal1.getNafCount() + 1);
            return body.contains(literal1);
        }
        return false;
    }

    private boolean existPosConflict(PelpLiteral literal, List<PelpLiteral> body) {
        if (literal instanceof PelpSubjectiveLiteral && ((PelpSubjectiveLiteral) literal).isKoc01()) {
            return body.contains(((PelpSubjectiveLiteral) literal).getObjectiveLiteral());
        }
        return false;
    }

    private boolean existNegNafConflict(PelpLiteral literal, List<PelpLiteral> body) {
        if (literal instanceof PelpObjectiveLiteral && ((PelpObjectiveLiteral) literal).getNafCount() > 0) {
            PelpObjectiveLiteral literal1 = new PelpObjectiveLiteral(((PelpObjectiveLiteral) literal).getNafCount() - 1,
                    !((PelpObjectiveLiteral) literal).isNegation(),
                    ((PelpObjectiveLiteral) literal).getPredicate(),
                    ((PelpObjectiveLiteral) literal).getParams());
            return body.contains(literal1);
        }
        return false;
    }

    private boolean existNegK01Conflict(PelpLiteral literal, List<PelpLiteral> body) {
        if (literal instanceof PelpSubjectiveLiteral && ((PelpSubjectiveLiteral) literal).isKco01()) {
            PelpObjectiveLiteral literal1 = new PelpObjectiveLiteral(((PelpSubjectiveLiteral) literal).getObjectiveLiteral());
            literal1.setNegation(!literal1.isNegation());
            return body.contains(literal1);
        }
        return false;
    }

    private List<PelpLiteral> getFalseBody() {
        List<PelpLiteral> body = new ArrayList<>();
        body.add(new PelpObjectiveLiteral(0, false, "_false", new ArrayList<>()));
        return body;
    }

    private boolean sim(double a, double b) {
        return Math.abs(a - b) < 1e-6;
    }

    private boolean simLess(double a, double b) {
        return b - a > 1e-6;
    }

    private boolean simLeq(double a, double b) {
        return b - a > -1e-6;
    }
}
