package com.polyride.entity;
public class Passenger extends User{

    private boolean trustedRider;

    public Passenger(String name, int age){
        super(name, age);
    }

    // TODO
    public void requestSpot(TripListing t){
        return;
    }

    public boolean isTrustedRider(){return trustedRider;}

    public void setTrusted(boolean bool){
        trustedRider = bool;
    }
}