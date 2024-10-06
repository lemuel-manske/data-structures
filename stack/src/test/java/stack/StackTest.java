package stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class StackTest {
	
	protected Stack<Integer> stack;

	@Test
	void shouldBeEmptyWhenCreated() {
		assertTrue(stack.isEmpty());
	}
	
	@Test
	void shouldThrowWhenPopWithNoItems() {
		assertThrows(EmptyStack.class, () -> stack.pop());
	}

	@Test
	void shouldPushThenStackIsNotEmptyAnymore() {
		stack.push(1);
		
		assertFalse(stack.isEmpty());
	}

	@Test
	void shouldPushOneNTwoThenPopTwoNOne() {
		stack.push(1);
		stack.push(2);
		
		Integer first = stack.pop();
		Integer second = stack.pop();
		
		assertEquals(2, first);
		assertEquals(1, second);
	}

	@Test
	void shouldPeek() {
		stack.push(1);
		
		Integer peeked = stack.peek();
		
		assertEquals(1, peeked);
	}
	
	@Test
	void shouldReturnStackToItsOriginalState() {
		stack.push(1);
		stack.push(2);
		
		stack.free();
		
		assertTrue(stack.isEmpty());
	}
	
	@Test
	void shouldReturnAlLStackItemsSeparatedByComma() {
		stack.push(12);
		stack.push(52);
		stack.push(32);
		
		assertEquals("32, 52, 12", stack.toString());
	}

	protected void assertItems(int... expectedItems) {
		assertItems(stack, expectedItems);
	}

	protected void assertItems(Stack<Integer> stack, int... expectedItems) {
		for (int expectedItem : expectedItems)
			assertEquals(expectedItem, stack.pop());
	}
}
