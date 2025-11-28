package collections;

import collections.Collection;
import collections.sorts.Order;
import collections.utils.Array;
import collections.sorts.Sorter;

public class Application {

    public static final boolean STATISTICS_MODE = false;

    public static void main(String[] args) {
        Integer[] array = new Array(10).shuffle().build();

        Collection.sort(array, Order.ASCENDING, Sorter.MERGE_SORT);
    }
}
