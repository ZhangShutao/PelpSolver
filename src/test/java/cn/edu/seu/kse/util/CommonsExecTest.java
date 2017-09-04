package cn.edu.seu.kse.util;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
import org.junit.Test;

import java.io.*;

public class CommonsExecTest {

    @Test
    public void testCallClingo5() {
        for (int i = 1; i != 2; ++i) {
            String fileName = String.format("asp%02d.lp", i);
            String cmdStr = "DefaultReasoner5 0 --mode=gringo --text " + "test" + File.separator  + fileName;

            DefaultExecutor executor = new DefaultExecutor();
            CommandLine cmdLine = CommandLine.parse(cmdStr);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ByteArrayOutputStream baes = new ByteArrayOutputStream();
            executor.setStreamHandler(new PumpStreamHandler(baos, baes));

            executor.setExitValues(new int[]{0, 1, 20, 30, 65});
            try {
                int exitValue = executor.execute(cmdLine);
                System.out.println("exitValue: " + exitValue);
                System.out.println("Output Stream:");
                System.out.println(baos.toString().trim());
                System.out.println("Error Stream:");
                System.out.println(baes.toString().trim());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
