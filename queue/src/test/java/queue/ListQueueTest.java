package queue;

import org.junit.jupiter.api.BeforeEach;

class ListQueueTest extends QueueTest {

    @BeforeEach
    void setListQueue() {
        queue = new ListQueue<>();
    }
}

