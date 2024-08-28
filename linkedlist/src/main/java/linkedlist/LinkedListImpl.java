package linkedlist;

import java.util.Optional;

public class LinkedListImpl<T> implements LinkedList<T> {
	
	private Node<T> firstNode;
	
	public boolean isEmpty() {
		return Optional.ofNullable(firstNode).isEmpty();
	}
	
	public int size() {
		if (isEmpty()) 
			return 0;

		return firstNode.iterator(1);	
	}
	
	public Optional<Node<T>> first() {
		return Optional.ofNullable(firstNode);
	}
	
	public Optional<Node<T>> find(int index) {
		if (isEmpty())
			return Optional.empty();
		
		if (index == 0)
			return first();
		
		return firstNode.iterator(0, index);
	}
	
	public Optional<Node<T>> findByValue(T value) {
		if (isEmpty())
			return Optional.empty();
				
		return firstNode.iterator(value);
	}
	
	public void add(T e) {
		if (isEmpty()) {
			firstNode = Node.of(e);
			return;
		}
		
		firstNode
			.findLastLinkedNode()
			.ifPresent(lastNode -> lastNode.linkTo(e));
	}
	
	public void remove(T value) {
		// TODO;
	}
}
