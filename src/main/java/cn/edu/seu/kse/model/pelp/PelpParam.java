package cn.edu.seu.kse.model.pelp;

import cn.edu.seu.kse.model.ObjectModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Pelp中字的参数，分为常量和变量两种
 * Created by 张舒韬 on 2017/1/6.
 */
public class PelpParam extends ObjectModel {
    public static final int CONSTANT = 0;
    public static final int VARIABLE = 1;
    public static final int LITERAL = 2;

    private int type;
    private Object value;

    public PelpParam(int type, Object value) {
        this.type = type;
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getText() {
        return value.toString();
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return getText();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getType()).append(getValue()).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj || obj.getClass() != PelpParam.class) {
            return false;
        } else {
            PelpParam other = (PelpParam) obj;
            return new EqualsBuilder().append(getType(), other.getType()).append(getValue(), other.getValue()).isEquals();
        }
    }
}
