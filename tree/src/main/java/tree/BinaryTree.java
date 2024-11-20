package tree;

public class BinaryTree<E extends Comparable<E>> {

    private Node<E> root;

    public BinaryTree() { }

    public BinaryTree(Node<E> root) {
        this.root = root;
    }

    protected void updateRoot(Node<E> e) {
        if (isEmpty())
            root = e;
        else
            updateRoot(root, e);
    }

    private void updateRoot(Node<E> node, Node<E> e) {
        if (node.value().compareTo(e.value()) > 0)
            if (node.leftNode() == null)
                node.setL(e);
            else
                updateRoot(node.leftNode(), e);
        else
            if (node.rightNode() == null)
                node.setR(e);
            else
                updateRoot(node.rightNode(), e);
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
     * Adds an element to the tree.
     */
    public void add(E e) {
        updateRoot(Node.of(e));
    }

    /**
     * Finds a {@link Node} with the given value in the tree.
     */
    public Node<E> find(E e) {
        if (isEmpty()) return null;

        return find(getRoot(), e);
    }

    private Node<E> find(Node<E> node, E e) {
        if (node == null) return null;

        if (node.value().equals(e)) return node;

        if (e.compareTo(node.value()) < 0)
            return find(node.left, e);
        else
            return find(node.right, e);
    }

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
     * Removes a node in the tree by matching its value.
     */
    public void remove(E e) {

    }

    /**
     * Represents a tree node.
     */
    public static class Node<T> {

        private final T value;
        private Node<T> left;
        private Node<T> right;

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

        public void setL(Node<T> e) {
            left = e;
        }

        public void setR(Node<T> e) {
            right = e;
        }
    }
}