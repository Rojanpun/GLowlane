package com.example.glowlane;

public class Product {

    private int id;
    private String name;
    private String image;
    private String description;
    private String category;
    private String availability;
    private float price;

    public Product(int id, String name, String image, String description, String category, String availability, float price) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.category = category;
        this.availability = availability;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getAvailability() {
        return availability;
    }

    public float getPrice() {
        return price;
    }
}
