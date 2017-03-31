package cn.edu.seu.kse.translate;

import cn.edu.seu.kse.exception.SyntaxErrorException;
import cn.edu.seu.kse.exception.TranslateErrorException;
import cn.edu.seu.kse.model.asp.AspProgram;
import cn.edu.seu.kse.model.pelp.PelpProgram;
import cn.edu.seu.kse.syntax.parser.PelpSyntaxParser;
import cn.edu.seu.kse.translate.impl.EpistemicReducer;
import cn.edu.seu.kse.translate.impl.SoftRuleReducer;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * TODO:
 * Created by 张舒韬 on 2017/3/15.
 */
public class Pelp2AspTranslateTest {
    private ProgramTranslator softReducer = new SoftRuleReducer();
    private ProgramTranslator epistemicReducer = new EpistemicReducer();

    @Test
    public void testTranslateProgramWithRelation() {
        try {
            PelpProgram pelpProgram = PelpSyntaxParser.parseProgram("p(X) :- a(X, Y1), a(X, Y2), Y1 != Y2.");
            PelpProgram softReduced = (PelpProgram) softReducer.translateProgram(pelpProgram);
            AspProgram aspProgram = (AspProgram) epistemicReducer.translateProgram(softReduced);

            System.out.println(aspProgram);
        } catch (SyntaxErrorException | TranslateErrorException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testTranslateEpistemicConstrain() {
        try {
            PelpProgram program = PelpSyntaxParser.parseProgram("p | q :- K[1, 1] r.\n" +
                    "a :- K(0, 1] not b.\n" +
                    "a :- K[0, 0] not p.\n" +
                    "r :- not q.");
            PelpProgram aspProgram = (PelpProgram) epistemicReducer.translateProgram(program);

            System.out.println(aspProgram);
        } catch (SyntaxErrorException | TranslateErrorException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTranslatePELPWithProbRelation() {
        try {
            PelpProgram program = PelpSyntaxParser.parseProgram("b :- #PL(a(X), b(X)), a(X).\n" +
                    "p(X) | q(X) :- a(X).\n a(1).");
            PelpProgram aspProgram = (PelpProgram) epistemicReducer.translateProgram(program);

            System.out.println(aspProgram);
        } catch (SyntaxErrorException | TranslateErrorException e) {
            e.printStackTrace();
        }
    }
}
