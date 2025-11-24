package collections.sorts;

import collections.sorts.Order;
import collections.Application;
import collections.utils.Statistic;
import collections.sorts.AbstractSort;

public class HeapSort<T extends Comparable<T>> extends AbstractSort<T> {

    Statistic statistic;

    public HeapSort() {
        this.statistic = new Statistic("Heap Sort");
    }

    public void sort(T[] array, int length, Order order) {
        this.statistic.startTime();

        for (int i = (array.length / 2) - 1; i >= 0; i--) {
            this.heapify(array, array.length, i, order);
        }

        for (int i = array.length - 1; i >= array.length - length; i--) {
            this.swap(array, 0, i);
            this.statistic.swapped();

            this.heapify(array, i, 0, order);
        }

        this.statistic.endTime();
        if (Application.STATISTICS_MODE) {
            this.statistic.print();
        }
    }

    public void heapify(T[] array, int length, int index, Order order) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < length) {
            if (Order.ASCENDING == order) {
                this.statistic.compared();
                if (array[left].compareTo(array[largest]) > 0) {
                    largest = left;
                }
            } else if (Order.DESCENDING == order) {
                this.statistic.compared();
                if (array[left].compareTo(array[largest]) < 0) {
                    largest = left;
                }
            }
        }

        if (right < length) {
            if (Order.ASCENDING == order) {
                this.statistic.compared();
                if (array[right].compareTo(array[largest]) > 0) {
                    largest = right;
                }
            } else if (Order.DESCENDING == order) {
                this.statistic.compared();
                if (array[right].compareTo(array[largest]) < 0) {
                    largest = right;
                }
            }
        }

        if (largest != index) {
            this.swap(array, largest, index);
            this.statistic.swapped();

            this.heapify(array, length, largest, order);
        }
    }

}
