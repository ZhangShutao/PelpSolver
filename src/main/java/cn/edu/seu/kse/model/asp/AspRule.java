package cn.edu.seu.kse.model.asp;

import cn.edu.seu.kse.model.BaseObjectModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * ASP的规则类
 *
 * @author 张舒韬
 * @date 2017/1/9
 */
public class AspRule extends BaseObjectModel {

    private List<AspLiteral> head = new ArrayList<>();
    private List<AspLiteral> body = new ArrayList<>();
    private boolean isSoftConstrain = false;
    private int weight;
    private int level = 0;
    private List<AspParam> softConstrainParams = new ArrayList<>();

    public AspRule() {
    }

    public AspRule(List<AspLiteral> head, List<AspLiteral> body) {
        this.head = head;
        this.body = body;
    }

    public AspRule(List<AspLiteral> body, int weight, int level, List<AspParam> softConstrainParams) {
        this.body = body;
        this.isSoftConstrain = true;
        this.weight = weight;
        this.level = level;
        this.softConstrainParams = softConstrainParams;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<AspParam> getSoftConstrainParams() {
        return softConstrainParams;
    }

    public void setSoftConstrainParams(List<AspParam> softConstrainParams) {
        this.softConstrainParams = softConstrainParams;
    }

    public boolean isFact() {
        return !getHead().isEmpty() && getBody().isEmpty();
    }

    public boolean isConstrain() {
        return getHead().isEmpty() && !getBody().isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        StringJoiner headJoiner = new StringJoiner("|");
        getHead().forEach(aspLiteral -> headJoiner.add(aspLiteral.toString()));
        builder.append(headJoiner.toString());

        if (!isFact()) {
            if (isSoftConstrain()) {
                builder.append(":~");
            } else {
                builder.append(":-");
            }
            StringJoiner bodyJoiner = new StringJoiner(",");
            getBody().forEach(aspLiteral -> bodyJoiner.add(aspLiteral.toString()));
            builder.append(bodyJoiner.toString());
        }
        builder.append(".");
        if (isSoftConstrain()) {
            StringJoiner softJoiner = new StringJoiner(",", "[", "]");
            softJoiner.add(String.valueOf(getWeight()) + "@" + String.valueOf(getLevel()));
            getSoftConstrainParams().forEach(aspParam -> softJoiner.add(aspParam.toString()));

            builder.append(softJoiner.toString());
        }

        return builder.toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getHead())
                .append(isSoftConstrain())
                .append(getBody())
                .append(getWeight())
                .append(getSoftConstrainParams())
                .append(getLevel())
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (null == obj || obj.getClass() != AspRule.class) {
            return false;
        } else {
            AspRule other = (AspRule) obj;
            return new EqualsBuilder()
                    .append(getHead(), other.getHead())
                    .append(getBody(), other.getBody())
                    .append(isSoftConstrain(), other.isSoftConstrain())
                    .append(getWeight(), other.getWeight())
                    .append(getLevel(), other.getLevel())
                    .append(getSoftConstrainParams(), other.getSoftConstrainParams())
                    .isEquals();
        }
    }
}
