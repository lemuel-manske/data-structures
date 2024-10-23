package tree;

import stack.ListStack;
import stack.Stack;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public final class StackBinaryTree<T> implements BinaryTree<T> {

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
        if (isEmpty())
            return false;

        final AtomicBoolean found = new AtomicBoolean(false);

        traverse(node -> {
            if (node.value().equals(t))
                found.set(true);
        });

        return found.get();
    }

    @Override
    public int count() {
        if (isEmpty())
            return 0;

        final AtomicInteger count = new AtomicInteger();

        traverse(node -> count.getAndIncrement());

        return count.get();
    }

    @Override
    public boolean isDegenerated() {
        if (isEmpty() || count() == 1)
            return false;

        final AtomicBoolean isDegenerated = new AtomicBoolean(true);

        traverse(node -> {
            if (node.leftNode() != null && node.rightNode() != null)
                isDegenerated.set(false);
        });

        return isDegenerated.get();
    }

    @Override
    public String toString() {
        // TODO
        return "<>";
    }

    private void traverse(Consumer<Node<T>> consumer) {
        Stack<Node<T>> stackOfNodes = new ListStack<>();

        stackOfNodes.push(root);

        while(!stackOfNodes.isEmpty()) {
            Node<T> currNode = stackOfNodes.pop();

            consumer.accept(currNode);

            if (currNode.leftNode() != null)
                stackOfNodes.push(currNode.leftNode());

            if (currNode.rightNode() != null)
                stackOfNodes.push(currNode.rightNode());
        }
    }

}
