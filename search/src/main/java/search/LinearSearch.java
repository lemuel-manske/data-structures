package search;

public class LinearSearch<T extends Comparable<T>> implements SearchStrategy<T> {

    @Override
    public int search(T[] items, T elementToFind) {
        for (int i = 0; i < items.length; i++)
            if (items[i].compareTo(elementToFind) == 0)
                return i;

        return -1;
    }
}
