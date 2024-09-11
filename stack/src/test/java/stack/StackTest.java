package stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StackTest {
	
	private Stack<Integer> stack;
	
	@BeforeEach
	void setup() {
		stack = new VectorStack<>(10);
	}
	
	@Test
	void testWhenCreatedHasSizeZero() {
		assertEquals(0, stack.size());
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
	void testPushIncreasesSize() {
		stack.push(1);
		
		assertEquals(1, stack.size());
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
	void testPushOneWhenPopOneThenSizeDecreases() {
		stack.push(1);
		
		stack.pop();
		
		assertEquals(0, stack.size());
	}
	
	@Test
	void testPeekKeepsSize() {
		stack.push(1);
		
		stack.peek();
		
		assertEquals(1, stack.size());
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
		
		assertThrows(Stack.Empty.class, () -> stack.pop());
		assertEquals(0, stack.size());
	}
	
	@Test
	void testString() {
		stack.push(12);
		stack.push(52);
		stack.push(32);
		
		assertEquals("32, 52, 12", stack.toString());
	}
	
	private void pushMultiple(Integer value, int times) {
		for (int i = 0; i <= times; i++)
			stack.push(value);
	}
}
