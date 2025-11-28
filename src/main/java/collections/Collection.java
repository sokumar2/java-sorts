package collections;

import collections.sorts.Order;
import collections.sorts.Sorter;
import collections.sorts.HeapSort;
import collections.sorts.MergeSort;
import collections.sorts.BubbleSort;
import collections.sorts.SelectionSort;
import collections.sorts.InsertionSort;
import collections.interfaces.Sortable;
import collections.sorts.interfaces.Sort;

public class Collection<T extends Comparable<T>> implements Sortable<T> {

    protected Sort<T> sorter;

    public Collection(Sort<T> sorter) {
        this.sorter = sorter;
    }

    public void execute(T[] array, Order order) {
        sorter.sort(array, order);
    }

    public static <T extends Comparable<T>> void sort(T[] array, Order order, Sorter sorter) {
        if (sorter == Sorter.BUBBLE_SORT) {
            new Collection<T>(new BubbleSort<T>()).execute(array, order);
        } else if (sorter == Sorter.SELECTION_SORT) {
            new Collection<T>(new SelectionSort<T>()).execute(array, order);
        } else if (sorter == Sorter.INSERTION_SORT) {
            new Collection<T>(new InsertionSort<T>()).execute(array, order);
        } else if (sorter == Sorter.HEAP_SORT) {
            new Collection<T>(new HeapSort<T>()).execute(array, order);
        } else if (sorter == Sorter.MERGE_SORT) {
            new Collection<T>(new MergeSort<T>()).execute(array, order);
        }
    }

}
