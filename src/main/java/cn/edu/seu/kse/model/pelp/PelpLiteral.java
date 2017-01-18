package cn.edu.seu.kse.model.pelp;

import cn.edu.seu.kse.model.ObjectModel;

import java.util.*;

/**
 * PELP字的语法类，是一个抽象类，有表示主观字和客观字的子类
 * Created by 张舒韬 on 2017/1/6.
 */
public abstract class PelpLiteral extends ObjectModel {
    private boolean naf;    // 弱否定
    private boolean negation;   // 强否定
    private String predicate;    // 谓词
    private List<PelpParam> params = new ArrayList<>(); // 参数列表

    public boolean isNaf() {
        return naf;
    }

    public void setNaf(boolean naf) {
        this.naf = naf;
    }

    public boolean isNegation() {
        return negation;
    }

    public void setNegation(boolean negation) {
        this.negation = negation;
    }

    public String getPredicate() {
        return predicate;
    }

    public void setPredicate(String predicate) {
        this.predicate = predicate;
    }

    public List<PelpParam> getParams() {
        return params;
    }

    public void setParams(List<PelpParam> params) {
        this.params = params;
    }

    protected String getSimpleLiteral() {
        StringBuilder builder = new StringBuilder();
        if (isNaf()) {
            builder.append("not ");
        }
        if (isNegation()) {
            builder.append("-");
        }
        builder.append(getPredicate());
        if (!getParams().isEmpty()) {
            StringJoiner paramJoiner = new StringJoiner(",", "(", ")");
            getParams().forEach(param -> paramJoiner.add(param.toString()));
            builder.append(paramJoiner.toString());
        }

        return builder.toString();
    }

    public Set<PelpParam> getHerbrandUniverse() {
        return filterParamType(PelpParam.CONSTANT);
    }

    public Set<PelpParam> getVariableSet() {
        return filterParamType(PelpParam.VARIABLE);
    }

    private Set<PelpParam> filterParamType (int type) {
        Set<PelpParam> paramSet = new HashSet<>();
        getParams().forEach(pelpParam -> {
            if (pelpParam.getType() == type) {
                paramSet.add(pelpParam);
            }
        });
        return paramSet;
    }

    public abstract boolean isPositive();
}
