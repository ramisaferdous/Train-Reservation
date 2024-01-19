public class ExpressTrain extends Train {
    public ExpressTrain(String trainNumber, int availableSeats) {
        super(trainNumber, availableSeats);
    }
    @Override
    public boolean bookSeats(int numberOfSeats) {
        if (numberOfSeats <= availableSeats) {
            availableSeats -= numberOfSeats;
            return true;
        }
        return false;
    }
}