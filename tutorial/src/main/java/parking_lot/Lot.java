package parking_lot;

public class Lot implements Location{
    private Coordinate entrance;
    private Coordinate exit;

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

}
