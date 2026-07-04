package com.sl;

public class Product implements IProduct{

    String name;
    float price;

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
}