package queue;

public interface Queue<E> {

    void add(E e);

    boolean isEmpty();

    E peek();

    E remove();

    void free();

    class EmptyQueue extends RuntimeException {}
}
