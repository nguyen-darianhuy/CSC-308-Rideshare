package com.polyride.entity;

public class TripListing {

    public User driver;
    public Integer maxPassengers;
    public Integer numPassengers;
    public String destination;
    public String departure;
    public String departureDate;

    public TripListing() {}

    public TripListing(User driver, Integer maxPassengers, Integer numPassengers,
                       String destination, String departure, String departureDate) {
        this.driver = driver;
        this.maxPassengers = maxPassengers;
        this.numPassengers = numPassengers;
        this.destination = destination;
        this.departure = departure;
        this.departureDate = departureDate;
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
}