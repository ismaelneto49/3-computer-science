package BinarySearchTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {

    private BinarySearchTree<Integer> bst;
    private BinarySearchTree<Integer> emptyBst;

    private Integer[] values;


    @BeforeEach
    void init() {
        this.bst = new BinarySearchTreeImpl<Integer>();
        this.emptyBst = new BinarySearchTreeImpl<Integer>();
        this.values = new Integer[]{10, 8, 17, 9, 5, 19, 0, 6, 11, 16};
        this.fillTree(this.bst);
    }

    private void fillTree(BinarySearchTree<Integer> bst) {
        for (Integer element : this.values) {
            bst.insert(element);
        }
    }

    private void emptyTree(BinarySearchTree<Integer> bst) {
        for (Integer element : this.values) {
            bst.remove(element);
        }
    }

    @Test
    void testInsert() {
        assertEquals(10, this.bst.size());
        this.bst.insert(20);
        assertEquals(11, this.bst.size());
    }

    @Test
    void testRemove() {
        assertEquals(10, this.bst.size());
        this.emptyTree(this.bst);
        assertEquals(0, this.bst.size());
    }

    @Test
    void testHeight() {
        assertEquals(-1, this.emptyBst.height());
        assertEquals(3, this.bst.height());
    }

    @Test
    void testSize() {
        assertEquals(10, this.bst.size());
        this.bst.insert(45);
        assertEquals(11, this.bst.size());
        this.bst.remove(45);
        assertEquals(10, this.bst.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(this.emptyBst.isEmpty());
        assertFalse(this.bst.isEmpty());
    }

    @Test
    void testContains() {
        assertFalse(this.emptyBst.contains(10));
        assertFalse(this.bst.contains(45));
        assertTrue(this.bst.contains(10));
        assertTrue(this.bst.contains(5));
    }

    @Test
    void testMinimum() {
        Arrays.sort(this.values);
        assertEquals(this.values[0], this.bst.minimum());
    }

    @Test
    void testMinimumEmptyBst() {
        assertNull(this.emptyBst.minimum());
    }

    @Test
    void testMaximum() {
        Arrays.sort(this.values);
        assertEquals(this.values[this.values.length - 1], this.bst.maximum());
    }

    @Test
    void testMaximumEmptyBst() {
        assertNull(this.emptyBst.maximum());
    }

    @Test
    void testPreOrder() {
        Integer[] expected = new Integer[]{10, 8, 5, 0, 6, 9, 17, 11, 16, 19};
        Comparable[] result = this.bst.preOrder();
        assertArrayEquals(expected, result);
    }

    @Test
    void testPreOrderEmptyBst() {
        assertArrayEquals(new Integer[]{}, this.emptyBst.preOrder());
    }

    @Test
    void testInOrder() {
        Integer[] expected = new Integer[]{0, 5, 6, 8, 9, 10, 11, 16, 17, 19};
        Comparable[] result = this.bst.inOrder();
        assertArrayEquals(expected, result);
    }

    @Test
    void testInOrderEmptyBst() {
        assertArrayEquals(new Integer[]{}, this.emptyBst.inOrder());
    }

    @Test
    void testPostOrder() {
        Integer[] expected = new Integer[]{0, 6, 5, 9, 8, 16, 11, 19, 17, 10};
        Comparable[] result = this.bst.postOrder();
        assertArrayEquals(expected, result);
    }

    @Test
    void testPostOrderEmptyBst() {
        assertArrayEquals(new Integer[]{}, this.emptyBst.postOrder());
    }

    @Test
    void testBreadthFirst() {
        Integer[] expected = new Integer[]{10, 8, 17, 5, 9, 16, 19, 0, 6, 11};
        Comparable[] result = this.bst.breadthFirst();
        assertArrayEquals(expected, result);
    }

    @Test
    void testBreadthFirstEmptyBst() {
        assertArrayEquals(new Integer[]{}, this.emptyBst.breadthFirst());
    }

}
