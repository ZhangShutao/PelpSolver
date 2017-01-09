package cn.edu.seu.kse.PelpSolver.model.asp;

import cn.edu.seu.kse.PelpSolver.model.ObjectModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * ASP字的参数的语法类
 * Created by 张舒韬 on 2017/1/9.
 */
public class AspParam extends ObjectModel {
    public static final int CONSTANT = 0;
    public static final int VARIABLE = 1;

    private int type;
    private String text;

    public AspParam() {
    }

    public AspParam(int type, String text) {
        this.type = type;
        this.text = text;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(type).append(true).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj || obj.getClass() != AspParam.class) {
            return false;
        } else {
            AspParam other = (AspParam) obj;
            return new EqualsBuilder().append(type, other.getType()).append(text, other.getText()).isEquals();
        }
    }
}
