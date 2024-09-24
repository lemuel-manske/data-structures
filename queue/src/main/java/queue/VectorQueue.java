package queue;

public class VectorQueue<E> implements Queue<E> {

    private final Object[] elements;
    private int firstElementIndex;
    private int size;

    public VectorQueue(final int initialSize) {
        elements = new Object[initialSize];
    }

    @Override
    public void add(E o) {
        if (size == elements.length) throw new FullQueue();
        elements[(firstElementIndex + size++) % elements.length] = o;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E peek() {
        if (isEmpty()) throw new EmptyQueue();
        return (E) elements[firstElementIndex];
    }

    @Override
    public E remove() {
        E e = peek();
        size--;
        firstElementIndex = (firstElementIndex + 1) % elements.length;
        return e;
    }

    @Override
    public void free() {
        while (!isEmpty()) remove();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        int indexToPrint = firstElementIndex;

        for (int i = 1; i <= size; i++) {
            sb.append(elements[indexToPrint]);

            indexToPrint = (firstElementIndex + i) % elements.length;

            if (i < size) sb.append(", ");
        }

        return sb.toString();
    }
}
