package cn.edu.seu.kse.pelpSolver.impl;

import cn.edu.seu.kse.aspSolver.AspSolver;
import cn.edu.seu.kse.aspSolver.impl.AspSolverClingo4Impl;
import cn.edu.seu.kse.exception.ReasoningErrorException;
import cn.edu.seu.kse.exception.SyntaxErrorException;
import cn.edu.seu.kse.exception.UnsatisfiableException;
import cn.edu.seu.kse.model.asp.AnswerSet;
import cn.edu.seu.kse.model.asp.AspProgram;
import cn.edu.seu.kse.model.pelp.PelpProgram;
import cn.edu.seu.kse.model.pelp.PossibleWorld;
import cn.edu.seu.kse.model.pelp.WorldView;
import cn.edu.seu.kse.pelpSolver.PelpSolver;
import cn.edu.seu.kse.translate.impl.EpistemicReducer;
import cn.edu.seu.kse.translate.impl.KNotReducer;
import cn.edu.seu.kse.translate.impl.SoftRuleReducer;
import cn.edu.seu.kse.util.Logger;

import java.util.Set;

/**
 * TODO:
 * Created by 张舒韬 on 2017/2/7.
 */
public class PelpSolverImpl implements PelpSolver {
    private AspSolver aspSolver = new AspSolverClingo4Impl();
    private Logger logger = new Logger(PelpSolverImpl.class);

    private Logger getLogger() {
        return logger;
    }

    @Override
    public Set<WorldView> solve(PelpProgram program) throws SyntaxErrorException, ReasoningErrorException {
        return null;
    }

    /**
     * 将一个PELP程序翻译成对应的ASP程序
     * @param pelpProgram 待翻译的PELP程序
     * @return 对应的ASP程序
     * @throws SyntaxErrorException 原程序中存在语法错误
     */
    public AspProgram pelp2Asp(PelpProgram pelpProgram) throws SyntaxErrorException {
        getLogger().info("translating PELP program into ASP program:\n{}", pelpProgram.toString());
        PelpProgram noSoftProgram = (PelpProgram) new SoftRuleReducer().translateProgram(pelpProgram);
        PelpProgram noKNotProgram = (PelpProgram) new KNotReducer().translateProgram(noSoftProgram);
        AspProgram aspProgram = (AspProgram) new EpistemicReducer().translateProgram(noKNotProgram);
        getLogger().info("translating finished.\n{}", aspProgram.toString());
        return aspProgram;
    }

    public Set<AnswerSet> solveAspProgram(AspProgram aspProgram) throws ReasoningErrorException, UnsatisfiableException, ReasoningErrorException {
        return null;
    }

    public Set<PossibleWorld> answerset2PossibleWorld(Set<AnswerSet> answerSets) throws ReasoningErrorException {
        return null;
    }

    public Set<WorldView> groupPossibleWorld(Set<PossibleWorld> possibleWorlds) {
        return null;
    }

    public boolean testWorldView(WorldView worldView) {
        return false;
    }
}
