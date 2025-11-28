package collections.sorts;

import collections.Application;

final public class BubbleSort<T extends Comparable<T>> extends AbstractSort<T> {

    public void sort(T[] array, int length, Order order) {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0 ; j < array.length - i - 1; j++) {
                statistic.compared();

                if (Order.ASCENDING == order) {
                    if (array[j].compareTo(array[j + 1]) > 0) {
                        this.swap(array, j, j + 1);
                    }
                } else if (Order.DESCENDING == order) {
                    if (array[j].compareTo(array[j + 1]) < 0) {
                        this.swap(array, j, j + 1);
                    }
                }
            }
        }
    }

}