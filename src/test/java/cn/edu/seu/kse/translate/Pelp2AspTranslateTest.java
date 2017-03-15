package cn.edu.seu.kse.translate;

import cn.edu.seu.kse.exception.SyntaxErrorException;
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
        } catch (SyntaxErrorException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
}
