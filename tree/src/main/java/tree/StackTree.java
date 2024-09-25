package tree;

import stack.ListStack;
import stack.Stack;

public class StackTree<T> implements Tree<T> {

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

            if (currNode.getValue().equals(t)) return true;

            if (currNode.getLeft() != null)
                stackOfNodes.push(currNode.getLeft());

            if (currNode.getRight() != null)
                stackOfNodes.push(currNode.getRight());
        }

        return false;
    }
}
