package cn.edu.seu.kse.PelSolver.syntax;

import cn.edu.seu.kse.PelpSolver.exception.SyntaxErrorException;
import cn.edu.seu.kse.PelpSolver.model.pelp.PelpProgram;
import cn.edu.seu.kse.PelpSolver.syntax.parser.PelpSyntaxParser;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

/**
 * PelpProgramParser类的单元测试
 * Created by 张舒韬 on 2017/1/9.
 */
public class PelpSyntaxParserTest {
    @Test
    public void testProgramParser() {
        String text = "human(X) :- man(X).\n" +
                "human(X) :- woman(X).\n" +
                ":- man(X), woman(X).\n" +
                "man(jo).[1]\n" +
                "woman(jo).[1]";
        try {
            PelpProgram program = PelpSyntaxParser.parseProgram(text);

            assertTrue(program.getRules().size() == 5);
            assertFalse(program.getRules().get(0).isSoft());
            assertTrue(program.getRules().get(3).isSoft());
            assertTrue(program.getRules().get(4).isSoft());
        } catch (SyntaxErrorException e) {
            fail("语法解析错误：" + e.getMessage());
        }
    }

    @Test
    public void testWrongProgramParserCausedByCapitalPredicate() {
        String text = "Human(X) :- man(X).\n" +
                "Human(X) :- woman(X).\n" +
                ":- man(X), woman(X).\n" +
                "man(jo).[1]\n" +
                "woman(jo).[1]";
        try {
            PelpProgram program = PelpSyntaxParser.parseProgram(text);
            fail("未检测到语法错误：\n" + program);
        } catch (SyntaxErrorException e) {
            assertTrue(e.getMessage().contains("Human"));
        }
    }

    @Test
    public void testWrongProgramParserCausedByIncomplete() {
        String text = "human(X) :- man(X).\n" +
                "human(X) :- woman(X).\n" +
                ":- man(X), woman(X).\n" +
                "man(jo).[1]\n" +
                "woman(jo";
        try {
            PelpProgram program = PelpSyntaxParser.parseProgram(text);
            fail("未检测到语法错误：\n" + program);
        } catch (SyntaxErrorException e) {
            assertTrue(e.getMessage().contains("woman(jo"));
        }
    }
}
