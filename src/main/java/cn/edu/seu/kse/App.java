package cn.edu.seu.kse;

import cn.edu.seu.kse.exception.ReasoningErrorException;
import cn.edu.seu.kse.exception.SyntaxErrorException;
import cn.edu.seu.kse.pelpSolver.PelpSolver;
import cn.edu.seu.kse.pelpSolver.impl.PelpSolverImpl;
import cn.edu.seu.kse.util.Logger;

import java.io.*;
import java.util.Date;
import java.util.StringJoiner;

/**
 * Hello world!
 *
 */
public class App {
    private static PelpSolver pelpSolver = new PelpSolverImpl();

    private static String readFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName))));
        StringJoiner input = new StringJoiner("\n");
        String line;
        while ((line = reader.readLine()) != null) {
            input.add(line);
        }
        return input.toString();
    }

    public static void main( String[] args ) {
        if (args.length != 1) {
            StringJoiner cmd = new StringJoiner(" ");
            for (String arg : args) {
                cmd.add(arg);
            }
            Logger.warn("非法的调用参数：{}\nUsage: java PelpSolver filename", cmd);
            System.out.println("非法的调用参数：" + cmd + "\nUsage: java PelpSolver filename");
        } else {
            String fileName = args[0];
            try {
                String programStr = readFile(fileName);
                Date startTime = new Date();
                String worldViews = pelpSolver.solve(programStr);
                Date endTime = new Date();

                Logger.info("推理结果：{}", worldViews);
                System.out.println(worldViews);
                Logger.info("Using Time: {} ms", endTime.getTime() - startTime.getTime());
                System.out.println("Using Time: " + (endTime.getTime() - startTime.getTime()) + "ms");
            } catch (FileNotFoundException e) {
                Logger.warn("未找到源文件 {}", fileName);
                System.err.println("未找到源文件");
            } catch (SyntaxErrorException e) {
                Logger.warn("源文件中存在语法错误：{}", e.getMessage());
                System.err.println("源文件中存在语法错误：" + e.getMessage());
            } catch (ReasoningErrorException e) {
                Logger.warn("推理错误：{}", e.getMessage());
                System.err.println("推理错误：" + e.getMessage());
            } catch (IOException e) {
                Logger.warn("文件读取出错：{}", e.getMessage());
                System.out.println("文件读取出错：" + e.getMessage());
            }

            PelpSolver solver = new PelpSolverImpl();
        }
    }
}
