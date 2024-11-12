package sort;

import org.junit.jupiter.api.BeforeEach;

public class BubbleSortTest extends SortStrategyTest {

    @BeforeEach
    void setSortStrategy() {
        sortStrategy = new BubbleSort<>();
    }
}
