package adt.bst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SimpleBSTManipulationTest {
    private SimpleBSTManipulation<Integer> bstManipulation;
    private BSTImpl<Integer> sameTree1;
    private BSTImpl<Integer> sameTree2;
    private BSTImpl<Integer> notSameTree1;

    private BSTImpl<Integer> emptyTree1;

    private BSTImpl<Integer> emptyTree2;


    private void fillTrees() {
        Integer[] numbers = {6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40};
        for (int number : numbers) {
            sameTree1.insert(number);
            sameTree2.insert(number);
        }

        notSameTree1.insert(1);

    }

    @Before
    public void setUp() {
        this.bstManipulation = new SimpleBSTManipulationImpl<>();
        this.sameTree1 = new BSTImpl<>();
        this.sameTree2 = new BSTImpl<>();
        this.notSameTree1 = new BSTImpl<>();
        this.emptyTree1 = new BSTImpl<>();
        this.emptyTree2 = new BSTImpl<>();
    }

    @Test
    public void testEqualsSameTrees() {
        this.fillTrees();
        assertTrue(this.bstManipulation.equals(this.sameTree1, this.sameTree2));
    }

    @Test
    public void testEqualsDifferentTrees() {
        this.fillTrees();
        assertFalse(this.bstManipulation.equals(this.sameTree1, this.notSameTree1));
    }

    @Test
    public void testIsSimilarSimilarTrees() {
        this.fillTrees();
        assertTrue(this.bstManipulation.isSimilar(this.sameTree1, this.sameTree2));
    }

    @Test
    public void testIsSimilarNonSimilarTrees() {
        this.fillTrees();
        assertFalse(this.bstManipulation.isSimilar(this.sameTree1, this.notSameTree1));
    }

    @Test
    public void testEqualsEmptyTrees() {
        assertTrue(this.bstManipulation.equals(this.emptyTree1, this.emptyTree2));
    }

    @Test
    public void testSimilarEmptyTrees() {
        assertTrue(this.bstManipulation.isSimilar(this.emptyTree1, this.emptyTree2));
    }

    @Test
    public void testOrderStatistic() {
        this.fillTrees();
        Integer[] orderedNumbers = {-40, -34, 0, 2, 5, 6, 9, 12, 23, 67, 76, 232};
        for (int i = 1; i <= orderedNumbers.length; i++) {
            assertEquals(orderedNumbers[i-1], this.bstManipulation.orderStatistic(sameTree1, i));
        }
    }

    @Test
    public void testOrderStatisticNonExistent() {
        assertNull(this.bstManipulation.orderStatistic(sameTree1, 13));
        assertNull(this.bstManipulation.orderStatistic(sameTree1, 0));
    }
}