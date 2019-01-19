package parking_lot;

public class Bridge implements Location {
    private Coordinate entrance;
    private Coordinate exit;

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
