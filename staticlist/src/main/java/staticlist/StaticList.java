package staticlist;

/**
 * Defines the contract for a static list.
 */
public interface StaticList<T> {
	
	/**
	 * Returns <code>true</code> if the list is empty, else <code>false</code>.
	 */
	boolean isEmpty();

	/**
	 * Returns the current list size.
	 */
	int size();
	
	/**
	 * Returns whether exists an element 
	 * that matches <code>elementToFind</code> argument
	 */
	int find(T elementToFind);
	
	/**
	 * Returns an element if it is found
	 * by the <code>elementIndex</code> argument, if not found
	 * returns -1.
	 */
	T get(int elementIndex);
	
	/**
	 * Adds an element to the list.
	 */
	void add(T elementToAdd);
	
	/**
	 * Reset the list to its original state of size 0 without any elements.
	 */
	void free();

	/**
	 * Removes an element from the list by matching its value.
	 */
    void remove(T elementToRemove);

    void reverseOrder();
}
