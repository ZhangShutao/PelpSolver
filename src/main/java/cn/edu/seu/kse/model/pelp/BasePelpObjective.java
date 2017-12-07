package cn.edu.seu.kse.model.pelp;

/**
 * 客观原子
 *
 * @author 张舒韬
 * @date 2017/3/28
 */
public abstract class BasePelpObjective extends BasePelpLiteral {
    @Override
    public boolean isSubjective() {
        return false;
    }
}
