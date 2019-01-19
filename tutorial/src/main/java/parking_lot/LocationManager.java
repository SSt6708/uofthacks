package parking_lot;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LocationManager {
    /**
     * List of locations (of bridges, parking lots)
     */
    private List<Location> locations;

    /**
     * Creates a new Location manager with no locations initialized
     */
    public LocationManager() {
        this.locations = new ArrayList<>();
    }

    /**
     * set the self.locations to locations
     * @param locations the locations to be set to
     */
    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    /**
     * get the locations of this LocationManager
     * @return the locations
     */
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
