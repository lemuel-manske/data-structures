import org.junit.jupiter.api.Test;
import tree.RecursiveTree;
import tree.Tree;

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

        assertEquals(1, tree.getRoot().getValue());
    }

    @Test
    void whenEmptyDoesNotHasAnyValue() {
        assertFalse(tree.has(1));
        assertFalse(tree.has(4));
        assertFalse(tree.has(2));
    }

    @Test
    void whenNodeIsAddedThenHasIt() {
        RecursiveTree.Node<Integer> leftRootSideNode = RecursiveTree.Node.of(2);

        RecursiveTree.Node<Integer> root = RecursiveTree.Node.of(1, leftRootSideNode);

        tree.updateRoot(root);

        assertTrue(tree.has(2));
    }

    @Test
    void whenThreeLevelNodeIsAddedThenHasIt() {
        RecursiveTree.Node<Integer> leftNodeLeftSideNode = RecursiveTree.Node.of(5);

        RecursiveTree.Node<Integer> leftRootSideNode = RecursiveTree.Node.of(2, leftNodeLeftSideNode);

        RecursiveTree.Node<Integer> root = RecursiveTree.Node.of(1, leftRootSideNode);

        tree.updateRoot(root);

        assertTrue(tree.has(5));
    }

    @Test
    void whenHasDeepNodeThenHasIt() {
        RecursiveTree.Node<Integer> thirdLeft = RecursiveTree.Node.of(9, RecursiveTree.Node.of(18), RecursiveTree.Node.of(12));

        RecursiveTree.Node<Integer> secondLeft = RecursiveTree.Node.of(5, thirdLeft);

        RecursiveTree.Node<Integer> leftRootSideNode = RecursiveTree.Node.of(2, secondLeft);

        RecursiveTree.Node<Integer> root = RecursiveTree.Node.of(1, leftRootSideNode);

        tree.updateRoot(root);

        assertTrue(tree.has(12));
        assertTrue(tree.has(18));
    }
}
