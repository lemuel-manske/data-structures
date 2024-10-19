package tree;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class RecursiveTree<E> implements Tree<E> {

    private Node<E> rootNode;

    @Override
    public void updateRoot(Node<E> newRoot) {
        rootNode = newRoot;
    }

    @Override
    public boolean has(E e) {
        if (isEmpty()) return false;

        if (rootNode.value().equals(e)) return true;

        Iterator<Node<E>> rootChildren = rootNode.children();

        while (rootChildren.hasNext())
            if (rootChildren.next().value().equals(e))
                return true;

        return false;
    }

    @Override
    public Node<E> root() {
        return rootNode;
    }

    @Override
    public boolean isEmpty() {
        return rootNode == null;
    }

    @Override
    public int count() {
        if (isEmpty()) return 0;

        AtomicInteger count = new AtomicInteger(1);

        rootNode.children().forEachRemaining(ignored -> count.incrementAndGet());

        return count.get();
    }

    @Override
    public int countLeaves() {
        if (isEmpty()) return 0;

        return countLeaves(rootNode);
    }

    private int countLeaves(Node<E> node) {
        int count = 0;

        boolean isLeave = node.firstNode() == null;

        if (isLeave) count++;

        Node<E> currNode = node.firstNode();

        while(currNode != null) {
            count += countLeaves(currNode);
            currNode = currNode.nextNode();
        }

        return count;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "<>";

        return toString(rootNode);
    }

    private String toString(Node<E> node) {
        StringBuilder sb = new StringBuilder();

        sb.append("<").append(node.value());

        node.children().forEachRemaining(currNode ->
                sb.append(toString(currNode)));

        sb.append(">");

        return sb.toString();
    }
}
