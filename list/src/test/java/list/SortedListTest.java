package list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SortedListTest extends AbstractListTest {

    @BeforeEach
    void setStaticList() {
        list = new SortedStaticList<>();
    }

    @Test
    void itemsMustBeAddedAndSorted() {
        add(44, 12, 22, 31, 56);

        assertItems(12, 22, 31, 44, 56);
    }
}

