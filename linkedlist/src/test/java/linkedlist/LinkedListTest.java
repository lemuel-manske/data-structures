package linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LinkedListTest {
	
	private LinkedList<Integer> linkedList;
	
	@BeforeEach
	void createLinkedList() {
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
		linkedList.add(15);
		
		assertTrue(linkedList.findByIdx(3).isEmpty());
	}
	
	@Test
	void whenCreatedShouldNotFindByValue() {
		linkedList.add(64);
		
		assertTrue(linkedList.findByValue(3).isEmpty());
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
	void mustAddAnElementToTheList() {	
		linkedList.add(15);

		Optional<LinkedList.Node<Integer>> firstNode = linkedList.findByIdx(0);
		
		assertTrue(firstNode.isPresent());

		assertEquals(15, firstNode.get().value());
	}
	
	@Test
	void mustAddMultipleElementsToTheList() {	
		addMultipleElements(15, 42, 65, 32, 62, 24);

		assertItems(24, 62, 32, 65, 42, 15);
	}
	
	@Test
	void mustAddMultipleElementsThenGetSize() {	
		addMultipleElements(15, 42, 65, 32, 62, 24);

		assertEquals(6, linkedList.size());
	}
	
	@Test
	void mustFindElementByItsValue() {
		linkedList.add(15);

		Optional<LinkedList.Node<Integer>> firstNode =
				linkedList.findByValue(15);
		
		assertTrue(firstNode.isPresent());

		assertEquals(15, firstNode.get().value());
	}

	@Test
	void testRemoveItemThatNotExist() {
		addMultipleElements(22, 18);

        linkedList.remove(61);

        assertEquals(2, linkedList.size());
	}

	@Test
	void testRemoveItemReducesSize() {
		addMultipleElements(61, 15, 22, 18);

		linkedList.remove(22);

        assertEquals(3, linkedList.size());
	}

	@Test
	void testRemoveItemRemovesTheItem() {
		addMultipleElements(61, 15, 22, 18);

		linkedList.remove(22);

		assertItems(18, 15, 61);
	}

	@Test
	void testRemoveFirstNode() {
		addMultipleElements(61, 15, 22, 18);

		linkedList.remove(61);

		assertItems(18, 22, 15);
	}

	@Test
	void testRemoveLast() {
		addMultipleElements(61, 15, 22);

		linkedList.remove(22);

		assertItems(15, 61);
	}
	private void assertItems(int... expectedItems) {
		for (int i = 0; i < expectedItems.length; i++) {
			Optional<LinkedList.Node<Integer>> aNode = linkedList.findByIdx(i);
			assertTrue(aNode.isPresent());
			assertEquals(expectedItems[i], aNode.get().value());
		}
	}

	private void addMultipleElements(int... elements) {
		for (int element : elements)
			linkedList.add(element);
	}
}
