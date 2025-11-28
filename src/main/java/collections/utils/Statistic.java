package collections.utils;

public class Statistic {

    long startTime, endTime;

    long comparisons = 0;

    public void startTime() {
        startTime = System.currentTimeMillis();
    }

    public void endTime() {
        endTime = System.currentTimeMillis();
    }

    public long duration() {
        if (0 != startTime && 0 != endTime) {
            return endTime - startTime;
        }

        return 0;
    }

    public void compared() {
        this.comparisons++;
    }

    public long getComparisons() {
        return this.comparisons;
    }

}
