package test.collections;

import test.TestCase;
import org.junit.Test;
import collections.Array;
import collections.Collection;
import collections.sorts.Order;
import java.util.stream.Stream;
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
                Arguments.of(Sorter.SELECTION_SORT)
            );
        }

    }

    @ParameterizedTest
    @ArgumentsSource(MyArgumentsProvider.class)
    public void testSort(Sorter sorter) {
        Integer[] expected = new Array(100).build();

        Integer[] actual = new Array(100).shuffle().build();

        Collection.sort(actual, Order.ASCENDING, sorter);

        assertArrayEquals("Ascending Order", actual, expected);
    }

}