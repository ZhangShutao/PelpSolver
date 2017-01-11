package cn.edu.seu.kse.syntax;

import cn.edu.seu.kse.model.ObjectModel;
import cn.edu.seu.kse.model.pelp.*;
import cn.edu.seu.kse.syntax.SyntaxErrorListener;
import cn.edu.seu.kse.syntax.pelp.PelpLexer;
import cn.edu.seu.kse.syntax.pelp.PelpParser;
import cn.edu.seu.kse.syntax.pelp.PelpVisitorImpl;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

/**
 * PelpVisitorImpl类的单元测试类
 * Created by 张舒韬 on 2017/1/8.
 */
public class PelpVisitorImplTest {

    private PelpParser getParser(String text) {
        PelpLexer lexer = new PelpLexer(new ANTLRInputStream(text));
        CommonTokenStream token = new CommonTokenStream(lexer);
        PelpParser parser = new PelpParser(token);

        // 错误处理
        parser.removeErrorListeners();
        parser.addErrorListener(new SyntaxErrorListener());

        return parser;
    }

    private ObjectModel getVisitedObject(ParseTree tree) {
        PelpVisitorImpl visitor = new PelpVisitorImpl();
        return (ObjectModel) visitor.visit(tree);
    }

    @Test
    public void testObjectiveLiteralWithIntegerParam() {
        PelpParser parser = getParser("simple(1, 2)");
        ParseTree tree = parser.objective_literal();

        PelpObjectiveLiteral literal = (PelpObjectiveLiteral) getVisitedObject(tree);

        assertTrue("simple(1,2)".equals(literal.toString()));
        assertTrue(literal.getParams().get(0).getType() == PelpParam.CONSTANT);
    }

    @Test
    public void testObjectiveLiteralWithStringParam() {
        PelpParser parser = getParser("simple(\"simple string\", X)");
        ParseTree tree = parser.objective_literal();

        PelpObjectiveLiteral literal = (PelpObjectiveLiteral) getVisitedObject(tree);

        assertTrue("simple(\"simple string\",X)".equals(literal.toString()));
        assertTrue(literal.getParams().get(0).getType() == PelpParam.CONSTANT);
    }

    @Test
    public void testObjectiveLiteralWithVariableParam() {
        PelpParser parser = getParser("simple(1, X)");
        ParseTree tree = parser.objective_literal();

        PelpObjectiveLiteral literal = (PelpObjectiveLiteral) getVisitedObject(tree);

        assertTrue("simple(1,X)".equals(literal.toString()));
        assertTrue(literal.getParams().get(1).getType() == PelpParam.VARIABLE);
    }

    @Test
    public void testObjectiveLiteralWithoutParam() {
        PelpParser parser = getParser("simple");
        ParseTree tree = parser.objective_literal();

        PelpObjectiveLiteral literal = (PelpObjectiveLiteral) getVisitedObject(tree);

        assertTrue("simple".equals(literal.toString()));
        assertTrue(literal.getParams().size() == 0);
    }

    @Test
    public void testObjectiveLiteralWithNaf() {
        PelpParser parser = getParser("not simple(X, Y)");
        ParseTree tree = parser.objective_literal();

        PelpObjectiveLiteral literal = (PelpObjectiveLiteral) getVisitedObject(tree);

        assertTrue("not simple(X,Y)".equals(literal.toString()));
        assertTrue(literal.isNaf());
    }

    @Test
    public void testObjectiveLiteralWithNegation() {
        PelpParser parser = getParser("-simple(X, Y)");
        ParseTree tree = parser.objective_literal();

        PelpObjectiveLiteral literal = (PelpObjectiveLiteral) getVisitedObject(tree);

        assertTrue("-simple(X,Y)".equals(literal.toString()));
        assertTrue(literal.isNegation());
    }

    @Test
    public void testObjectiveLiteralWithNafAndNegation() {
        PelpParser parser = getParser("not -simple(X, Y)");
        ParseTree tree = parser.objective_literal();

        PelpObjectiveLiteral literal = (PelpObjectiveLiteral) getVisitedObject(tree);

        assertTrue("not -simple(X,Y)".equals(literal.toString()));
        assertTrue(literal.isNegation());
        assertTrue(literal.isNaf());
    }

    @Test
    public void testObjectiveLiteralWithKAsParam() {
        PelpParser parser = getParser("simple(a, K)");
        ParseTree tree = parser.objective_literal();

        PelpObjectiveLiteral literal = (PelpObjectiveLiteral) getVisitedObject(tree);

        assertTrue("simple(a,K)".equals(literal.toString()));
        assertTrue(literal.getParams().get(0).getType() == PelpParam.CONSTANT);
        assertTrue(literal.getParams().get(1).getType() == PelpParam.VARIABLE);
    }

    @Test
    public void testWrongObjectiveLiteralWithCapitalPredicate() {
        try {
            PelpParser parser = getParser("Simple(a, K)");
            ParseTree tree = parser.objective_literal();

            PelpObjectiveLiteral literal = (PelpObjectiveLiteral) getVisitedObject(tree);

            fail("未检测到语法错误：" + literal);
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Simple"));
        }
    }

