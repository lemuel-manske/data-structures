package staticlist;

public interface StaticList {
	
	/**
	 * Returns ´true´ if the list is empty, else ´false´.
	 */
	boolean isEmpty();

	/**
	 * Returns the current list size.
	 */
	int size();
	
	/**
	 * Returns whether exists an element 
	 * that matches ´elementToFind´ argument
	 */
	int find(int elementToFind);
	
	/**
	 * Returns an element if it is found
	 * by the ´elementIndex´ argument, if not found 
	 * returns -1.
	 */
	int get(int elementIndex);
	
	/**
	 * Adds an element to the list.
	 */
	void add(int elementToAdd);
	
	/**
	 * Reset the list to its original state of size 0 without any elements.
	 */
	void free();
}
