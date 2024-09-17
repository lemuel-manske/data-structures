package stack;

import org.junit.jupiter.api.BeforeEach;

public class ListStackTest extends StackTest {

    @BeforeEach
    void setup() {
        stack = new ListStack<>();
    }
}
