package tree;

import org.junit.jupiter.api.BeforeEach;

class RecursiveBinaryTreeTest extends AbstractBinaryTreeTest {

    @BeforeEach
    void setTree() {
        binaryTree = new RecursiveBinaryTree<>();
    }
}
