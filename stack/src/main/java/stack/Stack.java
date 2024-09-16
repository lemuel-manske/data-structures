package stack;

public interface Stack<T> {

	/**
	 * Returns the current stack size. 
	 */
	int size();
	
	/**
	 * Pushes an element to the stack top.
	 * 
	 * <p>Throws {@link MaximumCapacity} when no more elements can be pushed.
	 */
	void push(T e);
	
	/**
	 * Pops an element by removing it and returning its value.
	 * 
	 * <p>Throws {@link Empty} when no element to pop.
	 */
	T pop();
	
	/**
	 * Peeks the stack top element.
	 */
	T peek();
	
	/**
	 * Returns whether the stack is empty.
	 */
	boolean isEmpty();
	
	/**
	 * Sets free all the stack's elements. 
	 */
	void free();
	
	class MaximumCapacity extends RuntimeException {
		private static final long serialVersionUID = 5875002575184536190L;
	}
	
	class Empty extends RuntimeException {
		private static final long serialVersionUID = 1651844929494254362L;
	}
}
