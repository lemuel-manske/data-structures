package linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Predicate;

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
		return findNode(byIndex(index));
	}

	/**
	 * Returns the node with the given value, or else {@link Optional#empty()}
	 */
	public Optional<Node<T>> findByValue(T value) {
		return findNode(node -> node.value().equals(value));
	}

	/**
	 * Adds a new element to the list.
	 */
	public void add(T e) {
		size++;

		Node<T> newNode = new Node<>(e);

		if (isEmpty()) {
			firstNode = newNode;
			return;
		}

		newNode.nextNode = firstNode;
		firstNode.previousNode = newNode;
		firstNode = newNode;
	}

	/**
	 * Removes the node with the given value.
	 */
	public void remove(T value) {
		if (isEmpty()) return;

		Optional<Node<T>> maybeNode = findByValue(value);

		if (maybeNode.isEmpty())
			return;

		Node<T> nodeToRemove = maybeNode.get();

		if (nodeToRemove.equals(firstNode))
			firstNode = nodeToRemove.nextNode;
		else
			nodeToRemove.previousNode.nextNode = nodeToRemove.nextNode;

		if (nodeToRemove.nextNode != null)
			nodeToRemove.previousNode = nodeToRemove.nextNode;

		size--;
	}

	private Predicate<Node<T>> byIndex(int index) {
		return new Predicate<>() {
			private int currentIndex = index;

			@Override
			public boolean test(Node<T> node) {
				return currentIndex-- == 0;
			}
		};
	}

	private Optional<Node<T>> findNode(Predicate<Node<T>> predicate) {
		Iterator<Node<T>> it = firstNode.iterator();

		while (it.hasNext()) {
			Node<T> node = it.next();

			if (predicate.test(node)) return Optional.of(node);
		}

		return Optional.empty();
	}

	public static class Node<T> {

		private Node<T> previousNode;
		private final T value;
		private Node<T> nextNode;

		private Node(T value) {
			this.value = value;
		}

		public T value() {
			return value;
		}

		public Iterator<Node<T>> iterator() {
			return createNodeIterator();
		}

		private Iterator<Node<T>> createNodeIterator() {
			return new Iterator<>() {

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
			};
		}
	}
}
