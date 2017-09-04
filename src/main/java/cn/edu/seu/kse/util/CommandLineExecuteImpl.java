package cn.edu.seu.kse.util;

import cn.edu.seu.kse.exception.UnsupportedOsTypeException;
import cn.edu.seu.kse.model.CommandLineOutput;
import org.apache.commons.lang.SystemUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringJoiner;

/**
 * 命令行程序调用工具类
 * Created by 张舒韬 on 2017/1/11.
 */
public class CommandLineExecuteImpl implements CommandLineExecutor {

    /**
     * 获得当前操作系统调用命令的前缀
     * @return 添加在调用命令前的前缀
     * @throws UnsupportedOsTypeException 当前操作系统不是可支持的操作系统
     */
    private static String getCommandLinePrefix() throws UnsupportedOsTypeException {
        if (SystemUtils.IS_OS_LINUX || SystemUtils.IS_OS_UNIX) {
            return "sh -c";
        } else if (SystemUtils.IS_OS_WINDOWS) {
            return "cmd.exe /c";
        } else {
            throw new UnsupportedOsTypeException(System.getProperty("os.name"));
        }
    }

    /**
     * 获得输入流中的字符串
     * @param inputStream 输入流
     * @return 输入流中的字符串
     * @throws IOException 读取字符串时发生读写错误
     */
    private static String getTextFromInputStream(InputStream inputStream) throws IOException {
        String res = "";

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                res += line + System.lineSeparator();
            }
        }

        return res;
    }

    private static class ReadThread extends Thread {
        private InputStream inputStream;
        private String result;
        private IOException exception = null;

        ReadThread(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        String getResult() throws IOException {
            while (true) {
                if (!(isAlive())) break;
            }
            if (exception == null) {
                return result;
            } else {
                throw exception;
            }
        }

        public void run () {
            try {
                result = getTextFromInputStream(inputStream);
            } catch (IOException e) {
                exception = e;
            }
        }
    }

    public CommandLineOutput callShell(String name, List<String> params) throws UnsupportedOsTypeException, IOException {
        StringJoiner cmdJoiner = new StringJoiner(" ");

        cmdJoiner.add(getCommandLinePrefix()).add(name);
        params.forEach(cmdJoiner::add);
        String cmd = cmdJoiner.toString();

        Process process = Runtime.getRuntime().exec(cmd);
        ReadThread outputReader = new ReadThread(process.getInputStream());
        outputReader.start();
        ReadThread errorReader = new ReadThread(process.getErrorStream());
        errorReader.start();

        return new CommandLineOutput(outputReader.getResult(), errorReader.getResult());
    }
}
