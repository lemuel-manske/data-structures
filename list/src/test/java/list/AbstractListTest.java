package list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class AbstractListTest {
	
	private static final int ELEMENT_NOT_FOUND = -1;
	
	protected AbstractList<Integer> list;
	
	@Test
	void shouldBeEmptyWhenCreated() {
		assertTrue(list.isEmpty());
	}
	
	@Test
	void shouldHaveSizeZeroWhenCreated() {
		assertEquals(0, list.size());
	}
	
	@Test
	void shouldHaveNoElementsWhenCreated() {
		assertEquals(ELEMENT_NOT_FOUND, list.find(3));
		assertEquals(ELEMENT_NOT_FOUND, list.find(0));
		assertEquals(ELEMENT_NOT_FOUND, list.find(15));
	}

	@Test
	void shouldThrowIndexOutOfBoundsExceptionForElementThatDoesNotExists() {
		assertThrows(IndexOutOfBoundsException.class,
				() -> list.get(15));
		assertThrows(IndexOutOfBoundsException.class,
				() -> list.get(3));
		assertThrows(IndexOutOfBoundsException.class,
				() -> list.get(0));
	}
	
	@Test
	void shouldAddAnElementToTheListThenIsNotEmpty() {
		add(15, 42, 23);

		assertFalse(list.isEmpty());
	}

	@Test
	void shouldAddThreeElementsToTheListAndGetThemAll() {
		add(15, 23, 32);

		assertEquals(15, list.get(0));
		assertEquals(23, list.get(1));
		assertEquals(32, list.get(2));
	}
	
	@Test
	void shouldReturnListToItsOriginalStateWhenFreed() {
		add(661, 422);
		
		list.free();

		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
	}

	@Test
	void shouldOutputEachElementSplitByAnEmptySpace() {
	    add(2, 15, 162);

		String asString = list.toString();

		assertEquals("2 15 162", asString);
	}

	@Test
	void shouldHaveSizeN_ForAListWithN_Elements() {
		add(15, 61, 22, 18);

		assertEquals(4, list.size());
	}

	@Test
	void shouldNotRemoveAnItemThatDoesNotExists() {
		add(22, 18);

        list.remove(61);

        assertEquals(2, list.size());
	}

	@Test
	void shouldRemoveAnItemThenDecreaseSize() {
		add(15, 18, 22, 61);

		list.remove(61);

        assertEquals(3, list.size());
	}

	@Test
	void shouldRemoveAnItem() {
		add(15, 18, 22, 61);

		list.remove(22);

		assertEquals(3, list.size());
		assertEquals(ELEMENT_NOT_FOUND, list.find(22));
	}

	@Test
	void shouldRemoveAnItemAtTheStart() {
		add(15, 18, 22, 61);

		list.remove(15);

		assertEquals(3, list.size());
		assertEquals(ELEMENT_NOT_FOUND, list.find(15));
	}

	@Test
	void shouldRemoveAnItemAtTheEnd() {
		add(15, 18, 22, 61);

		list.remove(61);

		assertEquals(3, list.size());
		assertEquals(ELEMENT_NOT_FOUND, list.find(61));
	}

	@Test
	void shouldResizeToAddMoreFreeSpaceWhenAddingElementsBeyondTheInitialLength() {
		add(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);

		assertEquals(13, list.size());
	}

	@Test
	void shouldReverseListOrderForOddAmountOfElements() {
	    add(12, 23,  40, 51, 69);

		list.reverseOrder();

		assertItems(69, 51, 40, 23, 12);
	}

	@Test
	void shouldReverseListOrderForEvenAmountOfElements() {
		add(12, 23, 29, 40, 51, 69);

		list.reverseOrder();

		assertItems(69, 51, 40, 29, 23, 12);
	}
	
	@Test
	void shouldRemoveInBetween() {
		add(10, 20, 30, 40, 50, 60);
		
		list.removeInRange(2, 4);
		
		assertItems(10, 20, 60);
		assertEquals(3, list.size());
	}

	@Test
	void shouldRemoveElementsAtStart() {
		add(10, 20, 30, 40, 50, 60);
		
		list.removeInRange(0, 2);
		
		assertItems(40, 50, 60);
		assertEquals(3, list.size());
	}
	
	@Test
	void shouldRemoveElementsAtEnd() {
		add(10, 20, 30, 40, 50, 60);
		
		list.removeInRange(2, 5);
		
		assertItems(10, 20);
		assertEquals(2, list.size());
	}
	
	@Test
	void shouldRemoveAllElements() {
		add(10, 20, 30, 40, 50, 60);
	
		list.removeInRange(0, 5);
		
		assertEquals(0, list.size());
	}
	
	protected void assertItems(int... expectedItems) {
		for (int i = 0; i < expectedItems.length; i++)
			assertEquals(expectedItems[i], list.get(i));
	}

	protected void add(int... elements) {
		for (int element : elements)
			list.add(element);
	}
}
