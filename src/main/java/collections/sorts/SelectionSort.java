package collections.sorts;

import collections.sorts.Order;
import collections.Application;
import collections.utils.Statistic;
import collections.sorts.AbstractSort;

final public class SelectionSort<T extends Comparable<T>> extends AbstractSort<T> {

    public void sort(T[] array, int length, Order order) {
        Statistic statistic = new Statistic("Selection Sort");

        statistic.startTime();
        for (int i = 0; i < length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                statistic.compared();

                if (Order.ASCENDING == order) {
                    if (array[index].compareTo(array[j]) > 0) {
                        index = j;
                    }
                } else if (Order.DESCENDING == order) {
                    if (array[index].compareTo(array[j]) < 0) {
                        index = j;
                    }
                }
            }

            this.swap(array, index, i);
            statistic.swapped();
        }

        statistic.endTime();
        if (Application.STATISTICS_MODE) {
            statistic.print();
        }
    }

}