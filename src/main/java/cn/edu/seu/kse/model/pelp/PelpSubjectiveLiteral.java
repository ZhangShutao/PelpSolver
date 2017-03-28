package cn.edu.seu.kse.model.pelp;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.Set;

/**
 * Pelp的主观字
 * Created by 张舒韬 on 2017/1/7.
 */
public class PelpSubjectiveLiteral extends PelpSubjective {

    private boolean isLeftClose;
    private boolean isRightClose;
    private double leftBound;
    private double rightBound;
    private PelpObjectiveLiteral objectiveLiteral = new PelpObjectiveLiteral();

    public PelpSubjectiveLiteral() {
    }

    public PelpSubjectiveLiteral(boolean isLeftClose, boolean isRightClose, double leftBound, double rightBound, PelpObjectiveLiteral objectiveLiteral) {
        this.isLeftClose = isLeftClose;
        this.isRightClose = isRightClose;
        this.leftBound = leftBound;
        this.rightBound = rightBound;
        this.objectiveLiteral.setNaf(objectiveLiteral.isNaf());
        this.objectiveLiteral.setNegation(objectiveLiteral.isNegation());
        this.objectiveLiteral.setPredicate(objectiveLiteral.getPredicate());
        this.objectiveLiteral.setParams(objectiveLiteral.getParams());
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

    public PelpObjectiveLiteral getObjectiveLiteral() {
        return objectiveLiteral;
    }

    public void setObjectiveLiteral(PelpObjectiveLiteral objectiveLiteral) {
        this.objectiveLiteral = objectiveLiteral;
    }

    @Override
    public String toString() {
        return "K" + (isLeftClose() ? "[" : "(") + getLeftBound() + "," + getRightBound() + (isRightClose() ? "]" : ")") + objectiveLiteral.toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(isLeftClose())
                .append(getLeftBound())
                .append(isRightClose())
                .append(getRightBound())
                .append(getObjectiveLiteral())
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
                    .append(getObjectiveLiteral(), other.getObjectiveLiteral())
                    .isEquals();
        }
    }

    /**
     * 判断当前主观字是否是形如K[1,1]o的主观字
     * @return true 或 false
     */
    public boolean isKcc11() {
        return isLeftClose() && isRightClose() &&
                Math.abs(getLeftBound() - 1) < 1e-6 && Math.abs(getRightBound() - 1) < 1e-6;
    }

    /**
     * 判断当前主观字是否是形如K[0,0]o的主观字
     * @return true 或 false
     */
    public boolean isKcc00() {
        return isLeftClose() && isRightClose() &&
                Math.abs(getLeftBound()) < 1e-6 && Math.abs(getRightBound()) < 1e-6;
    }

    /**
     * 判断当前主观字是否是形如K[1,1)o的主观字
     * @return true 或 false
     */
    public boolean isKco01() {
        return isLeftClose() && !isRightClose() &&
                Math.abs(getLeftBound()) < 1e-6 && Math.abs(getRightBound() - 1) < 1e-6;
    }

    /**
     * 判断当前主观字是否是形如K(1,1]o的主观字
     * @return true 或 false
     */
    public boolean isKoc01() {
        return !isLeftClose() && isRightClose() &&
                Math.abs(getLeftBound()) < 1e-6 && Math.abs(getRightBound() - 1) < 1e-6;
    }

    /**
     * 判断当前主观字是否是除了K[1,1]o,K[0,0]o,K(0,1]o,K[0,1)o之外的主观字
     * @return true 或 false
     */
    public boolean isNormal() {
        return !(!isLeftClose() && !isRightClose() &&
                    Math.abs(getLeftBound()) < 1e-6 && Math.abs(getRightBound() - 1) < 1e-6)
                || (getLeftBound()> 1e-6 && getRightBound() < (1 - 1e-6));
    }

    @Override
    public Set<PelpParam> getHerbrandUniverse() {
        return objectiveLiteral.getHerbrandUniverse();
    }

    @Override
    public Set<PelpParam> getVariableSet() {
        return objectiveLiteral.getVariableSet();
    }
}
