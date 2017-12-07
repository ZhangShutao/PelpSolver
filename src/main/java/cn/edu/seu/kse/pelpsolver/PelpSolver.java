package cn.edu.seu.kse.pelpsolver;

import cn.edu.seu.kse.exception.ReasoningErrorException;
import cn.edu.seu.kse.exception.SyntaxErrorException;
import cn.edu.seu.kse.model.pelp.PelpProgram;
import cn.edu.seu.kse.model.pelp.WorldView;

import java.util.Set;

/**
 * Pelp程序求解器接口
 *
 * @author 张舒韬
 * @date 2017/2/7
 */
public interface PelpSolver {
    /**
     * call PelpSolver on a parsed PELP program
     * @param optMode using reduce optimize mode if this param is 1
     * @param program a PELP program
     * @return the world views of this program
     * @throws SyntaxErrorException there are some syntax error in reduce and translation
     * @throws ReasoningErrorException failed to solve this program
     */
    Set<WorldView> solve(int optMode, PelpProgram program) throws SyntaxErrorException, ReasoningErrorException;

    /**
     * call PelpSolver on a PELP program string
     * @param optMode using reduce optimize mode if this param is 1
     * @param program an PELP program string
     * @return the world views of this program
     * @throws SyntaxErrorException there are some syntax error in reduce and translation
     * @throws ReasoningErrorException failed to solve this program
     */
    String solve(int optMode, String program) throws SyntaxErrorException, ReasoningErrorException;
}
