package cn.edu.seu.kse.translate;

import cn.edu.seu.kse.exception.SyntaxErrorException;
import cn.edu.seu.kse.model.pelp.PelpProgram;
import cn.edu.seu.kse.syntax.parser.PelpSyntaxParser;
import cn.edu.seu.kse.translate.impl.SoftRuleReducer;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * TODO:
 * Created by 张舒韬 on 2017/1/18.
 */
public class SoftRuleReducerTest {

    private final static String text[] = {"student(jo).\n" +
            "ill(jo). [2]\n" +
            "-ill(jo). [1]\n" +
            "rest(X) :- K[0.6, 0] ill(X), student(X).",

            "feelGood(X) :- rest(X).[2]\n" +
            "student(jo).\n" +
            "ill(jo).[2]\n" +
            "-ill(jo).[1]\n" +
            "rest(X) :- K[0.6, 1] ill(X), student(X).\n" +
            "feelGood(X) :- -ill(X).\n" +
            "not feelGood(X) :- rest(X). [1]"};
    private ProgramTranslator translator = new SoftRuleReducer();

    private static PelpProgram getTestProgram(int id) throws SyntaxErrorException {
        return PelpSyntaxParser.parseProgram(text[id]);
    }

    @Test
    public void testGenerateHerbrandDeclare() {
        try {
            PelpProgram originProgram = getTestProgram(0);

            PelpProgram translatedProgram = (PelpProgram) translator.translateProgram(originProgram);
            assertTrue(translatedProgram.toString().contains("_herbrand(jo)."));
        } catch (SyntaxErrorException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testGenerateSelectOption() {
        try {
            PelpProgram originProgram = getTestProgram(1);

            PelpProgram translateProgram = (PelpProgram) translator.translateProgram(originProgram);
            assertTrue(translateProgram.toString().contains("_select(_r0,X)|not _select(_r0,X):-_herbrand(X)."));
        } catch (SyntaxErrorException e) {
            e.printStackTrace();
        }
    }
}
