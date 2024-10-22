package queue;

import list.DoubleAccessLinkedList;

/**
 * A queue implementation that uses a {@link DoubleAccessLinkedList} to store its elements.
 */
public final class ListQueue<E> implements Queue<E> {

    private final DoubleAccessLinkedList<E> list;

    public ListQueue() {
        this.list = new DoubleAccessLinkedList<>();
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
        requireNotEmptyQueue();

        return list.first().value();
    }

    @Override
    public E remove() {
        E value = peek();

        list.remove(value);

        return value;
   }

    @Override
    public void free() {
        while (!isEmpty()) remove();
    }

    @Override
    public void shrink() {
        requireNotEmptyQueue();

        DoubleAccessLinkedList.Node<E> first = list.first();

        while (first != null) {
            if (first.value() == null)
                list.remove(first.value());

            first = first.next();
        }
    }

    @Override
    public String toString() {
        return list.toString();
    }

    private void requireNotEmptyQueue() {
        if (isEmpty())
            throw new EmptyQueue();
    }
}