package com.polyride.entity;

import com.google.firebase.firestore.DocumentSnapshot;

public class TripListing {

    private User driverID;
    private Integer maxPassengers;
    private Integer numPassengers;
    private String destination;
    private String departure;
    private String departureDate;

    public TripListing() {}

    public TripListing(DocumentSnapshot document, User user) {
        setTripAttributes(document, user);
    }

    public TripListing(User driver, Integer maxPassengers, Integer numPassengers,
                       String destination, String departure, String departureDate) {
        this.driverID = driver;
        this.maxPassengers = maxPassengers;
        this.numPassengers = numPassengers;
        this.destination = destination;
        this.departure = departure;
        this.departureDate = departureDate;
    }

    @Override
    public String toString() {
        return "TripListing{" +
                "driver=" + driverID +
                ", maxPassengers=" + maxPassengers +
                ", numPassengers=" + numPassengers +
                ", destination='" + destination + '\'' +
                ", departure='" + departure + '\'' +
                ", departureDate='" + departureDate + '\'' +
                '}';
    }

    private void setTripAttributes(DocumentSnapshot document, User user) {
        driverID = user;
        maxPassengers = document.get("maxPassengers", Integer.class);
        numPassengers = document.get("numPassengers", Integer.class);
        destination = document.getString("destination");
        departure = document.getString("departure");
        departureDate = document.getString("departureDate");
    }

    public User getDriver() {
        return driverID;
    }

    public void setDriver(User driver) {
        this.driverID = driver;
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