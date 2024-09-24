package queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class QueueTest {

    protected Queue<Integer> queue;

    @BeforeEach
    void setQueue() {
        queue = new VectorQueue<>(5);
    }

    @Test
    void whenCreatedIsEmpty() {
        assertTrue(queue.isEmpty());
    }

    @Test
    void whenElementIsAddedThenIsNotEmpty() {
        queue.add(1);

        assertFalse(queue.isEmpty());
    }

    @Test
    void givenNoElementsWhenRemoveThenReturnNull() {
        assertThrows(Queue.EmptyQueue.class, () -> queue.remove());
    }

    @Test
    void givenNoElementsWhenPeekThenReturnNull() {
        assertThrows(Queue.EmptyQueue.class, () -> queue.peek());
    }

    @Test
    void givenElementIsAddedWhenRemovedThenIsEmpty() {
        queue.add(1);

        queue.remove();

        assertTrue(queue.isEmpty());
    }

    @Test
    void givenElementWhenPeekThenIsNotRemoved() {
        queue.add(1);

        queue.peek();

        assertFalse(queue.isEmpty());
    }

    @Test
    void givenElementWhenPeekThenReturnIt() {
        queue.add(1);

        Integer element = queue.peek();

        assertEquals(1, element);
    }

    @Test
    void givenElementWhenRemovedThenReturnIt() {
        queue.add(1);

        Integer elementRemoved = queue.remove();

        assertEquals(1, elementRemoved);
    }

    @Test
    void whenElementIsAddedThenRemovedThenAdded() {
        queue.add(1);
        queue.add(2);

        Integer expectOne = queue.remove();

        Integer expectTwo = queue.remove();

        assertEquals(1, expectOne);
        assertEquals(2, expectTwo);
    }

    @Test
    void whenElementIsAddedThenRemovedReturnIt() {
        queue.add(1);

        Integer expectOne = queue.remove();

        queue.add(2);

        Integer expectTwo = queue.remove();

        assertEquals(1, expectOne);
        assertEquals(2, expectTwo);
    }

    @Test
    void whenFreeThenQueueIsEmpty() {
        queue.add(2);
        queue.add(2);
        queue.add(2);

        queue.free();

        assertTrue(queue.isEmpty());
    }

    @Test
    void whenFreeHasNoElements() {
        queue.add(2);
        queue.add(2);
        queue.add(2);

        queue.free();

        assertThrows(Queue.EmptyQueue.class, () -> queue.peek());
    }

    @Test
    void integrationTest() {
        queue.add(8);
        queue.add(2);
        queue.add(5);
        queue.add(2);
        queue.add(1);

        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();

        queue.add(6);
        queue.add(3);

        assertEquals(1, queue.remove());
    }
}
