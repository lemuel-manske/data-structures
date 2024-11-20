package map;

import list.LinkedList;

public class HashMap<E> {

    private final LinkedList<Node<E>>[] buckets;

    public HashMap(final int size) {
        buckets = new LinkedList[size];
    }

    public void add(final int key, final E value) {
        final int index = calculateHash(key);

        if (buckets[index] == null)
            buckets[index] = new LinkedList<>();

        final Node<E> node = new Node<>(key, value);

        buckets[index].add(node);
    }

    public void remove(final int key) {
        if (buckets[key] == null)
            return;

        final Node<E> node = new Node<>(key);

        buckets[key].remove(node);
    }

    public E get(final int key) {
        if (buckets[key] == null)
            return null;

        final Node<E> node = new Node<>(key);

         LinkedList.Node<Node<E>> bucketNode = buckets[key].getByValue(node);

         if (bucketNode == null)
             return null;

        return bucketNode.getValue().v();
    }

    private int calculateHash(final int key) {
        return key % buckets.length;
    }

    public static class Node<T> {

        private final int k;
        private final T v;

        public Node(final int k, final T v) {
            this.k = k;
            this.v = v;
        }

        public Node(int k) {
            this.k = k;
            this.v = null;
        }

        public int k() {
            return k;
        }

        public T v() {
            return v;
        }

        @Override
        public boolean equals(final Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Node<?> node = (Node<?>) obj;
            return k == node.k;
        }
    }
}
