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

        int pos = findRightPosFor(element);

        for (int i = size(); i > pos; i--) {
            list[i] = list[i-1];
        }

        list[pos] = element;
        size++;
    }

    private int findRightPosFor(T e) {
        int i;

        for (i = 0; i < size(); i++)
            if (list[i].compareTo(e) > 0)
                break;

        return i;
    }
}
