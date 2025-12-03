package collections.sorts;

import collections.Application;
import collections.utils.Statistic;
import collections.sorts.interfaces.Sort;

public abstract class AbstractSort<T extends Comparable<T>> implements Sort<T> {

    protected Statistic statistic;

    public AbstractSort() {
        this.statistic = new Statistic();
    }

    public void sort(T[] array, Order order) {
        this.statistic.startTime();

        this.sort(array, array.length, order);

        this.statistic.endTime();

        if (Application.STATISTICS_MODE) {
            System.out.println(this.statistic.duration());
        }
    }

    public void swap(T[] array, int i, int j) {
        T swapped = array[j];
        array[j] = array[i];
        array[i] = swapped;
    }

}
