package cn.edu.seu.kse;

import cn.edu.seu.kse.exception.ReasoningErrorException;
import cn.edu.seu.kse.exception.SyntaxErrorException;
import cn.edu.seu.kse.pelpSolver.PelpSolver;
import cn.edu.seu.kse.pelpSolver.impl.PelpSolverImpl;
import cn.edu.seu.kse.util.Logger;
import org.apache.commons.cli.*;

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
        Options options = new Options();
        options.addOption("opt", true, "0 as not optimise, 1 as simplify");
        CommandLineParser parser = new DefaultParser();

        try {
            CommandLine cmd = parser.parse(options, args);
            int optMode = 0;
            if (cmd.hasOption("opt")) {
                optMode = Integer.parseInt(cmd.getOptionValue("opt"));
            }
            String fileName = cmd.getArgs()[0];
            try {
                String programStr = readFile(fileName);
                Date startTime = new Date();
                String worldViews = pelpSolver.solve(optMode, programStr);
                Date endTime = new Date();

                Logger.info("推理结果：{}", worldViews);
                System.out.println(worldViews);
                Logger.info("Used Time: {} ms", endTime.getTime() - startTime.getTime());
                System.out.println("Used Time: " + (endTime.getTime() - startTime.getTime()) + "ms");
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
        } catch (ParseException e) {
            Logger.warn("命令行解析错误：{}", e.getMessage());
            System.out.println("命令行解析错误：" + e.getMessage() + "\nUsage: PelpSolver [-opt 0/1] filename");
        }
    }
}
