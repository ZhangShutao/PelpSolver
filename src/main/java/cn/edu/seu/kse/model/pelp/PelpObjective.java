package cn.edu.seu.kse.model.pelp;

/**
 * 客观原子
 * Created by 张舒韬 on 2017/3/28.
 */
public abstract class PelpObjective extends PelpLiteral {
    @Override
    public boolean isSubjective() {
        return false;
    }
}
