package stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class VectorStackTest extends StackTest {

	@BeforeEach
	void setup() {
		stack = new VectorStack<>(10);
	}
	
	@Test
	void testPushToOutOfBounds() {
		pushMultiple();
		
		assertThrows(Stack.MaximumCapacity.class, () -> stack.push(1));
	}

	private void pushMultiple() {
		int timesToPush = 9;

		int valueToPush = 1;

		for (int i = 0; i <= timesToPush; i++)
			stack.push(valueToPush);
	}
}
