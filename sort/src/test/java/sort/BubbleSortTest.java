package sort;

import org.junit.jupiter.api.BeforeEach;

public class BubbleSortTest extends SortableTest {

    @BeforeEach
    void setSortStrategy() {
        sortStrategy = new BubbleSort<>();
    }
}
