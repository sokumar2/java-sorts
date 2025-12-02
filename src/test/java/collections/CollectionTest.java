package test.collections;

import test.TestCase;
import org.junit.Test;
import collections.Collection;
import collections.sorts.Order;
import java.util.stream.Stream;
import collections.Application;
import collections.utils.Array;
import collections.sorts.Sorter;
import static org.junit.Assert.assertArrayEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ArgumentsProvider;

final public class CollectionTest extends TestCase {

    static class MyArgumentsProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                Arguments.of(Sorter.BUBBLE_SORT),
                Arguments.of(Sorter.SELECTION_SORT),
                Arguments.of(Sorter.INSERTION_SORT),
                Arguments.of(Sorter.HEAP_SORT),
                Arguments.of(Sorter.MERGE_SORT),
                Arguments.of(Sorter.QUICK_SORT)
            );
        }

    }

    @ParameterizedTest
    @ArgumentsSource(MyArgumentsProvider.class)
    public void testSortEmpty(Sorter sorter) {
        Integer[] expected = {};
        Integer[] actual = {};

        Collection.sort(actual, Order.ASCENDING, sorter);

        assertArrayEquals("Empty Array", actual, expected);
    }

    @ParameterizedTest
    @ArgumentsSource(MyArgumentsProvider.class)
    public void testSortAscending(Sorter sorter) {
        Integer[] expected = new Array(1000).build();
        Integer[] actual = new Array(1000).shuffle().build();

        Collection.sort(actual, Order.ASCENDING, sorter);

        assertArrayEquals("Ascending Order", actual, expected);
    }

    @ParameterizedTest
    @ArgumentsSource(MyArgumentsProvider.class)
    public void testSortDescending(Sorter sorter) {
        Integer[] expected = new Array(1000).reverse().build();
        Integer[] actual = new Array(1000).shuffle().build();

        Collection.sort(actual, Order.DESCENDING, sorter);

        assertArrayEquals("Descending Order", actual, expected);
    }

}