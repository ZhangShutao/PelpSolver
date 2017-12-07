package cn.edu.seu.kse.model.asp;

import cn.edu.seu.kse.model.BaseObjectModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

/**
 * ASP程序的语法类
 *
 * @author 张舒韬
 * @date 2017/1/9
 */
public class AspProgram extends BaseObjectModel {
    private Set<AspRule> rules = new HashSet<>();

    public AspProgram() {
    }

    public AspProgram(Set<AspRule> rules) {
        this.rules = rules;
    }

    public Set<AspRule> getRules() {
        return rules;
    }

    public void setRules(Set<AspRule> rules) {
        this.rules = rules;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        getRules().forEach(aspRule -> joiner.add(aspRule.toString()));
        return joiner.toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getRules()).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (null == obj || obj.getClass() != AspProgram.class) {
            return false;
        } else {
            AspProgram other = (AspProgram) obj;
            return new EqualsBuilder().append(getRules(), other.getRules()).isEquals();
        }
    }
}
