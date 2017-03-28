package cn.edu.seu.kse.model.pelp;

import cn.edu.seu.kse.model.ObjectModel;

import java.util.*;

/**
 * PELP字的语法类，是一个抽象类，有表示主观字和客观字的子类
 * Created by 张舒韬 on 2017/1/6.
 */
public abstract class PelpLiteral extends ObjectModel {

    public abstract Set<PelpParam> getHerbrandUniverse();

    public abstract Set<PelpParam> getVariableSet();

    public abstract boolean isPositive();
}
