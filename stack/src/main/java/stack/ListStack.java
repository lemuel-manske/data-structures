package stack;

import linkedlist.LinkedList;

public class ListStack<T> implements Stack<T> {

	private LinkedList<T> list;
	
	public ListStack() {
		list = new LinkedList<T>();
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
		if (isEmpty()) throw new Stack.Empty();
		
		return list.firstNode().get().value();
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

