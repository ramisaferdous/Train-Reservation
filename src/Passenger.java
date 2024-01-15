import java.util.List;

class Passenger {
    private String name;
    private String contactNumber;
    public static final List<Passenger> passengersCollection = RailwayManagementSystem.getCustomersCollection();

    public Passenger() {

    }
    public Passenger(String name, String contactNumber) {
        this.name = name;
        this.contactNumber = contactNumber;
        passengersCollection.add(new Passenger(name,contactNumber));
    }


    public String getContactNumber() {
        return contactNumber;
    }

    public String getName() {
        return name;
    }

    // Getters and setters...
}