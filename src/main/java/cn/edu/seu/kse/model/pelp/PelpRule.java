package cn.edu.seu.kse.model.pelp;

import cn.edu.seu.kse.model.ObjectModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringJoiner;

/**
 * PELP规则的语法类
 * Created by 张舒韬 on 2017/1/6.
 */
public class PelpRule extends ObjectModel {
    private List<PelpObjectiveLiteral> head = new ArrayList<>();
    private List<PelpLiteral> body = new ArrayList<>();
    private Double weight = null;

    public PelpRule() {
    }

    public PelpRule(List<PelpObjectiveLiteral> head, List<PelpLiteral> body, Double weight) {
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

    public List<PelpLiteral> getBody() {
        return body;
    }

    public void setBody(List<PelpLiteral> body) {
        this.body = body;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    /**
     * 该规则是事实规则
     * @return 该规则是事实则为true，否则为false
     */
    public boolean isFact() {
        return !head.isEmpty() && body.isEmpty();
    }

    /**
     * 该规则是约束规则
     * @return 该规则是约束则为true，否则为false
     */
    public boolean isConstrain() {
        return head.isEmpty() && !body.isEmpty();
    }

    /**
     * 该规则是软规则
     * @return 该规则是软规则则为true，否则为false
     */
    public boolean isSoft() {
        return weight != null;
    }

    @Override
    public String toString() {
        StringJoiner headJoiner = new StringJoiner("|");
        StringJoiner bodyJoiner = new StringJoiner(",");

        head.forEach(literal -> headJoiner.add(literal.toString()));
        body.forEach(literal -> bodyJoiner.add(literal.toString()));

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(headJoiner.toString());
        if (!isFact()) {
            stringBuilder.append(":-").append(bodyJoiner.toString());
        }
        stringBuilder.append(".");
        if (isSoft()) {
            stringBuilder.append("[").append(weight).append("]");
        }
        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getHead().toArray()).append(getBody().toArray()).append(weight).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj || obj.getClass() != PelpProgram.class) {
            return false;
        } else {
            PelpRule other = (PelpRule) obj;
            return new EqualsBuilder().append(new HashSet<>(getHead()), new HashSet<>(other.getHead()))
                    .append(new HashSet<>(getBody()), new HashSet<>(other.getBody()))
                    .append(getWeight(), other.getWeight()).isEquals();
        }
    }
}
