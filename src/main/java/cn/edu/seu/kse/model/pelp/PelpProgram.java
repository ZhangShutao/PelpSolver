package cn.edu.seu.kse.model.pelp;

import cn.edu.seu.kse.model.ObjectModel;
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
        getRules().add(rule);
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        getRules().forEach(rule -> joiner.add(rule.toString()));
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
        } else if (null == obj || obj.getClass() != PelpProgram.class) {
            return false;
        } else {
            PelpProgram other = (PelpProgram) obj;
            return new EqualsBuilder().append(getRules(), other.getRules()).isEquals();
        }
    }

    public Set<PelpParam> getHerbrandUniverse() {
        Set<PelpParam> herbrandUniverse = new HashSet<>();
        getRules().forEach(rule -> herbrandUniverse.addAll(rule.getHerbrandUniverse()));
        return herbrandUniverse;
    }
}
