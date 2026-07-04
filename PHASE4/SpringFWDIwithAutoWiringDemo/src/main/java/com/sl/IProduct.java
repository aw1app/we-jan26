package com.sl;

public interface IProduct {

    public String getName();
    public void setName(String name) ;

    public float getPrice();
    public void setPrice(float price);

    public IBrand getBrand();
    public void setBrand(IBrand brand);

}