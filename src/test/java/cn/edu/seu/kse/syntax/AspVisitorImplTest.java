package cn.edu.seu.kse.syntax;

import cn.edu.seu.kse.model.asp.*;
import cn.edu.seu.kse.syntax.asp.AspParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import static cn.edu.seu.kse.syntax.parser.AspSyntaxParser.getParser;
import static cn.edu.seu.kse.syntax.parser.AspSyntaxParser.getVisitedObject;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * 测试AspVisitorImpl类的ASP语法解析功能
 * Created by 张舒韬 on 2017/1/9.
 */
public class AspVisitorImplTest {

    @Test
    public void testSimpleLiteral() {
        AspParser parser = getParser("simple(1, 2)");
        ParseTree tree = parser.literal();
        AspLiteral literal = (AspLiteral) getVisitedObject(tree);

        assertTrue("simple(1,2)".equals(literal.toString()));
        assertFalse(literal.isNegation());
        assertTrue(literal.getParams().get(0).getType() == AspParam.CONSTANT);
    }

    @Test
    public void testLiteralWithoutParam() {
        AspParser parser = getParser("p");
        ParseTree tree = parser.literal();
        AspLiteral literal = (AspLiteral) getVisitedObject(tree);

        assertTrue("p".equals(literal.toString()));
        assertTrue(literal.getParams().isEmpty());
    }

    @Test
    public void testLiteralWithDoubleNaf() {
        AspParser parser = getParser("not not simple(1, 2)");
        ParseTree tree = parser.literal();
        AspLiteral literal = (AspLiteral) getVisitedObject(tree);

        assertTrue("not not simple(1,2)".equals(literal.toString()));
        assertTrue(literal.getNafCount() == 2);
    }

    @Test
    public void testLiteralWithNegation() {
        AspParser parser = getParser("-simple(1, X)");
        ParseTree tree = parser.literal();
        AspLiteral literal = (AspLiteral) getVisitedObject(tree);

        assertTrue("-simple(1,X)".equals(literal.toString()));
        assertTrue(literal.isNegation());
        assertTrue(literal.getParams().get(1).getType() == AspParam.VARIABLE);
    }

    @Test
    public void testFactRule() {
        AspParser parser = getParser("naive(john).");
        ParseTree tree = parser.reasoning_rule();
        AspRule rule = (AspRule) getVisitedObject(tree);

        assertTrue("naive(john).".equals(rule.toString()));
        assertTrue(rule.isFact());

        assertFalse(rule.isConstrain());
        assertFalse(rule.isSoftConstrain());
    }

    @Test
    public void testConstrainRule() {
        AspParser parser = getParser(":- not naive(X), simple(X).");
        ParseTree tree = parser.reasoning_rule();
        AspRule rule = (AspRule) getVisitedObject(tree);

        assertTrue(":-not naive(X),simple(X).".equals(rule.toString()));
        assertTrue(rule.isConstrain());

        assertFalse(rule.isFact());
        assertFalse(rule.isSoftConstrain());
    }

    @Test
    public void testNormalRule() {
        AspParser parser = getParser("naive(X) :- not not naive(X).");
        ParseTree tree = parser.reasoning_rule();
        AspRule rule = (AspRule) getVisitedObject(tree);

        assertTrue("naive(X):-not not naive(X).".equals(rule.toString()));

        assertFalse(rule.isConstrain());
        assertFalse(rule.isFact());
        assertFalse(rule.isSoftConstrain());
    }

    @Test
    public void testSoftConstrainRule() {
        AspParser parser = getParser(":~ _sat(1, X1, X2).[1@1, X1, X2]");
        ParseTree tree = parser.reasoning_rule();
        AspRule rule = (AspRule) getVisitedObject(tree);

        assertTrue(":~_sat(1,X1,X2).[1@1,X1,X2]".equals(rule.toString()));
        assertTrue(rule.isSoftConstrain());
        assertTrue(rule.getLevel() == 1);
    }

