package collections.sorts;

import java.util.Arrays;
import collections.sorts.Order;
import collections.Application;
import collections.sorts.AbstractSort;

public class BubbleSort<T extends Comparable<T>> extends AbstractSort<T> {

    public void sort(T[] array, Order order) {
        this.sort(array, array.length, order);
    }

    protected void sort(T[] array, int length, Order order) {
        int comparisons = 0;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0 ; j < array.length - i - 1; j++) {
                if (Order.ASCENDING == order) {
                    if (array[j].compareTo(array[j + 1]) > 0) {
                        this.swap(array, j, j + 1);

                        ++comparisons;
                    }
                } else if (Order.DESCENDING == order) {
                    if (array[j].compareTo(array[j + 1]) < 0) {
                        this.swap(array, j, j + 1);

                        ++comparisons;
                    }
                }
            }
        }
        if (Application.STATISTICS_MODE) {
            System.out.println("Comparisons: " + comparisons);
        }
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