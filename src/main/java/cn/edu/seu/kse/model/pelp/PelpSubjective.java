package cn.edu.seu.kse.model.pelp;

/**
 * TODO:
 * Created by 张舒韬 on 2017/3/28.
 */
public abstract class PelpSubjective extends PelpLiteral {
    @Override
    public boolean isPositive() {
        return false;
    }

    @Override
    public boolean isSubjective() {
        return true;
    }
}
