package map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class HashMapTest {

    private HashMap<String> hashMap;

    @BeforeEach
    public void setHashMap() {
        hashMap = new HashMap<>(10);
    }

    @Test
    void shouldAddAndGet() {
        hashMap.add(1, "one");
        hashMap.add(2, "two");
        hashMap.add(3, "three");

        assertEquals("one", hashMap.get(1));
        assertEquals("two", hashMap.get(2));
        assertEquals("three", hashMap.get(3));
    }

    @Test
    void shouldAddGetAndThenRemove() {
        hashMap.add(1, "one");
        hashMap.add(2, "two");
        hashMap.add(3, "three");

        assertEquals("one", hashMap.get(1));
        assertEquals("two", hashMap.get(2));
        assertEquals("three", hashMap.get(3));

        hashMap.remove(1);
        hashMap.remove(2);
        hashMap.remove(3);

        assertNull(hashMap.get(1));
        assertNull(hashMap.get(2));
        assertNull(hashMap.get(3));
    }
}
