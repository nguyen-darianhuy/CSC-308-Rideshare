package com.polyride.entity;

import java.util.*;

public class User {
    private String name;
    private String email;
    private String vehicle;
    private String bio;
    private List<Integer> reviews;

    public User() {}

    public User(String name, String email, String vehicle, String bio, List<Integer> reviews) {
        this.name = name;
        this.email = email;
        this.vehicle = vehicle;
        this.bio = bio;
        this.reviews = reviews;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public String getEmail() {
        return email;
    }

    public String getVehicle() {
        return vehicle;
    }

    public List<Integer> getReviews() {
        return reviews;
    }
}
