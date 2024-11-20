package tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BinaryTreeTest {

    private BinaryTree<Integer> binaryTree;

    @BeforeEach
    void setTree() {
        binaryTree = new BinaryTree<>();
    }

    @Test
    void whenCreatedIsEmpty() {
        assertTrue(binaryTree.isEmpty());
    }

    @Test
    void whenHasNodesThenIsNotEmpty() {
        binaryTree.updateRoot(BinaryTree.Node.of(1));

        assertFalse(binaryTree.isEmpty());
    }

    @Test
    void whenCreatedHasCountZero() {
        assertEquals(0, binaryTree.count());
    }

    @Test
    void shouldGetTreeRoot() {
        binaryTree.updateRoot(BinaryTree.Node.of(1));

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
        binaryTree.add(1);
        binaryTree.add(2);

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
        BinaryTree.Node<Integer> leftNodeLeftSideNode = BinaryTree.Node.of(1);

        BinaryTree.Node<Integer> leftRootSideNode = BinaryTree.Node.of(2, leftNodeLeftSideNode);

        BinaryTree.Node<Integer> root = BinaryTree.Node.of(10, leftRootSideNode);

        binaryTree.updateRoot(root);

        assertTrue(binaryTree.has(1));
    }

    @Test
    void whenHasDeepNodeThenHasIt() {
        binaryTree.add(1);
        binaryTree.add(2);
        binaryTree.add(5);
        binaryTree.add(9);
        binaryTree.add(18);
        binaryTree.add(12);

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
        binaryTree.updateRoot(BinaryTree.Node.of(1));

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

    @Test
    void shouldRemoveALeaf() {
        binaryTree.add(1);
        binaryTree.add(2);

        binaryTree.remove(2);

        assertEquals("<1<><>>", binaryTree.toString());
    }
    
    @Test
    void shouldRemoveANodeWithJustOneChild() {
        binaryTree.add(80);
        binaryTree.add(52);
        binaryTree.add(90);
        binaryTree.add(48);
        binaryTree.add(71);
        binaryTree.add(63);
        binaryTree.add(67);

        binaryTree.remove(71);

        assertEquals("<80<52<48<><>><63<><67<><>>>><90<><>>>", binaryTree.toString());
    }

    @Test
    void shouldRemoveANodeWithMoreTwoChildren() {
        binaryTree.add(250);
        binaryTree.add(38);
        binaryTree.add(26);
        binaryTree.add(72);
        binaryTree.add(55);
        binaryTree.add(90);
        binaryTree.add(41);
        binaryTree.add(60);
        binaryTree.add(43);
        binaryTree.add(78);
        binaryTree.add(92);
        binaryTree.add(74);

        binaryTree.remove(38);

        assertEquals("<250<41<26<><>><72<55<43<><>><60<><>>><90<78<74<><>><>><92<><>>>>><>>", binaryTree.toString());
    }
}
