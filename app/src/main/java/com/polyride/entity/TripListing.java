import java.util.Date;

public class TripListing {

    int RideID;
    int DriverID;
    int MaxPassengers;
    int NumPassengers;
    String Destination;
    String Departure;
    Date PostDate;
    Date DepartureDate;


    int total_spots;
    int avaliable_spots;

    public TripListing(int RideID, int DriverID, int MaxPassengers, int NumPassengers,
        String Destination, String Departure, Date PostDate, Date DepartureDate)
    {
        this.RideID = RideID;
        this.DriverID = DriverID;
        this.MaxPassengers = MaxPassengers;
        this.NumPassengers = NumPassengers;
        this.Destination = Destination;
        this.Departure = Departure;
        this.PostDate = PostDate;
        this.DepartureDate = DepartureDate;
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
