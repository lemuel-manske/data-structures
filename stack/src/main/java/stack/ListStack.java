package stack;

import list.LinkedList;

public class ListStack<T> implements Stack<T> {

	private final LinkedList<T> list;
	
	public ListStack() {
		list = new LinkedList<>();
	}
	
	public int size() {
		return list.size();
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
		LinkedList.Node<T> maybeFirstNode = list.findByIdx(0);

		if (maybeFirstNode == null) throw new Stack.Empty();

		return maybeFirstNode.value();
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

