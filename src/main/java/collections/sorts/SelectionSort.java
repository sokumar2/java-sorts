package collections.sorts;

import collections.sorts.Order;
import collections.sorts.AbstractSort;

public class SelectionSort<T extends Comparable<T>> extends AbstractSort<T> {

    public void sort(T[] array, int length, Order order) {
        for (int i = 0; i < length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
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
        }
    }

}