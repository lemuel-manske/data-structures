package stack;

import list.LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListStack<E> implements Stack<E> {

	private final LinkedList<E> list;
	
	public ListStack() {
		list = new LinkedList<>();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public E pop() {
		E valueToPop = peek();
		
		list.remove(valueToPop);
		
		return valueToPop;
	}
	
	public E peek() {
		if (isEmpty())
			throw new EmptyStack();

		return list.getByIndex(0).getValue();
	}
	
	public void push(E e) {
		list.add(e);
	}

	public void free() {
		list.free();
	}


	public void concat(Stack<E> stackToConcat) {
		if (stackToConcat.isEmpty())
			return;

		Iterator<E> it = stackToConcat.iterator();

		while (it.hasNext()) push(it.next());
	}

	@Override
	public String toString() {
		return list.toString();
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<>() {
			private int current = list.size() - 1;

			@Override
			public boolean hasNext() {
				return current >= 0;
			}

			@Override
			public E next() {
				if (!hasNext()) throw new NoSuchElementException();
				return list.getByIndex(current--).getValue();
			}
		};
	}
}

