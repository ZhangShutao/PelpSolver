package cn.edu.seu.kse.pelpSolver;

import cn.edu.seu.kse.exception.ReasoningErrorException;
import cn.edu.seu.kse.exception.SyntaxErrorException;
import cn.edu.seu.kse.model.pelp.PelpProgram;
import cn.edu.seu.kse.model.pelp.WorldView;

import java.util.Set;

/**
 * Pelp程序求解器接口
 * Created by 张舒韬 on 2017/2/7.
 */
public interface PelpSolver {
    Set<WorldView> solve(PelpProgram program) throws SyntaxErrorException, ReasoningErrorException;

    String solve(String program) throws SyntaxErrorException, ReasoningErrorException;
}
