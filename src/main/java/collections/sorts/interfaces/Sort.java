package collections.sorts.interfaces;

import collections.sorts.Order;

public interface Sort<T extends Comparable<T>> {

    public void sort(T[] array, Order order);

    public T minimum(T[] array);

    public T maximum(T[] array);

}