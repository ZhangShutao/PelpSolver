package cn.edu.seu.kse.aspSolver;

import cn.edu.seu.kse.exception.ReasoningErrorException;
import cn.edu.seu.kse.exception.SyntaxErrorException;
import cn.edu.seu.kse.exception.UnsatisfiableException;
import cn.edu.seu.kse.model.ObjectModel;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 命令行推理机的实现接口
 * Created by 张舒韬 on 2017/1/11.
 */
public interface CommandLineSolver {

    /**
     * 生成推理机的参数列表
     * @param valueParam 键值对参数
     * @param singleParam 单选项参数
     * @return 所得的参数列表
     */
    List<String> generateSolverParamList(Map<String, String> valueParam, List<String> singleParam);

    /**
     * 推理机调用
     * @param programFile 待推理的逻辑程序所保存的文件
     * @param options 调用选项
     * @return 推理结果
     * @throws SyntaxErrorException 逻辑程序中存在语法错误
     * @throws ReasoningErrorException 推理过程中出现错误
     */
    String callSolver(File programFile, List<String> options) throws SyntaxErrorException, ReasoningErrorException;

    /**
     * 解析推理机的推理结果
     * @param result 待解析的推理结果
     * @return 解析所得的推理结果
     * @throws UnsatisfiableException 原程序不可满足
     */
    List<ObjectModel> resolveReasonResult(String result) throws UnsatisfiableException, IOException, SyntaxErrorException;
}
