package queue;

public interface Queue<E> {

    /**
     * Adds an element to the queue.
     */
    void add(E e);

    /**
     * Returns whether the queue is empty.
     */
    boolean isEmpty();

    /**
     * Gets the first element of the queue.
     *
     * <p>Throws {@link EmptyQueue} if the queue is empty.
     */
    E peek();

    /**
     * Removes the first queue element.
     *
     * <p>Throws {@link EmptyQueue} if the queue is empty.
     */
    E remove();

    /**
     * Returns the queue to its original state.
     */
    void free();

}
