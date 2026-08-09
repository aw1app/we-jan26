package com.sl.orderservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long cartId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "dish_id")
    private String dishId;

    @Column(name = "dish_name")
    private String dishName;

    private double price;
    private int quantity;

    @Column(name = "thumbnail_image")
    private String thumbnailImage;

    public CartItem() {}

    public CartItem(Long cartId, String userId, String dishId, String dishName, double price, int quantity, String thumbnailImage) {
        this.cartId = cartId;
        this.userId = userId;
        this.dishId = dishId;
        this.dishName = dishName;
        this.price = price;
        this.quantity = quantity;
        this.thumbnailImage = thumbnailImage;
    }

    public Long getCartId() { return cartId; }
    public void setCartId(Long cartId) { this.cartId = cartId; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getDishId() { return dishId; }
    public void setDishId(String dishId) { this.dishId = dishId; }

    public String getDishName() { return dishName; }
    public void setDishName(String dishName) { this.dishName = dishName; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getThumbnailImage() { return thumbnailImage; }
    public void setThumbnailImage(String thumbnailImage) { this.thumbnailImage = thumbnailImage; }
}

