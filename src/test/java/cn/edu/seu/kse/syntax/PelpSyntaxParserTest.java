package cn.edu.seu.kse.syntax;

import cn.edu.seu.kse.exception.SyntaxErrorException;
import cn.edu.seu.kse.model.pelp.PelpProgram;
import cn.edu.seu.kse.syntax.parser.PelpSyntaxParser;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

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

    @Test
    public void testWrongProgramWithUnsafeRule() {
        String text = "simple(Y) :- naive(X).";
        try {
            PelpProgram program = PelpSyntaxParser.parseProgram(text);
            fail("未检测到语法错误：\n" + program);
        } catch (SyntaxErrorException e) {
            assertTrue(e.getMessage().contains("不安全"));
        }
    }

    @Test
    public void testWrongProgramWithUnsafeSoftRule() {
        String text = "simple(Y) :- naive(X).[2]";
        try {
            PelpProgram program = PelpSyntaxParser.parseProgram(text);
            fail("未检测到语法错误：\n" + program);
        } catch (SyntaxErrorException e) {
            assertTrue(e.getMessage().contains("不安全"));
        }
    }

    @Test
    public void testUniqueRuleId() {
        String text = "human(X) :- man(X).\n" +
                "human(X) :- woman(X).\n" +
                ":- man(X), woman(X).\n" +
                "man(jo).[1]\n" +
                "woman(jo).[1]";
        try {
            PelpProgram program = PelpSyntaxParser.parseProgram(text);

            Set<String> idSet = new HashSet<>();
            program.getRules().forEach(rule -> idSet.add(rule.getId()));
            assertTrue(idSet.size() == program.getRules().size());
        } catch (SyntaxErrorException e) {
            fail("语法解析错误：" + e.getMessage());
        }
    }

    @Test
    public void testProbRelation() {
        try {
            PelpProgram program = PelpSyntaxParser.parseProgram("a(X) :- #PL(b(X), c(X)), b(X).");

            System.out.println(program);
        } catch (SyntaxErrorException e) {
            fail("语法解析错误：" + e.getMessage());
        }
    }
}
