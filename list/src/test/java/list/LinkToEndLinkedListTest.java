package list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LinkToEndLinkedListTest {

    private LinkToEndLinkedList<Integer> list;

    @BeforeEach
    void setList() {
        list = new LinkToEndLinkedList<>();
    }

    @Test
    void whenCreatedThenIsEmpty() {
        assertTrue(list.isEmpty());
    }

    @Test
    void whenCreatedHasSizeZero() {
        assertEquals(0, list.size());
    }

    @Test
    void whenElementIsAddedThenIsNotEmpty() {
        list.add(3);

        assertFalse(list.isEmpty());
    }

    @Test
    void whenElementIsAddedHasSizeOne() {
        list.add(3);

        assertEquals(1, list.size());
    }

    @Test
    void whenFindInEmptyListThenReturnMinusOne() {
        assertEquals(-1, (Integer) list.find(3));
    }

    @Test
    void removesAtEmptyListDoesNothing() {
        assertDoesNotThrow(() -> list.remove(3));
    }

    @Test
    void givenElementWhenRemovedHasSizeZero() {
        list.add(3);

        list.remove(3);

        assertEquals(0, list.size());
    }

    @Test
    void givenElementWhenRemovedIsEmpty() {
        list.add(3);

        list.remove(3);

        assertTrue(list.isEmpty());
    }

    @Test
    void whenThreeElementsAreAddedHasSizeThree() {
        list.add(3);
        list.add(1);
        list.add(6);

        assertEquals(3, list.size());
    }

    @Test
    void whenOneTwoAndThreeAreAddedThenFindOneTwoAndThree() {
        list.add(3);
        list.add(1);
        list.add(6);

        assertEquals(0, list.find(3));
        assertEquals(1, list.find(1));
        assertEquals(2, list.find(6));
    }

    @Test
    void multipleRemovedThenListIsEmpty() {
        list.add(3);
        list.add(1);
        list.add(6);

        list.remove(6);
        list.remove(1);
        list.remove(3);

        assertTrue(list.isEmpty());
    }
}
