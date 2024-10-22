package sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class SortableTest {

    protected Sortable<Integer> sortStrategy;

    @Test
    void shouldReturnEmptyVectorWhenSortingEmptyVector() {
        Integer[] empty = {};

        assertArrayEquals(empty, sortStrategy.sort(empty));
    }

    @Test
    void shouldReturnSameVectorWhenSortingOneElementVector() {
        Integer[] oneElementVector = new Integer[]{ 1 };

        assertArrayEquals(oneElementVector, sortStrategy.sort(oneElementVector));
    }

    @Test
    void shouldSortThreeElementsVector() {
        Integer[] threeElementsVector = new Integer[]{ 3, 1, 2 };

        assertArrayEquals(new Integer[]{ 1, 2, 3 }, sortStrategy.sort(threeElementsVector));
    }

    @Test
    void shouldSortTwentyElementsVector() {
        Integer[] threeElementsVector = new Integer[]{ 31, 12, 24, 6, 9, 20, 17, 26, 92, 10, 11, 62, 15, 21 };

        assertArrayEquals(new Integer[]{ 6, 9, 10, 11, 12, 15, 17, 20, 21, 24, 26, 31, 62, 92, },
                sortStrategy.sort(threeElementsVector));
    }
}
