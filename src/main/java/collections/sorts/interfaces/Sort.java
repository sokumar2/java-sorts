package collections.sorts.interfaces;

import collections.sorts.Order;

public interface Sort<T extends Comparable<T>> {

    public void sort(T[] array, Order order);

    public void sort(T[] array, int length, Order order);

}