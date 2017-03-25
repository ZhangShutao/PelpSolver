package cn.edu.seu.kse.util;

import cn.edu.seu.kse.exception.SyntaxErrorException;
import cn.edu.seu.kse.model.pelp.PelpProgram;
import cn.edu.seu.kse.model.pelp.PelpSubjectiveLiteral;
import cn.edu.seu.kse.syntax.parser.PelpSyntaxParser;
import cn.edu.seu.kse.translate.impl.EpistemicReducer;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * TODO:
 * Created by 张舒韬 on 2017/3/25.
 */
public class ReflectTest {
    @Test
    public void testGetMethod() {
        try {
            Method method = EpistemicReducer.class.getMethod("translateAllParamAsVariable", PelpSubjectiveLiteral.class);
            System.out.println(method.getReturnType().getName());
            System.out.println(method.getName());
            for (Class clazz :method.getParameterTypes()) {
                System.out.println(clazz.getName());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testEpistemicConstrains() {
        try {
            PelpProgram program = PelpSyntaxParser.parseProgram("p :- K[1,1] p. q :- K[0,1) not q. l:- K(0,1]l.");
            EpistemicReducer reducer = new EpistemicReducer();
            reducer.generateEpistemicConstrain(program).forEach(System.out::println);
        } catch (SyntaxErrorException e) {
            e.printStackTrace();
        }
    }
}
