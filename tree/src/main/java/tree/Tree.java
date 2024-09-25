package tree;

public interface Tree<E> {

    /**
     * Updates the tree root with the given {@link E value}
     */
    void updateRoot(E e);

    /**
     * Updates the tree root with the given {@link Node<E> node}
     */
    void updateRoot(Node<E> newRoot);

    /**
     * Gets the tree root.
     */
    Node<E> getRoot();

    /**
     * Returns whether the tree is empty.
     */
    boolean isEmpty();

    /**
     * Returns whether the tree has the given {@link E element}
     */
    boolean has(E e);

    class Node<T> {

        private T value;
        private Node<T> left;
        private Node<T> right;

        private Node(T value) {
            this.value = value;
        }

        private Node(T value, Node<T> left) {
            this.value = value;
            this.left = left;
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

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
