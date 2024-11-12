package sort;

import org.junit.jupiter.api.BeforeEach;

public class MergeSortTest extends SortStrategyTest {

    @BeforeEach
    void setSortStrategy() {
        sortStrategy = new MergeSort<>();
    }
}
