package collections.sorts;

import java.util.Arrays;
import java.util.ArrayList;
import collections.Application;
import collections.utils.Statistic;

final public class QuickSort<T extends Comparable<T>> extends AbstractSort<T> {

    public void sort(T[] array, int length, Order order) {
        this.sort(array, 0, length - 1, order);
    }

    protected int partition(T[] array, int low, int high, Order order) {
        T pivot = array[high];

        int index = low;
        for (int j = low; j <= high; j++) {
            if (Order.ASCENDING == order) {
                if (array[j].compareTo(pivot) < 0) {
                    this.swap(array, index, j);

                    index++;
                }
            } else if (Order.DESCENDING == order) {
                if (array[j].compareTo(pivot) > 0) {
                    this.swap(array, index, j);

                    index++;
                }
            }
        }

        this.swap(array, index, high);

        return index;
    }

    protected void sort(T[] array, int low, int high, Order order) {
        if (low < high) {
            int index = this.partition(array, low, high, order);

            this.sort(array, low, index - 1, order);
            this.sort(array, index + 1, high, order);
        }
    }
}
