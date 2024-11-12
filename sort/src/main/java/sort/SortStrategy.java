package sort;

public interface SortStrategy<T extends Comparable<T>>{

    /**
     * Sorts a list using the desired strategy implementation.
     */
    T[] sort(final T[] list);
}
