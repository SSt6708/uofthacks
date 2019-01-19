package parking_lot;

public interface Location {

    /**
     * Return the Coordinate of the Entrance
     *
     * @return the Coordinate of the Entrance
     */
    Coordinate getEntrance();

    /**
     * Return the Coordinate of the Exit
     *
     * @return the Coordinate of the Exit
     */
    Coordinate getExit();

    /**
     * return the id of the location
     * @return the id of the location
     */
    String getId();
}
