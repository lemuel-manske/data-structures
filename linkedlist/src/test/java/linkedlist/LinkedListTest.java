package linkedlist;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
	
	private LinkedList<Integer> linkedList;
	
	@BeforeEach
	void createLinkedList() {
		linkedList = new LinkedListImpl<>();
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
		
		assertTrue(linkedList.find(3).isEmpty());
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

		Optional<Node<Integer>> firstNode = linkedList.find(0);
		
		assertTrue(firstNode.isPresent());
		
		assertEquals(15, firstNode.get().value());
	}
	
	@Test
	void mustAddMultipleElementsToTheList() {	
		addMultipleElements(15, 42, 65, 32, 62, 24);

		assertItems(15, 42, 65, 32, 62, 24);
	}
	
	@Test
	void mustAddMultipleElementsThenGetSize() {	
		addMultipleElements(15, 42, 65, 32, 62, 24);

		assertEquals(6, linkedList.size());
	}
	
	@Test
	void mustFindElementByItsValue() {
		linkedList.add(15);

		Optional<Node<Integer>> firstNode = 
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
	void testRemoveItem() {
		addMultipleElements(61, 15, 22, 18);

		linkedList.remove(22);

        assertEquals(3, linkedList.size());
		assertTrue(linkedList.findByValue(22).isEmpty());
	}
	
	private void assertItems(int... expectedItems) {
		for (int i = 0; i < expectedItems.length; i++) {
			Optional<Node<Integer>> aNode = linkedList.find(i);
			assertTrue(aNode.isPresent());
			assertEquals(expectedItems[i], aNode.get().value());
		}
	}

	private void addMultipleElements(int... elements) {
		for (int element : elements)
			linkedList.add(element);
	}
}
