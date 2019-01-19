package Locations;

public class Bridge implements Location {
    private Coordinate entrance;
    private Coordinate exit;
    /**
     * the (unique) id of the Bridge
     */
    private String id;

    /**
     * Create a new Bridge with entrance and exit
     * @param entrance Coordinate of the entrance of the bridge
     * @param exit Coordinate of the exit of the bridge
     */
    public Bridge(Coordinate entrance, Coordinate exit, String id) {
        this.entrance = entrance;
        this.exit = exit;
        this.id = id;
    }

    @Override
    public Coordinate getEntrance() {
        return entrance;
    }

    @Override
    public Coordinate getExit() {
        return exit;
    }
    public String getId(){
        return id;
    }
}