    @Test
    public void testSubjectiveLiteralWithClosedIntegerWeight() {
        PelpParser parser = getParser("K[0,1] simple(1, 2)");
        ParseTree tree = parser.subjective_literal();

        PelpSubjectiveLiteral literal = (PelpSubjectiveLiteral) getVisitedObject(tree);

        assertTrue("K[0.0,1.0]simple(1,2)".equals(literal.toString()));
        assertTrue(literal.isLeftClose());
        assertTrue(literal.isRightClose());
    }

    @Test
    public void testSubjectiveLiteralWithClosedDoubleWeight() {
        PelpParser parser = getParser("K[0.33,0.5] simple(1, 2)");
        ParseTree tree = parser.subjective_literal();

        PelpSubjectiveLiteral literal = (PelpSubjectiveLiteral) getVisitedObject(tree);

        assertTrue("K[0.33,0.5]simple(1,2)".equals(literal.toString()));
        assertTrue(literal.isLeftClose());
        assertTrue(literal.isRightClose());
    }

    @Test
    public void testSubjectiveLiteralWithOpenWeight() {
        PelpParser parser = getParser("K(0.33,0.5) simple(1, 2)");
        ParseTree tree = parser.subjective_literal();

        PelpSubjectiveLiteral literal = (PelpSubjectiveLiteral) getVisitedObject(tree);

        assertTrue("K(0.33,0.5)simple(1,2)".equals(literal.toString()));
        assertFalse(literal.isLeftClose());
        assertFalse(literal.isRightClose());
    }

    @Test
    public void testHardFactRule() {
        PelpParser parser = getParser("simple(1, 2).");
        ParseTree tree = parser.hard_rule();

        PelpRule rule = (PelpRule) getVisitedObject(tree);

        assertTrue("simple(1,2).".equals(rule.toString()));
        assertTrue(rule.isFact());
    }

    @Test
    public void testHardConstrainRule() {
        PelpParser parser = getParser(":- simple(1, 2), simple(3, 4).");
        ParseTree tree = parser.hard_rule();

        PelpRule rule = (PelpRule) getVisitedObject(tree);

        assertTrue(":-simple(1,2),simple(3,4).".equals(rule.toString()));
        assertTrue(rule.isConstrain());
    }

    @Test
    public void testHardNormalRule() {
        PelpParser parser = getParser("equal(X, Y) :- equal(X, Z), equal(Z, Y).");
        ParseTree tree = parser.hard_rule();

        PelpRule rule = (PelpRule) getVisitedObject(tree);

        assertTrue("equal(X,Y):-equal(X,Z),equal(Z,Y).".equals(rule.toString()));
        assertFalse(rule.isConstrain());
        assertFalse(rule.isFact());
        assertFalse(rule.isSoft());
    }

    @Test
    public void testHardNormalRuleWithSubjectiveLiteral() {
        PelpParser parser = getParser("equal(X, Y) :- equal(X, Z), equal(Z, Y), K[0.2, 0.6) not simple(1, 2).");
        ParseTree tree = parser.hard_rule();

        PelpRule rule = (PelpRule) getVisitedObject(tree);

        assertTrue("equal(X,Y):-equal(X,Z),equal(Z,Y),K[0.2,0.6)not simple(1,2).".equals(rule.toString()));
        assertFalse(rule.isConstrain());
        assertFalse(rule.isFact());
        assertFalse(rule.isSoft());
        assertTrue(rule.getBody().get(2) instanceof PelpSubjectiveLiteral);
        assertTrue(rule.getBody().get(2).isNaf());
    }

    @Test
    public void testSoftFactRule() {
        PelpParser parser = getParser("simple(1, 2). [0.53]");
        ParseTree tree = parser.soft_rule();

        PelpRule rule = (PelpRule) getVisitedObject(tree);

        assertTrue("simple(1,2).[0.53]".equals(rule.toString()));
        assertTrue(rule.isFact());
        assertTrue(rule.isSoft());
        assertTrue(Math.abs(rule.getWeight() - 0.53) < 1e-6);
    }

    @Test
    public void testSoftNormalRuleWithSubjectiveLiteral() {
        PelpParser parser = getParser("equal(X, Y) :- equal(X, Z), equal(Z, Y), K[0.2, 0.6) not simple(1, 2).[100.2]");
        ParseTree tree = parser.soft_rule();

        PelpRule rule = (PelpRule) getVisitedObject(tree);

        assertTrue("equal(X,Y):-equal(X,Z),equal(Z,Y),K[0.2,0.6)not simple(1,2).[100.2]".equals(rule.toString()));
        assertFalse(rule.isConstrain());
        assertFalse(rule.isFact());
        assertTrue(rule.getBody().get(2) instanceof PelpSubjectiveLiteral);
        assertTrue(rule.getBody().get(2).isNaf());
        assertTrue(rule.isSoft());
        assertTrue(Math.abs(rule.getWeight() - 100.2) < 1e-6);
    }

    @Test
    public void testPelpProgram() {
        String text = "human(X) :- man(X).\n" +
                "human(X) :- woman(X).\n" +
                ":- man(X), woman(X).\n" +
                "man(jo).[1]\n" +
                "woman(jo).[1]";
        PelpParser parser = getParser(text);
        ParseTree tree = parser.program();
        PelpProgram program = (PelpProgram) getVisitedObject(tree);

        assertTrue(program.getRules().size() == 5);
        assertFalse(program.getRules().get(0).isSoft());
        assertTrue(program.getRules().get(3).isSoft());
        assertTrue(program.getRules().get(4).isSoft());
    }
}
