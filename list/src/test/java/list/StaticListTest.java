package list;

import org.junit.jupiter.api.BeforeEach;

class StaticListTest extends AbstractListTest {

    @BeforeEach
    void setStaticList() {
        list = new StaticList<>();
    }
}
