package com.polyride.entity;

import com.google.firebase.Timestamp;

import java.util.Date;

public class TripListing {

    public String driverID;
    public Integer maxPassengers;
    public Integer numPassengers;
    public String destination;
    public String departure;
    public Timestamp departureDate;

    public TripListing() {}

    public TripListing(String driverID, Integer maxPassengers, Integer numPassengers,
                       String destination, String departure, Timestamp departureDate) {
        this.driverID = driverID;
        this.maxPassengers = maxPassengers;
        this.numPassengers = numPassengers;
        this.destination = destination;
        this.departure = departure;
        this.departureDate = departureDate;
    }

    public String getDriverID() {
        return driverID;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
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

    public Timestamp getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Timestamp departureDate) {
        this.departureDate = departureDate;
    }
}