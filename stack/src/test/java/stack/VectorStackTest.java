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

	private void pushNineElementsToTheTop() {
		int timesToPush = 9;

		int valueToPush = 1;

		for (int i = 0; i <= timesToPush; i++)
			stack.push(valueToPush);
	}
}
