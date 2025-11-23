package collections.sorts;

import collections.sorts.interfaces.Sort;

public abstract class AbstractSort<T extends Comparable<T>> implements Sort<T> {

    public void swap(T[] array, int i, int j) {
        T swapped = array[j];
        array[j] = array[i];
        array[i] = swapped;
    }

}
