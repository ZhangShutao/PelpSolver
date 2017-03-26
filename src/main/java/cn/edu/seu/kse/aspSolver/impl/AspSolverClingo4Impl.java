package cn.edu.seu.kse.aspSolver.impl;

import cn.edu.seu.kse.aspSolver.AspSolver;
import cn.edu.seu.kse.aspSolver.CommandLineSolver;
import cn.edu.seu.kse.exception.ReasoningErrorException;
import cn.edu.seu.kse.exception.SyntaxErrorException;
import cn.edu.seu.kse.exception.UnsatisfiableException;
import cn.edu.seu.kse.exception.UnsupportedOsTypeException;
import cn.edu.seu.kse.model.CommandLineOutput;
import cn.edu.seu.kse.model.ObjectModel;
import cn.edu.seu.kse.model.asp.AnswerSet;
import cn.edu.seu.kse.model.asp.AspProgram;
import cn.edu.seu.kse.syntax.parser.AspSyntaxParser;
import cn.edu.seu.kse.util.CommandLineExecute;
import cn.edu.seu.kse.util.Logger;
import org.apache.commons.lang.SystemUtils;

import java.io.*;
import java.util.*;

/**
 * 调用Clingo 4进行ASP的推理，要求clingo已经配置为环境变量
 * Created by 张舒韬 on 2017/1/11.
 */
public class AspSolverClingo4Impl implements CommandLineSolver, AspSolver {

    private File saveProgramAsTempFile(AspProgram program) throws IOException {
        File programFile = File.createTempFile("pelpTemp", ".lp");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(programFile)));
        writer.write(program.toString());
        writer.flush();
        return programFile;
    }

    public Set<AnswerSet> reason(AspProgram program) throws UnsatisfiableException, ReasoningErrorException, IOException {
        Map<String, String> valueParam = new HashMap<>();
        valueParam.put("--opt-mode", "enum");
        valueParam.put("--models", "0");
        List<String> params = generateSolverParamList(valueParam, new ArrayList<>());

        File programFile = null;
        try {
            programFile = saveProgramAsTempFile(program);
            Logger.info("待推理的ASP程序：\n{}", program);
            String answers = callSolver(programFile, params);
            Logger.info("ASP推理机输出结果：\n{}", answers);
            if (!programFile.delete()) {
                Logger.warn("删除文件{}失败", programFile.getAbsolutePath());
            }

            Set<AnswerSet> answerSets = new HashSet<>();
            resolveReasonResult(answers).forEach(answerSet -> {
                if (answerSet instanceof AnswerSet) {
                    answerSets.add((AnswerSet) answerSet);
                }
            });
            return answerSets;
        } catch (SyntaxErrorException e) {
            throw new ReasoningErrorException("逻辑程序中存在语法错误", e);
        } finally {
            if (programFile != null && !programFile.delete()) {
                programFile.deleteOnExit();
            }
        }
    }

    public List<String> generateSolverParamList(Map<String, String> valueParam, List<String> singleParam) {
        List<String> list = new ArrayList<>();

        valueParam.entrySet().forEach(entry -> {
            list.add(entry.getKey());
            list.add(entry.getValue());
        });
        singleParam.forEach(list::add);

        return list;
    }

    public String callSolver(File programFile, List<String> options) throws SyntaxErrorException, ReasoningErrorException {
        List<String> params = new ArrayList<>();
        params.addAll(options);
        params.add(programFile.getAbsolutePath());

        try {
            CommandLineOutput result = CommandLineExecute.callShell("clingo", params);
            if (result.getError().contains("ERROR")) {
                throw new ReasoningErrorException(result.getError());
            } else {
                return result.getOutput();
            }
        } catch (UnsupportedOsTypeException e) {
            throw new ReasoningErrorException(SystemUtils.OS_NAME + "不是可支持的操作系统类型");
        } catch (IOException e) {
            throw new ReasoningErrorException(e.getMessage());
        }
    }

    public List<ObjectModel> resolveReasonResult(String result) throws UnsatisfiableException, IOException, SyntaxErrorException {
        List<ObjectModel> answerSets = new ArrayList<>();

        if (result.contains("UNSATISFIABLE")) {
            throw new UnsatisfiableException("逻辑程序不可满足");
        }

        boolean isOptimize = result.contains("OPTIMUM FOUND");

        BufferedReader reader = new BufferedReader(new StringReader(result));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("Answer: ")) {
                String answerSetStr = reader.readLine();
                AnswerSet answerSet = AspSyntaxParser.parseAnswerSet(answerSetStr);

                if (isOptimize) {
                    String optimizationStr = reader.readLine();
                    int weight = Integer.parseInt(optimizationStr.substring(14));
                    answerSet.setWeight(weight);
                }
                answerSets.add(answerSet);
            }
        }
        return answerSets;
    }
}
