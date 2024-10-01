package binarytree;

import stack.ListStack;
import stack.Stack;

public class StackBinaryTree<T> implements BinaryTree<T> {

    private Node<T> root;

    @Override
    public void updateRoot(T t) {
        root = Node.of(t);
    }

    @Override
    public void updateRoot(Node<T> newRoot) {
        root = newRoot;
    }

    @Override
    public Node<T> getRoot() {
        return root;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean has(T t) {
        if (isEmpty()) return false;

        Stack<Node<T>> stackOfNodes = new ListStack<>();

        stackOfNodes.push(root);

        while(!stackOfNodes.isEmpty()) {
            Node<T> currNode = stackOfNodes.pop();

            if (currNode.value().equals(t)) return true;

            if (currNode.leftNode() != null)
                stackOfNodes.push(currNode.leftNode());

            if (currNode.rightNode() != null)
                stackOfNodes.push(currNode.rightNode());
        }

        return false;
    }

    @Override
    public int count() {
        return 0;
    }
}
