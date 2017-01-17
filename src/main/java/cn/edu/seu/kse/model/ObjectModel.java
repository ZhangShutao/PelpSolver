package cn.edu.seu.kse.model;

import java.util.UUID;

/**
 * 所有语法单元的基类
 * Created by 张舒韬 on 2017/1/6.
 */
public class ObjectModel {
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
