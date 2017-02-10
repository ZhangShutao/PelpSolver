package cn.edu.seu.kse.model.pelp;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.Set;
import java.util.StringJoiner;

/**
 * Pelp推理结果中的可能世界
 * Created by 张舒韬 on 2017/2/7.
 */
public class PossibleWorld {
    private Set<PelpObjectiveLiteral> literals; // 可能世界中的客观字
    private Double weight = 1.0;  // 可能世界在世界观中的权重，在(0, 1]上

    public PossibleWorld(Set<PelpObjectiveLiteral> literals, Double weight) {
        this.literals = literals;
        this.weight = weight;
    }

    public Set<PelpObjectiveLiteral> getLiterals() {
        return literals;
    }

    public void setLiterals(Set<PelpObjectiveLiteral> literals) {
        this.literals = literals;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        if (getLiterals() == null) {
            return 0;
        } else {
            return new HashCodeBuilder().append(getLiterals()).append(getWeight()).toHashCode();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (null != obj && obj.getClass() == PossibleWorld.class) {
            PossibleWorld other = (PossibleWorld) obj;
            return new EqualsBuilder().append(getLiterals(), other.getLiterals()).isEquals();
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        if (null != getLiterals() && null != getWeight()) {
            String prefix = "[" + getWeight().toString() + "]:{";
            StringJoiner joiner = new StringJoiner(",", prefix, "}");
            getLiterals().forEach(literal -> joiner.add(literal.toString()));
            return joiner.toString();
        } else {
            return null;
        }
    }
}
