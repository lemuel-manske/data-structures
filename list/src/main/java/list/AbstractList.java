package list;

/**
 * A static list implementation.
 */
public abstract class AbstractList<T> {

	private static final int SIZE_TO_INCREASE = 10;
	private static final int DEFAULT_LIST_SIZE = 10;
	public static final int NO_ELEMENT_EXCEPTION_CODE = -1;

	protected int size = 0;
	protected Comparable<T>[] list;

	public AbstractList() {
		list = new Comparable[DEFAULT_LIST_SIZE];
	}

	public AbstractList(final int initialSize) {
		list = new Comparable[initialSize];
	}

	/**
	 * Returns the current size of the list.
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns whether the list is empty or not.
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Returns the index for the given element if it exists or else returns -1.
	 */
	public abstract int find(T element);

	/**
	 * Returns an element if it is found by its index or else throws <code>IndexOutOfBoundsException</code>
	 */
	public T get(int index) {
		if (size() == 0 || index > size())
			throw new IndexOutOfBoundsException();
		
		return (T) list[index];
	}

	/**
	 * Adds an element to the list.
	 *
	 * <p>When not enough size, resizes the list by copying its elements to a new list, with ten more spaces.
	 */
	public abstract void add(T element);

	/**
	 * Reset the list to its original state.
	 *
	 * <p><strong>Careful</strong>, it will remove all the elements of the list.
	 */
	public void free() {
		size = 0;
		list = new Comparable[DEFAULT_LIST_SIZE];
	}

	/**
	 * Removes an element from the list by matching its value.
	 */
	public void remove(T element) {
		int index = find(element);

		if (index == NO_ELEMENT_EXCEPTION_CODE) return;

		for (int i = index; i < size(); i++)
			list[i] = list[i + 1];

		size--;
	}

	/**
	 * Given the original order of elements in the list,
	 * this will reorganize the list to the opposite order.
	 *
	 * <p>In example, given that the list is 3, 2 and 1, <code>reverseOrder</code>
	 * will set reorganize the list to 1, 2 and 3.
	 */
	public void reverseOrder() {
		int midIndex = size() / 2 -1;

		for (int i = midIndex; i >= 0; i--) {
			int oppositeSideIndex = size() - i -1;
			Comparable<T> temp = list[oppositeSideIndex];
			list[oppositeSideIndex] = list[i];
			list[i] = temp;
		}
	}
	
	/**
	 * Given a valid range, will remove the items in this range
	 * and keep the remaining items in the freed positions.
	 *
	 * <p>In example, for the given list: 10, 20, 30, 40, 50, 60
	 * we call <code>removeInRange(2, 5)</code> just the elements 10 and 20 will remain.
	 */
	public void removeInRange(int startIndex, int endIndex) {
		int nextToRemove = endIndex + 1;
		for (int i = startIndex; i <= endIndex; i++) {
			if (nextToRemove < list.length) {
				list[i] = list[nextToRemove];
				list[nextToRemove] = null;
			} else {
				list[i] = null;
			}
			size--;
			nextToRemove++;
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < size; i++) {
			builder.append(list[i]);
			if (i < size - 1) builder.append(" ");
		}

		return builder.toString();
	}

	protected void resizeList() {
		Comparable<T>[] newList = new Comparable[list.length + SIZE_TO_INCREASE];

        System.arraycopy(list, 0, newList, 0, list.length);

		list = newList;
	}
}
