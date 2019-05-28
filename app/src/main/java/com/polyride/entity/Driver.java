package com.polyride.entity;
import java.util.ArrayList;
import java.util.List;


public class Driver {


    public Integer userId;
    public Integer carId;
    public List<Integer> plannedTrips;

    public Driver() {}

    public Driver(Integer userId, Integer carId ) {
        this.userId = userId;
        this.carId = carId;
        this.plannedTrips = new ArrayList<>();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public List<Integer> getPlannedTrips() {
        return plannedTrips;
    }

    public void setPlannedTrips(List<Integer> plannedTrips) {
        this.plannedTrips = plannedTrips;
    }
}