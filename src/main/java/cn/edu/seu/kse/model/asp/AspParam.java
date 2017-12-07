package cn.edu.seu.kse.model.asp;

import cn.edu.seu.kse.model.BaseObjectModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * ASP字的参数的语法类
 *
 * @author 张舒韬
 * @date 2017/1/9
 */
public class AspParam extends BaseObjectModel {
    public static final int CONSTANT = 0;
    public static final int VARIABLE = 1;
    public static final int LITERAL = 2;

    private int type;
    private Object value;

    public AspParam() {
    }

    public AspParam(int type, Object value) {
        this.type = type;
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return getValue().toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getType()).append(getValue()).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (null == obj || obj.getClass() != AspParam.class) {
            return false;
        } else {
            AspParam other = (AspParam) obj;
            return new EqualsBuilder().append(getType(), other.getType()).append(getValue(), other.getValue()).isEquals();
        }
    }
}
