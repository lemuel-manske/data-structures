package queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class VectorQueueTest extends QueueTest {

    @BeforeEach
    void setQueue() {
        queue = new VectorQueue<>(5);
    }

    @Test
    void shouldPushUntilFullQueue() {
        queue.add(15);
        queue.add(5);
        queue.add(9);
        queue.add(4);
        queue.add(3);

        assertThrows(FullQueue.class, () -> queue.add(1));
    }
}
