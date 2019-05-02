package com.polyride.entity;

import java.util.List;
public class Driver extends User{

    private Car carInfo;
    private List<TripListing> plannedTrips;

    public Driver(String name, int age, Car car){
        //super(name, age);
        carInfo = car;
    }

    public void addListing(TripListing t){
        plannedTrips.add(t);
    }

    // TODO
    public void editListing(TripListing t){
        return;
    }

    //TODO
    public void deleteListing(TripListing t){
        return;
    }

    public Car getCarInfo(){return carInfo;}
}