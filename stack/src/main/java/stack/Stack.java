package stack;

import java.util.Iterator;

public interface Stack<T> {

	/**
	 * Pushes an element to top of the stack.
	 */
	void push(T e);
	
	/**
	 * Pops the top element and returns it.
	 * 
	 * <p>Throws {@link EmptyStack} when no element to pop.
	 */
	T pop();
	
	/**
	 * Peeks the top element of the stack.
	 */
	T peek();
	
	/**
	 * Returns whether the stack is empty.
	 */
	boolean isEmpty();
	
	/**
	 * Resets the stack to its original state.
	 */
	void free();

	/**
	 * Returns an {@link Iterator} implementation for the stack
	 */
	Iterator<T> iterator();

	/**
	 * Concatenate another stack into that stack.
	 */
	void concat(Stack<T> stackToConcat);
}
