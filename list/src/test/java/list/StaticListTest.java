package list;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import sort.QuickSort;

import static org.junit.jupiter.api.Assertions.*;

class StaticListTest {
	
	private static final int ELEMENT_NOT_FOUND = -1;
	
	private StaticList<Integer> staticList;
	
	@BeforeEach
	void setStaticList() {
		staticList = new StaticList<>();
	}
	
	@Test
	void shouldBeEmptyWhenCreated() {
		assertTrue(staticList.isEmpty());
	}
	
	@Test
	void shouldHaveSizeZeroWhenCreated() {
		assertEquals(0, staticList.size());
	}
	
	@Test
	void shouldHaveNoElementsWhenCreated() {
		assertEquals(ELEMENT_NOT_FOUND, staticList.find(3));
		assertEquals(ELEMENT_NOT_FOUND, staticList.find(0));
		assertEquals(ELEMENT_NOT_FOUND, staticList.find(15));
	}

	@Test
	void shouldThrowIndexOutOfBoundsExceptionForElementThatDoesNotExists() {
		assertThrows(IndexOutOfBoundsException.class,
				() -> staticList.get(15));
		assertThrows(IndexOutOfBoundsException.class,
				() -> staticList.get(3));
		assertThrows(IndexOutOfBoundsException.class,
				() -> staticList.get(0));
	}
	
	@Test
	void shouldAddAnElementToTheListThenIsNotEmpty() {
		addMultipleElements(15, 42, 23);

		assertFalse(staticList.isEmpty());
	}

	@Test
	void shouldAddThreeElementsToTheListAndGetThemAll() {
		addMultipleElements(15, 42, 23);

		assertEquals(15, staticList.get(0));
		assertEquals(42, staticList.get(1));
		assertEquals(23, staticList.get(2));
	}
	
	@Test
	void shouldReturnListToItsOriginalStateWhenFreed() {
		addMultipleElements(661, 422);
		
		staticList.free();

		assertEquals(0, staticList.size());
		assertTrue(staticList.isEmpty());
	}

	@Test
	void shouldOutputEachElementSplitByAnEmptySpace() {
	    addMultipleElements(15, 2, 162);

		String asString = staticList.toString();

		assertEquals("15 2 162", asString);
	}

	@Test
	void shouldHaveSizeN_ForAListWithN_Elements() {
		addMultipleElements(15, 61, 22, 18);

		assertEquals(4, staticList.size());
	}

	@Test
	void shouldNotRemoveAnItemThatDoesNotExists() {
		addMultipleElements(22, 18);

        staticList.remove(61);

        assertEquals(2, staticList.size());
	}

	@Test
	void shouldRemoveAnItem() {
		addMultipleElements(61, 15, 22, 18);

		staticList.remove(61);

        assertEquals(3, staticList.size());
		assertEquals(15, staticList.get(0)); // fifty is the new element at 0
		assertEquals(ELEMENT_NOT_FOUND, staticList.find(61));
	}

	@Test
	void shouldResizeToAddMoreFreeSpaceWhenAddingElementsBeyondTheInitialLength() {
		addMultipleElements(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);

		assertEquals(13, staticList.size());
	}

	@Test
	void shouldReverseListOrderForOddAmountOfElements() {
	    addMultipleElements(12, 23, 51, 69, 40);

		staticList.reverseOrder();

		assertItems(40, 69, 51, 23, 12);
	}

	@Test
	void shouldReverseListOrderForEvenAmountOfElements() {
		addMultipleElements(12, 23, 51, 69, 40, 29);

		staticList.reverseOrder();

		assertItems(29, 40, 69, 51, 23, 12);
	}
	
	@Test
	void shouldRemoveInBetween() {
		addMultipleElements(10, 20, 30, 40, 50, 60);
		
		staticList.removeInRange(2, 4);
		
		assertItems(10, 20, 60);
		assertEquals(3, staticList.size());
	}

	@Test
	void shouldRemoveElementsAtStart() {
		addMultipleElements(10, 20, 30, 40, 50, 60);
		
		staticList.removeInRange(0, 2);
		
		assertItems(40, 50, 60);
		assertEquals(3, staticList.size());
	}
	
	@Test
	void shouldRemoveElementsAtEnd() {
		addMultipleElements(10, 20, 30, 40, 50, 60);
		
		staticList.removeInRange(2, 5);
		
		assertItems(10, 20);
		assertEquals(2, staticList.size());
	}
	
	@Test
	void shouldRemoveAllElements() {
		addMultipleElements(10, 20, 30, 40, 50, 60);
	
		staticList.removeInRange(0, 5);
		
		assertEquals(0, staticList.size());
	}

	@Test
	void shouldSort() {
		addMultipleElements(60, 10, 50, 20, 40, 30, 70, 80, 90, 100);

		staticList.sort(new QuickSort<>());

		assertItems(10, 20, 30, 40, 50, 60, 70, 80, 90, 100);
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
