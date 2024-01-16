import java.util.ArrayList;
import java.util.List;

class Station {
    private final String name;
    private final List<Platform> platforms;

    public Station(String name) {
        this.name = name;
        this.platforms = new ArrayList<>();
    }
    public String getName() {
        return name;
    }


    // Getters and setters...
}