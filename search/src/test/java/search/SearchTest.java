package search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class SearchTest {

    protected SearchStrategy<Integer> s;

    @Test
    void searchTest() {
        assertEquals(-1, s.search(new Integer[]{}, 1));
        assertEquals(-1, s.search(new Integer[]{4, 2, 3}, 1));
        assertEquals(6, s.search(new Integer[]{54, 12, 73, 42, 22, 8, 9, 13}, 9));
        assertEquals(-1, s.search(new Integer[]{null,null,null}, 9));
        assertEquals(2, s.search(new Integer[]{null,null,9}, 9));
    }
}
