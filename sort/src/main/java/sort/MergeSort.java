package sort;

public class MergeSort<T extends Comparable<T>> implements Sortable<T> {


    @Override
    public T[] sort(final T[] list) {
        if (list.length <= 1) return list;

        sort(list, 0, list.length - 1);

        return list;
    }

    public void sort(final T[] list, int begin, int end) {
        if (begin >= end)
            return;

        int mid = (begin + end) / 2;

        sort(list, begin, mid);
        sort(list, mid + 1, end);

        merge(list, begin, end, mid);
    }

    private void merge(T[] list, int begin, int end, int mid) {
        T[] left = createLeft(list, begin, mid);
        T[] right = createRight(list, begin, end, mid);

        int compareLeft = 0;
        int compareRight = 0;

        int stopAt = 0;

        for (int i = begin; i <= end; i++) {
            if (compareLeft < left.length && compareRight < right.length) {
                if (left[compareLeft].compareTo(right[compareRight]) < 0) {
                    list[i] = left[compareLeft];
                    compareLeft +=1;
                }
                else {
                    list[i] = right[compareRight];
                    compareRight += 1;
                }
            } else {
                stopAt = i;
                break;
            }
        }

        while (compareLeft < left.length) {
            list[stopAt] = left[compareLeft];
            compareLeft += 1;
            stopAt += 1;
        }

        while (compareRight < right.length) {
            list[stopAt] = right[compareRight];
            compareRight += 1;
            stopAt += 1;
        }
    }

    private T[] createLeft(T[] list, int begin, int mid) {
        T[] left = (T[]) new Comparable[mid - begin + 1];

        for (int i = 0; i < left.length; i++)
            left[i] = list[begin +i];

        return left;
    }

    private T[] createRight(T[] list, int begin, int end, int mid) {
        T[] right = (T[]) new Comparable[end - mid];

        for (int i = 0; i < right.length; i++)
            right[i] = list[begin + i + 1];

        return right;
    }
}
