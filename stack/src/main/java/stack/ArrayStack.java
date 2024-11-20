package stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<E> implements Stack<E> {

	private final E[] objects;
	private int size;
	
	public ArrayStack(int initialCapacity) {
		objects = (E[]) new Object[initialCapacity];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E pop() {
		E valueToPop = peek();

		size--;

		return valueToPop;
	}

	public E peek() {
		if (isEmpty()) 
			throw new EmptyStack();
		
		return objects[size-1];
	}
	
	public void push(E e) {
		if (size == objects.length)
			throw new MaximumCapacity();

		objects[size++] = e;
	}

	public void free() {
		while(!isEmpty()) pop();
	}

	public void concat(Stack<E> stackToConcat) {
		if (stackToConcat.isEmpty())
			return;

		Iterator<E> it = stackToConcat.iterator();

		while (it.hasNext()) push(it.next());
	}

	@Override
	public String toString() {
		if (isEmpty()) return "";

		StringBuilder sb = new StringBuilder();

		for (int i = size - 1; i  > 0; i--)
			sb.append(objects[i]).append(", ");

		sb.append(objects[0]);

		return sb.toString();
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<>() {
			private int current = 0;

			@Override
			public boolean hasNext() {
				return current < size;
			}

			@Override
			public E next() {
				if (!hasNext()) throw new NoSuchElementException();
				return objects[current++];
			}
		};
	}
}
