package com.sl;

import org.springframework.beans.factory.annotation.Autowired;

public class ProductV2 implements IProduct{

    String name;
    float price;
    @Autowired IBrand brand;

    public ProductV2(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public float getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public IBrand getBrand() {
        return brand;
    }

    public void setBrand(IBrand brand) {
        this.brand = brand;
    }
}