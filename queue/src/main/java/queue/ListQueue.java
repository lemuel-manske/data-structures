package queue;

import list.LinkToEndLinkedList;

public class ListQueue<E> implements Queue<E> {

    private final LinkToEndLinkedList<E> list;

    public ListQueue() {
        this.list = new LinkToEndLinkedList<>();
    }

    @Override
    public void add(E e) {
        list.add(e);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public E peek() {
        if (isEmpty()) throw new EmptyQueue();

        return list.getFirst().value();
    }

    @Override
    public E remove() {
        E value = peek();

        list.remove(value);

        return value;
    }

    @Override
    public Queue<E> concat(Queue<E> queueToConcat) {
        // TODO;
        return null;
    }

    @Override
    public void free() {
        while (!isEmpty()) remove();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}