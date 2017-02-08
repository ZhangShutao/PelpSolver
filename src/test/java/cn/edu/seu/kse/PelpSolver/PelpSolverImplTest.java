package cn.edu.seu.kse.PelpSolver;

import cn.edu.seu.kse.exception.SyntaxErrorException;
import cn.edu.seu.kse.model.asp.AspProgram;
import cn.edu.seu.kse.model.pelp.PelpProgram;
import cn.edu.seu.kse.pelpSolver.impl.PelpSolverImpl;
import cn.edu.seu.kse.syntax.parser.PelpSyntaxParser;
import org.junit.Test;

/**
 * TODO:
 * Created by 张舒韬 on 2017/2/7.
 */
public class PelpSolverImplTest {
    private final static String text[] = {
            "p :- K[0, 0] not p.",
            "p :- K[0, 0] not p.[2]\n" +
                    "q :- not p.[1]"
    };

    @Test
    public void testTranslatePelp2Asp() {
        try {
            PelpSolverImpl solver = new PelpSolverImpl();
            PelpProgram pelpProgram = PelpSyntaxParser.parseProgram(text[1]);
            AspProgram aspProgram = solver.pelp2Asp(pelpProgram);
            System.out.println(aspProgram);
        } catch (SyntaxErrorException e) {
            e.printStackTrace();
        }
    }
}
