package stack;

import linkedlist.LinkedList;

import java.util.Optional;

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
		Optional<LinkedList.Node<T>> maybeFirstNode = list.firstNode();

		if (!maybeFirstNode.isPresent()) throw new Stack.Empty();

		return maybeFirstNode.get().value();
	}
	
	public void push(T e) {
		list.add(e);
	}
	
	@Override
	public String toString() {	
		return list.toString();
	}

	public void free() {
		list.free();
	}
}

