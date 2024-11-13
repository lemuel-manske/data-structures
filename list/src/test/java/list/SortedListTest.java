package list;

import org.junit.jupiter.api.BeforeEach;

public class SortedListTest extends AbstractListTest {

    @BeforeEach
    void setStaticList() {
        list = new SortedStaticList<>();
    }
}

