package tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

abstract class AbstractBinaryTreeTest {

    protected AbstractBinaryTree<Integer> binaryTree;

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
        AbstractBinaryTree.Node<Integer> leftRootSideNode = AbstractBinaryTree.Node.of(2);

        AbstractBinaryTree.Node<Integer> root = AbstractBinaryTree.Node.of(1, leftRootSideNode);

        binaryTree.updateRoot(root);

        assertTrue(binaryTree.has(2));
    }

    @Test
    void whenThreeNodesThenHasCountThree() {
        AbstractBinaryTree.Node<Integer> root = AbstractBinaryTree.Node.of(1, AbstractBinaryTree.Node.of(2), AbstractBinaryTree.Node.of(4));

        binaryTree.updateRoot(root);

        assertEquals(3, binaryTree.count());
    }

    @Test
    void whenThreeLevelNodeIsAddedThenHasIt() {
        AbstractBinaryTree.Node<Integer> leftNodeLeftSideNode = AbstractBinaryTree.Node.of(5);

        AbstractBinaryTree.Node<Integer> leftRootSideNode = AbstractBinaryTree.Node.of(2, leftNodeLeftSideNode);

        AbstractBinaryTree.Node<Integer> root = AbstractBinaryTree.Node.of(1, leftRootSideNode);

        binaryTree.updateRoot(root);

        assertTrue(binaryTree.has(5));
    }

    @Test
    void whenHasDeepNodeThenHasIt() {
        AbstractBinaryTree.Node<Integer> thirdLeft = AbstractBinaryTree.Node.of(9, AbstractBinaryTree.Node.of(18), AbstractBinaryTree.Node.of(12));

        AbstractBinaryTree.Node<Integer> secondLeft = AbstractBinaryTree.Node.of(5, thirdLeft);

        AbstractBinaryTree.Node<Integer> leftRootSideNode = AbstractBinaryTree.Node.of(2, secondLeft);

        AbstractBinaryTree.Node<Integer> root = AbstractBinaryTree.Node.of(1, leftRootSideNode);

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
        AbstractBinaryTree.Node<Integer> thirdLeft = AbstractBinaryTree.Node.of(9, AbstractBinaryTree.Node.of(18), AbstractBinaryTree.Node.of(12));

        AbstractBinaryTree.Node<Integer> secondLeft = AbstractBinaryTree.Node.of(5, thirdLeft);

        AbstractBinaryTree.Node<Integer> leftRootSideNode = AbstractBinaryTree.Node.of(2, secondLeft);

        AbstractBinaryTree.Node<Integer> root = AbstractBinaryTree.Node.of(1, leftRootSideNode);

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
        AbstractBinaryTree.Node<Integer> leaf = AbstractBinaryTree.Node.of(3);

        AbstractBinaryTree.Node<Integer> leftFromRoot = AbstractBinaryTree.Node.of(2, AbstractBinaryTree.Node.of(4, leaf));

        AbstractBinaryTree.Node<Integer> root = AbstractBinaryTree.Node.of(1, leftFromRoot);

        binaryTree.updateRoot(root);

        assertTrue(binaryTree.isDegenerated());
    }

    @Test
    void whenHasNodeWithMoreThanOneChildThenIsNotDegenerated() {
        AbstractBinaryTree.Node<Integer> leftFromRoot = AbstractBinaryTree.Node.of(2,
                AbstractBinaryTree.Node.of(4),
                AbstractBinaryTree.Node.of(7));

        AbstractBinaryTree.Node<Integer> root = AbstractBinaryTree.Node.of(1, leftFromRoot);

        binaryTree.updateRoot(root);

        assertFalse(binaryTree.isDegenerated());
    }

    @Test
    void mustFindANode() {
        AbstractBinaryTree.Node<Integer> leftFromRoot = AbstractBinaryTree.Node.of(2,
                AbstractBinaryTree.Node.of(4),
                AbstractBinaryTree.Node.of(7));

        AbstractBinaryTree.Node<Integer> root = AbstractBinaryTree.Node.of(1, leftFromRoot);

        binaryTree.updateRoot(root);

        assertEquals(leftFromRoot, binaryTree.find(2));
    }
}
