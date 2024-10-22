package sort;

public class BubbleSort<T extends Comparable<T>> implements Sortable<T> {

    @Override
    public T[] sort(final T[] list) {
        if (list.length <= 1) return list;

        for (int i = 0; i < list.length; i++) {
            for (int j = list.length - 1; j > 0; j--) {
                if (list[j].compareTo(list[j-1]) < 0) {
                    swap(list, j, j-1);
                }
            }
        }

        return list;
    }

    private void swap(T[] list, int first, int second) {
        T temp = list[first];
        list[first] = list[second];
        list[second] = temp;
    }
}
