package cn.edu.seu.kse.PelpSolver;

import cn.edu.seu.kse.exception.ReasoningErrorException;
import cn.edu.seu.kse.exception.SyntaxErrorException;
import cn.edu.seu.kse.exception.UnsatisfiableException;
import cn.edu.seu.kse.model.asp.AnswerSet;
import cn.edu.seu.kse.model.asp.AspProgram;
import cn.edu.seu.kse.model.pelp.PelpProgram;
import cn.edu.seu.kse.pelpSolver.impl.PelpSolverImpl;
import cn.edu.seu.kse.syntax.parser.AspSyntaxParser;
import cn.edu.seu.kse.syntax.parser.PelpSyntaxParser;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * TODO:
 * Created by 张舒韬 on 2017/2/7.
 */
public class PelpSolverImplTest {
    private final static String text[] = {
            "p :- K[0, 0] not p.",
            "p :- K[0, 0] not p.[2]\n" +
                    "q :- not p.[1]"
    };

    private PelpSolverImpl solver = new PelpSolverImpl();

    @Test
    public void testTranslatePelp2AspCase0() {
        try {
            PelpProgram pelpProgram = PelpSyntaxParser.parseProgram(text[0]);
            AspProgram aspProgram = solver.pelp2Asp(pelpProgram);

            String standardOutput = "_kcc10001000tp|-_kcc10001000tp:-p.\n" +
                    "p:-_kcc10001000tp.";
            assertTrue(standardOutput.equals(aspProgram.toString()));
        } catch (SyntaxErrorException e) {
            fail("语法错误");
        }
    }

    @Test
    public void testTranslatePelp2AspCase1() {
        try {
            PelpProgram pelpProgram = PelpSyntaxParser.parseProgram(text[1]);
            AspProgram aspProgram = solver.pelp2Asp(pelpProgram);

            String standardOutput = "_kcc10001000tp|-_kcc10001000tp:-p.\n" +
                    "p:-_select(_r0),_kcc10001000tp.\n" +
                    "_head(_r1):-q.\n" +
                    ":-not _select(_r1),_sat(_r1).\n" +
                    "_select(_r1)|not _select(_r1).\n" +
                    "_sat(_r1):-_head(_r1).\n" +
                    ":~_sat(_r1).[1000@1]\n" +
                    "q:-_select(_r1),not p.\n" +
                    ":~_sat(_r0).[2000@1]\n" +
                    ":-not _select(_r0),_sat(_r0).\n" +
                    "_sat(_r1):-not _body(_r1).\n" +
                    "_sat(_r0):-_head(_r0).\n" +
                    "_head(_r0):-p.\n" +
                    "_body(_r0):-_kcc10001000tp.\n" +
                    "_body(_r1):-not p.\n" +
                    "_sat(_r0):-not _body(_r0).\n" +
                    "_select(_r0)|not _select(_r0).";
            assertTrue(standardOutput.equals(aspProgram.toString()));
        } catch (SyntaxErrorException e) {
            fail("语法错误");
        }
    }

    @Test
    public void testSolveAspCase0() {
        try {
            AspProgram aspProgram = AspSyntaxParser.parseProgram("_kcc10001000tp|-_kcc10001000tp:-p.\np:-_kcc10001000tp.");
            Set<AnswerSet> answerSets = solver.solveAspProgram(aspProgram);

            assertTrue(answerSets.size() == 1);
            assertTrue(((AnswerSet)answerSets.toArray()[0]).getLiterals().size() == 0);
        } catch (SyntaxErrorException e) {
            fail("语法错误");
        } catch (UnsatisfiableException e) {
            fail("程序不可满足");
        } catch (ReasoningErrorException e) {
            fail("求解出错");
        }
    }
}
