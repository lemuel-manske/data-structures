package search;

public interface SearchStrategy<T extends Comparable<T>> {

    /**
     * Searches an {@code elementToFind} in {@code items}
     */
    int search(T[] items, T elementToFind);

}
