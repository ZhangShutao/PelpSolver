package cn.edu.seu.kse.util;

import cn.edu.seu.kse.TestConstant;
import cn.edu.seu.kse.exception.UnsupportedOsTypeException;
import cn.edu.seu.kse.model.CommandLineOutput;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.UUID;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * 测试命令行调用工具
 * Created by 张舒韬 on 2017/1/11.
 */
public class CommandLineExecuteImplTest {
    private static final String perfectProgram = "naive(X):-simple(X). simple(jo).";
    private static final String warningProgram = "naive(X):-simple(X).";
    private static final String errorProgram = "Naive(X):-Simple(X). Simple(jo).";
    private static final String unsatProgram = "-simple(X):-simple(X).simple(jo).";

    private File generateTemporaryFile(String text) {
        File file;
        try {
            file = File.createTempFile("testPelpSolver", ".lp");
        } catch (IOException e) {
            e.printStackTrace();
            String fileName = TestConstant.testDir + File.separator + UUID.randomUUID().toString() + ".lp";
            file = new File(fileName);
        }

        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    @Test
    public void testCallClingoWithPerfectProgram() {
        File file = generateTemporaryFile(perfectProgram);
        try {
            CommandLineOutput output = new ApacheCommandlineExecutor().callShell("clingo", Arrays.asList("0", file.getAbsolutePath()));

            assertTrue(output.getOutput().contains("SATISFIABLE"));
            assertTrue(output.getError().isEmpty());
        } catch (UnsupportedOsTypeException | IOException e) {
            fail(e.getMessage());
        } finally {
            if (file != null && !file.delete()) {
                file.deleteOnExit();
            }
        }
    }

    @Test
    public void testCallClingoWithWarningProgram() {
        File file = generateTemporaryFile(warningProgram);
        try {
            CommandLineOutput output = new ApacheCommandlineExecutor().callShell("clingo", Arrays.asList("0", file.getAbsolutePath()));

            assertTrue(output.getOutput().contains("SATISFIABLE"));
            assertTrue(output.getError().contains("warning"));
        } catch (UnsupportedOsTypeException | IOException e) {
            fail(e.getMessage());
        } finally {
            if (file != null && !file.delete()) {
                file.deleteOnExit();
            }
        }
    }

    @Test
    public void testCallClingoWithErrorProgram() {
        File file = generateTemporaryFile(errorProgram);
        try {
            CommandLineOutput output = new ApacheCommandlineExecutor().callShell("clingo", Arrays.asList("0", file.getAbsolutePath()));

            assertTrue(output.getOutput().contains("UNKNOWN"));
            assertTrue(output.getError().contains("ERROR"));
        } catch (UnsupportedOsTypeException | IOException e) {
            fail(e.getMessage());
        } finally {
            if (file != null && !file.delete()) {
                file.deleteOnExit();
            }
        }
    }

    @Test
    public void testCallClingoWithUnsatisfiableProgram() {
        File file = generateTemporaryFile(unsatProgram);
        try {
            CommandLineOutput output = new ApacheCommandlineExecutor().callShell("clingo", Arrays.asList("0", file.getAbsolutePath()));
            assertTrue(output.getOutput().contains("UNSATISFIABLE"));
        } catch (UnsupportedOsTypeException | IOException e) {
            e.printStackTrace();
        } finally {
            if (file != null && !file.delete()) {
                file.deleteOnExit();
            }
        }
    }
}
