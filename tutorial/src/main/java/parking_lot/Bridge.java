package parking_lot;

public class Bridge implements Location {
    private Coordinate entrance;
    private Coordinate exit;

    /**
     * Create a new Bridge with entrance and exit
     * @param entrance Coordinate of the entrance of the bridge
     * @param exit Coordinate of the exit of the bridge
     */
    public Bridge(Coordinate entrance, Coordinate exit) {
        this.entrance = entrance;
        this.exit = exit;
    }

    @Override
    public Coordinate getEntrance() {
        return entrance;
    }

    @Override
    public Coordinate getExit() {
        return exit;
    }
}
