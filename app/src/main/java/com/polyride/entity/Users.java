package com.polyride.entity;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.*;

@Entity(foreignKeys = @ForeignKey(entity = Login.class,
        parentColumns = "profId",
        childColumns = "profId"))

public class Users {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "userId")
    public int userId;

    @ColumnInfo(name = "profId")
    public int profId;

    @ColumnInfo(name = "firstname")
    public String firstName;

    @ColumnInfo(name = "lastname")
    public String lastName;

    @ColumnInfo(name = "age")
    public int age;

    @ColumnInfo(name = "bio")
    public String bio;

    private List<Integer> reviews;
    private List<Integer> tripHistory;

    public Users(int userId, String userName, String firstName, String lastName, int age, String bio) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.bio = bio;
        reviews = new ArrayList<Integer>();
        tripHistory = new ArrayList<Integer>();
    }

    public void setUserID(int userID) { this.userId = userID; }
    public int getUserID() { return this.userId; }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return this.lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return this.age;
    }

    public void setBio(String bio) { this.bio = bio; }
    public String getBio() { return this.bio; }

    public void addReview(int reviewId) { reviews.add(reviewId); }
    public void addTripHistory(int tripId) { tripHistory.add(tripId); }

    public void printReviews() {
        System.out.println("Reviews:");
        for (int i = 0; i < reviews.size(); i++) {
            System.out.println(reviews.get(i));
        }
    }

    public void printHistory() {
        System.out.println("History:");
        for (int i = 0; i < tripHistory.size(); i++) {
            // Implement title field in TripListing to differentiate different rides
            System.out.println(tripHistory.get(i));
        }
    }
}
