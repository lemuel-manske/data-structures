package stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ArrayStackTest extends StackTest {

	@BeforeEach
	void setup() {
		stack = new ArrayStack<>(10);
	}
	
	@Test
	void shouldThrowMaximumCapacityWhenPushElementsBeyondTheLimit() {
		pushNineElementsToTheTop();
		
		assertThrows(MaximumCapacity.class, () -> stack.push(1));
	}

	@Test
	void shouldStayTheSameWhenConcatEmptyStack() {
		stack.push(1);
		stack.push(2);
		stack.push(3);

		Stack<Integer> other = new ArrayStack<>(2);

		stack.concat(other);

		assertItems(3, 2, 1);
	}

	@Test
	void shouldThrowMaximumCapacityWhenConcatStackToLimit() {
		Stack<Integer> vectorStack = new ArrayStack<>(4);
		vectorStack.push(1);
		vectorStack.push(2);
		vectorStack.push(3);

		Stack<Integer> other = new ArrayStack<>(2);
		other.push(4);
		other.push(5);

		assertThrows(MaximumCapacity.class, () -> vectorStack.concat(other));
	}

	@Test
	void shouldNotChangeConcatenatedStack() {
		stack.push(2);
		stack.push(15);
		stack.push(4);

		Stack<Integer> other = new ArrayStack<>(2);
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

		Stack<Integer> other = new ArrayStack<>(2);
		other.push(4);
		other.push(5);

		stack.concat(other);

		assertItems(5, 4, 3, 2, 1);
	}

	private void pushNineElementsToTheTop() {
		for (int i = 0; i <= 9; i++) stack.push(1);
	}
}
