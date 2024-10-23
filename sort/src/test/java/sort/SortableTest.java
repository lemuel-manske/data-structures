package sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public abstract class SortableTest {

    protected Sortable<Integer> sortStrategy;

    @Test
    void shouldReturnEmptyArrayWhenSortingEmptyArray() {
        Integer[] empty = {};

        assertArrayEquals(empty, sortStrategy.sort(empty));
    }

    @Test
    void shouldReturnSameArrayWhenSortingOneElementArray() {
        Integer[] oneElementArray = new Integer[]{ 1 };

        assertArrayEquals(oneElementArray, sortStrategy.sort(oneElementArray));
    }
    
    @Test
    void shouldSortTwoElementsArray() {
        
    }

    @Test
    void shouldSortThreeElementsArray() {
        Integer[] threeElementsArray = new Integer[]{ 3, 1, 2 };

        assertArrayEquals(new Integer[]{ 1, 2, 3 }, sortStrategy.sort(threeElementsArray));
    }

    @Test
    void shouldSortTwentyElementsArray() {
        Integer[] threeElementsArray = new Integer[]{ 31, 12, 24, 6, 9, 20, 17, 26, 92, 10, 11, 62, 15, 21 };

        assertArrayEquals(new Integer[]{ 6, 9, 10, 11, 12, 15, 17, 20, 21, 24, 26, 31, 62, 92, },
                sortStrategy.sort(threeElementsArray));
    }
}
