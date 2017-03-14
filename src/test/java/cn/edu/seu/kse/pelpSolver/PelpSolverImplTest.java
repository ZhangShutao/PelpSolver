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
            String output = solver.solve(readFile(inputFile));
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
}
