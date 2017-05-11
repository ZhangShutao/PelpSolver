package cn.edu.seu.kse.pelpSolver.impl;

import cn.edu.seu.kse.aspSolver.AspSolver;
import cn.edu.seu.kse.aspSolver.impl.AspSolverClingo4Impl;
import cn.edu.seu.kse.exception.ReasoningErrorException;
import cn.edu.seu.kse.exception.SyntaxErrorException;
import cn.edu.seu.kse.exception.TranslateErrorException;
import cn.edu.seu.kse.exception.UnsatisfiableException;
import cn.edu.seu.kse.model.asp.AnswerSet;
import cn.edu.seu.kse.model.asp.AspProgram;
import cn.edu.seu.kse.model.pelp.*;
import cn.edu.seu.kse.pelpSolver.PelpSolver;
import cn.edu.seu.kse.syntax.parser.PelpSyntaxParser;
import cn.edu.seu.kse.translate.AnswerSet2PossibleWorldTranslator;
import cn.edu.seu.kse.translate.ProgramTranslator;
import cn.edu.seu.kse.translate.impl.EpistemicReducer;
import cn.edu.seu.kse.translate.impl.Pelp2AspTranslator;
import cn.edu.seu.kse.translate.impl.SimplifyResucer;
import cn.edu.seu.kse.translate.impl.SoftRuleReducer;
import cn.edu.seu.kse.util.Logger;

import java.io.IOException;
import java.util.*;

/**
 * TODO:
 * Created by 张舒韬 on 2017/2/7.
 */
public class PelpSolverImpl implements PelpSolver {
    private AspSolver aspSolver = new AspSolverClingo4Impl();
    private ProgramTranslator simplifyReducer = new SimplifyResucer();
    private ProgramTranslator softReducer = new SoftRuleReducer();
    private ProgramTranslator epistemicReducer = new EpistemicReducer();
    private ProgramTranslator pelp2AspTranslator = new Pelp2AspTranslator();
    private AnswerSet2PossibleWorldTranslator answerSetTranslator = new AnswerSet2PossibleWorldTranslator();

    public AspSolver getAspSolver() {
        return aspSolver;
    }

    public void setAspSolver(AspSolver aspSolver) {
        this.aspSolver = aspSolver;
    }

    public ProgramTranslator getSoftReducer() {
        return softReducer;
    }

    public void setSoftReducer(ProgramTranslator softReducer) {
        this.softReducer = softReducer;
    }

    public ProgramTranslator getEpistemicReducer() {
        return epistemicReducer;
    }

    public void setEpistemicReducer(ProgramTranslator epistemicReducer) {
        this.epistemicReducer = epistemicReducer;
    }

    public AnswerSet2PossibleWorldTranslator getAnswerSetTranslator() {
        return answerSetTranslator;
    }

    public void setAnswerSetTranslator(AnswerSet2PossibleWorldTranslator answerSetTranslator) {
        this.answerSetTranslator = answerSetTranslator;
    }

    public ProgramTranslator getPelp2AspTranslator() {
        return pelp2AspTranslator;
    }

    public void setPelp2AspTranslator(ProgramTranslator pelp2AspTranslator) {
        this.pelp2AspTranslator = pelp2AspTranslator;
    }

    @Override
    public Set<WorldView> solve(int optMode, PelpProgram program) throws SyntaxErrorException, ReasoningErrorException {
        Set<WorldView> worldViews = new HashSet<>();
        try {
            PelpProgram toSolve = program;
            if (optMode == 1) {
                toSolve = (PelpProgram) simplifyReducer.translateProgram(program);
            }
            AspProgram aspProgram = pelp2Asp(toSolve);
            Set<AnswerSet> answerSets = solveAspProgram(aspProgram);
            Set<WorldView> candidateWorldViews = getCandidateWorldView(answerSets);
            candidateWorldViews.forEach(worldView -> {
                StringJoiner joiner = new StringJoiner("\n");
                joiner.add(worldView + "with supported set:");
                getSupportSet(worldView).forEach(literal -> joiner.add(literal.toString()));
                joiner.add("satisfy:");
                worldView.getSupportedEpistemic().forEach(literal -> joiner.add(literal.toString()));
                joiner.add("unsatisfy:");
                worldView.getUnsupportedEpistemic().forEach(literal -> joiner.add(literal.toString()));
                joiner.add("");
                Logger.info(joiner.toString());

                if (testWorldView(worldView) // 该世界观中的主观字得到满足
                        && !supportedCovered(worldViews, worldView) // 该世界观没有被已有的世界观覆盖
                        && !replaceCoveredWorldView(worldViews, worldView) // 该世界观没有覆盖已有的世界观
                        ) {
                    worldViews.add(worldView);
                }
            });
        } catch (UnsatisfiableException e) {
            Logger.info("PELP程序{}对应的ASP程序不可满足。", program.toString());
        } catch (TranslateErrorException e) {
            Logger.warn("Pelp程序编译出错：{}", e);
        }
        return worldViews;
    }

