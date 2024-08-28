package linkedlist;

import java.util.Optional;

public interface LinkedList<T> {

	boolean isEmpty();
	
	int size();
	
	Optional<Node<T>> find(int index);
	
	void add(T e);
	
	Optional<Node<T>> findByValue(T value);
	
	void remove(T value);
}
