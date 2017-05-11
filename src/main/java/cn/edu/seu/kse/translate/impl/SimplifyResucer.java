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
        origin.getRules().forEach(originRule -> {
            String id = originRule.getId();
            PelpRule rule1 = reduceKnot(originRule);
            //System.out.println("rule1:" + rule1);
            PelpRule rule2 = mergeProbEpisWithSameObjectiveLiterals(rule1);
            //System.out.println("rule2:" + rule2);
            if (rule2 != null && !existConflict(rule2)) {
                rule2.setId(id);
                translated.addRule(rule2);
            }
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

    private boolean existConflict(PelpRule rule) {
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
