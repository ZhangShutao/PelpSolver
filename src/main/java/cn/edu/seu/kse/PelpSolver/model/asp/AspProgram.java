package cn.edu.seu.kse.PelpSolver.model.asp;

import cn.edu.seu.kse.PelpSolver.model.ObjectModel;

import java.util.ArrayList;
import java.util.List;

/**
 * ASP程序的语法类
 * Created by 张舒韬 on 2017/1/9.
 */
public class AspProgram extends ObjectModel {
    private List<AspRule> rules = new ArrayList<>();

    public AspProgram() {
    }

    public AspProgram(List<AspRule> rules) {
        this.rules = rules;
    }

    public List<AspRule> getRules() {
        return rules;
    }

    public void setRules(List<AspRule> rules) {
        this.rules = rules;
    }
}
