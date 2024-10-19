package queue;

public interface Queue<E> {

    /**
     * Adds an element to the start of the queue.
     */
    void add(E e);

    /**
     * Returns whether the queue is empty.
     */
    boolean isEmpty();

    /**
     * Gets the start element of the queue.
     *
     * <p>Throws {@link EmptyQueue} if the queue is empty.
     */
    E peek();

    /**
     * Removes the start element of the queue.
     *
     * <p>Throws {@link EmptyQueue} if the queue is empty.
     */
    E remove();

    /**
     * Returns the queue to its original state.
     */
    void free();

    /**
     * Removes all the empty spaces in the queue, making it as small as possible.
     *
     * <p>Throws {@link EmptyQueue} if the queue is empty.
     */
    void shrink();
}
