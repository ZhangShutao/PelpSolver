package cn.edu.seu.kse.model.pelp;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

/**
 * the world view in the reasoning result of a PELP program
 *
 * @author 张舒韬
 * @date 2017/2/7
 */
public class WorldView {
    private Set<PossibleWorld> possibleWorldSet = new HashSet<>();
    /** 世界观支持的主观字 */
    private Set<BasePelpSubjective> supportedEpistemic = new HashSet<>();
    /** 世界观否定的主观字 */
    private Set<BasePelpSubjective> unsupportedEpistemic = new HashSet<>();

    public WorldView(Set<BasePelpSubjective> supportedEpistemic, Set<BasePelpSubjective> unsupportedEpistemic) {
        this.supportedEpistemic = supportedEpistemic;
        this.unsupportedEpistemic = unsupportedEpistemic;
    }

    public Set<PossibleWorld> getPossibleWorldSet() {
        return possibleWorldSet;
    }

    public void setPossibleWorldSet(Set<PossibleWorld> possibleWorldSet) {
        this.possibleWorldSet = possibleWorldSet;
    }

    public Set<BasePelpSubjective> getSupportedEpistemic() {
        return supportedEpistemic;
    }

    public void setSupportedEpistemic(Set<BasePelpSubjective> supportedEpistemic) {
        this.supportedEpistemic = supportedEpistemic;
    }

    public Set<BasePelpSubjective> getUnsupportedEpistemic() {
        return unsupportedEpistemic;
    }

    public void setUnsupportedEpistemic(Set<BasePelpSubjective> unsupportedEpistemic) {
        this.unsupportedEpistemic = unsupportedEpistemic;
    }

    public void addPossibleWorld(PossibleWorld possibleWorld) {
        getPossibleWorldSet().add(possibleWorld);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        } else {
            WorldView worldView = (WorldView) o;
            return new EqualsBuilder().append(getPossibleWorldSet(), worldView.getPossibleWorldSet())
                    .append(getSupportedEpistemic(), worldView.getSupportedEpistemic())
                    .append(getUnsupportedEpistemic(), worldView.getUnsupportedEpistemic())
                    .isEquals();
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getPossibleWorldSet())
                .append(getSupportedEpistemic())
                .append(getUnsupportedEpistemic())
                .toHashCode();
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(",", "{", "}");
        getPossibleWorldSet().forEach(possibleWorld -> joiner.add(possibleWorld.toString()));
        return joiner.toString();
    }
}
