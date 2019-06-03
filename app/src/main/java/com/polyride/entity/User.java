package com.polyride.entity;

import java.util.*;

public class User {
    private String name;
    private String email;
    private String vehicle;
    private String bio;
    private String homeCity;

    public User() {}

    public User(String name, String email, String vehicle, String bio, String homeCity) {
        this.name = name;
        this.email = email;
        this.vehicle = vehicle;
        this.bio = bio;
        this.homeCity = homeCity;
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

    public String getHomeCity() { return homeCity; }
}
