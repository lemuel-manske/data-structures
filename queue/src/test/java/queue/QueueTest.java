package queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

abstract class QueueTest {

    protected Queue<Integer> queue;

    @Test
    void shouldBeEmptyWhenCreated() {
        assertTrue(queue.isEmpty());
    }

    @Test
    void shouldNotBeEmptyWhenElementIsAdded() {
        queue.add(1);

        assertFalse(queue.isEmpty());
    }

    @Test
    void shouldThrowEmptyQueueWhenRemovingElementForAnEmptyQueue() {
        assertThrows(EmptyQueue.class, () -> queue.remove());
    }

    @Test
    void shouldThrowEmptyQueueWhenPeekingElementForAnEmptyQueue() {
        assertThrows(EmptyQueue.class, () -> queue.peek());
    }

    @Test
    void shouldBeEmptyWhenElementIsAddedThenRemoved() {
        queue.add(1);

        queue.remove();

        assertTrue(queue.isEmpty());
    }

    @Test
    void shouldPeekAnElement() {
        queue.add(1);

        Integer element = queue.peek();

        assertEquals(1, element);
    }

    @Test
    void shouldNotBeEmptyWhenElementIsAddedThenPeeked() {
        queue.add(1);

        queue.peek();

        assertFalse(queue.isEmpty());
    }

    @Test
    void shouldReturnTheElementWhenItIsRemoved() {
        queue.add(1);

        assertEquals(1, queue.remove());
    }

    @Test
    void shouldAddOneAndTwoThenRemoveOneAndTwo() {
        queue.add(1);
        queue.add(2);

        Integer expectOne = queue.remove();

        Integer expectTwo = queue.remove();

        assertEquals(1, expectOne);
        assertEquals(2, expectTwo);
    }

    @Test
    void shouldBeEmptyWhenFreed() {
        queue.add(2);
        queue.add(2);
        queue.add(2);

        queue.free();

        assertTrue(queue.isEmpty());
    }

    @Test
    void shouldExpectFifthElementToBeRemovedAfterFifthAdditionsFourRemovesAndTwoAdditions() {
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

    @Test
    void shouldOutputEmptyStringWhenQueueIsEmpty() {
        assertEquals("", queue.toString());
    }

    @Test
    void shouldOutputAllElementsSeparatedByComma() {
        queue.add(2);
        queue.add(5);
        queue.add(4);
        queue.add(1);
        queue.add(3);

        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();

        queue.add(6);
        queue.add(7);

        assertEquals("3, 6, 7", queue.toString());
    }

    @Test
    void shouldThrowEmptyQueueWhenShrinkingEmptyQueue() {
        assertThrows(EmptyQueue.class, () -> queue.shrink());
    }

    @Test
    void shouldShrinkElementsAtEnd() {
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        queue.remove();
        queue.remove();

        queue.shrink();

        assertEquals(3, queue.remove());
        assertEquals(4, queue.remove());
        assertEquals(5, queue.remove());
    }

    @Test
    void shouldShrinkElementsAtStart() {
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();

        queue.add(6);
        queue.add(7);
        queue.add(8);

        queue.remove();

        queue.shrink();

        assertEquals(6, queue.remove());
        assertEquals(7, queue.remove());
        assertEquals(8, queue.remove());
    }

    @Test
    void shouldShrinkInBetween() {
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();

        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);

        queue.remove();
        queue.remove();
        queue.remove();

        queue.shrink();

        assertEquals(8, queue.remove());
        assertEquals(9, queue.remove());
    }

    @Test
    void shouldOutputOnlyLeftElementsAfterShrinking() {
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();

        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);

        queue.remove();
        queue.remove();
        queue.remove();

        queue.shrink();

        assertEquals("8, 9", queue.toString());
    }
}
