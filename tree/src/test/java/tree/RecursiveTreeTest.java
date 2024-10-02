package tree;

import org.junit.jupiter.api.BeforeEach;

public class RecursiveTreeTest extends TreeTest {

    @BeforeEach
    void setTree() {
        tree = new RecursiveTree<>();
    }
}
