package cn.edu.seu.kse.aspsolver.impl;

import cn.edu.seu.kse.aspsolver.AspSolver;
import cn.edu.seu.kse.aspsolver.CommandLineSolver;
import cn.edu.seu.kse.exception.ReasoningErrorException;
import cn.edu.seu.kse.exception.SyntaxErrorException;
import cn.edu.seu.kse.exception.UnsatisfiableException;
import cn.edu.seu.kse.exception.UnsupportedOsTypeException;
import cn.edu.seu.kse.model.CommandLineOutput;
import cn.edu.seu.kse.model.BaseObjectModel;
import cn.edu.seu.kse.model.asp.AnswerSet;
import cn.edu.seu.kse.model.asp.AspLiteral;
import cn.edu.seu.kse.model.asp.AspProgram;
import cn.edu.seu.kse.syntax.parser.AspSyntaxParser;
import cn.edu.seu.kse.util.ApacheCommandlineExecutor;
import cn.edu.seu.kse.util.CommandLineExecutor;
import cn.edu.seu.kse.util.Logger;
import org.apache.commons.lang.SystemUtils;

import java.io.*;
import java.util.*;

/**
 * 调用Clingo 4进行ASP的推理，要求clingo已经配置为环境变量
 *
 * @author 张舒韬
 * @date 2017/1/11
 */
public class AspSolverClingo5Impl implements CommandLineSolver, AspSolver {
    private static final String UNSAT_TAG = "UNSATISFIABLE";
    private static final String ERR_TAG = "ERROR";
    private static final String CLINGO_PATH = new File("").getAbsolutePath() + "\\clingo5.2";

    private CommandLineExecutor cmdExecutor = new ApacheCommandlineExecutor();

    private File saveProgramAsTempFile(AspProgram program) throws IOException {
        File programFile = File.createTempFile("pelpTemp", ".lp");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(programFile)));
        writer.write(program.toString());
        writer.flush();
        writer.close();
        return programFile;
    }

    @Override
    public Set<AnswerSet> reason(AspProgram program) throws UnsatisfiableException, ReasoningErrorException, IOException {
        Map<String, String> valueParam = new HashMap<>(16);
        valueParam.put("--models", "0");
        List<String> params = generateSolverParamList(valueParam, new ArrayList<>());

        File programFile = null;
        try {
            programFile = saveProgramAsTempFile(program);
            Logger.info("待推理的ASP程序：\n{}", program);
            String answers = callSolver(programFile, params);
            Logger.info("ASP推理机输出结果：\n{}", answers);
            programFile.deleteOnExit();

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

    @Override
    public List<String> generateSolverParamList(Map<String, String> valueParam, List<String> singleParam) {
        List<String> list = new ArrayList<>();

        valueParam.forEach((key, value) -> {
            list.add(key);
            list.add(value);
        });
        list.addAll(singleParam);

        return list;
    }

    @Override
    public String callSolver(File programFile, List<String> options) throws SyntaxErrorException, ReasoningErrorException {
        List<String> params = new ArrayList<>();
        params.addAll(options);
        params.add(programFile.getAbsolutePath());

        try {
            CommandLineOutput result = cmdExecutor.callShell(CLINGO_PATH, params);
            if (result.getError().contains(ERR_TAG)) {
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

    @Override
    public List<BaseObjectModel> resolveReasonResult(String result) throws UnsatisfiableException, IOException, SyntaxErrorException {
        List<BaseObjectModel> answerSets = new ArrayList<>();

        if (result.contains(UNSAT_TAG)) {
            throw new UnsatisfiableException("逻辑程序不可满足");
        }

        BufferedReader reader = new BufferedReader(new StringReader(result));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("Answer: ")) {
                String answerSetStr = reader.readLine();
                AnswerSet answerSet = AspSyntaxParser.parseAnswerSet(answerSetStr);

                int weight = getAnswerSetWeight(answerSet);
                answerSet.setWeight(weight);

                answerSets.add(answerSet);
            }
        }
        return answerSets;
    }

    private int getAnswerSetWeight(AnswerSet answerSet) {
        int sum = 0;
        for (AspLiteral literal : answerSet.getLiterals()) {
            if ("_sat".equals(literal.getPredicate())) {
                sum += Integer.parseInt(literal.getParams().get(1).toString());
            }
        }
        return sum;
    }
}
