package queue;

import org.junit.jupiter.api.BeforeEach;

class ListQueueTest extends QueueTest {

    @BeforeEach
    void setQueue() {
        queue = new ListQueue<>();
    }
}

