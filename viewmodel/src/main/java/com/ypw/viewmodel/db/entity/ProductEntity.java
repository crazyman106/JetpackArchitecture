package com.ypw.viewmodel.db.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import com.ypw.viewmodel.model.Product;

/**
 * @author : fengzili on
 * @email : 291924028@qq.com
 * @date : 2019/10/29 0029
 * @pkn : com.ypw.viewmodel.db.entity
 * @desc :
 */

@Entity(tableName = "products")
public class ProductEntity implements Product {
    @PrimaryKey
    private int id;
    private String name;
    private String description;
    private int price;

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ProductEntity() {
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    @Ignore
    public ProductEntity(int id, String name, String description, int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public ProductEntity(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
    }
}
