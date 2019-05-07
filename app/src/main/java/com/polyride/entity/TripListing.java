package com.polyride.entity;
import android.arch.persistence.room.Index;
import android.support.annotation.*;
import java.util.Date;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity (indices = {@Index("driverId")},
        foreignKeys = @ForeignKey(entity = Users.class,
        parentColumns = "userId",
        childColumns = "driverId"))

public class TripListing {
    @NonNull
    @PrimaryKey
    public Integer rideId;

    @NonNull
    @ColumnInfo(name = "driverId")
    public Integer driverId;

    @NonNull
    @ColumnInfo(name = "maxPassengers")
    public Integer maxPassengers;

    @ColumnInfo(name = "numPassengers")
    public Integer numPassengers;

    @NonNull
    @ColumnInfo(name = "destination")
    public String destination;

    @NonNull
    @ColumnInfo(name = "departure")
    public String departure;

    @NonNull
    @ColumnInfo(name = "departureDate")
    public String departureDate;

    @NonNull
    @ColumnInfo(name = "postDate")
    public Date postDate;


    public TripListing(Integer rideId, Integer driverId, Integer maxPassengers,
                       String destination, String departure,
                       String departureDate, Date postDate) {
        this.rideId = rideId;
        this.driverId = driverId;
        this.maxPassengers = maxPassengers;
        this.numPassengers = numPassengers;
        this.destination = destination;
        this.departure = departure;
        this.departureDate = departureDate;
        this.postDate = postDate;
    }

    public Integer getRideId() {
        return rideId;
    }
    public void setRideId(Integer rideId) {
        this.rideId = rideId;
    }

    public Integer getDriverId() {
        return driverId;
    }
    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public Integer getMaxPassengers() {
        return maxPassengers;
    }
    public void setMaxPassengers(Integer maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public Integer getNumPassengers() {
        return numPassengers;
    }
    public void setNumPassengers(Integer numPassengers) {
        this.numPassengers = numPassengers;
    }

    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDeparture() {
        return departure;
    }
    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDepartureDate() {
        return departureDate;
    }
    public void setDepartureDate(String departureDate) { this.departureDate = departureDate; }

    public Date getPostDate() { return postDate; }
    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }
}