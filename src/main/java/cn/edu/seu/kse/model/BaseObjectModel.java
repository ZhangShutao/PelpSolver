package cn.edu.seu.kse.model;

/**
 * 所有语法单元的基类
 *
 * @author 张舒韬
 * @date 2017/1/6
 */
public abstract class BaseObjectModel {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
