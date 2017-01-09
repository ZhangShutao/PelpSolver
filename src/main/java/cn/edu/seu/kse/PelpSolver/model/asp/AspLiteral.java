package cn.edu.seu.kse.PelpSolver.model.asp;

import cn.edu.seu.kse.PelpSolver.model.ObjectModel;

import java.util.List;

/**
 * ASP字的语法类
 * Created by 张舒韬 on 2017/1/9.
 */
public class AspLiteral extends ObjectModel {

    private int nafCount = 0;
    private boolean isNegation = false;
    private String predicate;
    private List<AspParam> params;

    public AspLiteral() {
    }

    public AspLiteral(int nafCount, boolean isNegation, String predicate, List<AspParam> params) {
        this.nafCount = nafCount;
        this.isNegation = isNegation;
        this.predicate = predicate;
        this.params = params;
    }

    public int getNafCount() {
        return nafCount;
    }

    public void setNafCount(int nafCount) {
        this.nafCount = nafCount;
    }

    public boolean isNegation() {
        return isNegation;
    }

    public void setNegation(boolean negation) {
        isNegation = negation;
    }

    public String getPredicate() {
        return predicate;
    }

    public void setPredicate(String predicate) {
        this.predicate = predicate;
    }

    public List<AspParam> getParams() {
        return params;
    }

    public void setParams(List<AspParam> params) {
        this.params = params;
    }
}
