package tree;

import java.util.Iterator;

public interface Tree<E> {

    /**
     * Returns whether the element exist in this tree.
     */
    boolean has(E e);

    /**
     * Updates the tree root.
     */
    void updateRoot(Node<E> root);

    /**
     * Gets the root.
     */
    Node<E> root();

    /**
     * Returns whether the tree is empty.
     */
    boolean isEmpty();

    /**
     * Returns the count of all nodes in the tree.
     */
    int count();

    class Node<E> {

        private Node<E> firstNode;
        private Node<E> nextNode;
        private final E value;

        public Node(E e) {
            value = e;
        }

        public E value() {
            return value;
        }

        public Node<E> firstNode() {
            return firstNode;
        }

        public Node<E> nextNode() {
            return nextNode;
        }

        public void append(Node<E> node) {
            node.nextNode = firstNode;
            firstNode = node;
        }

        public Iterator<Node<E>> children() {
            return new Iterator<>() {
                private Node<E> current = firstNode;

                @Override
                public boolean hasNext() {
                    return current != null;
                }

                @Override
                public Node<E> next() {
                    Node<E> that = current;
                    current = current.nextNode;
                    return that;
                }
            };
        }
    }
}
