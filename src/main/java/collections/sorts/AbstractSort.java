package collections.sorts;

import collections.sorts.Order;
import collections.sorts.interfaces.Sort;

public abstract class AbstractSort<T extends Comparable<T>> implements Sort<T> {

    public void sort(T[] array, Order order) {
        this.sort(array, array.length, order);
    }

    public void swap(T[] array, int i, int j) {
        T swapped = array[j];
        array[j] = array[i];
        array[i] = swapped;
    }

    public T minimum(T[] array) {
        if (0 == array.length) {
            return null;
        }

        T[] clone = array.clone();
        this.sort(clone, 2, Order.DESCENDING);

        return clone[array.length - 1];
    }

    public T maximum(T[] array) {
        if (0 == array.length) {
            return null;
        }

        T[] clone = array.clone();
        this.sort(clone, 2, Order.ASCENDING);

        return clone[array.length - 1];
    }

}
