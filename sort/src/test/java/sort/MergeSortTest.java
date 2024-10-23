package sort;

import org.junit.jupiter.api.BeforeEach;

public class MergeSortTest extends SortableTest {

    @BeforeEach
    void setSortStrategy() {
        sortStrategy = new MergeSort<>();
    }
}
