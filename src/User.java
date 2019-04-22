import java.util.List;

public abstract class User {

    private String name;
    private int age;
    private String bio;
    private List<Review> reviews = new ArrayList<Review>();
    private List<TripListing> tripHistory = new ArrayList<TripListing>();

    public User(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getBio() {
        return this.bio;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public void addTripHistory(TripListing trip) {
        tripHistory.add(trip);
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
