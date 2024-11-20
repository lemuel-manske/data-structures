package search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinearSearchTest {

    @Test
    void searchTest() {
        SearchStrategy<Integer> strategy = new LinearSearch<>();

        assertEquals(-1, strategy.search(new Integer[]{ }, 1));
        assertEquals(-1, strategy.search(new Integer[]{ 4, 2, 3 }, 1));
        assertEquals(-1, strategy.search(new Integer[]{ null, null, null }, 9));
        assertEquals(2,  strategy.search(new Integer[]{ null, null, 9 }, 9));
        assertEquals(6,  strategy.search(new Integer[]{ 54, 12, 73, 42, 22, 8, 9, 13 }, 9));
        assertEquals(3,  strategy.search(new Integer[]{ null, null, 9, 2, null, null }, 2));
        assertEquals(0,  strategy.search(new Integer[]{ 11, null, null, null, null, null }, 11));
    }
}
