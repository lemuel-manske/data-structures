package staticlist;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class StaticListTest {
	
	private static final int ELEMENT_NOT_FOUND = -1;
	
	private StaticList staticList;
	
	@BeforeEach
	void createStaticList() {
		staticList = new StaticListImpl();
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
	void whenGetElementThatNotExistsThrowsException() {
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
		
		assertEquals(15, staticList.get(0));
		assertEquals(42, staticList.get(1));
		assertEquals(23, staticList.get(2));
	}
	
	@Test
	void whenFreeThenResetListToItsOriginalState() {
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
	void testSizeToBeAllListElements() {
		addMultipleElements(15, 61, 22, 18);

		assertEquals(4, staticList.size());
	}

	private void addMultipleElements(int... elements) {
		for (int element : elements)
			staticList.add(element);
	}
}
