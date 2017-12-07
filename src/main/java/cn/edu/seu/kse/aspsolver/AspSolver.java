package cn.edu.seu.kse.aspsolver;

import cn.edu.seu.kse.exception.ReasoningErrorException;
import cn.edu.seu.kse.exception.UnsatisfiableException;
import cn.edu.seu.kse.model.asp.AnswerSet;
import cn.edu.seu.kse.model.asp.AspProgram;

import java.io.IOException;
import java.util.Set;

/**
 * ASP推理机的调用接口
 *
 * @author 张舒韬
 * @date 2017/1/11
 */
public interface AspSolver {

    /**
     * ASP推理机调用
     * @param program 待推理的ASP程序
     * @return 推理结果
     * @throws UnsatisfiableException 程序不可满足
     * @throws ReasoningErrorException 推理出错
     * @throws IOException 读写错误
     */
    Set<AnswerSet> reason(AspProgram program) throws UnsatisfiableException, ReasoningErrorException, IOException;
}
