package tree;

import org.junit.jupiter.api.BeforeEach;

public class StackTreeTest extends TreeTest {

    @BeforeEach
    void setTree() {
        tree = new StackTree<>();
    }
}
