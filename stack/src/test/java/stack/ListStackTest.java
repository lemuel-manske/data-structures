package stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListStackTest extends StackTest {

    @BeforeEach
    void setup() {
        stack = new ListStack<>();
    }

    @Test
    void shouldStayTheSameWhenConcatEmptyStack() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Stack<Integer> other = new ListStack<>();

        stack.concat(other);

        assertItems(3, 2, 1);
    }

    @Test
    void shouldNotChangeConcatenatedStack() {
        stack.push(2);
        stack.push(15);
        stack.push(4);

        Stack<Integer> other = new ListStack<>();
        other.push(4);
        other.push(5);

        stack.concat(other);

        assertItems(other, 5, 4);
    }

    @Test
    void shouldPushConcatenatedStackItems() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Stack<Integer> other = new ListStack<>();
        other.push(4);
        other.push(5);

        stack.concat(other);

        assertItems(5, 4, 3, 2, 1);
    }
}
