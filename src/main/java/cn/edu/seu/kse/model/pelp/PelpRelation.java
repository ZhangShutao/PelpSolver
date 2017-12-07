package cn.edu.seu.kse.model.pelp;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.HashSet;
import java.util.Set;

/**
 * objective relation expressions in PELP programs
 *
 * @author 张舒韬
 * @date 2017/3/15
 */
public class PelpRelation extends BasePelpObjective {

    private PelpParam left;
    private PelpParam right;
    private String operator;

    public PelpRelation(PelpParam left, String operator, PelpParam right) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    public PelpParam getLeft() {
        return left;
    }

    public void setLeft(PelpParam left) {
        this.left = left;
    }

    public PelpParam getRight() {
        return right;
    }

    public void setRight(PelpParam right) {
        this.right = right;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return left + operator + right;
    }

    @Override
    public Set<PelpParam> getHerbrandUniverse() {
        Set<PelpParam> herbrand = new HashSet<>();
        if (left.getType() == PelpParam.CONSTANT) {
            herbrand.add(left);
        }
        if (right.getType() == PelpParam.CONSTANT) {
            herbrand.add(right);
        }
        return herbrand;
    }

    @Override
    public Set<PelpParam> getVariableSet() {
        Set<PelpParam> var = new HashSet<>();
        if (left.getType() == PelpParam.VARIABLE) {
            var.add(left);
        }
        if (right.getType() == PelpParam.VARIABLE) {
            var.add(right);
        }
        return var;
    }

    @Override
    public boolean isPositive() {
        return true;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(left).append(right).append(operator).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (null == obj || obj.getClass() != PelpRelation.class) {
            return false;
        } else {
            PelpRelation other = (PelpRelation) obj;
            return new EqualsBuilder().append(left, other.left)
                    .append(right, other.right)
                    .append(operator, other.operator).isEquals();
        }
    }
}
