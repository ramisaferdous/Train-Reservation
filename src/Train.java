public class Train {
    private String trainNumber;
    private int capacity;
    private Route route;

    public Train(String trainNumber, int capacity, Route route) {
        this.trainNumber = trainNumber;
        this.capacity = capacity;
        this.route = route;
    }

    public String getTrainNumber() {
        return trainNumber;
    }


    // Getters and setters...
}