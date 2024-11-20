package search;

public class LinearSearch<T extends Comparable<T>> implements SearchStrategy<T> {

    @Override
    public int search(T[] items, T e) {
        for (int i = 0; i < items.length; i++)
            if (items[i] != null && items[i].compareTo(e) == 0)
                return i;

        return -1;
    }
}
