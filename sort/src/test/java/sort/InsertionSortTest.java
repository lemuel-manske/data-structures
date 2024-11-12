package sort;

import org.junit.jupiter.api.BeforeEach;

public class InsertionSortTest extends SortStrategyTest {

    @BeforeEach
    void setSortStrategy() {
        sortStrategy = new InsertionSort<>();
    }
}