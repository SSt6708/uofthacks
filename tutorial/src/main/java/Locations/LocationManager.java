package Locations;

import java.util.*;

public class LocationManager {
    /**
     * List of locations (of bridges, parking lots)
     */
    private Map<String, List<Location>> locations;

    public static final Set<String> LOCATION_TYPES = new HashSet<>(Arrays.asList("Bridge", "Lot"));

    /**
     * Creates a new Location manager with no locations initialized
     */
    public LocationManager() {
        this.locations = new HashMap<>();
        for (String locationType: LOCATION_TYPES) {
            this.locations.put(locationType, new ArrayList<>());
        }
    }

    /**
     * set the self.locations to locations
     * @param locations the locations to be set to
     */
    public void setLocations(List<Location> locations) {
        for (Location location: locations) {
            addLocation(location);
        }
    }

    /**
     * get the locations of this LocationManager
     * @return the locations
     */
    public Map<String, List<Location>> getLocations() {
        return locations;
    }

    public void addLocation(Location location) {
        this.locations.get(location.getClass().getSimpleName()).add(location);
    }

    public List<Location> getTypeList(String type) {
        if (LOCATION_TYPES.contains(type)) {
            return this.locations.get(type);
        } else {
            return null;
        }
    }
}
