public  class Train {
    protected final String trainNumber;
    protected int availableSeats;

    public Train(String trainNumber, int availableSeats) {
        this.trainNumber = trainNumber;
        this.availableSeats = availableSeats;
    }

    public boolean bookSeats(int numberOfSeats) {
        if (numberOfSeats <= availableSeats) {
            availableSeats -= numberOfSeats;
            return true;
        }
        else{
        return false;}
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public String getTrainNumber() {
        return trainNumber;
    }
}