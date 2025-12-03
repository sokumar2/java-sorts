package collections.sorts;

import collections.Application;
import collections.sorts.interfaces.SequentialSort;

final public class SelectionSort<T extends Comparable<T>> extends AbstractSort<T> implements SequentialSort<T> {

    public void sort(T[] array, int length, Order order) {
        for (int i = 0; i < length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                this.statistic.compared();

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

    public T minimum(T[] array) {
        if (0 == array.length) {
            return null;
        }

        T[] clone = array.clone();
        this.sort(clone, 2, Order.ASCENDING);

        return clone[0];
    }

    public T maximum(T[] array) {
        if (0 == array.length) {
            return null;
        }

        T[] clone = array.clone();
        this.sort(clone, 2, Order.DESCENDING);

        return clone[0];
    }
}