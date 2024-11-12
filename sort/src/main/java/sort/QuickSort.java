package sort;

public class QuickSort<T extends Comparable<T>> implements SortStrategy<T> {

    @Override
    public T[] sort(final T[] list) {
        if (list.length <= 1) return list;

        sort(list, 0, list.length - 1);

        return list;
    }

    private void sort(T[] list, int begin, int end) {
        if (begin >= end)
            return;

        int pivot = partition(list, begin, end);

        sort(list, begin, pivot-1);
        sort(list, pivot+1, end);
    }

    private int partition(T[] list, int begin, int end) {
        T pivot = list[end];

        int i = begin - 1;

        for (int j = begin; j < end; j++)
            if (list[j].compareTo(pivot) <= 0)
                swap(list, ++i, j);

        swap(list, i+1, end);

        return i + 1;
    }

    private void swap(T[] list, int first, int second) {
        T temp = list[first];
        list[first] = list[second];
        list[second] = temp;
    }
}
