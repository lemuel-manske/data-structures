package tree;

public class RecursiveTree<E> implements Tree<E> {

    private Node<E> root;

    public RecursiveTree() { }

    public RecursiveTree(Node<E> root) {
        this.root = root;
    }

    @Override
    public void updateRoot(E e) {
        root = Tree.Node.of(e);
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

    @Override
    public String toString() {
        if (isEmpty()) return "<>";

        return toString(root);
    }

    private String toString(Node<E> node) {
        return String.format("<%s%s%s>",
                node.value(),
                new RecursiveTree<>(node.leftNode()),
                new RecursiveTree<>(node.rightNode()));
    }

}
