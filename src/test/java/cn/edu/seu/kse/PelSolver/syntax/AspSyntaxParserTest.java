package cn.edu.seu.kse.PelSolver.syntax;

import cn.edu.seu.kse.PelpSolver.exception.SyntaxErrorException;
import cn.edu.seu.kse.PelpSolver.model.asp.AnswerSet;
import cn.edu.seu.kse.PelpSolver.model.asp.AspProgram;
import cn.edu.seu.kse.PelpSolver.syntax.parser.AspSyntaxParser;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * 测试AspSyntaxParser
 * Created by 张舒韬 on 2017/1/9.
 */
public class AspSyntaxParserTest {
    @Test
    public void testParseProgram() {
        String text = "p :- not not p.";

        try {
            AspProgram program = AspSyntaxParser.parseProgram(text);
            assertTrue("p:-not not p.".equals(program.toString()));
        } catch (SyntaxErrorException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testParseAnswerSet() {
        String text = "friend(a,b) friend(b,c) influences(a,b) influences(b,c) influences(a,c)";

        try {
            AnswerSet answerSet = AspSyntaxParser.parseAnswerSet(text);
            assertTrue(answerSet.getLiterals().size() == 5);
        } catch (SyntaxErrorException e) {
            fail(e.getMessage());
        }
    }
}
