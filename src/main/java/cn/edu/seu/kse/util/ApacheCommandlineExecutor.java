package cn.edu.seu.kse.util;

import cn.edu.seu.kse.exception.UnsupportedOsTypeException;
import cn.edu.seu.kse.model.CommandLineOutput;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.Executor;
import org.apache.commons.exec.PumpStreamHandler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class ApacheCommandlineExecutor {

    public CommandLineOutput callShell(String name, List<String> params) throws UnsupportedOsTypeException, IOException {
        CommandLine cmdline = new CommandLine(name);
        params.forEach(cmdline::addArgument);

        Executor executor = new DefaultExecutor();

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        ByteArrayOutputStream errStream = new ByteArrayOutputStream();
        executor.setStreamHandler(new PumpStreamHandler(outStream, errStream));

        executor.setExitValues(new int[]{0, 1, 20, 30, 65});

        int exitValue = executor.execute(cmdline);
        return new CommandLineOutput(exitValue, outStream.toString().trim(), errStream.toString().trim());
    }
}
