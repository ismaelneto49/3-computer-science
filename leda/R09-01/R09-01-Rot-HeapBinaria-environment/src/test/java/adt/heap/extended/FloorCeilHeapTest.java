package adt.heap.extended;

import adt.heap.ComparatorMinHeap;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FloorCeilHeapTest {
    private FloorCeilHeapImpl floorCeilHeap;
    private Integer[] array;

    @Before
    public void setUp() {
        this.floorCeilHeap = new FloorCeilHeapImpl(new ComparatorMinHeap<>());
        this.array = new Integer[]{82, 6, 99, 12, 34, 64, 58, 1};
    }

    @Test
    public void testFloorEqualSmallest() {
        Integer result = this.floorCeilHeap.floor(this.array, 1);
        assertEquals(new Integer(1), result);
    }

    @Test
    public void testFloorSmaller() {
        Integer result = this.floorCeilHeap.floor(this.array, -1);
        assertNull(result);
    }

    @Test
    public void testFloorNonExistent() {
        Integer result = this.floorCeilHeap.floor(this.array, 13);
        assertEquals(new Integer(12), result);
    }

    @Test
    public void testCeilEqualsBiggest() {
        Integer result = this.floorCeilHeap.ceil(this.array, 99);
        assertEquals(new Integer(99), result);
    }

    @Test
    public void testCeilBigger() {
        Integer result = this.floorCeilHeap.ceil(this.array, 100);
        assertNull(result);
    }

    @Test
    public void testCeilNonExistent() {
        Integer result = this.floorCeilHeap.ceil(this.array, 80);
        assertEquals(new Integer(82), result);
    }
}