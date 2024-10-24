package map;

public class MapNode<T> {

    private final int key;
    private final T value;

    public MapNode(final int key, final T value) {
        this.key = key;
        this.value = value;
    }

    public MapNode(int key) {
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
        final MapNode<?> mapNode = (MapNode<?>) obj;
        return key == mapNode.key;
    }
}
