package collections;

import collections.Collection;
import collections.sorts.Order;
import collections.utils.Array;
import collections.sorts.Sorter;

public class Application {

    public static final boolean STATISTICS_MODE = false;

    public static void main(String[] args) {
        int capacity = 10000000;

        System.out.println("Merge Sort");
        Collection.sort(new Array(capacity).shuffle().build(), Order.ASCENDING, Sorter.MERGE_SORT);

        System.out.println("Quick Sort");
        Collection.sort(new Array(capacity).shuffle().build(), Order.ASCENDING, Sorter.QUICK_SORT);

        System.out.println("Heap Sort");
        Collection.sort(new Array(capacity).shuffle().build(), Order.ASCENDING, Sorter.HEAP_SORT);
    }

}
