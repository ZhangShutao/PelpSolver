package cn.edu.seu.kse.model.pelp;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.*;

/**
 * Pelp中的客观字
 *
 * @author 张舒韬
 * @date 2017/1/8
 */
public class PelpObjectiveLiteral extends BasePelpObjective {
    private Integer nafCount = 0;
    /** 强否定 */
    private boolean negation;
    /** 谓词 */
    private String predicate;
    /** 参数列表 */
    private List<PelpParam> params = new ArrayList<>();

    public PelpObjectiveLiteral() {
    }

    public PelpObjectiveLiteral(PelpObjectiveLiteral other) {
        setNafCount(other.getNafCount());
        setNegation(other.isNegation());
        setPredicate(other.getPredicate());
        setParams(other.getParams());
    }

    public PelpObjectiveLiteral(Integer nafCount, boolean negation, String predicate, List<PelpParam> paramList) {
        setNafCount(nafCount);
        setNegation(negation);
        setPredicate(predicate);
        setParams(paramList);
    }

    public boolean isNaf() {
        return nafCount == 1;
    }

    public void setNaf(boolean naf) {
        setNafCount(naf ? 1 : 0);
    }

    public Integer getNafCount() {
        return nafCount;
    }

    public void setNafCount(Integer nafCount) {
        if (nafCount > 2) {
            this.nafCount = (nafCount % 2) + 1;
        } else {
            this.nafCount = nafCount;
        }
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i != getNafCount(); ++i) {
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

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getNafCount())
                .append(isNegation())
                .append(getPredicate())
                .append(getParams())
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (null == obj || obj.getClass() != PelpObjectiveLiteral.class) {
            return false;
        } else {
            PelpObjectiveLiteral other = (PelpObjectiveLiteral) obj;
            return new EqualsBuilder()
                    .append(getNafCount(), other.getNafCount())
                    .append(isNegation(), other.isNegation())
                    .append(getPredicate(), other.getPredicate())
                    .append(getParams(), other.getParams())
                    .isEquals();
        }
    }

    @Override
    public boolean isPositive() {
        return getNafCount() == 0;
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
}
