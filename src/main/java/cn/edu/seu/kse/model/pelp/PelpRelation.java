package cn.edu.seu.kse.model.pelp;

import java.util.Arrays;

/**
 * TODO:
 * Created by 张舒韬 on 2017/3/15.
 */
public class PelpRelation extends PelpLiteral {

    public PelpRelation(PelpParam left, String operator, PelpParam right) {
        setParams(Arrays.asList(left, right));
        setPredicate(operator);
        setNaf(false);
        setNegation(false);
    }

    @Override
    public String toString() {
        return getParams().get(0).toString() + getPredicate() + getParams().get(1).toString();
    }

    @Override
    public boolean isPositive() {
        return true;
    }
}
