package com.polyride.entity;

import java.util.Date;



public class TripListing {

    public String driverID;
    public Integer maxPassengers;
    public Integer numPassengers;
    public String destination;
    public String departure;
    public String departureDate;

    public TripListing() {}

    public TripListing(String driverId, Integer maxPassengers, Integer numPassengers,
                       String destination, String departure, String departureDate) {
        this.driverID = driverId;
        this.maxPassengers = maxPassengers;
        this.numPassengers = numPassengers;
        this.destination = destination;
        this.departure = departure;
        this.departureDate = departureDate;
    }

    public String getDriverId() {
        return driverID;
    }

    public void setDriverId(String driverId) {
        this.driverID = driverId;
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

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }
}