    private boolean replaceCoveredWorldView(Set<WorldView> worldViews, WorldView worldView) {
        Set<WorldView> tobeChecked = new HashSet<>(worldViews);
        boolean added = false;
        for (WorldView checked : tobeChecked) {
            if (supportedCovered(worldView, checked)) {
                worldViews.remove(checked);
                if (!added) {
                    worldViews.add(worldView);
                    added = true;
                }
            }
        }
        return added;
    }

    private boolean supportedCovered(Set<WorldView> worldViews, WorldView worldView) {
        for (WorldView checked : worldViews) {
            if (supportedCovered(checked, worldView)) {
                Logger.info(checked + " covered " + worldView);
                return true;
            }
        }
        return false;
    }

    private boolean supportedCovered(WorldView a, WorldView b) {
        return a != b && getSupportSet(a).containsAll(getSupportSet(b));
    }

    private Set<PelpSubjective> getSupportSet(WorldView worldView) {
        Set<PelpSubjective> supportedSet = new HashSet<>();
        worldView.getSupportedEpistemic().forEach(literal -> {
            if (literal instanceof PelpSubjectiveLiteral) {
                PelpSubjectiveLiteral subjectiveLiteral = (PelpSubjectiveLiteral) literal;
                if (!subjectiveLiteral.isKcc11() && !subjectiveLiteral.isKcc00()) {
                    supportedSet.add(literal);
                }
            } else if (literal instanceof PelpProbRelation) {
                supportedSet.add(literal);
            }
        });
        worldView.getUnsupportedEpistemic().forEach(literal -> {
            if (literal instanceof PelpSubjectiveLiteral) {
                PelpSubjectiveLiteral subjectiveLiteral = (PelpSubjectiveLiteral) literal;
                if (subjectiveLiteral.isKcc11() || subjectiveLiteral.isKcc00()) {
                    supportedSet.add(literal);
                }
            }
        });

        return supportedSet;
    }

    @Override
    public String solve(int optMode, String program) throws SyntaxErrorException, ReasoningErrorException {
        Logger.info("solving program...\n{}", program);
        PelpProgram pelpProgram = PelpSyntaxParser.parseProgram(program);
        Set<WorldView> worldViews = solve(optMode, pelpProgram);
        StringJoiner outputJoiner = new StringJoiner("\n");

        if (worldViews.isEmpty()) {
            outputJoiner.add("Inconsistent program");
        } else {
            Integer counter = 1;
            for (WorldView worldView : worldViews) {
                outputJoiner.add("WorldView " + counter + ":");
                outputJoiner.add(worldView.toString());
                counter++;
            }
        }

        String output = outputJoiner.toString();
        Logger.info("program solved:\n{}", output);
        return output;
    }

    /**
     * 将一个PELP程序翻译成对应的ASP程序
     * @param pelpProgram 待翻译的PELP程序
     * @return 对应的ASP程序
     * @throws SyntaxErrorException 原程序中存在语法错误
     */
    public AspProgram pelp2Asp(PelpProgram pelpProgram) throws SyntaxErrorException, TranslateErrorException {
        Logger.info("translating PELP program into ASP program:\n{}", pelpProgram.toString());
        PelpProgram noSubjectProgram = (PelpProgram) getEpistemicReducer().translateProgram(pelpProgram);
        Logger.info("LPMLN program:\n{}", noSubjectProgram);
        PelpProgram noSoftProgram = (PelpProgram) getSoftReducer().translateProgram(noSubjectProgram);
        AspProgram aspProgram = (AspProgram) getPelp2AspTranslator().translateProgram(noSoftProgram);

        Logger.info("translating finished.\n{}", aspProgram.toString());
        return aspProgram;
    }

