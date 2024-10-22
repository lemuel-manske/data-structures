package sort;

import org.junit.jupiter.api.BeforeEach;

public class InsertionSortTest extends SortableTest {

    @BeforeEach
    void setSortStrategy() {
        sortStrategy = new InsertionSort<>();
    }
}