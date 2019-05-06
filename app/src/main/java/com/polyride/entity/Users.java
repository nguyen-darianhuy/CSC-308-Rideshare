package com.polyride.entity;
import android.support.annotation.*;
import java.util.*;

@Entity(foreignKeys = @ForeignKey(entity = Login.class,
        parentColumns = 'profId',
        childColumns = 'profId'))

public class Users {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = 'userId')
    public int userId;

    @NonNull
    @ColumnInfo(name = 'profId')
    public int profId;

    @NonNull
    @ColumnInfo(name = 'firstname')
    public String firstName;

    @NonNull
    @ColumnInfo(name = 'lastname')
    public String lastName;

    @ColumnInfo(name = 'age')
    public int age;

    @ColumnInfo(name = 'bio')
    public String bio;

    @Ignore
    private List<Integer> reviews = new ArrayList<Integer>;
    @Ignore
    private List<Integer> tripHistory = new ArrayList<Integer>;


    @Ignore
    public Users(int userId, String userName, String firstName, String lastName, int age, String bio) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.bio = bio;
    }

    public void setUserID(int userID) { this.userId = userID; }
    public int getUserID() { return this.userId; }

    public void setUserName(String userName) { this.userName = userName; }
    public String getUserName() { return userName; }

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
