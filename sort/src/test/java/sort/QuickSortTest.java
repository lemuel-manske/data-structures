package sort;

import org.junit.jupiter.api.BeforeEach;

public class QuickSortTest extends SortableTest {

    @BeforeEach
    void setSortStrategy() {
        sortStrategy = new QuickSort<>();
    }
}
