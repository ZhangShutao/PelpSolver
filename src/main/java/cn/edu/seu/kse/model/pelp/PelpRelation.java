package cn.edu.seu.kse.model.pelp;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO:
 * Created by 张舒韬 on 2017/3/15.
 */
public class PelpRelation extends PelpObjective {

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
}
