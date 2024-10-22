package queue;

/**
 * A queue implementation that uses a vector to store its elements.
 */
public final class VectorQueue<E> implements Queue<E> {

    private Object[] objects;
    private int start;
    private int size;

    public VectorQueue(final int capacity) {
        objects = new Object[capacity];
    }

    @Override
    public void add(E o) {
        if (isFull())
            throw new FullQueue();

        objects[(start + size++) % objects.length] = o;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E peek() {
        requireNotEmptyQueue();

        return (E) objects[start];
    }

    @Override
    public E remove() {
        E e = peek();
        size--;
        start = (start + 1) % objects.length;
        return e;
    }

    @Override
    public void free() {
        while (!isEmpty()) remove();
    }

    @Override
    public void shrink() {
        requireNotEmptyQueue();

        Object[] newObjects = new Object[size];

        for (int i = 0; i < size; i++)
            newObjects[i] = objects[(start + i) % objects.length];

        start = 0;
        objects = newObjects;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        int indexToPrint = start;

        for (int i = 1; i <= size; i++) {
            sb.append(objects[indexToPrint]);

            indexToPrint = (start + i) % objects.length;

            if (i < size) sb.append(", ");
        }

        return sb.toString();
    }

    private boolean isFull() {
        return size == objects.length;
    }

    private void requireNotEmptyQueue() {
        if (isEmpty())
            throw new EmptyQueue();
    }
}
