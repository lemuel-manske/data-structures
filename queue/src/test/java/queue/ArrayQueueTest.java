package queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArrayQueueTest extends QueueTest {

    @BeforeEach
    void setVectorQueue() {
        queue = new ArrayQueue<>(5);
    }

    @Test
    void shouldThrowFullQueueWhenAddingElementToA_FullQueue() {
        queue.add(15);
        queue.add(5);
        queue.add(9);
        queue.add(4);
        queue.add(3);

        assertThrows(FullQueue.class, () -> queue.add(1));
    }
}
