package tree;

import org.junit.jupiter.api.BeforeEach;

class RecursiveBinaryTreeTest extends BinaryTreeTest {

    @BeforeEach
    void setTree() {
        binaryTree = new RecursiveBinaryTree<>();
    }
}
