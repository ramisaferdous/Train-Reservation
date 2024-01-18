import java.util.List;

class Passenger {
    private String name;
    private String contactNumber;
    private String user_ID;
    private String password;
    public static final List<Passenger> passengersCollection = RailwayManagementSystem.getCustomersCollection();

    public Passenger(String name, String contactNumber,String user_ID,String password) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.user_ID = user_ID;
        this.password= password;

    }
    public boolean checkPassword(String password) {
        return this.password.equals(password);
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