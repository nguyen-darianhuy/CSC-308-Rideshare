package com.polyride.entity;

public class TripListing {

    private User driver;
    private Integer maxPassengers;
    private Integer numPassengers;
    private String destination;
    private String departure;
    private String departureDate;

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

    public String getRoute() {
        String dest = getDestination();
        String depa = getDeparture();
        if (dest.equals("")) {
            dest = "Undefined";
        }
        if (depa.equals("")) {
            depa = "Undefined";
        }
        return depa + " -> " + dest;
    }

    public Integer getAvailableSeats() {
        return getMaxPassengers() - getNumPassengers();
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