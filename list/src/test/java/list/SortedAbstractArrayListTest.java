package list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SortedAbstractArrayListTest extends AbstractArrayListTest {

    @BeforeEach
    void setStaticList() {
        abstractArrayList = new SortedArrayList<>();
    }

    @Test
    void itemsMustBeAddedAndSorted() {
        add(44, 12, 22, 31, 56);

        assertItems(12, 22, 31, 44, 56);
    }
}

