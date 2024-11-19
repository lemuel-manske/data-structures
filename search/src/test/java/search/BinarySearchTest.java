package search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {

    private SearchStrategy<Integer> strategy;

    @BeforeEach
    void setSearch() {
        strategy = new BinarySearch<>();
    }

    @Test
    void searchTest() {
        assertEquals(-1, strategy.search(new Integer[]{ }, 1));
        assertEquals(0,  strategy.search(new Integer[]{ 9 }, 9));
        assertEquals(2,  strategy.search(new Integer[]{ 1, 10, 11, 12, 25, 34, 100, 234, 330, 612 }, 11));
        assertEquals(2,  strategy.search(new Integer[]{ 1, 10, 11, 12, 25, 34, null, null, null, null, null }, 11));
        assertEquals(0,  strategy.search(new Integer[]{ 1, null, null, null, null, null, null, null, null, null }, 1));
        assertEquals(-1,  strategy.search(new Integer[]{ null, null, null, null, null, null, null, null, null, 1 }, 1));
    }
}