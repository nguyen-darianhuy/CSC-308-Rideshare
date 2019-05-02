package com.polyride.entity;
public class TripListing {

    String title;
    String driver;
    String destination;
    String departure;
    String departure_date;
    String posting_date;

    int total_spots;
    int avaliable_spots;

    public TripListing(String driver, String destination,  String departure, String departure_date,  String posting_date,
                       int total_spots, int avaliable_spots)
    {
        this.driver = driver;
        this.destination = destination;
        this.departure = departure;
        this.departure_date = departure_date;
        this.posting_date = posting_date;

        this.total_spots = total_spots;
        this.avaliable_spots = avaliable_spots;
    }


    public String getDriver(){
        return driver;
    }

    public String getDestination(){
        return destination;
    }

    public String getDeparture(){
        return departure;
    }

    public String getDeparture_date(){
        return departure_date;
    }

    public String getPosting_date(){
        return posting_date;
    }

    public int getTotal_spots(){
        return total_spots;
    }

    public int getAvaliable_spots(){
        return avaliable_spots;
    }


}
