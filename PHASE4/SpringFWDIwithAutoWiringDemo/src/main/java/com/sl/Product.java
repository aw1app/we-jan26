package com.sl;

import org.springframework.beans.factory.annotation.Autowired;

public class Product implements IProduct{

    String name;
    float price;
    @Autowired IBrand brand;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public float getPrice() {
        return 0f;
    }

    @Override
    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
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