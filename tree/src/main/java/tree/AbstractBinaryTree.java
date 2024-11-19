package tree;

public abstract class AbstractBinaryTree<E> {

    private Node<E> root;

    public AbstractBinaryTree() { }

    public AbstractBinaryTree(Node<E> root) {
        this.root = root;
    }

    protected void updateRoot(E e) {
        root = Node.of(e);
    }

    protected void updateRoot(Node<E> newRoot) {
        root = newRoot;
    }

    /**
     * Gets the root node of the tree.
     */
    public Node<E> getRoot() {
        return root;
    }

    /**
     * Returns whether the tree is empty.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Returns whether the tree has a given {@link E value}
     */
    public boolean has(E e) {
        if (isEmpty()) return false;

        return has(root, e);
    }

    private boolean has(Node<E> node, E e) {
        Node<E> element = find(e);

        return element != null;
    }

    /**
     * Gets the count of all nodes in the tree.
     */
    public int count() {
        return count(root);
    }

    /**
     * Returns whether the tree is degenerated.
     */
    public boolean isDegenerated() {
        if (isEmpty() || count() == 1) return false;

        return isDegenerated(root);
    }

    /**
     * Finds a {@link Node} with the given value in the tree.
     */
    public abstract Node<E> find(E e);

    private boolean isDegenerated(Node<E> node) {
        if (node == null) return true;

        if (node.leftNode() != null && node.rightNode() != null) return false;

        return isDegenerated(node.leftNode())
                && isDegenerated(node.rightNode());
    }

    private int count(Node<E> root) {
        if (root == null) return 0;

        return 1 + count(root.leftNode()) + count(root.rightNode());
    }

    public String toString() {
        return toString(root);
    }

    private String toString(Node<E> node) {
        if (node == null) return "<>";

        return String.format("<%s%s%s>",
                node.value(),
                toString(node.leftNode()),
                toString(node.rightNode()));
    }

    /**
     * Represents a tree node.
     */
    public static class Node<T> {

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