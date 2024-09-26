package tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

abstract class TreeTest {

    protected Tree<Integer> tree;

    @Test
    void whenCreatedIsEmpty() {
        assertTrue(tree.isEmpty());
    }

    @Test
    void whenHasNodesThenIsNotEmpty() {
        tree.updateRoot(1);

        assertFalse(tree.isEmpty());
    }

    @Test
    void shouldGetTreeRoot() {
        tree.updateRoot(1);

        assertEquals(1, tree.getRoot().value());
    }

    @Test
    void whenEmptyDoesNotHasAnyValue() {
        assertFalse(tree.has(1));
        assertFalse(tree.has(4));
        assertFalse(tree.has(2));
    }

    @Test
    void whenNodeIsAddedThenHasIt() {
        Tree.Node<Integer> leftRootSideNode = Tree.Node.of(2);

        Tree.Node<Integer> root = Tree.Node.of(1, leftRootSideNode);

        tree.updateRoot(root);

        assertTrue(tree.has(2));
    }

    @Test
    void whenThreeLevelNodeIsAddedThenHasIt() {
        Tree.Node<Integer> leftNodeLeftSideNode = Tree.Node.of(5);

        Tree.Node<Integer> leftRootSideNode = Tree.Node.of(2, leftNodeLeftSideNode);

        Tree.Node<Integer> root = Tree.Node.of(1, leftRootSideNode);

        tree.updateRoot(root);

        assertTrue(tree.has(5));
    }

    @Test
    void whenHasDeepNodeThenHasIt() {
        Tree.Node<Integer> thirdLeft = Tree.Node.of(9, Tree.Node.of(18), Tree.Node.of(12));

        Tree.Node<Integer> secondLeft = Tree.Node.of(5, thirdLeft);

        Tree.Node<Integer> leftRootSideNode = Tree.Node.of(2, secondLeft);

        Tree.Node<Integer> root = Tree.Node.of(1, leftRootSideNode);

        tree.updateRoot(root);

        assertTrue(tree.has(12));
        assertTrue(tree.has(18));
    }

    @Test
    void testShouldEmptyTreeAsString() {
        assertEquals("<>", tree.toString());
    }

    @Test
    void shouldDeepTreeAsString() {
        Tree.Node<Integer> thirdLeft = Tree.Node.of(9, Tree.Node.of(18), Tree.Node.of(12));

        Tree.Node<Integer> secondLeft = Tree.Node.of(5, thirdLeft);

        Tree.Node<Integer> leftRootSideNode = Tree.Node.of(2, secondLeft);

        Tree.Node<Integer> root = Tree.Node.of(1, leftRootSideNode);

        tree.updateRoot(root);

        assertEquals("<1<2<5<9<18<><>><12<><>>><>><>><>>", tree.toString());
    }
}
