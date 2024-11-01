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
	void setLinkedList() {
		linkedList = new LinkedList<>();
	}
	
	@Test
	void shouldBeEmptyWhenCreated() {
		assertTrue(linkedList.isEmpty());
	}
	
	@Test
	void shouldHaveSizeZeroWhenCreated() {
		assertEquals(0, linkedList.size());
	}
	
	@Test
	void shouldNotFindByIndexWhenCreated() {
		assertNull(linkedList.getByIndex(0));
	}
	
	@Test
	void shouldNotFindByValueWhenCreated() {
		assertNull(linkedList.getByValue(35));
	}

	@Test
	void shouldHaveSizeOneWhenAnElementIsAdded() {
		linkedList.add(15);

		assertEquals(1, linkedList.size());
	}
	
	@Test
	void shouldNotBeEmptyWhenAnElementIsAdded() {
		linkedList.add(15);

		assertFalse(linkedList.isEmpty());
	}
	
	@Test
	void shouldGetElementAtIndexZeroWhenFirstElementIsAdded() {
		linkedList.add(15);

		LinkedList.Node<Integer> firstNode = linkedList.getByIndex(0);
		
		assertEquals(15, firstNode.getValue());
	}
	
	@Test
	void shouldFindAllSixElementsByIndex() {
		addMultipleElements(15, 42, 65, 32, 62, 24);

		assertItems(24, 62, 32, 65, 42, 15);
	}
	
	@Test
	void shouldHaveSizeSixWhenSixElementsAreAdded() {
		addMultipleElements(15, 42, 65, 32, 62, 24);

		assertEquals(6, linkedList.size());
	}
	
	@Test
	void shouldFindElementByValue() {
		linkedList.add(15);

		LinkedList.Node<Integer> firstNode =
				linkedList.getByValue(15);

		assertEquals(15, firstNode.getValue());
	}

	@Test
	void shouldNotThrowExceptionsWhenRemovingElementThatDoesNotExists() {
	    assertDoesNotThrow(() -> linkedList.remove(61));
	}

	@Test
	void shouldKeepTheSizeWhenRemovingAnElementThatDoesNotExists() {
		addMultipleElements(22, 18);

        linkedList.remove(61);

        assertEquals(2, linkedList.size());
	}

	@Test
	void shouldHaveSizeThreeWhenElementIsRemovedFromListWithSizeFour() {
		addMultipleElements(61, 15, 22, 18);

		linkedList.remove(22);

        assertEquals(3, linkedList.size());
	}

	@Test
	void shouldNotHaveA_RemovedElement() {
		addMultipleElements(61, 15, 22, 18);

		linkedList.remove(22);

		assertItems(18, 15, 61);
	}

	@Test
	void shouldRemoveFirstElement() {
		addMultipleElements(61, 15, 22, 18);

		linkedList.remove(61);

		assertItems(18, 22, 15);
	}

	@Test
	void shouldRemoveLastElement() {
		addMultipleElements(61, 15, 22);

		linkedList.remove(22);

		assertItems(15, 61);
	}
	
	@Test
	void shouldReverseListOrder() {
		addMultipleElements(15, 42, 65, 32, 62, 24);

        assertItems(linkedList.reverseOrder(), 15, 42, 65, 32, 62, 24);
	}

	@Test
	void shouldOutputEmptyStringWhenIsEmpty() {
	    assertEquals("", linkedList.toString());
	}
	
	
	@Test
	void shouldOutputElementsSeparatedByComma() {
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
	void shouldCreateSubListOfTheElementsAtEnd() {
		addMultipleElements(70, 60, 50, 40, 30, 20, 10);
		
		LinkedList<Integer> newList = linkedList.subList(4, 6);

		assertItems(newList, 50, 60, 70);	
	}

	
	@Test
	void shouldCreateSubListOfTheElementsAtStart() {
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
	void shouldBeEmptyWhenFreed() {
		linkedList.add(13);
		linkedList.add(22);
		linkedList.add(30);
		
		linkedList.free();
		
		assertTrue(linkedList.isEmpty());
	}

	@Test
	void shouldHaveSizeZeroWhenFreed() {
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
			assertEquals(expectedItems[i], list.getByIndex(i).getValue());
	}

	private void addMultipleElements(int... elements) {
		for (int element : elements) linkedList.add(element);
	}
}
