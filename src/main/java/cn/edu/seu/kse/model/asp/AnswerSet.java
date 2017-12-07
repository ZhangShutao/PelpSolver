package cn.edu.seu.kse.model.asp;

import cn.edu.seu.kse.model.BaseObjectModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.*;

/**
 * ASP推理所得的回答集的语法类
 *
 * @author 张舒韬
 * @date 2017/1/9
 */
public class AnswerSet extends BaseObjectModel {
    private Set<AspLiteral> literals = new HashSet<>();
    private Integer weight = 0;

    public AnswerSet() {
    }

    public AnswerSet(Set<AspLiteral> literals) {
        this.literals = literals;
    }

    public AnswerSet(Set<AspLiteral> literals, Integer weight) {
        this.literals = literals;
        this.weight = weight;
    }

    public Set<AspLiteral> getLiterals() {
        return literals;
    }

    public void setLiterals(Set<AspLiteral> literals) {
        this.literals = literals;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getLiterals()).append(getWeight()).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (null == obj || obj.getClass() != AnswerSet.class) {
            return false;
        } else {
            AnswerSet other = (AnswerSet) obj;
            return new EqualsBuilder().append(getLiterals(), other.getLiterals()).append(getWeight(), other.getWeight()).isEquals();
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        StringJoiner answerSetJoiner = new StringJoiner(",", "Answer:\n", "");
        literals.forEach(aspLiteral -> answerSetJoiner.add(aspLiteral.toString()));
        builder.append(answerSetJoiner.toString());

        if (weight != 0) {
            builder.append("\nWeights:").append(weight);
        }

        return builder.toString();
    }
}
