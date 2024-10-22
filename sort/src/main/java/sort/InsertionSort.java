package sort;

public class InsertionSort<T extends Comparable<T>> implements Sortable<T> {

    @Override
    public T[] sort(final T[] source) {
        if (source.length <= 1) return source;

        T[] list = source.clone();

        for (int i = 1; i < list.length; i++) {
            T key = list[i];
            int j = i - 1;
            while (j >= 0 && list[j].compareTo(key) > 0) {
                list[j + 1] = list[j];
                j -= 1;
            }
            list[j + 1] = key;
        }

        return list;
    }
}
