package cn.edu.seu.kse.translate;

import cn.edu.seu.kse.exception.SyntaxErrorException;
import cn.edu.seu.kse.model.pelp.PelpProgram;
import cn.edu.seu.kse.syntax.parser.PelpSyntaxParser;
import cn.edu.seu.kse.translate.impl.KNotReducer;
import cn.edu.seu.kse.translate.impl.SoftRuleReducer;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * 测试主观字中的NAF的消解和翻译器之间的串联
 * Created by 张舒韬 on 2017/1/20.
 */
public class KNotReducerTest {
    private final static String text[] = {
            "p :- K[0, 0] not p.",
            "p :- K[0, 0] not p.[2]\n" +
                    "q :- not p.[1]"
    };
    private ProgramTranslator translator = new KNotReducer();
    private ProgramTranslator softTranslator = new SoftRuleReducer();

    private static PelpProgram getTestProgram(int id) throws SyntaxErrorException {
        return PelpSyntaxParser.parseProgram(text[id]);
    }

    @Test
    public void testReduceNafInSubjectiveLiteral() {
        try {
            PelpProgram originProgram = getTestProgram(0);
            PelpProgram translatedProgram = (PelpProgram) translator.translateProgram(originProgram);
            assertTrue("p:-K[1.0,1.0]p.".equals(translatedProgram.toString()));
        } catch (SyntaxErrorException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testJoiningReducer() {
        try {
            PelpProgram originProgram = getTestProgram(1);
            PelpProgram kNafReducedProgram = (PelpProgram) translator.translateProgram(originProgram);
            PelpProgram softRuleReducedProgram = (PelpProgram) softTranslator.translateProgram(kNafReducedProgram);

            assertTrue(softRuleReducedProgram.toString().contains(":-_sat(_r0).[2.0]"));
            assertTrue(softRuleReducedProgram.toString().contains(":-_sat(_r1).[1.0]"));
            assertFalse(softRuleReducedProgram.toString().contains("K[0.0,0.0]not p"));
        } catch (SyntaxErrorException e) {
            fail(e.getMessage());
        }
    }
}
