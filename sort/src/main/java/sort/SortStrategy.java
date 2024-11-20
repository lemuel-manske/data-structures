package sort;

public interface SortStrategy<T extends Comparable<T>>{

    /**
     * Sorts a list using the desired {@link SortStrategy} implementation.
     */
    T[] sort(final T[] list);
}
