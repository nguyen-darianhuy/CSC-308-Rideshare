package com.polyride.entity;

import com.google.firebase.firestore.DocumentSnapshot;

public class User {
    private String name;
    private String bio;
    private String email;
    private String number;
    private String departureCity;
    private String arrivalCity;

    public User() {}

    public User(String name, String bio, String email, String number, String departureCity, String arrivalCity) {
        this.name = name;
        this.bio = bio;
        this.email = email;
        this.number = number;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
    }

    public User(DocumentSnapshot document) {
        setUserAttributes(document);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", bio='" + bio + '\'' +
                ", email='" + email + '\'' +
                ", number='" + number + '\'' +
                ", departureCity='" + departureCity + '\'' +
                ", arrivalCity='" + arrivalCity + '\'' +
                '}';
    }

    public void setUserAttributes(DocumentSnapshot document) {
        name = document.getString("name");
        bio = document.getString("bio");
        email = document.getString("email");
        number = document.getString("number");
        departureCity = document.getString("departureCity");
        arrivalCity = document.getString("arrivalCity");
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

    public String getNumber() {
        return number;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public String getArrivalCity() { return arrivalCity; }

    public void setName(String name) {
        this.name = name;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }
}
