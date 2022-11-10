package problems;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BitonicPointBinarySearchImplTest {

    private BitonicPointBinarySearch<Integer> search;
    private final Integer[] bitonicPointFirstElement = { 12, 9, 8, 6, 5, 4 };
    private final Integer[] bitonicPointLastElement = { 1, 2, 3, 4, 12 };
    private final Integer[] bitonicPointMiddleElement = { 1, 2, 3, 50, 3, 2, 1 };
    private final Integer[] bitonicPointAnyElement = { 0, 21, 10, 9, 5, 4, 3, 2, 1 };
    private final Integer[] emptyArray = {};
    private final Integer[] oneElementArray = { 13 };
    private final Integer[] symmetricalArray = { 1, 2, 3, 2, 1 };

    @Before
    public void init() {
        this.search = new BitonicPointBinarySearchImpl<Integer>();
    }

    public void genericTest(Integer[] array, Integer expected) {
        Integer result = this.search.bitonicPoint(array);
        assertEquals(expected, result);
    }

    @Test
    public void testBitonicPointStart() {
        int start = 0;
        genericTest(bitonicPointFirstElement, bitonicPointFirstElement[start]);
    }

    @Test
    public void testBitonicPointEnd() {
        int end = bitonicPointLastElement.length - 1;
        genericTest(bitonicPointLastElement, bitonicPointLastElement[end]);
    }

    @Test
    public void testBitonicPointMiddle() {
        int mid = (bitonicPointMiddleElement.length - 1) / 2;
        genericTest(bitonicPointMiddleElement, bitonicPointMiddleElement[mid]);

    }

    @Test
    public void testBitonicPointAny() {
        int bitonicPointIndex = 1;
        genericTest(bitonicPointAnyElement, bitonicPointAnyElement[bitonicPointIndex]);

    }

    @Test
    public void testArrayEmpty() {
        genericTest(emptyArray, null);
    }

    @Test
    public void testOneElementArray() {
        genericTest(oneElementArray, oneElementArray[0]);
    }

    @Test
    public void testSymmetricalArray() {
        int mid = (symmetricalArray.length - 1) / 2;
        genericTest(symmetricalArray, symmetricalArray[mid]);
    }
}
 