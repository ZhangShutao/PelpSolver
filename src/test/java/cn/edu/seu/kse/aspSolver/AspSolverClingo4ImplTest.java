package cn.edu.seu.kse.aspSolver;

import cn.edu.seu.kse.aspSolver.impl.AspSolverClingo4Impl;
import cn.edu.seu.kse.exception.ReasoningErrorException;
import cn.edu.seu.kse.exception.SyntaxErrorException;
import cn.edu.seu.kse.exception.UnsatisfiableException;
import cn.edu.seu.kse.model.asp.AnswerSet;
import cn.edu.seu.kse.model.asp.AspProgram;
import cn.edu.seu.kse.syntax.parser.AspSyntaxParser;
import org.junit.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * 测试ASP推理机Clingo 4的调用
 * Created by 张舒韬 on 2017/1/16.
 */
public class AspSolverClingo4ImplTest {
    private static AspSolver solver = new AspSolverClingo4Impl();

    @Test
    public void testSolve() {
        String programStr = "parent(a,b).\n" +
                "parent(b,c).\n" +
                "parent(a,d).\n" +
                "ancestor(X,Y):-parent(X,Y).\n" +
                "ancestor(X,Y):-parent(X,Z),ancestor(Z,Y).";
        try {
            AspProgram program = AspSyntaxParser.parseProgram(programStr);
            Set<AnswerSet> answerSets = solver.reason(program);

            AnswerSet correctAnswerSet = AspSyntaxParser.parseAnswerSet("parent(a,b) parent(b,c) parent(a,d) ancestor(a,b) ancestor(b,c) ancestor(a,d) ancestor(a,c)");

            assertTrue(answerSets.size() == 1);
            assertTrue(answerSets.contains(correctAnswerSet));
        } catch (SyntaxErrorException | UnsatisfiableException | IOException | ReasoningErrorException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testUnsatisfiableProgram() {
        String programStr = "simple(jo). -simple(X) :- simple(X).";
        try {
            AspProgram program = AspSyntaxParser.parseProgram(programStr);
            solver.reason(program);
            fail("未抛出源程序不可满足的异常");
        } catch (SyntaxErrorException | IOException | ReasoningErrorException e) {
            fail(e.getMessage());
        } catch (UnsatisfiableException e) {
            assertTrue(e.getMessage().contains("不可满足"));
        }
    }

    @Test
    public void testSyntaxErrorProgram() {
        String programStr = "simple(jo). -Simple(X) :- Simple(X).";
        try {
            AspProgram program = AspSyntaxParser.parseProgram(programStr);
            solver.reason(program);
            fail("未抛出语法错误异常");
        } catch (UnsatisfiableException | IOException | ReasoningErrorException e) {
            fail(e.getMessage());
        } catch (SyntaxErrorException e) {
            assertTrue(e.getMessage().contains("语法"));
        }
    }
}
