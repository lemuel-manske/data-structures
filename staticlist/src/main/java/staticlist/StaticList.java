package staticlist;

public class StaticList<T> {

	private static final int SIZE_TO_INCREASE = 10;
	private static final int DEFAULT_LIST_SIZE = 10;
	public static final int NO_ELEMENT_EXCEPTION_CODE = -1;

	private int size = 0;
	private Object[] list = new Object[DEFAULT_LIST_SIZE];

	/**
	 * Returns the current list size.
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns <code>true</code> if the list is empty, else <code>false</code>.
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Returns whether the given element exists.
	 */
	public int find(T element) {
		for (int i = 0; i < size(); i++)
			if (list[i] == element)
				return i;
		
		return NO_ELEMENT_EXCEPTION_CODE;
	}

	/**
	 * Returns an element if it is found by its index.
	 *
	 * <p>When no element is found returns -1.
	 */
	@SuppressWarnings("unchecked")
	public T get(int index) {
		if (size() == 0 || index > size())
			throw new IndexOutOfBoundsException();
		
		return (T) list[index];
	}

	/**
	 * Adds an element to the list.
	 */
	public void add(T element) {
		if (size == list.length)
			resizeList();

		list[size++] = element;
	}

	/**
	 * Reset the list to its original state of size 0 without any elements.
	 */
	public void free() {
		size = 0;
		list = new Object[DEFAULT_LIST_SIZE];
	}

	/**
	 * Removes an element from the list by matching its value.
	 */
	public void remove(T element) {
		int index = find(element);

		if (index == NO_ELEMENT_EXCEPTION_CODE) return;

		for (int i = index; i < size() - 1; i++)
			list[i] = list[i + 1];

		size--;
	}

	/**
	 * Given the addition order of elements in the list,
	 * this will reorganize the list to the opposite order.
	 */
	public void reverseOrder() {
		int midIndex = size() / 2 -1;

		for (int i = midIndex; i >= 0; i--) {
			int oppositeSideIndex = size() - i -1;
			Object temp = list[oppositeSideIndex];
			list[oppositeSideIndex] = list[i];
			list[i] = temp;
		}
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < size; i++) {
			builder.append(list[i]);
			if (i < size - 1) builder.append(" ");
		}

		return builder.toString();
	}

	private void resizeList() {
		Object[] newList = new Object[list.length + SIZE_TO_INCREASE];

        System.arraycopy(list, 0, newList, 0, list.length);

		list = newList;
	}
}
