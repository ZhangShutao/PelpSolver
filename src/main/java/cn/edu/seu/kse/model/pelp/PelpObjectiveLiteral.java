package cn.edu.seu.kse.model.pelp;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.List;

/**
 * Pelp中的客观字
 * Created by 张舒韬 on 2017/1/8.
 */
public class PelpObjectiveLiteral extends PelpLiteral{
    public PelpObjectiveLiteral() {
    }

    public PelpObjectiveLiteral(boolean naf, boolean negation, String predicate, List<PelpParam> paramList) {
        setNaf(naf);
        setNegation(negation);
        setPredicate(predicate);
        setParams(paramList);
    }

    @Override
    public String toString() {
        return getSimpleLiteral();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(isNaf()).append(isNegation()).append(getPredicate()).append(getParams().toArray()).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj || obj.getClass() != PelpObjectiveLiteral.class) {
            return false;
        } else {
            PelpObjectiveLiteral other = (PelpObjectiveLiteral) obj;
            return new EqualsBuilder().append(isNaf(), other.isNaf())
                    .append(isNegation(), other.isNegation())
                    .append(getPredicate(), other.getPredicate())
                    .append(getParams(), other.getParams())
                    .isEquals();
        }
    }

    @Override
    public boolean isPositive() {
        return !isNegation();
    }
}
