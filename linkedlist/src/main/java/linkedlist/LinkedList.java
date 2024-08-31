package linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

public class LinkedList<T> {

	private int size;
	private Node<T> firstNode;

	/**
	 * Gets the first node in the list.
	 *
	 * @return the first node or an {@link Optional#empty()} if the list is empty.
	 */
	public Optional<Node<T>> firstNode() {
		return Optional.ofNullable(firstNode);
	}

	/**
	 * Returns whether the list is empty or not.
	 */
	public boolean isEmpty() {
		return firstNode().isEmpty();
	}

	/**
	 * Returns the current size of the list.
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns the node at the given index, or else {@link Optional#empty()}
	 */
	public Optional<Node<T>> findByIdx(int index) {
		if (isEmpty()) return Optional.empty();

		if (index == 0) return firstNode();

		Iterator<Node<T>> it = firstNode.iterator();

		while (it.hasNext()) {
			Node<T> node = it.next();

			if (index-- == 0)
				return Optional.of(node);
		}

		return Optional.empty();
	}

	/**
	 * Returns the node with the given value, or else {@link Optional#empty()}
	 */
	public Optional<Node<T>> findByValue(T value) {
		if (isEmpty()) return Optional.empty();
				
		Iterator<Node<T>> it = firstNode.iterator();

		while (it.hasNext()) {
			Node<T> node = it.next();

			if (node.value.equals(value))
				return Optional.of(node);
		}

		return Optional.empty();
	}

	/**
	 * Adds a new element to the list.
	 */
	public void add(T e) {
		Node<T> newNode = new Node<>(e);
		newNode.nextNode = firstNode;
		firstNode = newNode;
		size++;
	}

	/**
	 * Removes the node with the given value.
	 */
	public void remove(T value) {
		if (isEmpty()) return;

		Node<T> prev = firstNode;
		Iterator<Node<T>> it = firstNode.iterator();

		while (it.hasNext()) {
			Node<T> node = it.next();

			if (node.value.equals(value)) {
                prev.nextNode = node.nextNode;
				size--;
				return;
			}

			prev = node;
		}
	}

	public static class Node<T> {

		private final T value;
		private Node<T> nextNode;

		private Node(T value) {
			this.value = value;
		}

		public T value() {
			return value;
		}

		public Iterator<Node<T>> iterator() {
			return new NodeIterator();
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Node<?> node = (Node<?>) o;
			return Objects.equals(value, node.value);
		}

		private class NodeIterator implements Iterator<Node<T>> {

			private Node<T> current = Node.this;

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public Node<T> next() {
				if (!hasNext()) throw new NoSuchElementException();
				Node<T> next = current;
				current = current.nextNode;
				return next;
			}
		}
	}
}
