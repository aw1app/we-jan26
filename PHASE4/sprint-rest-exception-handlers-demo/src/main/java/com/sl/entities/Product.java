package com.sl.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;

    //TASK-4: Add a constraint that wil disallow names with less than 3 chars
    String name;

    @Min(value=100, message="product price cannot be less than 100!")
    float price;

    String description;


    public Product() {
    }

    public Product(int id, String name, float price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}