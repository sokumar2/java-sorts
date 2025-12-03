package collections.sorts.interfaces;

import collections.sorts.Order;

public interface SequentialSort<T extends Comparable<T>> extends Sort<T> {

    public T minimum(T[] array);

    public T maximum(T[] array);

}