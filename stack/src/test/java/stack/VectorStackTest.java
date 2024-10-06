package stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class VectorStackTest extends StackTest {

	@BeforeEach
	void setup() {
		stack = new VectorStack<>(10);
	}
	
	@Test
	void whenItemsArePushedToTheStackLimitThenThrowMaximumCapacity() {
		pushNineElementsToTheTop();
		
		assertThrows(MaximumCapacity.class, () -> stack.push(1));
	}

	@Test
	void shouldStayTheSameWhenConcatEmptyStack() {
		stack.push(1);
		stack.push(2);
		stack.push(3);

		Stack<Integer> other = new VectorStack<>(2);

		stack.concat(other);

		assertItems(3, 2, 1);
	}

	@Test
	void shouldThrowMaximumCapacityWhenConcatStackToLimit() {
		Stack<Integer> vectorStack = new VectorStack<>(4);
		vectorStack.push(1);
		vectorStack.push(2);
		vectorStack.push(3);

		Stack<Integer> other = new VectorStack<>(2);
		other.push(4);
		other.push(5);

		assertThrows(MaximumCapacity.class, () -> vectorStack.concat(other));
	}

	@Test
	void shouldNotChangeConcatenatedStack() {
		stack.push(2);
		stack.push(15);
		stack.push(4);

		Stack<Integer> other = new VectorStack<>(2);
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

		Stack<Integer> other = new VectorStack<>(2);
		other.push(4);
		other.push(5);

		stack.concat(other);

		assertItems(5, 4, 3, 2, 1);
	}

	private void pushNineElementsToTheTop() {
		for (int i = 0; i <= 9; i++) stack.push(1);
	}
}
