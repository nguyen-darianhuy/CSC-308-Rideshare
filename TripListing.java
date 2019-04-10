public class TripListing {

    String driver;
    String destination;
    String departure;
    String departure_date;
    String posting_date;

    Integer total_spots;
    Integer avaliable_spots;

    public TripListing(String driver, String destination,  String departure, String departure_date,  String posting_date,
                       Integer total_spots, Integer avaliable_spots)
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

    public Integer getTotal_spots(){
        return total_spots;
    }

    public Integer getAvaliable_spots(){
        return avaliable_spots;
    }


}
