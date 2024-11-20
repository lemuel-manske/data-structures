package list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class AbstractArrayListTest {
	
	private static final int ELEMENT_NOT_FOUND = -1;
	
	protected AbstractArrayList<Integer> abstractArrayList;
	
	@Test
	void shouldBeEmptyWhenCreated() {
		assertTrue(abstractArrayList.isEmpty());
	}
	
	@Test
	void shouldHaveSizeZeroWhenCreated() {
		assertEquals(0, abstractArrayList.size());
	}
	
	@Test
	void shouldHaveNoElementsWhenCreated() {
		assertEquals(ELEMENT_NOT_FOUND, abstractArrayList.find(3));
		assertEquals(ELEMENT_NOT_FOUND, abstractArrayList.find(0));
		assertEquals(ELEMENT_NOT_FOUND, abstractArrayList.find(15));
	}

	@Test
	void shouldThrowIndexOutOfBoundsExceptionForElementThatDoesNotExists() {
		assertThrows(IndexOutOfBoundsException.class,
				() -> abstractArrayList.get(15));
		assertThrows(IndexOutOfBoundsException.class,
				() -> abstractArrayList.get(3));
		assertThrows(IndexOutOfBoundsException.class,
				() -> abstractArrayList.get(0));
	}
	
	@Test
	void shouldAddAnElementToTheListThenIsNotEmpty() {
		add(15, 42, 23);

		assertFalse(abstractArrayList.isEmpty());
	}

	@Test
	void shouldAddThreeElementsToTheListAndGetThemAll() {
		add(15, 23, 32);

		assertEquals(15, abstractArrayList.get(0));
		assertEquals(23, abstractArrayList.get(1));
		assertEquals(32, abstractArrayList.get(2));
	}
	
	@Test
	void shouldReturnListToItsOriginalStateWhenFreed() {
		add(661, 422);
		
		abstractArrayList.free();

		assertEquals(0, abstractArrayList.size());
		assertTrue(abstractArrayList.isEmpty());
	}

	@Test
	void shouldOutputEachElementSplitByAnEmptySpace() {
	    add(2, 15, 162);

		String asString = abstractArrayList.toString();

		assertEquals("2 15 162", asString);
	}

	@Test
	void shouldHaveSizeN_ForAListWithN_Elements() {
		add(15, 61, 22, 18);

		assertEquals(4, abstractArrayList.size());
	}

	@Test
	void shouldNotRemoveAnItemThatDoesNotExists() {
		add(22, 18);

        abstractArrayList.remove(61);

        assertEquals(2, abstractArrayList.size());
	}

	@Test
	void shouldRemoveAnItemThenDecreaseSize() {
		add(15, 18, 22, 61);

		abstractArrayList.remove(61);

        assertEquals(3, abstractArrayList.size());
	}

	@Test
	void shouldRemoveAnItem() {
		add(15, 18, 22, 61);

		abstractArrayList.remove(22);

		assertEquals(3, abstractArrayList.size());
		assertEquals(ELEMENT_NOT_FOUND, abstractArrayList.find(22));
	}

	@Test
	void shouldRemoveAnItemAtTheStart() {
		add(15, 18, 22, 61);

		abstractArrayList.remove(15);

		assertEquals(3, abstractArrayList.size());
		assertEquals(ELEMENT_NOT_FOUND, abstractArrayList.find(15));
	}

	@Test
	void shouldRemoveAnItemAtTheEnd() {
		add(15, 18, 22, 61);

		abstractArrayList.remove(61);

		assertEquals(3, abstractArrayList.size());
		assertEquals(ELEMENT_NOT_FOUND, abstractArrayList.find(61));
	}

	@Test
	void shouldResizeToAddMoreFreeSpaceWhenAddingElementsBeyondTheInitialLength() {
		add(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);

		assertEquals(13, abstractArrayList.size());
	}

	@Test
	void shouldReverseListOrderForOddAmountOfElements() {
	    add(12, 23,  40, 51, 69);

		abstractArrayList.reverseOrder();

		assertItems(69, 51, 40, 23, 12);
	}

	@Test
	void shouldReverseListOrderForEvenAmountOfElements() {
		add(12, 23, 29, 40, 51, 69);

		abstractArrayList.reverseOrder();

		assertItems(69, 51, 40, 29, 23, 12);
	}
	
	@Test
	void shouldRemoveInBetween() {
		add(10, 20, 30, 40, 50, 60);
		
		abstractArrayList.removeInRange(2, 4);
		
		assertItems(10, 20, 60);
		assertEquals(3, abstractArrayList.size());
	}

	@Test
	void shouldRemoveElementsAtStart() {
		add(10, 20, 30, 40, 50, 60);
		
		abstractArrayList.removeInRange(0, 2);
		
		assertItems(40, 50, 60);
		assertEquals(3, abstractArrayList.size());
	}
	
	@Test
	void shouldRemoveElementsAtEnd() {
		add(10, 20, 30, 40, 50, 60);
		
		abstractArrayList.removeInRange(2, 5);
		
		assertItems(10, 20);
		assertEquals(2, abstractArrayList.size());
	}
	
	@Test
	void shouldRemoveAllElements() {
		add(10, 20, 30, 40, 50, 60);
	
		abstractArrayList.removeInRange(0, 5);
		
		assertEquals(0, abstractArrayList.size());
	}
	
	protected void assertItems(int... expectedItems) {
		for (int i = 0; i < expectedItems.length; i++)
			assertEquals(expectedItems[i], abstractArrayList.get(i));
	}

	protected void add(int... elements) {
		for (int element : elements)
			abstractArrayList.add(element);
	}
}
