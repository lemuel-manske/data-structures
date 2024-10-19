package list;

/**
 * Linked list with access to the first and last elements.
 */
public final class DoubleAccessList<E> {

    private int size;
    private Node<E> firstNode;
    private Node<E> lastNode;

    /**
     * Returns the current list size.
     */
    public int size() {
        return size;
    }

    /**
     * Returns whether the list is empty.
     */
    public boolean isEmpty() {
        return firstNode == null;
    }

    /**
     * Adds an element to the <strong>end of the list</strong>.
     */
    public void add(E e) {
        Node<E> newNode = new Node<>(e);

        if (isEmpty())
            firstNode = newNode;
        else
            lastNode.nextNode = newNode;

        lastNode = newNode;

        size++;
    }

    /**
     * Gets the first node in the list.
     */
    public Node<E> getFirst() {
        return firstNode;
    }

    /**
     * Removes the first element with the given value.
     */
    public void remove(E e) {
        if (isEmpty()) return;

        if (firstNode.value().equals(e)) {
            if (firstNode == lastNode) {
                firstNode = null;
                lastNode = null;
            } else firstNode = firstNode.nextNode;
            size--;
            return;
        }

        Node<E> previousNode = firstNode;
        Node<E> currentNode = firstNode.nextNode;

        while (currentNode != null) {
            if (currentNode.value().equals(e)) {
                previousNode.nextNode = currentNode.nextNode;
                size--;

                if (currentNode == lastNode) lastNode = previousNode;

                return;
            }

            previousNode = currentNode;
            currentNode = currentNode.nextNode;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node<E> node = firstNode;

        while(node != null) {
            sb.append(node.value);
            node = node.nextNode;
            if (node != null) sb.append(", ");
        }

        return sb.toString();
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

        public Node<T> nextNode() {
            return nextNode;
        }
    }
}
