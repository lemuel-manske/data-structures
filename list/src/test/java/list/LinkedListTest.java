package list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LinkedListTest {
	
	private LinkedList<Integer> linkedList;
	
	@BeforeEach
	void setupLinkedList() {
		linkedList = new LinkedList<>();
	}
	
	@Test
	void whenCreatedShouldBeEmpty() {
		assertTrue(linkedList.isEmpty());
	}
	
	@Test
	void whenCreatedShouldHaveSizeZero() {
		assertEquals(0, linkedList.size());
	}
	
	@Test
	void whenCreatedShouldNotFindByIndex() {
		assertNull(linkedList.findByIdx(0));
	}
	
	@Test
	void whenCreatedShouldNotFindByValue() {
		assertNull(linkedList.findByValue(35));
	}

	@Test
	void whenElementIsAddedThenHasSizeOne() {	
		linkedList.add(15);

		assertEquals(1, linkedList.size());
	}
	
	@Test
	void whenElementIsAddedThenIsNotEmpty() {	
		linkedList.add(15);

		assertFalse(linkedList.isEmpty());
	}
	
	@Test
	void whenOneElementIsAddedThemFindByIndexZero() {
		linkedList.add(15);

		LinkedList.Node<Integer> firstNode = linkedList.findByIdx(0);
		
		assertEquals(15, firstNode.value());
	}
	
	@Test
	void whenMultipleElementsAreAddedThenFindThemByIndex() {
		addMultipleElements(15, 42, 65, 32, 62, 24);

		assertItems(24, 62, 32, 65, 42, 15);
	}
	
	@Test
	void whenSixElementsAreAddedThenHaveSizeSix() {
		addMultipleElements(15, 42, 65, 32, 62, 24);

		assertEquals(6, linkedList.size());
	}
	
	@Test
	void whenFifteenIsAddedThenFindByValueFifteen() {
		linkedList.add(15);

		LinkedList.Node<Integer> firstNode =
				linkedList.findByValue(15);
		
		assertEquals(15, firstNode.value());
	}

	@Test
	void whenRemoveWithNoElementsDoNothing() {
	    assertDoesNotThrow(() -> linkedList.remove(61));
	}

	@Test
	void whenRemoveElementThatDoesNotExistsThenSizeKeepsTheSame() {
		addMultipleElements(22, 18);

        linkedList.remove(61);

        assertEquals(2, linkedList.size());
	}

	@Test
	void whenRemoveItemThatExistsThenSizeDecreases() {
		addMultipleElements(61, 15, 22, 18);

		linkedList.remove(22);

        assertEquals(3, linkedList.size());
	}

	@Test
	void whenItemIsRemovedThenItDoesNotExistAnymore() {
		addMultipleElements(61, 15, 22, 18);

		linkedList.remove(22);

		assertItems(18, 15, 61);
	}

	@Test
	void shouldRemoveFirstNode() {
		addMultipleElements(61, 15, 22, 18);

		linkedList.remove(61);

		assertItems(18, 22, 15);
	}

	@Test
	void shouldRemoveLastNode() {
		addMultipleElements(61, 15, 22);

		linkedList.remove(22);

		assertItems(15, 61);
	}
	
	@Test
	void whenReverseOrderNewListHaveItemsInReverseOrder() {
		addMultipleElements(15, 42, 65, 32, 62, 24);
		
		LinkedList<Integer> reversed = linkedList.reverseOrder();

		assertItems(reversed, 15, 42, 65, 32, 62, 24);	
	}

	@Test
	void shouldOutputEmptyStringWhenIsEmpty() {
	    assertEquals("", linkedList.toString());
	}
	
	
	@Test
	void shouldOutputStringVersionOfListItems() {
		addMultipleElements(15, 42, 65, 32, 62, 24);
		
		String toString = linkedList.toString();

		assertEquals("24, 62, 32, 65, 42, 15", toString);	
	}
	
	@Test
	void shouldCreateSubListOfInnerElements() {
		addMultipleElements(70, 60, 50, 40, 30, 20, 10);
		
		LinkedList<Integer> newList = linkedList.subList(2, 5);

		assertItems(newList, 30, 40, 50, 60);	
	}
	
	@Test
	void shouldCreateSubListOfLastElements() {
		addMultipleElements(70, 60, 50, 40, 30, 20, 10);
		
		LinkedList<Integer> newList = linkedList.subList(4, 6);

		assertItems(newList, 50, 60, 70);	
	}

	
	@Test
	void shouldCreateSubListOfStartElements() {
		addMultipleElements(70, 60, 50, 40, 30, 20, 10);
		
		LinkedList<Integer> newList = linkedList.subList(0, 2);

		assertItems(newList, 10, 20, 30);
	}
	
	@Test
	void shouldThrowForInvalidSubListIndexes() {
		addMultipleElements(70, 60, 50, 40, 30, 20, 10);

		assertThrows(IndexOutOfBoundsException.class, 
				() -> linkedList.subList(5, 1));
		
		assertThrows(IndexOutOfBoundsException.class, 
				() -> linkedList.subList(10, 12));
		
		assertThrows(IndexOutOfBoundsException.class, 
				() -> linkedList.subList(-1, 2));

		assertThrows(IndexOutOfBoundsException.class, 
				() -> linkedList.subList(2, -1));
	}
	
	@Test
	void whenFreedIsEmpty() {
		linkedList.add(13);
		linkedList.add(22);
		linkedList.add(30);
		
		linkedList.free();
		
		assertTrue(linkedList.isEmpty());
	}

	@Test
	void whenFreedHasSizeZero() {
		linkedList.add(13);
		linkedList.add(22);
		linkedList.add(30);
		
		linkedList.free();
		
		assertEquals(0, linkedList.size());
	}
	
	private void assertItems(int... expectedItems) {
		assertItems(linkedList, expectedItems);
	}
	
	private void assertItems(LinkedList<Integer> list, int... expectedItems) {
		for (int i = 0; i < expectedItems.length; i++)
			assertEquals(expectedItems[i], list.findByIdx(i).value());
	}

	private void addMultipleElements(int... elements) {
		for (int element : elements) linkedList.add(element);
	}
}
