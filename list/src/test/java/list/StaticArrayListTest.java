package list;

import org.junit.jupiter.api.BeforeEach;

class StaticArrayListTest extends AbstractArrayListTest {

    @BeforeEach
    void setStaticList() {
        abstractArrayList = new StaticArrayList<>();
    }
}
