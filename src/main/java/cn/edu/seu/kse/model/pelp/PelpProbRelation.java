package cn.edu.seu.kse.model.pelp;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO:
 * Created by 张舒韬 on 2017/3/28.
 */
public class PelpProbRelation extends PelpLiteral {
    private PelpObjectiveLiteral left;
    private PelpObjectiveLiteral right;

    public PelpProbRelation(PelpObjectiveLiteral left, PelpObjectiveLiteral right) {
        this.left = left;
        this.right = right;
    }

    public PelpObjectiveLiteral getLeft() {
        return left;
    }

    public void setLeft(PelpObjectiveLiteral left) {
        this.left = left;
    }

    public PelpObjectiveLiteral getRight() {
        return right;
    }

    public void setRight(PelpObjectiveLiteral right) {
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        PelpProbRelation that = (PelpProbRelation) o;

        return new EqualsBuilder()
                .append(getLeft(), that.getLeft())
                .append(getRight(), that.getRight())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getLeft())
                .append(getRight())
                .toHashCode();
    }

    @Override
    public Set<PelpParam> getHerbrandUniverse() {
        Set<PelpParam> herbrand = new HashSet<>();
        herbrand.addAll(left.getHerbrandUniverse());
        herbrand.addAll(right.getHerbrandUniverse());
        return herbrand;
    }

    @Override
    public Set<PelpParam> getVariableSet() {
        Set<PelpParam> var = new HashSet<>();
        var.addAll(left.getVariableSet());
        var.addAll(right.getVariableSet());
        return var;
    }

    @Override
    public boolean isPositive() {
        return false;
    }

    @Override
    public String toString() {
        return "#PL(" + getLeft().toString() + "," + getRight().toString() + ")";
    }

}