    @Test
    public void testSoftConstrainRuleWithDefaultLevel() {
        AspParser parser = getParser(":~ _sat(1, X1, X2).[1, X1, X2]");
        ParseTree tree = parser.reasoning_rule();
        AspRule rule = (AspRule) getVisitedObject(tree);

        assertTrue(":~_sat(1,X1,X2).[1@0,X1,X2]".equals(rule.toString()));
        assertTrue(rule.isSoftConstrain());
        assertTrue(rule.getLevel() == 0);
    }

    @Test
    public void testProgram() {
        String text = "_herbrand(a).\n" +
                "_herbrand(b).\n" +
                "_herbrand(c).\n" +
                "\n" +
                "friend(a, b).\n" +
                "friend(b, c).\n" +
                "influences(X, Y) :- influences(X, Z), influences(Z, Y).\n" +
                "\n" +
                "_select(1, X1, X2) | not _select(1, X1, X2) :- _herbrand(X1), _herbrand(X2).\n" +
                "influences(X1, X2) :- friend(X1, X2), _select(1, X1, X2).\n" +
                "_head(1, X1, X2) :- influences(X1, X2).\n" +
                "_body(1, X1, X2) :- friend(X1, X2).\n" +
                "_sat(1, X1, X2) :- _head(1, X1, X2), _herbrand(X1), _herbrand(X2).\n" +
                "_sat(1, X1, X2) :- not _body(1, X1, X2), _herbrand(X1), _herbrand(X2).\n" +
                ":- not _select(1, X1, X2), _sat(1, X1, X2).\n" +
                ":~ _sat(1, X1, X2). [1@1, X1, X2]";

        AspParser parser = getParser(text);
        ParseTree tree = parser.program();
        AspProgram program = (AspProgram) getVisitedObject(tree);

        String text2 = "_herbrand(a).\n" +
                "_herbrand(b).\n" +
                "_herbrand(c).\n" +
                "friend(a,b).\n" +
                "friend(b,c).\n" +
                "influences(X,Y):-influences(X,Z),influences(Z,Y).\n" +
                "_select(1,X1,X2)|not _select(1,X1,X2):-_herbrand(X1),_herbrand(X2).\n" +
                "influences(X1,X2):-friend(X1,X2),_select(1,X1,X2).\n" +
                "_head(1,X1,X2):-influences(X1,X2).\n" +
                "_body(1,X1,X2):-friend(X1,X2).\n" +
                "_sat(1,X1,X2):-_head(1,X1,X2),_herbrand(X1),_herbrand(X2).\n" +
                "_sat(1,X1,X2):-not _body(1,X1,X2),_herbrand(X1),_herbrand(X2).\n" +
                ":-not _select(1,X1,X2),_sat(1,X1,X2).\n" +
                ":~_sat(1,X1,X2).[1@1,X1,X2]";
        assertTrue(text2.equals(program.toString()));
        assertTrue(program.getRules().size() == 14);
    }

    @Test
    public void testAnswerSetWithoutWeight() {
        String text = "friend(a,b) friend(b,c) influences(a,b) influences(b,c) influences(a,c)";

        AspParser parser = getParser(text);
        ParseTree tree = parser.answer_set();
        AnswerSet answerSet = (AnswerSet) getVisitedObject(tree);

        String text2 = "Answer:\n" +
                "influences(a,b),influences(b,c),influences(a,c),friend(a,b),friend(b,c)";
        assertTrue(text2.equals(answerSet.toString()));
        assertTrue(answerSet.getWeight() == 0);
    }

    @Test
    public void testProgramWithRelation() {
        AspParser parser = getParser("a(X) :- b(X, Y1), b(X, Y2), Y1 != Y2.");
        ParseTree tree = parser.program();
        AspProgram program = (AspProgram) getVisitedObject(tree);
        System.out.println(program);
    }

    @Test
    public void testAspRule() {
        AspParser parser = getParser("b:-_pl(_f0ta(1),_f0tb(1)).");
        ParseTree tree = parser.reasoning_rule();
        AspRule rule = (AspRule) getVisitedObject(tree);
        System.out.println(rule);
    }
}
