package cn.edu.seu.kse.PelpSolver.model.asp;

import cn.edu.seu.kse.PelpSolver.model.ObjectModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * ASP的规则类
 * Created by 张舒韬 on 2017/1/9.
 */
public class AspRule extends ObjectModel {

    private List<AspLiteral> head = new ArrayList<>();
    private List<AspLiteral> body = new ArrayList<>();
    private boolean isSoftConstrain = false;
    private int weight;

    public AspRule() {
    }

    public AspRule(List<AspLiteral> head, List<AspLiteral> body) {
        this.head = head;
        this.body = body;
    }

    public AspRule(List<AspLiteral> body, int weight) {
        this.body = body;
        this.isSoftConstrain = true;
        this.weight = weight;
    }

    public List<AspLiteral> getHead() {
        return head;
    }

    public void setHead(List<AspLiteral> head) {
        this.head = head;
    }

    public List<AspLiteral> getBody() {
        return body;
    }

    public void setBody(List<AspLiteral> body) {
        this.body = body;
    }

    public boolean isSoftConstrain() {
        return isSoftConstrain;
    }

    public void setSoftConstrain(boolean softConstrain) {
        isSoftConstrain = softConstrain;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isFact() {
        return !head.isEmpty() && body.isEmpty();
    }

    public boolean isConstrain() {
        return head.isEmpty() && !body.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        StringJoiner headJoiner = new StringJoiner("|");
        head.forEach(aspLiteral -> headJoiner.add(aspLiteral.toString()));
        builder.append(headJoiner.toString());

        if (!isFact()) {
            if (isSoftConstrain) {
                builder.append(":~");
            } else {
                builder.append(":-");
            }
            StringJoiner bodyJoiner = new StringJoiner(",");
            body.forEach(aspLiteral -> bodyJoiner.add(aspLiteral.toString()));
            builder.append(bodyJoiner.toString());
        }
        builder.append(".");
        if (isConstrain()) {
            builder.append("[").append(weight).append("]");
        }

        return builder.toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(head.toArray()).append(isSoftConstrain)
                .append(body.toArray()).append(weight).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj || obj.getClass() != AspRule.class) {
            return false;
        } else {
            AspRule other = (AspRule) obj;
            return new EqualsBuilder().append(head, other.getHead()).append(body, other.getBody())
                    .append(isSoftConstrain, other.isSoftConstrain).append(weight, other.getWeight()).isEquals();
        }
    }
}
