package tree;

public interface BinaryTree<E> {

    /**
     * Updates the tree root node with the given {@link E value}
     */
    void updateRoot(E e);

    /**
     * Updates the tree root node with the given {@link Node<E> node}
     */
    void updateRoot(Node<E> newRoot);

    /**
     * Gets the root node of the tree.
     */
    Node<E> getRoot();

    /**
     * Returns whether the tree is empty.
     */
    boolean isEmpty();

    /**
     * Returns whether the tree has a given {@link E value}
     */
    boolean has(E e);

    /**
     * Gets the count of all nodes in the tree.
     */
    int count();

    /**
     * Represents a tree node.
     */
    class Node<T> {

        private final T value;
        private final Node<T> left;
        private final Node<T> right;

        private Node(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        private Node(T value, Node<T> left) {
            this.value = value;
            this.left = left;
            this.right = null;
        }

        private Node(T value, Node<T> left, Node<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public static <T> Node<T> of(T e) {
            return new Node<>(e);
        }

        public static <T> Node<T> of(T e, Node<T> left) {
            return new Node<>(e, left);
        }

        public static <T> Node<T> of(T e, Node<T> left, Node<T> right) {
            return new Node<>(e, left, right);
        }

        public T value() {
            return value;
        }

        public Node<T> leftNode() {
            return left;
        }

        public Node<T> rightNode() {
            return right;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
