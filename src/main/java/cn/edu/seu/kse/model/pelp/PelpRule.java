package cn.edu.seu.kse.model.pelp;

import cn.edu.seu.kse.model.BaseObjectModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.*;

/**
 * PELP规则的语法类
 *
 * @author 张舒韬
 * @date 2017/1/6
 */
public class PelpRule extends BaseObjectModel {
    private List<PelpObjectiveLiteral> head = new ArrayList<>();
    private List<BasePelpLiteral> body = new ArrayList<>();
    private Double weight = null;

    private static final String DEFAULT_ID = "_r0";

    public PelpRule() {
        setId(DEFAULT_ID);
    }

    public PelpRule(List<PelpObjectiveLiteral> head, List<BasePelpLiteral> body) {
        super();
        this.head = head;
        this.body = body;
    }

    public PelpRule(List<PelpObjectiveLiteral> head, List<BasePelpLiteral> body, Double weight) {
        super();
        this.head = head;
        this.body = body;
        this.weight = weight;
    }

    public List<PelpObjectiveLiteral> getHead() {
        return head;
    }

    public void setHead(List<PelpObjectiveLiteral> head) {
        this.head = head;
    }

    public List<BasePelpLiteral> getBody() {
        return body;
    }

    public void setBody(List<BasePelpLiteral> body) {
        this.body = body;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    /**
     * 该规则是否安全，即首部的变量在体部正字中都出现
     * @return 规则安全则为true，否则为false
     */
    public boolean isSafe() {
        Set<PelpParam> headVariable = new HashSet<>();
        getHead().forEach(literal -> headVariable.addAll(literal.getVariableSet()));

        Set<PelpParam> positiveBodyVariable = new HashSet<>();
        getPositiveBody().forEach(literal -> positiveBodyVariable.addAll(literal.getVariableSet()));

        return positiveBodyVariable.containsAll(headVariable);
    }

    /**
     * 该规则是事实规则
     * @return 该规则是事实则为true，否则为false
     */
    public boolean isFact() {
        return !getHead().isEmpty() && getBody().isEmpty();
    }

    /**
     * 该规则是约束规则
     * @return 该规则是约束则为true，否则为false
     */
    public boolean isConstrain() {
        return getHead().isEmpty() && !getBody().isEmpty();
    }

    /**
     * 该规则是软规则
     * @return 该规则是软规则则为true，否则为false
     */
    public boolean isSoft() {
        return getWeight() != null;
    }

    @Override
    public String toString() {
        StringJoiner headJoiner = new StringJoiner("|");
        StringJoiner bodyJoiner = new StringJoiner(",");

        getHead().forEach(literal -> headJoiner.add(literal.toString()));
        getBody().forEach(literal -> bodyJoiner.add(literal.toString()));

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(headJoiner.toString());
        if (!isFact()) {
            stringBuilder.append(":-").append(bodyJoiner.toString());
        }
        stringBuilder.append(".");
        if (isSoft()) {
            stringBuilder.append("[").append(getWeight()).append("]");
        }
        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getHead()).append(getBody()).append(getWeight()).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (null == obj || obj.getClass() != PelpProgram.class) {
            return false;
        } else {
            PelpRule other = (PelpRule) obj;
            return new EqualsBuilder()
                    .append(getHead(), other.getHead())
                    .append(getBody(), other.getBody())
                    .append(getWeight(), other.getWeight())
                    .isEquals();
        }
    }

    public Set<PelpParam> getHerbrandUniverse() {
        Set<PelpParam> herbrandUniverse = new HashSet<>();
        getHead().forEach(literal -> herbrandUniverse.addAll(literal.getHerbrandUniverse()));
        getBody().forEach(literal -> herbrandUniverse.addAll(literal.getHerbrandUniverse()));
        return herbrandUniverse;
    }

    public Set<PelpParam> getVariableSet() {
        Set<PelpParam> variableSet = new HashSet<>();
        getBody().forEach(literal -> variableSet.addAll(literal.getVariableSet()));
        return variableSet;
    }

    public Set<BasePelpLiteral> getPositiveBody() {
        Set<BasePelpLiteral> literals = new HashSet<>();
        getBody().forEach(literal -> {
            if (literal.isPositive()) {
                literals.add(literal);
            }
        });
        return literals;
    }

    public Set<PelpSubjectiveLiteral> getSubjectiveLiterals() {
        Set<PelpSubjectiveLiteral> subjectiveLiterals = new HashSet<>();
        getBody().forEach(literal -> {
            if (literal instanceof PelpSubjectiveLiteral) {
                subjectiveLiterals.add((PelpSubjectiveLiteral) literal);
            }
        });
        return subjectiveLiterals;
    }

    public Set<BasePelpSubjective> getSubjectives() {
        Set<BasePelpSubjective> subjectives = new HashSet<>();
        getBody().forEach(literal -> {
            if (literal.isSubjective()) {
                subjectives.add((BasePelpSubjective) literal);
            }
        });
        return subjectives;
    }
}
