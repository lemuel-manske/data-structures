package stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class VectorStack<T> implements Stack<T> {

	private final T[] objects;
	private int size;
	
	public VectorStack (int initialCapacity) {
		objects = (T[]) new Object[initialCapacity];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public T pop() {
		T valueToPop = peek();

		size--;

		return valueToPop;
	}

	public T peek() {
		if (isEmpty()) 
			throw new EmptyStack();
		
		return objects[size-1];
	}
	
	public void push(T e) {
		if (size == objects.length)
			throw new MaximumCapacity();

		objects[size++] = e;
	}

	public void free() {
		while(!isEmpty()) pop();
	}

	public void concat(Stack<T> stackToConcat) {
		if (stackToConcat.isEmpty())
			return;

		Iterator<T> it = stackToConcat.iterator();

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
	public Iterator<T> iterator() {
		return new Iterator<>() {
			private int current = 0;

			@Override
			public boolean hasNext() {
				return current < size;
			}

			@Override
			public T next() {
				if (!hasNext()) throw new NoSuchElementException();
				return objects[current++];
			}
		};
	}
}
