package smartcar.com.uofthacks.Locations;

public class Lot implements Location{
    private Coordinate entrance;
    private Coordinate exit;
    /**
     * the (unique) id of the Lot
     */
    private String id;

    /**
     * Create a new Lot with entrance and exit
     * @param entrance Coordinate of the entrance of the lot
     * @param exit Coordinate of the exit of the lot
     */
    public Lot(Coordinate entrance, Coordinate exit) {
        this.entrance = entrance;
        this.exit = exit;
    }

    public Coordinate getEntrance() {
        return entrance;
    }

    public Coordinate getExit() {
        return exit;
    }
    public String getId(){
        return id;
    }

}
