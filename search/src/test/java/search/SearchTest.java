package search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class SearchTest {

    protected SearchStrategy<Integer> s;

    @Test
    void searchTest() {
        assertEquals(s.search(new Integer[]{}, 1), -1);
        assertEquals(s.search(new Integer[]{4, 2, 3}, 1), -1);
        assertEquals(s.search(new Integer[]{54, 12, 73, 42, 22, 8, 9, 13}, 9), 6);
    }
}
