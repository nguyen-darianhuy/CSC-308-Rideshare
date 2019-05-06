package com.polyride.entity;
import android.support.annotation.*;
import java.util.Date;
@Entity (foreignKeys = @ForeignKey(entity = Users.class,
        parentColumns = 'userId',
        childColumns = 'driverId'))

public class TripListing {
    @NonNull
    @PrimaryKey
    public int rideId;

    @NonNull
    @ColumnInfo(name = "driverId")
    public int driverId;

    @ColumnInfo(name = "maxPassengers")
    public int maxPassengers;

    @ColumnInfo(name = "numPassengers")
    public int numPassengers;

    @NonNull
    @ColumnInfo(name = "destination")
    public String destination;

    @NonNull
    @ColumnInfo(name = "departure")
    public String departure;

    @NonNull
    @ColumnInfo(name = "departureDate")
    public String departureDate;

    @ColumnInfo(name = "postDate")
    public Date postDate;


    public TripListing()
    {
    }

    public int getRideId() {
        return rideId;
    }
    public void setRideId(int rideId) {
        this.rideId = rideId;
    }

    public int getDriverId() {
        return driverId;
    }
    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }
    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public int getNumPassengers() {
        return numPassengers;
    }
    public void setNumPassengers(int numPassengers) {
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