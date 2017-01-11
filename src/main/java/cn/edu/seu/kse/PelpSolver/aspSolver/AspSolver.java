package cn.edu.seu.kse.PelpSolver.aspSolver;

import cn.edu.seu.kse.PelpSolver.model.asp.AnswerSet;
import cn.edu.seu.kse.PelpSolver.model.asp.AspProgram;

import java.util.Set;

/**
 * ASP推理机的调用接口
 * Created by 张舒韬 on 2017/1/11.
 */
public interface AspSolver {

    Set<AnswerSet> reason(AspProgram program);
}
