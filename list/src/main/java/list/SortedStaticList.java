package list;

import search.BinarySearch;
import search.SearchStrategy;

public class SortedStaticList<T extends Comparable<T>> extends AbstractList<T> {

    private final SearchStrategy<T> searchStrategy = new BinarySearch<>();

    @Override
    public int find(T element) {
        return searchStrategy.search((T[]) list, element);
    }

    @Override
    public void add(T element) {
        if (size == list.length)
            resizeList();

        int p = 0;

        // 61 null null null
        //

        while (p < size) {
            T e = get(p); // 61

            if (e != null)
                if (e.compareTo(element) < 0)
                    p++;

                else if (e.compareTo(element) > 0) {
                    list[p + 1] = e;
                    break;
                }
        }

        list[p] = element;

        size++;
    }
}

