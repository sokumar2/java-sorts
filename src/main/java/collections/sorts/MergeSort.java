package collections.sorts;

import java.util.Arrays;
import java.util.ArrayList;
import collections.Application;
import collections.utils.Statistic;

final public class MergeSort<T extends Comparable<T>> extends AbstractSort<T> {

    public void sort(T[] array, int length, Order order) {
        this.sort(array, 0, length - 1, order);
    }

    public void sort(T[] array, int low, int high, Order order) {
        if (low < high) {
            int middle = low + (high - low) / 2;

            this.sort(array, low, middle, order);
            this.sort(array, middle + 1, high, order);

            this.merge(array, low, middle, high, order);
        }
    }

    public void merge(T[] array, int low, int middle, int high, Order order) {
        T[] left = Arrays.copyOfRange(array, low, middle + 1);
        T[] right = Arrays.copyOfRange(array, middle + 1, high + 1);

        int leftIndex = 0, rightIndex = 0;
        int i = low;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (order == Order.ASCENDING) {
                this.statistic.compared();

                if (left[leftIndex].compareTo(right[rightIndex]) < 0) {
                    array[i] = left[leftIndex];
                    leftIndex++;
                } else {
                    array[i] = right[rightIndex];
                    rightIndex++;
                }
            } else if (order == Order.DESCENDING) {
                this.statistic.compared();

                if (left[leftIndex].compareTo(right[rightIndex]) > 0) {
                    array[i] = left[leftIndex];
                    leftIndex++;
                } else {
                    array[i] = right[rightIndex];
                    rightIndex++;
                }
            }
            i++;
        }

        while (leftIndex < left.length) {
            this.statistic.compared();

            array[i] = left[leftIndex];
            leftIndex++;
            i++;
        }

        while (rightIndex < right.length) {
            this.statistic.compared();

            array[i] = right[rightIndex];
            rightIndex++;
            i++;
        }

    }

}