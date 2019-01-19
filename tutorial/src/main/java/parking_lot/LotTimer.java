package parking_lot;

import java.util.List;

public class LotTimer {
    private boolean entered = false;
    private long startTime;
    private long endTime;
    private long durationTime = endTime - startTime;
    //gracePeriod in nano seconds.
    private long gracePeriod = 120 * 1000000000;

    public LotTimer(List<Location> lot_coordinates) {
        this.entered = true;
    }

    public boolean overlotTimer() {
        if (totalTime() > gracePeriod) {
            return true;
        }
        return false;
    }

    public long totalTime() {
        if (entered) {
            startTime = System.nanoTime();
            endTime = System.nanoTime();
            while (entered) {
                endTime = System.nanoTime();
            }
        }
        resetTimer();
        return durationTime;
    }

    private void resetTimer() {
        durationTime = 0;
    }

    public void setGracePeriod(int seconds) {
        this.gracePeriod = seconds * 1000000000;
    }
}
