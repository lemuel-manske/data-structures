package binarytree;

public final class RecursiveBinaryTree<E> implements BinaryTree<E> {

    private Node<E> root;

    public RecursiveBinaryTree() { }

    public RecursiveBinaryTree(Node<E> root) {
        this.root = root;
    }

    @Override
    public void updateRoot(E e) {
        root = BinaryTree.Node.of(e);
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

        if (node.value().equals(e)) return true;

        return has(node.rightNode(), e) || has(node.leftNode(), e);
    }

    public int count() {
        return count(root);
    }

    private int count(BinaryTree.Node<E> root) {
        if (root == null) return 0;

        return 1 + count(root.leftNode()) + count(root.rightNode());
    }

    @Override
    public String toString() {
        if (isEmpty()) return "<>";

        return toString(root);
    }

    private String toString(Node<E> node) {
        return String.format("<%s%s%s>",
                node.value(),
                new RecursiveBinaryTree<>(node.leftNode()),
                new RecursiveBinaryTree<>(node.rightNode()));
    }

}
