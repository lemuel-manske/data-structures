package map;

import list.LinkedList;

public class HashMap<T> {

    private final LinkedList<MapNode<T>>[] buckets;

    public HashMap(final int size) {
        buckets = new LinkedList[size];
    }

    public void add(final int key, final T value) {
        final int index = calculateHash(key);

        if (buckets[index] == null)
            buckets[index] = new LinkedList<>();

        final MapNode<T> node = new MapNode<>(key, value);

        buckets[index].add(node);
    }

    public void remove(final int key) {
        if (buckets[key] == null)
            return;

        final MapNode<T> node = new MapNode<>(key);

        buckets[key].remove(node);
    }

    public T get(final int key) {
        if (buckets[key] == null)
            return null;

        final MapNode<T> node = new MapNode<>(key);

         LinkedList.Node<MapNode<T>> bucketNode = buckets[key].getByValue(node);

         if (bucketNode == null)
             return null;

        return bucketNode.getValue().getValue();
    }

    private int calculateHash(final int key) {
        return key % buckets.length;
    }
}
