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

    private static PelpProgram getTestProgram() throws SyntaxErrorException {
        String text = "student(jo).\n" +
                "ill(jo). [2]\n" +
                "-ill(jo). [1]\n" +
                "rest(X) :- K[0.6, 0] ill(X), student(X).";
        return PelpSyntaxParser.parseProgram(text);
    }

    @Test
    public void testGenerateHerbrandDeclare() {
        ModelTranslator translator = new SoftRuleReducer();
        try {
            PelpProgram originProgram = getTestProgram();

            PelpProgram translatedProgram = (PelpProgram) translator.translateProgram(originProgram);
            assertTrue(translatedProgram.toString().contains("_herbrand(jo)."));
        } catch (SyntaxErrorException e) {
            fail(e.getMessage());
        }
    }
}
