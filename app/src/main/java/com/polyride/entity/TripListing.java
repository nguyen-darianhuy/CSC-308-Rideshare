package com.polyride.entity;

import com.google.firebase.firestore.DocumentSnapshot;

public class TripListing {


    private User driver;
    private String driverID;
    private Integer maxPassengers;
    private Integer numPassengers;
    private String destination;
    private String departure;
    private String departureDate;

    public TripListing() {}

    public TripListing(DocumentSnapshot document, User user, String uID) {
        setTripAttributes(document, user, uID);
    }

    public TripListing(User driver, Integer maxPassengers, Integer numPassengers,
                       String destination, String departure, String departureDate,
                       String driverID) {
        this.driver = driver;
        this.maxPassengers = maxPassengers;
        this.numPassengers = numPassengers;
        this.destination = destination;
        this.departure = departure;
        this.departureDate = departureDate;
        this.driverID = driverID;
    }

    @Override
    public String toString() {
        return "TripListing{" +
                "driver=" + driver +
                ", maxPassengers=" + maxPassengers +
                ", numPassengers=" + numPassengers +
                ", destination='" + destination + '\'' +
                ", departure='" + departure + '\'' +
                ", departureDate='" + departureDate + '\'' +
                '}';
    }

    private void setTripAttributes(DocumentSnapshot document, User user, String uID) {
        driver = user;
        maxPassengers = document.get("maxPassengers", Integer.class);
        numPassengers = document.get("numPassengers", Integer.class);
        destination = document.getString("destination");
        departure = document.getString("departure");
        departureDate = document.getString("departureDate");
        driverID = uID;
    }

    public String getDriverID() {
        return driverID;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
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

    public String getRoute() {
        String dep;
        String dest;

        if (departure.equals("")) { dep = "Undefined"; }
        else { dep = departure; }

        if (destination.equals("")) { dest = "Undefined"; }
        else { dest = destination; }

        return (dep + " -> " + dest);
    }

    public int getAvailableSeats() {
        return maxPassengers - numPassengers;
    }
}