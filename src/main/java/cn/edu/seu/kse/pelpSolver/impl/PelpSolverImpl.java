package cn.edu.seu.kse.pelpSolver.impl;

import cn.edu.seu.kse.aspSolver.AspSolver;
import cn.edu.seu.kse.aspSolver.impl.AspSolverClingo4Impl;
import cn.edu.seu.kse.exception.ReasoningErrorException;
import cn.edu.seu.kse.exception.SyntaxErrorException;
import cn.edu.seu.kse.exception.UnsatisfiableException;
import cn.edu.seu.kse.model.asp.AnswerSet;
import cn.edu.seu.kse.model.asp.AspProgram;
import cn.edu.seu.kse.model.pelp.*;
import cn.edu.seu.kse.pelpSolver.PelpSolver;
import cn.edu.seu.kse.syntax.parser.PelpSyntaxParser;
import cn.edu.seu.kse.translate.AnswerSet2PossibleWorldTranslator;
import cn.edu.seu.kse.translate.ProgramTranslator;
import cn.edu.seu.kse.translate.impl.EpistemicReducer;
import cn.edu.seu.kse.translate.impl.KNotReducer;
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
    private ProgramTranslator softReducer = new SoftRuleReducer();
    private ProgramTranslator kNotReducer = new KNotReducer();
    private ProgramTranslator epistemicReducer = new EpistemicReducer();
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

    public ProgramTranslator getkNotReducer() {
        return kNotReducer;
    }

    public void setkNotReducer(ProgramTranslator kNotReducer) {
        this.kNotReducer = kNotReducer;
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

    @Override
    public Set<WorldView> solve(PelpProgram program) throws SyntaxErrorException, ReasoningErrorException {
        Set<WorldView> worldViews = new HashSet<>();
        AspProgram aspProgram = pelp2Asp(program);
        try {
            Set<AnswerSet> answerSets = solveAspProgram(aspProgram);
            Set<WorldView> candidateWorldViews = getCandidateWorldView(answerSets);
            candidateWorldViews.forEach(worldView -> {
                if (testWorldView(worldView)) {
                    worldViews.add(worldView);
                }
            });
        } catch (UnsatisfiableException e) {
            Logger.info("PELP程序{}对应的ASP程序不可满足。", program.toString());
        }
        return worldViews;
    }

    @Override
    public String solve(String program) throws SyntaxErrorException, ReasoningErrorException {
        Logger.info("solving program...\n{}", program);
        PelpProgram pelpProgram = PelpSyntaxParser.parseProgram(program);
        Set<WorldView> worldViews = solve(pelpProgram);
        StringJoiner outputJoiner = new StringJoiner("\n");

        Integer counter = 1;
        for (WorldView worldView : worldViews) {
            outputJoiner.add("WorldView " + counter + ":");
            outputJoiner.add(worldView.toString());
            counter++;
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
    public AspProgram pelp2Asp(PelpProgram pelpProgram) throws SyntaxErrorException {
        Logger.info("translating PELP program into ASP program:\n{}", pelpProgram.toString());
        PelpProgram noSoftProgram = (PelpProgram) getSoftReducer().translateProgram(pelpProgram);
        PelpProgram noKNotProgram = (PelpProgram) getkNotReducer().translateProgram(noSoftProgram);
        AspProgram aspProgram = (AspProgram) getEpistemicReducer().translateProgram(noKNotProgram);
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
                Set<PelpSubjectiveLiteral> supported = getAnswerSetTranslator().getSupportedEpistemic(answerSet);
                Set<PelpSubjectiveLiteral> notSupported = getAnswerSetTranslator().getNotSupportedEpistemic(answerSet);
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
        System.out.println(worldView);
        System.out.println("support");
        for (PelpSubjectiveLiteral supported : worldView.getSupportedEpistemic()) {
            System.out.println(supported);
            double weight = getSupportedWeight(supported, worldView);
            if (!isInEpistemicRange(supported, weight)) {
                return false;
            }
        }

        System.out.println("not support:");
        for (PelpSubjectiveLiteral unsupported  : worldView.getUnsupportedEpistemic()) {
            System.out.println(unsupported);
            double weight = getSupportedWeight(unsupported, worldView);
            if (isInEpistemicRange(unsupported, weight)) {
                return false;
            }
        }
        return true;
    }

    private double getSupportedWeight(PelpSubjectiveLiteral supported, WorldView worldView) {
        double sum = 0;
        PelpObjectiveLiteral literal = supported.getObjectiveLiteral();
        for (PossibleWorld possibleWorld : worldView.getPossibleWorldSet()) {
            if (possibleWorld.getLiterals().contains(literal)) {
                sum += possibleWorld.getWeight();
            }
        }
        return sum;
    }

    private String getGroupId(AnswerSet answerSet) {
        StringJoiner supportJoiner = new StringJoiner(",", "{", "}");
        StringJoiner notSupportJoiner = new StringJoiner(", ", "{", "}");
        getAnswerSetTranslator().getSupportedEpistemic(answerSet).forEach(literal -> supportJoiner.add(literal.toString()));
        getAnswerSetTranslator().getNotSupportedEpistemic(answerSet).forEach(literal -> notSupportJoiner.add(literal.toString()));
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
