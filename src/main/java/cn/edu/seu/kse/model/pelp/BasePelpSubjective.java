package cn.edu.seu.kse.model.pelp;

/**
 * basic classes of subjective literals or relations in PELP programs
 *
 * @author 张舒韬
 * @date 2017/3/28
 */
public abstract class BasePelpSubjective extends BasePelpLiteral {
    @Override
    public boolean isPositive() {
        return false;
    }

    @Override
    public boolean isSubjective() {
        return true;
    }

    /**
     * generate the hash code of this object
     * @return generated hash code
     */
    @Override
    public abstract int hashCode();

    /**
     * compare two object
     * @param obj another object
     * @return if this object is equal to obj
     */
    @Override
    public abstract boolean equals(Object obj);
}
