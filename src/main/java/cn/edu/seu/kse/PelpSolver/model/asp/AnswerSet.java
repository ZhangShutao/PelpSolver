package cn.edu.seu.kse.PelpSolver.model.asp;

import cn.edu.seu.kse.PelpSolver.model.ObjectModel;

import java.util.HashSet;
import java.util.Set;

/**
 * ASP推理所得的回答集的语法类
 * Created by 张舒韬 on 2017/1/9.
 */
public class AnswerSet extends ObjectModel {
    private Set<AspLiteral> literals = new HashSet<>();

    public AnswerSet() {
    }

    public AnswerSet(Set<AspLiteral> literals) {
        this.literals = literals;
    }

    public Set<AspLiteral> getLiterals() {
        return literals;
    }

    public void setLiterals(Set<AspLiteral> literals) {
        this.literals = literals;
    }
}
