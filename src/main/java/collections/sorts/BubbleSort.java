package collections.sorts;

import collections.sorts.Order;
import collections.Application;
import collections.sorts.AbstractSort;

public class BubbleSort<T extends Comparable<T>> extends AbstractSort<T> {

    public void sort(T[] array, int length, Order order) {
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

}