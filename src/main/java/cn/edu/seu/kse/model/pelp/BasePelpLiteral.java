package cn.edu.seu.kse.model.pelp;

import cn.edu.seu.kse.model.BaseObjectModel;

import java.util.*;

/**
 * PELP字的语法类，是一个抽象类，有表示主观字和客观字的子类
 *
 * @author 张舒韬
 * @date 2017/1/6
 */
public abstract class BasePelpLiteral extends BaseObjectModel {

    /**
     * get all elements of the Herbrand universe in this literal
     * @return element set
     */
    public abstract Set<PelpParam> getHerbrandUniverse();

    /**
     * get all variable in this literal
     * @return variable set
     */
    public abstract Set<PelpParam> getVariableSet();

    /**
     * check if this literal is positive
     * @return true if it is positive
     */
    public abstract boolean isPositive();

    /**
     * check if this literal is subjective
     * @return true if it is subjective
     */
    public abstract boolean isSubjective();
}
