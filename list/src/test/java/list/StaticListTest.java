package list;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class StaticListTest {
	
	private static final int ELEMENT_NOT_FOUND = -1;
	
	private StaticList<Integer> staticList;
	
	@BeforeEach
	void createStaticList() {
		staticList = new StaticList<>();
	}
	
	@Test
	void whenCreatedShouldBeEmpty() {
		assertTrue(staticList.isEmpty());
	}
	
	@Test
	void whenCreatedShouldHaveSizeZero() {
		assertEquals(0, staticList.size());
	}
	
	@Test
	void whenCreatedShouldNotHaveElements() {
		assertEquals(ELEMENT_NOT_FOUND, staticList.find(3));
		assertEquals(ELEMENT_NOT_FOUND, staticList.find(0));
		assertEquals(ELEMENT_NOT_FOUND, staticList.find(15));
	}

	@Test
	void whenGetElementThatNotExistsThrowException() {
		assertThrows(IndexOutOfBoundsException.class,
				() -> staticList.get(15));
		assertThrows(IndexOutOfBoundsException.class,
				() -> staticList.get(3));
		assertThrows(IndexOutOfBoundsException.class,
				() -> staticList.get(0));
	}
	
	@Test
	void mustAddElementsToTheList() {	
		addMultipleElements(15, 42, 23);

		assertFalse(staticList.isEmpty());

		assertEquals(15, staticList.get(0));
		assertEquals(42, staticList.get(1));
		assertEquals(23, staticList.get(2));
	}
	
	@Test
	void whenFreeThenResetListOriginalState() {
		addMultipleElements(661, 422);
		
		staticList.free();

		assertEquals(0, staticList.size());
		assertTrue(staticList.isEmpty());
	}

	@Test
	void testOutput() {
	    addMultipleElements(15, 2, 162);

		String asString = staticList.toString();

		assertEquals("15 2 162", asString);
	}

	@Test
	void testListSize() {
		addMultipleElements(15, 61, 22, 18);

		assertEquals(4, staticList.size());
	}

	@Test
	void testRemoveItemThatNotExist() {
		addMultipleElements(22, 18);

        staticList.remove(61);

        assertEquals(2, staticList.size());
	}

	@Test
	void testRemoveItem() {
		addMultipleElements(61, 15, 22, 18);

		staticList.remove(61);

        assertEquals(3, staticList.size());
		assertEquals(15, staticList.get(0)); // fifty is the new element at 0
		assertEquals(ELEMENT_NOT_FOUND, staticList.find(61));
	}

	@Test
	void testResizeWhenAddingMultipleElements() {
		addMultipleElements(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);

		assertEquals(13, staticList.size());
	}

	@Test
	void testReverseOrderOdd() {
	    addMultipleElements(12, 23, 51, 69, 40);

		staticList.reverseOrder();

		assertItems(40, 69, 51, 23, 12);
	}

	@Test
	void testReverseOrderEven() {
		addMultipleElements(12, 23, 51, 69, 40, 29);

		staticList.reverseOrder();

		assertItems(29, 40, 69, 51, 23, 12);
	}
	
	@Test
	void testRemoveInBetween() {
		addMultipleElements(10, 20, 30, 40, 50, 60);
		
		staticList.removeInRange(2, 4);
		
		assertItems(10, 20, 60);
		assertEquals(3, staticList.size());
	}

	@Test
	void testRemoveAtStart() {
		addMultipleElements(10, 20, 30, 40, 50, 60);
		
		staticList.removeInRange(0, 2);
		
		assertItems(40, 50, 60);
		assertEquals(3, staticList.size());
	}
	
	@Test
	void testRemoveAtEnd() {
		addMultipleElements(10, 20, 30, 40, 50, 60);
		
		staticList.removeInRange(2, 5);
		
		assertItems(10, 20);
		assertEquals(2, staticList.size());
	}
	
	@Test
	void testRemoveAllElements() {
		addMultipleElements(10, 20, 30, 40, 50, 60);
	
		staticList.removeInRange(0, 5);
		
		assertEquals(0, staticList.size());
	}
	
	private void assertItems(int... expectedItems) {
		for (int i = 0; i < expectedItems.length; i++)
			assertEquals(expectedItems[i], staticList.get(i));
	}

	private void addMultipleElements(int... elements) {
		for (int element : elements)
			staticList.add(element);
	}
}
