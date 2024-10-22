package list;

/**
 * A linked list implementation.
 */
public final class LinkedList<T> {

	private int size;
	private Node<T> firstNode;

	/**
	 * Returns whether the list is empty or not.
	 */
	public boolean isEmpty() {
		return firstNode == null;
	}

	/**
	 * Returns the current size of the list.
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns the node at the given index or else null.
	 */
	public Node<T> getByIndex(int index) {
		Node<T> current = firstNode;

		for (int i = 0; i < index && current != null; i++)
			current = current.nextNode;

		return current;
	}

	/**
	 * Returns the first node with the given value or else null.
	 */
	public Node<T> getByValue(T value) {
		Node<T> current = firstNode;

		while (current != null) {
			if (value != null && value.equals(current.value))
				return current;

			current = current.nextNode;
		}

		return null;
	}

	/**
	 * Adds a new element to the list.
	 */
	public void add(T e) {
		size++;
		Node<T> newNode = new Node<>(e);

        if (!isEmpty()) {
            newNode.nextNode = firstNode;
            firstNode.previousNode = newNode;
        }

        firstNode = newNode;
    }

	/**
	 * Removes the first node with the given value.
	 */
	public void remove(T value) {
		if (isEmpty())
			return;

		Node<T> nodeToRemove = getByValue(value);

		if (nodeToRemove == null)
			return;

		if (nodeToRemove == firstNode)
			firstNode = nodeToRemove.nextNode;
		else
			nodeToRemove.previousNode.nextNode = nodeToRemove.nextNode;


		if (nodeToRemove.nextNode != null)
			nodeToRemove.nextNode.previousNode = nodeToRemove.previousNode;

		size--;
	}

	/**
	 * Returns a new list of reversed items in this.
	 */
	public LinkedList<T> reverseOrder() {
		LinkedList<T> newList = new LinkedList<>();

		Node<T> current = firstNode;

		while (current != null) {
			newList.add(current.value());
			current = current.nextNode;
		}

		return newList;
	}

	/**
	 * Returns a new list of the items in range.
	 */
	public LinkedList<T> subList(int startIndex, int endIndex) {
		if (startIndex > endIndex || startIndex < 0)
			throw new IndexOutOfBoundsException();

		Node<T> node = getByIndex(endIndex);

		if (node == null)
			throw new IndexOutOfBoundsException();

		LinkedList<T> newList = new LinkedList<>();

		for (int i = startIndex; i <= endIndex && node != null; i++) {
			newList.add(node.value());
			node = node.previousNode;
		}

		return newList;
	}

	/**
	 * Reset the list to its original state.
	 *
	 * <p><strong>Careful</strong>, it will remove all the elements of the list.
	 */
	public void free() {
		firstNode = null;
		size = 0;
	}

	@Override
	public String toString() {
		if (isEmpty()) return "";

		StringBuilder builder = new StringBuilder();

		Node<T> current = firstNode;

		while (current != null) {
			builder.append(current.value());

			if (current.nextNode != null)
				builder.append(", ");

			current = current.nextNode;
		}

		return builder.toString();
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

		public Node<T> previous() {
			return previousNode;
		}

		public Node<T> next() {
			return nextNode;
		}
	}
}
