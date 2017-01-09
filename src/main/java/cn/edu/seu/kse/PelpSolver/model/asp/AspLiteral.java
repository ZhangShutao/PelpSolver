package cn.edu.seu.kse.PelpSolver.model.asp;

import cn.edu.seu.kse.PelpSolver.model.ObjectModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.List;
import java.util.StringJoiner;

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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i != nafCount; ++i) {
            builder.append("not ");
        }
        builder.append(isNegation ? "-" : "").append(predicate);

        if (!params.isEmpty()) {
            StringJoiner paramJoiner = new StringJoiner(",", "(", ")");
            params.forEach(aspParam -> paramJoiner.add(aspParam.toString()));
            builder.append(paramJoiner.toString());
        }

        return builder.toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(nafCount).append(isNegation)
                .append(predicate).append(params.toArray()).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj || obj.getClass() != AspLiteral.class) {
            return false;
        } else {
            AspLiteral other = new AspLiteral();
            return new EqualsBuilder().append(nafCount, other.getNafCount())
                    .append(isNegation(), other.isNegation())
                    .append(predicate, other.getPredicate())
                    .append(params, other.getParams()).isEquals();
        }
    }
}
