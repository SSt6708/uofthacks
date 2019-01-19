package parking_lot;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LocationManager {

    private List<Location> locations;

    public LocationManager() {
        this.locations = new ArrayList<>();
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public List<Location> getBridges() {
        return locations.stream().filter(x -> x instanceof Bridge).collect(Collectors.toList());
    }

    public List<Location> getLots() {
        return locations.stream().filter(x -> x instanceof Lot).collect(Collectors.toList());
    }
}
