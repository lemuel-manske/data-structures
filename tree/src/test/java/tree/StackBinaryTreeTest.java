package tree;

import org.junit.jupiter.api.BeforeEach;

public class StackBinaryTreeTest extends BinaryTreeTest {

    @BeforeEach
    void setTree() {
        binaryTree = new StackBinaryTree<>();
    }
}
