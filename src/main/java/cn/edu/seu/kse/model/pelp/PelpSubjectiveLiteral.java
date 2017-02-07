package cn.edu.seu.kse.model.pelp;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Pelp的主观字
 * Created by 张舒韬 on 2017/1/7.
 */
public class PelpSubjectiveLiteral extends PelpLiteral {

    private boolean isLeftClose;
    private boolean isRightClose;
    private double leftBound;
    private double rightBound;

    public PelpSubjectiveLiteral() {
    }

    public PelpSubjectiveLiteral(boolean isLeftClose, boolean isRightClose, double leftBound, double rightBound, PelpObjectiveLiteral objectiveLiteral) {
        this.isLeftClose = isLeftClose;
        this.isRightClose = isRightClose;
        this.leftBound = leftBound;
        this.rightBound = rightBound;
        setNaf(objectiveLiteral.isNaf());
        setNegation(objectiveLiteral.isNegation());
        setPredicate(objectiveLiteral.getPredicate());
        setParams(objectiveLiteral.getParams());
    }

    public boolean isLeftClose() {
        return isLeftClose;
    }

    public void setLeftClose(boolean leftClose) {
        isLeftClose = leftClose;
    }

    public boolean isRightClose() {
        return isRightClose;
    }

    public void setRightClose(boolean rightClose) {
        isRightClose = rightClose;
    }

    public double getLeftBound() {
        return leftBound;
    }

    public void setLeftBound(double leftBound) {
        this.leftBound = leftBound;
    }

    public double getRightBound() {
        return rightBound;
    }

    public void setRightBound(double rightBound) {
        this.rightBound = rightBound;
    }

    @Override
    public String toString() {
        return "K" + (isLeftClose() ? "[" : "(") + getLeftBound() + "," + getRightBound() + (isRightClose() ? "]" : ")") + getSimpleLiteral();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(isLeftClose())
                .append(getLeftBound())
                .append(isRightClose())
                .append(getRightBound())
                .append(isNaf())
                .append(isNegation())
                .append(getPredicate())
                .append(getParams())
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (null == obj || obj.getClass() != PelpSubjectiveLiteral.class) {
            return false;
        } else {
            PelpSubjectiveLiteral other = (PelpSubjectiveLiteral) obj;
            return new EqualsBuilder()
                    .append(isLeftClose(), other.isLeftClose())
                    .append(getLeftBound(), other.getLeftBound())
                    .append(isRightClose(), other.isRightClose())
                    .append(getRightBound(), other.getRightBound())
                    .append(isNaf(), other.isNaf())
                    .append(isNegation(), other.isNegation())
                    .append(getPredicate(), other.getPredicate())
                    .append(getParams(), other.getParams())
                    .isEquals();
        }
    }

    @Override
    public boolean isPositive() {
        return false;
    }

    public boolean isEpistemicConfirm() {
        return isLeftClose() && isRightClose() &&
                Math.abs(getLeftBound() - 1) < 1e-6 && Math.abs(getRightBound() - 1) < 1e-6;
    }

    public boolean isEpistemicDeny() {
        return isLeftClose() && isRightClose() &&
                Math.abs(getLeftBound() - 0) < 1e-6 && Math.abs(getRightBound() - 0) < 1e-6;
    }

    public PelpObjectiveLiteral getObjectiveLiteral() {
        return new PelpObjectiveLiteral(isNaf(), isNegation(), getPredicate(), getParams());
    }
}
