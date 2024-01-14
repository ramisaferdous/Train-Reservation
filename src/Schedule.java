import java.time.LocalTime;
import java.util.Map;

class Schedule {
    private Train train;
    private Map<Station, LocalTime> arrivalTimings;

    public Schedule(Train train, Map<Station, LocalTime> arrivalTimings) {
        this.train = train;
        this.arrivalTimings = arrivalTimings;
    }

    // Getters and setters...
}
