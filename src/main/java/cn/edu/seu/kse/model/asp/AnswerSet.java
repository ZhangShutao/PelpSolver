package cn.edu.seu.kse.model.asp;

import cn.edu.seu.kse.model.ObjectModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.*;

/**
 * ASP推理所得的回答集的语法类
 * Created by 张舒韬 on 2017/1/9.
 */
public class AnswerSet extends ObjectModel {
    private Set<AspLiteral> literals = new HashSet<>();
    private List<Integer> weights = new ArrayList<>();

    public AnswerSet() {
    }

    public AnswerSet(Set<AspLiteral> literals) {
        this.literals = literals;
    }

    public AnswerSet(Set<AspLiteral> literals, List<Integer> weights) {
        this.literals = literals;
        this.weights = weights;
    }

    public Set<AspLiteral> getLiterals() {
        return literals;
    }

    public void setLiterals(Set<AspLiteral> literals) {
        this.literals = literals;
    }

    public List<Integer> getWeights() {
        return weights;
    }

    public void setWeights(List<Integer> weights) {
        this.weights = weights;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(literals.toArray()).append(weights.toArray()).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj || obj.getClass() == AnswerSet.class) {
            return false;
        } else {
            AnswerSet other = (AnswerSet) obj;
            return new EqualsBuilder().append(literals, other.getLiterals()).append(weights, other.weights).isEquals();
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        StringJoiner answerSetJoiner = new StringJoiner(",", "Answer:\n", "");
        literals.forEach(aspLiteral -> answerSetJoiner.add(aspLiteral.toString()));
        builder.append(answerSetJoiner.toString());

        if (!weights.isEmpty()) {
            StringJoiner weightJoiner = new StringJoiner(",", "\nWeights:\n", "");
            weights.forEach(weight -> weightJoiner.add(weight.toString()));
            builder.append(weightJoiner.toString());
        }

        return builder.toString();
    }
}
