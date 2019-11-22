package com.ypw.viewmodel.db.entity;

import androidx.room.Entity;
import androidx.room.Fts4;

/**
 * @author : fengzili on
 * @email : 291924028@qq.com
 * @date : 2019/10/29 0029
 * @pkn : com.ypw.viewmodel.db.entity
 * @desc :
 */
@Entity(tableName = "productsFts")
@Fts4(contentEntity = ProductEntity.class)
public class ProductFtsEntity {
    private String name;
    private String description;

    public ProductFtsEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