    public Set<AnswerSet> solveAspProgram(AspProgram aspProgram) throws UnsatisfiableException, ReasoningErrorException {
        try {
            return getAspSolver().reason(aspProgram);
        } catch (IOException e) {
            throw new ReasoningErrorException(e.getMessage());
        }
    }

    public Set<WorldView> getCandidateWorldView(Set<AnswerSet> answerSets) {
        Map<String, WorldView> worldViewMap = new HashMap<>();
        answerSets.forEach(answerSet -> {
            PossibleWorld possibleWorld = getAnswerSetTranslator().translate(answerSet);
            String groupId = getGroupId(answerSet);
            if (!worldViewMap.containsKey(groupId)) {
                Set<PelpSubjective> supported = getAnswerSetTranslator().getSupportedEpistemic(answerSet);
                Set<PelpSubjective> notSupported = getAnswerSetTranslator().getNotSupportedEpistemic(answerSet);
                worldViewMap.put(groupId, new WorldView(supported, notSupported));
            }
            worldViewMap.get(groupId).addPossibleWorld(possibleWorld);
        });

        Set<WorldView> worldViews = new HashSet<>(worldViewMap.values());
        worldViews.forEach(worldView -> {
            double sum = 0;
            for (PossibleWorld possibleWorld : worldView.getPossibleWorldSet()) {
                sum += Math.exp(possibleWorld.getWeight());
            }
            for (PossibleWorld possibleWorld : worldView.getPossibleWorldSet()) {
                if (sum != 0) {
                    possibleWorld.setWeight(Math.exp(possibleWorld.getWeight()) / sum);
                } else {
                    possibleWorld.setWeight(1.0);
                }
            }
        });
        return worldViews;
    }

    public boolean testWorldView(WorldView worldView) {
        for (PelpSubjective supported : worldView.getSupportedEpistemic()) {
            if (!supportedByWorldView(supported, worldView)) {
                return false;
            }
        }

        for (PelpSubjective unsupported  : worldView.getUnsupportedEpistemic()) {
            if (supportedByWorldView(unsupported, worldView)) {
                return false;
            }
        }
        return true;
    }

    private boolean supportedByWorldView(PelpSubjective subjective, WorldView worldView) {
        if (subjective instanceof PelpSubjectiveLiteral) {
            PelpSubjectiveLiteral subjectiveLiteral = (PelpSubjectiveLiteral) subjective;
            double weight = getSupportedWeight(subjectiveLiteral.getObjectiveLiteral(), worldView);
            return isInEpistemicRange(subjectiveLiteral, weight);
        } else {
            PelpProbRelation probRelation = (PelpProbRelation) subjective;
            double weightLeft = getSupportedWeight(probRelation.getLeft(), worldView);
            double weightRight = getSupportedWeight(probRelation.getRight(), worldView);
            return simLess(weightLeft, weightRight);
        }
    }

    private double getSupportedWeight(PelpObjectiveLiteral supported, WorldView worldView) {
        double sum = 0;
        PelpObjectiveLiteral literal = new PelpObjectiveLiteral(supported);
        literal.setNaf(false);

        for (PossibleWorld possibleWorld : worldView.getPossibleWorldSet()) {
            if (possibleWorld.getLiterals().contains(literal)) {
                sum += possibleWorld.getWeight();
            }
        }
        if (supported.getNafCount() % 2 == 0) {
            return sum;
        } else {
            return 1 - sum;
        }
    }

    private String getGroupId(AnswerSet answerSet) {
        StringJoiner supportJoiner = new StringJoiner(",", "{", "}");
        StringJoiner notSupportJoiner = new StringJoiner(", ", "{", "}");
        getAnswerSetTranslator().getSupportedEpistemic(answerSet).forEach(literal -> supportJoiner.add(literal.toString()));
        getAnswerSetTranslator().getNotSupportedEpistemic(answerSet).forEach(literal -> {
            notSupportJoiner.add(literal.toString());
        });
        return supportJoiner.toString() + notSupportJoiner.toString();
    }

    private boolean isInEpistemicRange(PelpSubjectiveLiteral literal, double weight) {
        return  (literal.isLeftClose() && sim(weight, literal.getLeftBound())) ||
                (literal.isRightClose() && sim(weight, literal.getRightBound())) ||
                (simLess(literal.getLeftBound(), weight) && simLess(weight, literal.getRightBound()));
    }

    private boolean sim(double a, double b) {
        return Math.abs(a - b) < 1e-6;
    }

    private boolean simLess(double a, double b) {
        return b - a > 1e-6;
    }
}
