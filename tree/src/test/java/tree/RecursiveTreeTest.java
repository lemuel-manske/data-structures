package tree;

import org.junit.jupiter.api.BeforeEach;

class RecursiveTreeTest extends TreeTest {

    @BeforeEach
    void setTree() {
        tree = new RecursiveTree<>();
    }
}
