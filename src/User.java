import java.util.List;

public abstract class User {

    private int UserID;
    private String Username;
    private String Name;
    private String Bio;

    public User(int UserID, String username){
        this.UserID = UserID;
        this.Username = Username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getBio() {
        return this.bio;
    }

    public void printReviews() {
        System.out.println("Reviews:");
        for (int i = 0; i < reviews.size(); i++) {
            System.out.println(reviews.get(i));
        }
    }

    public void printHistory() {
        System.out.println("History:");
        for (int i = 0; i < tripHistory.size(); i++) {
            // Implement title field in TripListing to differentiate different rides
            System.out.println(tripHistory.get(i).title);
        }
    }
}
