package cn.edu.seu.kse.model.asp;

import cn.edu.seu.kse.model.ObjectModel;
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
        if (nafCount <= 2) {
            this.nafCount = nafCount;
        } else {
            this.nafCount = nafCount % 2 + 1;
        }
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

        for (int i = 0; i != getNafCount(); ++i) {
            builder.append("not ");
        }
        builder.append(isNegation() ? "-" : "").append(getPredicate());

        if (getParams() != null && !getParams().isEmpty()) {
            StringJoiner paramJoiner = new StringJoiner(",", "(", ")");
            getParams().forEach(aspParam -> paramJoiner.add(aspParam.toString()));
            builder.append(paramJoiner.toString());
        }

        return builder.toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getNafCount()).append(isNegation())
                .append(getPredicate()).append(getParams()).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (null == obj || obj.getClass() != AspLiteral.class) {
            return false;
        } else {
            AspLiteral other = (AspLiteral) obj;
            return new EqualsBuilder().append(getNafCount(), other.getNafCount())
                    .append(isNegation(), other.isNegation())
                    .append(getPredicate(), other.getPredicate())
                    .append(getParams(), other.getParams()).isEquals();
        }
    }
}
