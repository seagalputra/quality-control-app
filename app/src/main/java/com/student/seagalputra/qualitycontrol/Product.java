package com.student.seagalputra.qualitycontrol;

/**
 * Created by seagalputra on 5/6/18.
 */

public class Product {
    private String name, type, price;

    public Product() {

    }

    public Product(String name, String type, String price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

}
