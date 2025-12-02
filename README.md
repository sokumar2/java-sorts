# Sorting Algorithm Comparison
![Coverage](https://raw.githubusercontent.com/sokumar2/java-sorts/refs/heads/master/.github/badges/jacoco.svg)
[![LICENSE](https://img.shields.io/badge/License-MIT-green)](./LICENSE)

In real world quick sort is often used over other better sorting algorithms such as merge or heap sort because it fairs better in memory allocation and has fast CPU cache access to the swapped elements, its an in place sorting algorithm whereas merge sort requires an auxiliary space on each partition to work.

# Comparison

Run time comparison on shuffled array of **10M** integers.

| Sorting Method | Run 1 | Run 2 | Run 3 | Average Time (ms) |
|---|---|---|---|:---:|
| Heap Sort | 5208 | 5009 | 5040 | 5086 |
| Merge Sort | 2546 | 2528 | 1889 | 2321 |
| Quick Sort | 1423 | 1507 | 1426 | 1452 |

This implementation of quick sort uses the last element as a pivot.

# Usage
## Collection
To sort an array you can call Collection's static `sort` method. Two arguments can be passed optionally to decide whether to sort in ascending or descending order or to which sorting algorithm to use. Both arguments are passed as enums.

Internally when `Collection.sort` method is called, it executes a sort command defined in the [Sortable](./src/main/java/interfaces/Sortable.java) interface.

```java
import collections.sorts.Order;
import collections.sorts.Sorter;

...
  ...
  Collection.sort(array, Order.DESCENDING, Sorter.INSERTION_SORT);
  ...
```

## Array
One helper class called `Array` is also provided which generates a randomized array of integers.

```java
new Array(1000).shuffle().build();
```

This creates a sequential array of 1000 integers, shuffled by Fischer-Yates algorithm.

# Test
```console
mvn test
```
