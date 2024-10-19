package tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class TreeTest {

    protected Tree<String> tree;

    @Test
    void whenCreatedIsEmpty() {
        assertTrue(tree.isEmpty());
    }

    @Test
    void whenHasRootIsNotEmpty() {
        Tree.Node<String> newRoot = new Tree.Node<>("10");

        tree.updateRoot(newRoot);

        assertFalse(tree.isEmpty());
    }

    @Test
    void shouldReturnTreeRoot() {
        Tree.Node<String> newRoot = new Tree.Node<>("10");

        tree.updateRoot(newRoot);

        assertEquals(newRoot, tree.root());
    }

    @Test
    void whenEmptyThenDoesNotHaveAnyValue() {
        assertFalse(tree.has("8"));
        assertFalse(tree.has("3"));
        assertFalse(tree.has("5"));
        assertFalse(tree.has("1"));
    }

    @Test
    void shouldHaveNode() {
        Tree.Node<String> nextNode = new Tree.Node<>("2");

        Tree.Node<String> root = new Tree.Node<>("root");
        root.append(nextNode);

        tree.updateRoot(root);

        assertTrue(tree.has("2"));
    }

    @Test
    void shouldNotHaveNode() {
        Tree.Node<String> nextNode = new Tree.Node<>("2");

        Tree.Node<String> root = new Tree.Node<>("root");
        root.append(nextNode);

        tree.updateRoot(root);

        assertFalse(tree.has("3"));
    }

    @Test
    void whenEmptyThenCountIsZero() {
        assertEquals(0, tree.count());
    }

    @Test
    void whenHasThreeNodesCountIsThree() {
        Tree.Node<String> thirdNode = new Tree.Node<>("15");

        Tree.Node<String> nextNode = new Tree.Node<>("2");

        Tree.Node<String> root = new Tree.Node<>("root");
        root.append(nextNode);
        root.append(thirdNode);

        tree.updateRoot(root);

        assertEquals(3, tree.count());
    }

    @Test
    void shouldReturnEmptyRepresentation() {
        assertEquals("<>", tree.toString());
    }

    @Test
    void shouldReturnStringRepresentation() {
        Tree.Node<String> fifteen = new Tree.Node<>("15");

        Tree.Node<String> two = new Tree.Node<>("2");

        Tree.Node<String> root = new Tree.Node<>("root");
        root.append(fifteen);
        root.append(two);

        tree.updateRoot(root);

        assertEquals("<root<2><15>>", tree.toString());
    }

    @Test
    void whenEmptyCountOfLeavesIsZero() {
        assertEquals(0, tree.countLeaves());
    }

    @Test
    void whenHasJustOneLeaveThenCountIsOne() {
        tree.updateRoot(new Tree.Node<>("3"));

        assertEquals(1, tree.countLeaves());
    }

    @Test
    void shouldCountLeaves() {
        Tree.Node<String> five = new Tree.Node<>("5");
        five.append(new Tree.Node<>("10"));
        five.append(new Tree.Node<>("11"));

        Tree.Node<String> two = new Tree.Node<>("2");
        two.append(new Tree.Node<>("4"));
        two.append(five);
        two.append(new Tree.Node<>("6"));

        Tree.Node<String> three = new Tree.Node<>("3");
        three.append(new Tree.Node<>("7"));
        three.append(new Tree.Node<>("8"));
        three.append(new Tree.Node<>("9"));

        Tree.Node<String> root = new Tree.Node<>("1");
        root.append(two);
        root.append(three);

        tree.updateRoot(root);

        assertEquals(7, tree.countLeaves());
    }
}
