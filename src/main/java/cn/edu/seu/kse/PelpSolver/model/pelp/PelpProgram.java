package cn.edu.seu.kse.PelpSolver.model.pelp;

import cn.edu.seu.kse.PelpSolver.model.ObjectModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.*;

/**
 * PELP程序的语法类
 * Created by 张舒韬 on 2017/1/6.
 */
public class PelpProgram extends ObjectModel {
    private List<PelpRule> rules = new ArrayList<>();   // 程序中的规则

    public PelpProgram() {
    }

    public PelpProgram(List<PelpRule> rules) {
        this.rules = rules;
    }

    public List<PelpRule> getRules() {
        return rules;
    }

    public void setRules(List<PelpRule> rules) {
        this.rules = rules;
    }

    /**
     * 向程序中添加规则
     * @param rule 待添加的规则
     */
    public void addRule(PelpRule rule) {
        rules.add(rule);
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        rules.forEach(rule -> joiner.add(rule.toString()));
        return joiner.toString();
    }

    @Override
    public int hashCode() {
        Set<PelpRule> ruleSet = new HashSet<>(rules);
        return new HashCodeBuilder().append(ruleSet.toArray()).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj || obj.getClass() != PelpProgram.class) {
            return false;
        } else {
            PelpProgram other = (PelpProgram) obj;
            return new EqualsBuilder().append(new HashSet<>(getRules()), new HashSet<>(other.getRules())).isEquals();
        }
    }
}
