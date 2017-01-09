package cn.edu.seu.kse.PelpSolver.model.asp;

import cn.edu.seu.kse.PelpSolver.model.ObjectModel;

import java.util.ArrayList;
import java.util.List;

/**
 * ASP的规则类
 * Created by 张舒韬 on 2017/1/9.
 */
public class AspRule extends ObjectModel {

    private List<AspLiteral> head = new ArrayList<>();
    private List<AspLiteral> body = new ArrayList<>();
    private boolean isSoftConstrain = false;
    private int weight;

    public AspRule() {
    }

    public AspRule(List<AspLiteral> head, List<AspLiteral> body) {
        this.head = head;
        this.body = body;
    }

    public AspRule(List<AspLiteral> body, int weight) {
        this.body = body;
        this.isSoftConstrain = true;
        this.weight = weight;
    }

    public List<AspLiteral> getHead() {
        return head;
    }

    public void setHead(List<AspLiteral> head) {
        this.head = head;
    }

    public List<AspLiteral> getBody() {
        return body;
    }

    public void setBody(List<AspLiteral> body) {
        this.body = body;
    }

    public boolean isSoftConstrain() {
        return isSoftConstrain;
    }

    public void setSoftConstrain(boolean softConstrain) {
        isSoftConstrain = softConstrain;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isFact() {
        return !head.isEmpty() && body.isEmpty();
    }

    public boolean isConstrain() {
        return head.isEmpty() && !body.isEmpty();
    }
}
