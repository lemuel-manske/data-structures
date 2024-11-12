package search;

import org.junit.jupiter.api.BeforeEach;

public class LinearSearchTest extends SearchTest {

    @BeforeEach
    void setSearch() {
        s = new LinearSearch<>();
    }
}
