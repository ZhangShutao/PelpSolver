package cn.edu.seu.kse.model.pelp;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.Set;
import java.util.StringJoiner;

/**
 * TODO:
 * Created by 张舒韬 on 2017/2/7.
 */
public class WorldView {
    private Set<PossibleWorld> possibleWorldSet;

    public Set<PossibleWorld> getPossibleWorldSet() {
        return possibleWorldSet;
    }

    public void setPossibleWorldSet(Set<PossibleWorld> possibleWorldSet) {
        this.possibleWorldSet = possibleWorldSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        } else {
            WorldView worldView = (WorldView) o;
            return new EqualsBuilder().append(getPossibleWorldSet(), worldView.getPossibleWorldSet()).isEquals();
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getPossibleWorldSet()).toHashCode();
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(",", "{", "}");
        getPossibleWorldSet().forEach(possibleWorld -> joiner.add(possibleWorld.toString()));
        return joiner.toString();
    }
}
