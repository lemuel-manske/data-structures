package stack;

import list.LinkedList;

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

		T elementToPush = stackToConcat.pop();
		concat(stackToConcat);
		push(elementToPush);
	}

	@Override
	public String toString() {
		return list.toString();
	}
}

