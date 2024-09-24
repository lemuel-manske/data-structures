package list;

public class LinkToEndLinkedList<E> {

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
     * Adds an element to the end of the list.
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
     * Given an element finds its index.
     */
    public int find(E e) {
        Node<E> currentNode = firstNode;

        int i = 0;

        while (currentNode != null) {
            if (currentNode.value().equals(e)) return i;

            currentNode = currentNode.nextNode;

            i++;
        }

        return -1;
    }

    /**
     * Removes an element if it is found by its value.
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

    public static class Node<T> {

        private final T value;
        private Node<T> nextNode;

        private Node(T value) {
            this.value = value;
        }

        public T value() {
            return value;
        }
    }
}
