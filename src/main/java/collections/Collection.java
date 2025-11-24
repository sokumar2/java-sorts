package collections;

import collections.sorts.Order;
import collections.sorts.Sorter;
import collections.sorts.BubbleSort;
import collections.sorts.SelectionSort;
import collections.sorts.InsertionSort;
import collections.interfaces.Sortable;
import collections.sorts.interfaces.Sort;

public class Collection<T extends Comparable<T>> implements Sortable<T> {

    protected Sort sorter;

    public Collection(Sort sorter) {
        this.sorter = sorter;
    }

    public void execute(T[] array, Order order) {
        sorter.sort(array, order);
    }

    public static <T extends Comparable<T>> void sort(T[] array, Order order, Sorter sorter) {
        if (sorter == Sorter.BUBBLE_SORT) {
            new Collection(new BubbleSort()).execute(array, order);
        } else if (sorter == Sorter.SELECTION_SORT) {
            new Collection(new SelectionSort()).execute(array, order);
        } else if (sorter == Sorter.INSERTION_SORT) {
            new Collection(new InsertionSort()).execute(array, order);
        }
    }

}
