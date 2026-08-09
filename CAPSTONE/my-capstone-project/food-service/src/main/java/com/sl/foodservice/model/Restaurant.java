package com.sl.foodservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "restaurants")
public class Restaurant {
    @Id
    private String id;
    private String name;
    private String cuisine;
    private String description;
    private String address;
    private String contact;
    private String email;
    private double rating;
    private String thumbnailImage;
    private int status;

    public Restaurant() {}

    public Restaurant(String id, String name, String cuisine, String description, String address, String contact, String email, double rating, String thumbnailImage, int status) {
        this.id = id;
        this.name = name;
        this.cuisine = cuisine;
        this.description = description;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.rating = rating;
        this.thumbnailImage = thumbnailImage;
        this.status = status;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCuisine() { return cuisine; }
    public void setCuisine(String cuisine) { this.cuisine = cuisine; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public String getThumbnailImage() { return thumbnailImage; }
    public void setThumbnailImage(String thumbnailImage) { this.thumbnailImage = thumbnailImage; }

    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }
}

