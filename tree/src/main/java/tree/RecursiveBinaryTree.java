package tree;

public final class RecursiveBinaryTree<E> extends AbstractBinaryTree<E> {

    @Override
    public Node<E> find(E e) {
        if (isEmpty()) return null;

        return find(getRoot(), e);
    }

    private Node<E> find(Node<E> node, E e) {
        if (node == null) 
            return null;

        if (node.value().equals(e)) 
            return node;

        Node<E> left = find(node.leftNode(), e);

        if (left != null)
            return left;

        return find(node.rightNode(), e);
    }
}
