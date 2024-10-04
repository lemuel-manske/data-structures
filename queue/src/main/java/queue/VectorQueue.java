package queue;

public class VectorQueue<E> implements Queue<E> {

    // objects.length is queue limit (initial size)
    private final Object[] objects;
    private int start;
    private int size;

    public VectorQueue(final int initialSize) {
        objects = new Object[initialSize];
    }

    @Override
    public void add(E o) {
        if (size == objects.length)
            throw new FullQueue();

        // Modular arithmetic is a system of arithmetic in which numbers "reset"
        // or "wrap around" upon reaching a certain value, called the modulus.
        // In simple terms, instead of numbers increasing indefinitely,
        // they are "reduced" to a fixed range, starting again
        // from zero when they reach the modulus.

        // the start + size is where we need to insert,
        // whereas objects.length is by which to "wrap around.

        objects[(start + size++) % objects.length] = o;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E peek() {
        if (isEmpty())
            throw new EmptyQueue();

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
}
