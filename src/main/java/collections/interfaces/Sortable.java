package collections.interfaces;

import collections.sorts.Order;

public interface Sortable<T extends Comparable<T>> {

    public void execute(T[] array, Order order);

}