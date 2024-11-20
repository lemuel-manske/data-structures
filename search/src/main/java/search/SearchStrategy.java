package search;

public interface SearchStrategy<T extends Comparable<T>> {

    /**
     * Searches an element {@code e} in the {@code items} array and returns
     * the element index.
     */
    int search(T[] items, T e);
}
