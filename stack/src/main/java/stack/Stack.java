package stack;

import java.io.Serial;

public interface Stack<T> {

	/**
	 * Pushes an element to top of the stack.
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

	/**
	 * Concatenate another stack into that stack.
	 */
	void concat(Stack<T> stackToConcat);
	
	class Empty extends RuntimeException {

		@Serial
		private static final long serialVersionUID = 1651844929494254362L;
	}
}
