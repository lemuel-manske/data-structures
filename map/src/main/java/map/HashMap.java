package map;

import list.LinkedList;

public class HashMap<T> {

    private final LinkedList<Node<T>>[] buckets;

    public HashMap(final int size) {
        buckets = new LinkedList[size];
    }

    public void add(final int key, final T value) {
        final int index = calculateHash(key);

        if (buckets[index] == null)
            buckets[index] = new LinkedList<>();

        final Node<T> node = new Node<>(key, value);

        buckets[index].add(node);
    }

    public void remove(final int key) {
        if (buckets[key] == null)
            return;

        final Node<T> node = new Node<>(key);

        buckets[key].remove(node);
    }

    public T get(final int key) {
        if (buckets[key] == null)
            return null;

        final Node<T> node = new Node<>(key);

         LinkedList.Node<Node<T>> bucketNode = buckets[key].getByValue(node);

         if (bucketNode == null)
             return null;

        return bucketNode.getValue().getValue();
    }

    private int calculateHash(final int key) {
        return key % buckets.length;
    }

    public static class Node<T> {

        private final int key;
        private final T value;

        public Node(final int key, final T value) {
            this.key = key;
            this.value = value;
        }

        public Node(int key) {
            this.key = key;
            this.value = null;
        }

        public int getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }

        @Override
        public boolean equals(final Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            final Node<?> node = (Node<?>) obj;
            return key == node.key;
        }
    }
}
