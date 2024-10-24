package tree;

public final class RecursiveBinaryTree<E> implements BinaryTree<E> {

    private Node<E> root;

    public RecursiveBinaryTree() { }

    public RecursiveBinaryTree(Node<E> root) {
        this.root = root;
    }

    @Override
    public void updateRoot(E e) {
        root = Node.of(e);
    }

    @Override
    public void updateRoot(Node<E> newRoot) {
        root = newRoot;
    }


    @Override
    public Node<E> getRoot() {
        return root;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean has(E e) {
        if (isEmpty()) return false;

        return has(root, e);
    }

    public boolean has(Node<E> node, E e) {
        if (node == null) return false;

        return node.value().equals(e) || has(node.rightNode(), e) || has(node.leftNode(), e);
    }

    public int count() {
        return count(root);
    }

    @Override
    public boolean isDegenerated() {
        if (isEmpty() || count() == 1) return false;

        return isDegenerated(root);
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

    @Override
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
}
