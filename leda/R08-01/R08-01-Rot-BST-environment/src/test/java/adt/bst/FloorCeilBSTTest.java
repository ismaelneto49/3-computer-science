package adt.bst;

import adt.bst.extended.FloorCeilBSTImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FloorCeilBSTTest {

    private FloorCeilBSTImpl tree;

    @Before
    public void setUp() {
        this.tree = new FloorCeilBSTImpl();
    }

    @Test
    public void testFloorEqualNumber() {
        Integer[] numbers = {6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40};
        Integer result = this.tree.floor(numbers, 2);
        assertEquals(new Integer(2), result);
    }

    @Test
    public void testFloorDifferentNumber() {
        // -40 -34 0 2 5 6 9 12 23 67 76 232
        Integer[] numbers = {6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40};
        Integer result = this.tree.floor(numbers, -35);
        assertEquals(new Integer(-40), result);

        result = this.tree.floor(numbers, -1);
        assertEquals(new Integer(-34), result);

        result = this.tree.floor(numbers, 1);
        assertEquals(new Integer(0), result);

        result = this.tree.floor(numbers, 4);
        assertEquals(new Integer(2), result);

        result = this.tree.floor(numbers, 5);
        assertEquals(new Integer(5), result);

        result = this.tree.floor(numbers, 8);
        assertEquals(new Integer(6), result);

        result = this.tree.floor(numbers, 11);
        assertEquals(new Integer(9), result);

        result = this.tree.floor(numbers, 22);
        assertEquals(new Integer(12), result);

        result = this.tree.floor(numbers, 66);
        assertEquals(new Integer(23), result);

        result = this.tree.floor(numbers, 75);
        assertEquals(new Integer(67), result);

        result = this.tree.floor(numbers, 231);
        assertEquals(new Integer(76), result);
    }

    @Test
    public void testFloorSmallestNumber() {
        Integer[] numbers = {6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40};
        Integer result = this.tree.floor(numbers, -41);
        assertNull(result);
    }

    @Test
    public void testCeilEqualNumber() {
        Integer[] numbers = {6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40};
        Integer result = this.tree.ceil(numbers, 2);
        assertEquals(new Integer(2), result);
    }

    @Test
    public void testCeilDifferentNumber() {
        Integer[] numbers = {6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40};
        // -40 -34 0 2 5 6 9 12 23 67 76 232
        Integer result = this.tree.ceil(numbers, -39);
        assertEquals(new Integer(-34), result);

        result = this.tree.ceil(numbers, -33);
        assertEquals(new Integer(0), result);

        result = this.tree.ceil(numbers, 1);
        assertEquals(new Integer(2), result);

        result = this.tree.ceil(numbers, 3);
        assertEquals(new Integer(5), result);

        result = this.tree.ceil(numbers, 6);
        assertEquals(new Integer(6), result);

        result = this.tree.ceil(numbers, 7);
        assertEquals(new Integer(9), result);

        result = this.tree.ceil(numbers, 10);
        assertEquals(new Integer(12), result);

        result = this.tree.ceil(numbers, 13);
        assertEquals(new Integer(23), result);

        result = this.tree.ceil(numbers, 24);
        assertEquals(new Integer(67), result);

        result = this.tree.ceil(numbers, 68);
        assertEquals(new Integer(76), result);

        result = this.tree.ceil(numbers, 77);
        assertEquals(new Integer(232), result);
    }

    @Test
    public void testCeilBiggestNumber() {
        Integer[] numbers = {6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40};
        Integer result = this.tree.ceil(numbers, 233);
        assertNull(result);
    }
}
