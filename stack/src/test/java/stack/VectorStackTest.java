package stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VectorStackTest {
	
	private Stack<Integer> stack;
	
	@BeforeEach
	void setup() {
		stack = new VectorStack<>(10);
	}

	@Test
	void testWhenCreatedIsEmpty() {
		assertTrue(stack.isEmpty());
	}
	
	@Test
	void testPopWithNoItems() {
		assertThrows(Stack.Empty.class, () -> stack.pop());
	}

	@Test
	void testPushThenIsNotEmpty() {
		stack.push(1);
		
		assertFalse(stack.isEmpty());
	}

	@Test
	void testPushThenPop() {
		stack.push(1);
		stack.push(2);
		
		Integer first = stack.pop();
		Integer second = stack.pop();
		
		assertEquals(2, first);
		assertEquals(1, second);
	}
	
	@Test
	void testPeek() {
		stack.push(1);
		
		Integer peeked = stack.peek();
		
		assertEquals(1, peeked);
	}
	
	
	@Test
	void testPushToOutOfBounds() {
		pushMultiple(1, 9);
		
		assertThrows(Stack.MaximumCapacity.class, () -> stack.push(1));
	}
	
	@Test
	void testFreeMakesTheStackEmpty() {
		stack.push(1);
		stack.push(2);
		
		stack.free();
		
		assertTrue(stack.isEmpty());
	}

	@Test
	void testEmptyString() {
		assertEquals("", stack.toString());
	}

	@Test
	void testString() {
		stack.push(12);
		stack.push(52);
		stack.push(32);
		
		assertEquals("32, 52, 12", stack.toString());
	}

	@Test
	@Tag("only-for-vector-stacks")
	void testConcatPushesStackIntoStack() {
		VectorStack<Integer> stack = new VectorStack<>(10);
		stack.push(1);
		stack.push(2);
		stack.push(3);

		VectorStack<Integer> other = new VectorStack<>(2);
		other.push(4);
		other.push(5);

		stack.concat(other);

		assertItems(stack, 5, 4, 3, 2, 1);
	}

	@Test
	@Tag("only-for-vector-stacks")
	void concatEmptyStackKeepsTheSame() {
		VectorStack<Integer> stack = new VectorStack<>(10);
		stack.push(1);
		stack.push(2);
		stack.push(3);

		VectorStack<Integer> other = new VectorStack<>(2);

		stack.concat(other);

		assertItems(stack, 3, 2, 1);
	}

	@Test
	@Tag("only-for-vector-stacks")
	void concatStackToMaximumCapacity() {
		VectorStack<Integer> stack = new VectorStack<>(3);
		stack.push(1);
		stack.push(2);
		stack.push(3);

		VectorStack<Integer> other = new VectorStack<>(2);
		other.push(4);
		other.push(5);

		assertThrows(Stack.MaximumCapacity.class, () -> stack.concat(other));
	}

	private void assertItems(int... expectedItems) {
		assertItems(stack, expectedItems);
	}

	private void assertItems(Stack<Integer> stack, int... expectedItems) {
		for (int expectedItem : expectedItems)
			assertEquals(expectedItem, stack.pop());
	}

	private void pushMultiple(Integer value, int times) {
		for (int i = 0; i <= times; i++)
			stack.push(value);
	}
}
