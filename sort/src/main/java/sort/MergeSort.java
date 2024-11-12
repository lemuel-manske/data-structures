package sort;

public class MergeSort<T extends Comparable<T>> implements SortStrategy<T> {

    @Override
    public T[] sort(final T[] list) {
        if (list.length <= 1) return list;

        sort(list, 0, list.length - 1);

        return list;
    }

    private void sort(final T[] list, int begin, int end) {
        if (begin >= end)
            return;

        int mid = (begin + end) / 2;

        sort(list, begin, mid);
        sort(list, mid + 1, end);

        merge(list, begin, mid, end);
    }

    private void merge(T[] list, int begin, int mid, int end) {
        T[] left = createLeft(list, begin, mid);
        T[] right = createRight(list, mid, end);

        int compareLeft = 0;
        int compareRight = 0;

        int i = begin;

        while (compareLeft < left.length && compareRight < right.length) {
            if (left[compareLeft].compareTo(right[compareRight]) <= 0) {
                list[i++] = left[compareLeft++];
            } else {
                list[i++] = right[compareRight++];
            }
        }

        while (compareLeft < left.length) {
            list[i++] = left[compareLeft++];
        }

        while (compareRight < right.length) {
            list[i++] = right[compareRight++];
        }
    }

    @SuppressWarnings("unchecked")
    private T[] createLeft(T[] list, int begin, int mid) {
        T[] left = (T[]) new Comparable[mid - begin + 1];
        System.arraycopy(list, begin, left, 0, left.length);
        return left;
    }

    @SuppressWarnings("unchecked")
    private T[] createRight(T[] list, int mid, int end) {
        T[] right = (T[]) new Comparable[end - mid];
        System.arraycopy(list, mid + 1, right, 0, right.length);
        return right;
    }
}
