package collections.sorts;

import collections.Application;
import collections.utils.Statistic;
import collections.sorts.interfaces.SequentialSort;

public class HeapSort<T extends Comparable<T>> extends AbstractSort<T> implements SequentialSort<T> {

    public void sort(T[] array, int length, Order order) {
        for (int i = (array.length / 2) - 1; i >= 0; i--) {
            this.heapify(array, array.length, i, order);
        }

        for (int i = length - 1; i > 0; i--) {
            this.swap(array, 0, i);

            this.heapify(array, i, 0, order);
        }
    }

    public void heapify(T[] array, int length, int index, Order order) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < length) {
            this.statistic.compared();

            if (Order.ASCENDING == order) {
                if (array[left].compareTo(array[largest]) > 0) {
                    largest = left;
                }
            } else if (Order.DESCENDING == order) {
                if (array[left].compareTo(array[largest]) < 0) {
                    largest = left;
                }
            }
        }

        if (right < length) {
            this.statistic.compared();

            if (Order.ASCENDING == order) {
                if (array[right].compareTo(array[largest]) > 0) {
                    largest = right;
                }
            } else if (Order.DESCENDING == order) {
                if (array[right].compareTo(array[largest]) < 0) {
                    largest = right;
                }
            }
        }

        if (largest != index) {
            this.swap(array, largest, index);

            this.heapify(array, length, largest, order);
        }
    }

    public T minimum(T[] array) {
        if (0 == array.length) {
            return null;
        }

        T[] clone = array.clone();
        this.sort(clone, 1, Order.DESCENDING);

        return clone[0];
    }

    public T maximum(T[] array) {
        if (0 == array.length) {
            return null;
        }

        T[] clone = array.clone();
        this.sort(clone, 1, Order.ASCENDING);

        return clone[0];
    }

}
