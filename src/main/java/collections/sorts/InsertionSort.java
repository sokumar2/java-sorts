package collections.sorts;

import collections.sorts.Order;
import collections.Application;
import collections.utils.Statistic;
import collections.sorts.AbstractSort;

final public class InsertionSort<T extends Comparable<T>> extends AbstractSort<T> {

    public void sort(T[] array, int length, Order order) {
        Statistic statistic = new Statistic("Insertion Sort");

        statistic.startTime();
        for (int j = 1; j < length; j++) {
            T value = array[j];
            int i = j - 1;

            if (Order.ASCENDING == order) {
                while (i >= 0 && array[i].compareTo(value) > 0) {
                    array[i + 1] = array[i];
                    i = i - 1;

                    statistic.compared();
                }
            } else if (Order.DESCENDING == order) {
                while (i >= 0 && array[i].compareTo(value) < 0) {
                    array[i + 1] = array[i];
                    i = i - 1;

                    statistic.compared();
                }
            }

            if (i >= 0) {
                statistic.compared();
            }

            array[i + 1] = value;
            statistic.swapped();
        }

        statistic.endTime();
        if (Application.STATISTICS_MODE) {
            statistic.print();
        }
    }

}
