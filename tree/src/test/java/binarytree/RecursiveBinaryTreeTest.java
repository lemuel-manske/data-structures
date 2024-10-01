package binarytree;

import org.junit.jupiter.api.BeforeEach;

public class RecursiveBinaryTreeTest extends BinaryTreeTest {


    @BeforeEach
    void setTree() {
        binaryTree = new RecursiveBinaryTree<>();
    }
}
