package parking_lot;

import java.util.ArrayList;
import java.util.List;

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


}
