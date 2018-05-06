package com.student.seagalputra.qualitycontrol;

/**
 * Created by seagalputra on 5/6/18.
 */

public class Product {
    private String idProduct, name, type, price, buyPrice;
    private int productQuantity;
    private boolean productStatus;

    public Product() {

    }

    // Constructor for RecyclerView
    public Product(String name, String type, String price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    // Constructor for Product View
    public Product(String idProduct, String name, String type, String price, String buyPrice, int productQuantity, boolean productStatus) {
        this.idProduct = idProduct;
        this.name = name;
        this.type = type;
        this.price = price;
        this.buyPrice = buyPrice;
        this.productQuantity = productQuantity;
        this.productStatus = productStatus;
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

    public String getPrice() {
        return price;
    }

    public String getBuyPrice() {
        return buyPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public boolean isProductStatus() {
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

    public void setPrice(String price) {
        this.price = price;
    }

    public void setBuyPrice(String buyPrice) {
        this.buyPrice = buyPrice;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }
}
