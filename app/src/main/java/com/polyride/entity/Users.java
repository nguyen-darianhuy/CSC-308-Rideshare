package com.polyride.entity;
import android.support.annotation.NonNull;

import java.util.*;

public class Users {

    public Integer userId;
    public Integer profId;
    public String firstName;
    public String lastName;
    public int age;
    public String bio;
    public List<Integer> reviews;

    public Users() {}

    public Users(Integer userId, String firstName,
                 String lastName, Integer age, String bio) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.bio = bio;
        this.reviews = new ArrayList<>();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProfId() {
        return profId;
    }

    public void setProfId(Integer profId) {
        this.profId = profId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void addReview(Integer reviewId) { reviews.add(reviewId); }

    public void printReviews() {
        System.out.println("Reviews:");
        for (int i = 0; i < reviews.size(); i++) {
            System.out.println(reviews.get(i));
        }
    }
}
