package queue;

import list.DoubleAccessList;

public final class ListQueue<E> implements Queue<E> {

    private final DoubleAccessList<E> list;

    public ListQueue() {
        this.list = new DoubleAccessList<>();
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
        if (isEmpty())
            throw new EmptyQueue();

        return list.getFirst().value();
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
        if (isEmpty())
            throw new EmptyQueue();

        DoubleAccessList.Node<E> first = list.getFirst();

        while (first != null) {
            if (first.value() == null)
                list.remove(first.value());

            first = first.nextNode();
        }
    }

    @Override
    public String toString() {
        return list.toString();
    }
}