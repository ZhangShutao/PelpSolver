package cn.edu.seu.kse.model.asp;

import java.util.Arrays;

/**
 * relation expressions in answer set programs
 *
 * @author 张舒韬
 * @date 2017/3/15
 */
public class AspRelation extends AspLiteral {
    public AspRelation(AspParam left, String operator, AspParam right) {
        setParams(Arrays.asList(left, right));
        setPredicate(operator);
        setNafCount(0);
        setNegation(false);
    }

    @Override
    public String toString() {
        return getParams().get(0).toString() + getPredicate() + getParams().get(1).toString();
    }

}
