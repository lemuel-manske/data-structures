package queue;

import org.junit.jupiter.api.BeforeEach;

class AbstractArrayListQueueTest extends QueueTest {

    @BeforeEach
    void setListQueue() {
        queue = new ListQueue<>();
    }
}

