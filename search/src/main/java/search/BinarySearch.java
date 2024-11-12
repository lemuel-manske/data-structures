package search;

public class BinarySearch<T extends Comparable<T>> implements SearchStrategy<T> {

    @Override
    public int search(T[] items, T elementToFind) {
        if (items.length == 0) return -1;

        return search(items, 0, items.length - 1, elementToFind);
    }

    private int search(T[] items, int start, int end, T elementToFind) {
        if (end < start)
            return -1;

        int pivot = end + (start - end) / 2;

        if (elementToFind.compareTo(items[pivot]) == 0)
            return pivot;

        if (elementToFind.compareTo(items[pivot]) > 0)
            return search(items, start, pivot - 1, elementToFind);

        return  search(items, pivot + 1, end, elementToFind);
    }
}
