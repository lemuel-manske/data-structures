import org.junit.jupiter.api.BeforeEach;

import tree.StackTree;

public class StackTreeTest extends TreeTest {

    @BeforeEach
    void setTree() {
        tree = new StackTree<>();
    }
}
