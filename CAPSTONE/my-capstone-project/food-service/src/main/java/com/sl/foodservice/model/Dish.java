package com.sl.foodservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "dishes")
public class Dish {
    @Id
    private String id;
    private String name;
    private String description;
    private double price;
    private double rating;
    private String restaurantId;
    private String restaurantName;
    private String thumbnailImage;
    private List<String> ingredients;
    private int status;

    public Dish() {}

    public Dish(String id, String name, String description, double price, double rating, String restaurantId, String restaurantName, String thumbnailImage, List<String> ingredients, int status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.thumbnailImage = thumbnailImage;
        this.ingredients = ingredients;
        this.status = status;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public String getRestaurantId() { return restaurantId; }
    public void setRestaurantId(String restaurantId) { this.restaurantId = restaurantId; }

    public String getRestaurantName() { return restaurantName; }
    public void setRestaurantName(String restaurantName) { this.restaurantName = restaurantName; }

    public String getThumbnailImage() { return thumbnailImage; }
    public void setThumbnailImage(String thumbnailImage) { this.thumbnailImage = thumbnailImage; }

    public List<String> getIngredients() { return ingredients; }
    public void setIngredients(List<String> ingredients) { this.ingredients = ingredients; }

    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }
}

