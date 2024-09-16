package stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ListStackTest {
	
	private Stack<Integer> stack;
	
	@BeforeEach
	void setup() {
		stack = new ListStack<>();
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
	void testFreeMakesTheStackEmpty() {
		stack.push(1);
		stack.push(2);
		
		stack.free();
		
		assertTrue(stack.isEmpty());
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
