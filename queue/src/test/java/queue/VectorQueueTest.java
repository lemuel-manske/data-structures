package queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class VectorQueueTest extends QueueTest {

    @Test
    void pushElementsToTheLimit() {
        queue.add(1);
        queue.add(1);
        queue.add(1);
        queue.add(1);
        queue.add(1);

        assertThrows(FullQueue.class, () -> queue.add(1));
    }
}
