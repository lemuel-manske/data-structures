package search;

public class BinarySearch<T extends Comparable<T>> implements SearchStrategy<T> {

    @Override
    public int search(T[] items, T e) {
        if (items.length == 0) return -1;

        return search(items, 0, items.length - 1, e);
    }

    private int search(T[] items, int start, int end, T elementToFind) {
        if (end < start)
            return -1;

        int pivot = end + (start - end) / 2;

        T found = items[pivot];

        if (found == null) {
            int lastNonNull = pivot - 1;

            while (lastNonNull >= start && items[lastNonNull] == null)
                lastNonNull--;

            return search(items, start, lastNonNull, elementToFind);
        }

        if (elementToFind.compareTo(found) == 0)
            return pivot;

        if (elementToFind.compareTo(found) < 0)
            return search(items, start, pivot - 1, elementToFind);

        return search(items, pivot + 1, end, elementToFind);
    }
}
