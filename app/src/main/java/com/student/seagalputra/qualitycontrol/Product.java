package com.student.seagalputra.qualitycontrol;

import com.android.volley.toolbox.StringRequest;

/**
 * Created by seagalputra on 5/6/18.
 */

public class Product {
    private String idProduct, name, type, brand, price;
    private int buyPrice, productQuantity;
    private int productStatus;

    public Product(String id_produk) {

    }

    // Constructor for RecyclerView
    public Product(String name, String type, String price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    // Constructor for QualityControl View
    public Product(String idProduct, String name, String type, String brand, String price, int buyPrice, int productStatus, int productQuantity) {
        this.idProduct = idProduct;
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.price = price;
        this.buyPrice = buyPrice;
        this.productStatus = productStatus;
        this.productQuantity = productQuantity;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getPrice() {
        return price;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }
}
