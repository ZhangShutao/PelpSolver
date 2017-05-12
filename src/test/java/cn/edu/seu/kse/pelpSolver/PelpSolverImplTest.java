package cn.edu.seu.kse.pelpSolver;

import cn.edu.seu.kse.exception.ReasoningErrorException;
import cn.edu.seu.kse.exception.SyntaxErrorException;
import cn.edu.seu.kse.pelpSolver.impl.PelpSolverImpl;
import cn.edu.seu.kse.translate.AnswerSet2PossibleWorldTranslator;
import org.junit.Test;

import java.io.*;
import java.util.StringJoiner;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * TODO:
 * Created by 张舒韬 on 2017/2/7.
 */
public class PelpSolverImplTest {
    private PelpSolverImpl solver = new PelpSolverImpl();
    private AnswerSet2PossibleWorldTranslator a2pTranslator = new AnswerSet2PossibleWorldTranslator();

    private String readFile(File file) throws IOException {
        StringJoiner input = new StringJoiner("\n");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line;
        while ((line = reader.readLine()) != null) {
            input.add(line);
        }
        return input.toString();
    }

    private void testProgram(File inputFile, File outputFile) {
        try {
            String output = solver.solve(0, readFile(inputFile));
            System.out.println(output);
            assertTrue(output.equals(readFile(outputFile)));
        } catch (SyntaxErrorException e) {
            fail("语法错误：" + e.getMessage());
        } catch (ReasoningErrorException e) {
            fail("推理出错：" + e.getMessage());
        } catch (IOException e) {
            fail("文件读写出错：" + e.getMessage());
        }
    }

    @Test
    public void testCase0() {
        testProgram(new File("test" + File.separator + "case0.lp"),
                new File("test" + File.separator + "case0.out"));
    }

    @Test
    public void testCase1() {
        testProgram(new File("test" + File.separator + "case1.lp"),
                new File("test" + File.separator + "case1.out"));
    }

    @Test
    public void testCase2() {
        testProgram(new File("test" + File.separator + "case2.lp"),
                new File("test" + File.separator + "case2.out"));
    }

    @Test
    public void testCase3() {
        testProgram(new File("test" + File.separator + "case3.lp"),
                new File("test" + File.separator + "case3.out"));
    }

    @Test
    public void testCase4() {
        testProgram(new File("test" + File.separator + "case4.lp"),
                new File("test" + File.separator + "case4.out"));
    }

    @Test
    public void testCase5() {
        testProgram(new File("test" + File.separator + "case5.lp"),
                new File("test" + File.separator + "case5.out"));
    }

    @Test
    public void testGrounding() {
        testProgram(new File("test" + File.separator + "case6.lp"),
                new File("test" + File.separator + "case6.out"));
    }

    @Test
    public void testEpistemicConstrain() {
        testProgram(new File("test" + File.separator + "case7.lp"),
                new File("test" + File.separator + "case7.out"));
    }

    @Test
    public void testCase8() {
        testProgram(new File("test" + File.separator + "case8.lp"),
                new File("test" + File.separator + "case8.out"));
    }

    @Test
    public void test3doors() {
        try {
            String program = readFile(new File("test" + File.separator + "3doors.lp"));
            System.out.println(solver.solve(0, program));
        } catch (IOException | ReasoningErrorException | SyntaxErrorException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConstrain1() {
        testProgram(new File("test" + File.separator + "case9.lp"),
                new File("test" + File.separator + "case9.out"));
    }

    @Test
    public void testConstrain2() {
        testProgram(new File("test" + File.separator + "case10.lp"),
                new File("test" + File.separator + "case10.out"));
    }

    @Test
    public void testSelfSupport1() {
        testProgram(new File("test" + File.separator + "case11.lp"),
                new File("test" + File.separator + "case11.out"));
    }

    @Test
    public void testMultiHeadSoftRule() {
        testProgram(new File("test" + File.separator + "case13.lp"),
                new File("test" + File.separator + "case13.out"));
    }

    @Test
    public void testENegCalculus() {
        testProgram(new File("test" + File.separator + "case14.lp"),
                new File("test" + File.separator + "case14.out"));
    }

    @Test
    public void testProbEpisMerge() {
        testProgram(new File("test" + File.separator + "case15.lp"),
                new File("test" + File.separator + "case15.out"));
    }

    @Test
    public void testPlanning() {
        testProgram(new File("test" + File.separator + "planning.lp"),
                new File("test" + File.separator + "planning.out"));
    }
}
