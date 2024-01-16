import java.util.List;

class Passenger {
    private String name;
    private String contactNumber;
    private String user_ID;
    public static final List<Passenger> passengersCollection = RailwayManagementSystem.getCustomersCollection();

    public Passenger() {

    }
    public Passenger(String name, String contactNumber,String user_ID) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.user_ID = user_ID;
//        passengersCollection.add(new Passenger(name,contactNumber));
    }
    public static void addToPassengersCollection(Passenger passenger) {
        passengersCollection.add(passenger);
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return user_ID;
    }

    // Getters and setters...
}