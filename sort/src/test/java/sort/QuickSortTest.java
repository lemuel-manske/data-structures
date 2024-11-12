package sort;

import org.junit.jupiter.api.BeforeEach;

public class QuickSortTest extends SortStrategyTest {

    @BeforeEach
    void setSortStrategy() {
        sortStrategy = new QuickSort<>();
    }
}
