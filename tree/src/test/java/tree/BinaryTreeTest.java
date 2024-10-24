package tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

abstract class BinaryTreeTest {

    protected BinaryTree<Integer> binaryTree;

    @Test
    void whenCreatedIsEmpty() {
        assertTrue(binaryTree.isEmpty());
    }

    @Test
    void whenHasNodesThenIsNotEmpty() {
        binaryTree.updateRoot(1);

        assertFalse(binaryTree.isEmpty());
    }

    @Test
    void whenCreatedHasCountZero() {
        assertEquals(0, binaryTree.count());
    }

    @Test
    void shouldGetTreeRoot() {
        binaryTree.updateRoot(1);

        assertEquals(1, binaryTree.getRoot().value());
    }

    @Test
    void whenEmptyDoesNotHasAnyValue() {
        assertFalse(binaryTree.has(1));
        assertFalse(binaryTree.has(4));
        assertFalse(binaryTree.has(2));
    }

    @Test
    void whenNodeIsAddedThenHasIt() {
        BinaryTree.Node<Integer> leftRootSideNode = BinaryTree.Node.of(2);

        BinaryTree.Node<Integer> root = BinaryTree.Node.of(1, leftRootSideNode);

        binaryTree.updateRoot(root);

        assertTrue(binaryTree.has(2));
    }

    @Test
    void whenThreeNodesThenHasCountThree() {
        BinaryTree.Node<Integer> root = BinaryTree.Node.of(1, BinaryTree.Node.of(2), BinaryTree.Node.of(4));

        binaryTree.updateRoot(root);

        assertEquals(3, binaryTree.count());
    }

    @Test
    void whenThreeLevelNodeIsAddedThenHasIt() {
        BinaryTree.Node<Integer> leftNodeLeftSideNode = BinaryTree.Node.of(5);

        BinaryTree.Node<Integer> leftRootSideNode = BinaryTree.Node.of(2, leftNodeLeftSideNode);

        BinaryTree.Node<Integer> root = BinaryTree.Node.of(1, leftRootSideNode);

        binaryTree.updateRoot(root);

        assertTrue(binaryTree.has(5));
    }

    @Test
    void whenHasDeepNodeThenHasIt() {
        BinaryTree.Node<Integer> thirdLeft = BinaryTree.Node.of(9, BinaryTree.Node.of(18), BinaryTree.Node.of(12));

        BinaryTree.Node<Integer> secondLeft = BinaryTree.Node.of(5, thirdLeft);

        BinaryTree.Node<Integer> leftRootSideNode = BinaryTree.Node.of(2, secondLeft);

        BinaryTree.Node<Integer> root = BinaryTree.Node.of(1, leftRootSideNode);

        binaryTree.updateRoot(root);

        assertTrue(binaryTree.has(12));
        assertTrue(binaryTree.has(18));
    }

    @Test
    void testShouldEmptyTreeAsString() {
        assertEquals("<>", binaryTree.toString());
    }

    @Test
    void shouldDeepTreeAsString() {
        BinaryTree.Node<Integer> thirdLeft = BinaryTree.Node.of(9, BinaryTree.Node.of(18), BinaryTree.Node.of(12));

        BinaryTree.Node<Integer> secondLeft = BinaryTree.Node.of(5, thirdLeft);

        BinaryTree.Node<Integer> leftRootSideNode = BinaryTree.Node.of(2, secondLeft);

        BinaryTree.Node<Integer> root = BinaryTree.Node.of(1, leftRootSideNode);

        binaryTree.updateRoot(root);

        assertEquals("<1<2<5<9<18<><>><12<><>>><>><>><>>", binaryTree.toString());
    }


    @Test
    void whenEmptyIsNotDegenerated() {
        assertFalse(binaryTree.isDegenerated());
    }

    @Test
    void whenOnlyOneNodeThenIsNotDegenerated() {
        binaryTree.updateRoot(1);

        assertFalse(binaryTree.isDegenerated());
    }

    @Test
    void whenHasOnlyOneChildNodesThenIsDegenerated() {
        BinaryTree.Node<Integer> leaf = BinaryTree.Node.of(3);

        BinaryTree.Node<Integer> leftFromRoot = BinaryTree.Node.of(2, BinaryTree.Node.of(4, leaf));

        BinaryTree.Node<Integer> root = BinaryTree.Node.of(1, leftFromRoot);

        binaryTree.updateRoot(root);

        assertTrue(binaryTree.isDegenerated());
    }

    @Test
    void whenHasNodeWithMoreThanOneChildThenIsNotDegenerated() {
        BinaryTree.Node<Integer> leftFromRoot = BinaryTree.Node.of(2,
                BinaryTree.Node.of(4),
                BinaryTree.Node.of(7));

        BinaryTree.Node<Integer> root = BinaryTree.Node.of(1, leftFromRoot);

        binaryTree.updateRoot(root);

        assertFalse(binaryTree.isDegenerated());
    }
}
