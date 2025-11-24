package collections.utils;

public class Statistic {

    String title;

    long startTime, endTime;

    long comparisons, swaps = 0;

    public Statistic(String title) {
        this.title = title;
    }

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
        ++this.comparisons;
    }

    public void swapped() {
        ++this.swaps;
    }

    public long getComparisons() {
        return this.comparisons;
    }

    public long getSwaps() {
        return this.swaps;
    }

    public void print() {
        System.out.println(
            title + "\nTime: " + this.duration() + "ms"
            + " Comparisons: " + this.getComparisons()
            + " Swaps: " + this.getSwaps()
        );
    }
}