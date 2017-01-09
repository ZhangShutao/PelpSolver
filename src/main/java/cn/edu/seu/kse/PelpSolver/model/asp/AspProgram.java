package cn.edu.seu.kse.PelpSolver.model.asp;

import cn.edu.seu.kse.PelpSolver.model.ObjectModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * ASP程序的语法类
 * Created by 张舒韬 on 2017/1/9.
 */
public class AspProgram extends ObjectModel {
    private List<AspRule> rules = new ArrayList<>();

    public AspProgram() {
    }

    public AspProgram(List<AspRule> rules) {
        this.rules = rules;
    }

    public List<AspRule> getRules() {
        return rules;
    }

    public void setRules(List<AspRule> rules) {
        this.rules = rules;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        rules.forEach(aspRule -> joiner.add(aspRule.toString()));
        return joiner.toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(rules.toArray()).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj || obj.getClass() != AspProgram.class) {
            return false;
        } else {
            AspProgram other = (AspProgram) obj;
            return new EqualsBuilder().append(rules, other.getRules()).isEquals();
        }
    }
}
