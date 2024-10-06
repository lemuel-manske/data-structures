package stack;

import list.LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListStack<T> implements Stack<T> {

	private final LinkedList<T> list;
	
	public ListStack() {
		list = new LinkedList<>();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public T pop() {
		T valueToPop = peek();
		
		list.remove(valueToPop);
		
		return valueToPop;
	}
	
	public T peek() {
		if (isEmpty())
			throw new EmptyStack();

		return list.findByIdx(0).value();
	}
	
	public void push(T e) {
		list.add(e);
	}

	public void free() {
		list.free();
	}


	public void concat(Stack<T> stackToConcat) {
		if (stackToConcat.isEmpty())
			return;

		Iterator<T> it = stackToConcat.iterator();

		while (it.hasNext()) push(it.next());
	}

	@Override
	public String toString() {
		return list.toString();
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<>() {
			private int current = list.size() - 1;

			@Override
			public boolean hasNext() {
				return current >= 0;
			}

			@Override
			public T next() {
				if (!hasNext()) throw new NoSuchElementException();
				return list.findByIdx(current--).value();
			}
		};
	}
}

