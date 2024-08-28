package linkedlist;

import java.util.Optional;

public class Node<T> {
	
	private T value;
	private Node<T> nextNode;
	
	private Node(T value) {
		this.value = value;
	}
	
	public static <T> Node<T> of(T value) {
		return new Node<T>(value);
	}
	
	public void linkTo(T e) {
		nextNode = Node.of(e);
	}
	
	// TODO: extract Iterator<Node<T>>

	
	public Optional<Node<T>> iterator(T valueToFind) {
		if (value.equals(valueToFind)) return Optional.of(this);
		
		if (nextNode().isEmpty()) return Optional.empty();
		
		return nextNode.iterator(valueToFind);
	}
	
	public int iterator(int currentSize) {
		Optional<Node<T>> nextNode = nextNode();
		
		if (nextNode.isEmpty()) return currentSize;
		
		return nextNode.get().iterator(currentSize + 1);
	}
	
	public Optional<Node<T>> iterator(int currentIndex, int indexToFind) {
		if (currentIndex == indexToFind) 
			return Optional.of(this);
		
		Optional<Node<T>> nextNode = nextNode();
		
		if (nextNode.isEmpty()) 
			return Optional.empty();
		
		return nextNode.get()
				.iterator(currentIndex + 1, indexToFind);
	}
	
	public Optional<Node<T>> findLastLinkedNode() {
		Optional<Node<T>> next = nextNode();
		
		if (next.isEmpty()) return Optional.of(this);
		
		return next.get().findLastLinkedNode();
	}
	
	public T value() {
		return value;
	}
	
	public Optional<Node<T>> nextNode() {
		return Optional.ofNullable(nextNode);
	}
}
