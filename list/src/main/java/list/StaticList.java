package list;

import search.LinearSearch;
import search.SearchStrategy;

public class StaticList<T extends Comparable<T>> extends AbstractList<T> {

    private final SearchStrategy<T> searchStrategy = new LinearSearch<>();

    @Override
    public int find(T element) {
        return searchStrategy.search((T[]) list, element);
    }

    @Override
    public void add(T element) {
        if (size == list.length)
            resizeList();

        list[size++] = element;
    }
}
