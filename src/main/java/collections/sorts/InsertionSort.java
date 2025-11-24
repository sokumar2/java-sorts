package collections.sorts;

import collections.sorts.Order;
import collections.Application;
import collections.sorts.AbstractSort;

public class InsertionSort<T extends Comparable<T>> extends AbstractSort<T> {

    public void sort(T[] array, int length, Order order) {
        for (int j = 1; j < length; j++) {
            T value = array[j];
            int i = j - 1;

            if (Order.ASCENDING == order) {
                while (i >= 0 && array[i].compareTo(value) > 0) {
                    array[i + 1] = array[i];
                    i = i - 1;
                }
            } else if (Order.DESCENDING == order) {
                while (i >= 0 && array[i].compareTo(value) < 0) {
                    array[i + 1] = array[i];
                    i = i - 1;
                }
            }

            array[i + 1] = value;
        }
    }

}
