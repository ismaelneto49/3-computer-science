package orderStatistic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class KLargestOrderStatisticsImplTest {

    private Integer[] evenSizeArray;
    private Integer[] oddSizeArray;
    private Integer[] emptyArray = {};
    private Integer[] testArray = new Integer[] { 5, 3, 6, 2, 8 };
    private int k = 5;

    private KLargest<Integer> kLargest;

    @BeforeEach
    void initialize() {
        fillEvenSizeArray(new Integer[]{30, 28, 7, 29, 11, 26, 4, 22, 23, 31});
        fillOddSizeArray(new Integer[]{6, 41, 32, 7, 26, 4, 37, 49, 11, 18, 36});

        kLargest = new KLargestOrderStatisticsImpl<>();
    }

    public void fillEvenSizeArray(Integer[] arrayPadrao) {
        this.evenSizeArray = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
    }

    public void fillOddSizeArray(Integer[] arrayPadrao) {
        this.oddSizeArray = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
    }

    @Test
    void testEvenSizeArray() {
        Comparable[] result = kLargest.getKLargest(evenSizeArray, k);
        Arrays.sort(evenSizeArray);
        int start = evenSizeArray.length - k;
        int end = evenSizeArray.length;
        Integer[] expected = Arrays.copyOfRange(evenSizeArray, start, end);
        assertArrayEquals(expected, result);
    }

    @Test
    void testOddSizeArray() {
        Comparable[] result = kLargest.getKLargest(oddSizeArray, k);
        Arrays.sort(oddSizeArray);
        int start = oddSizeArray.length - k;
        int end = oddSizeArray.length;
        Integer[] expected = Arrays.copyOfRange(oddSizeArray, start, end);
        assertArrayEquals(expected, result);
    }

    @Test
    void testEmptyArray() {
        Comparable[] result = kLargest.getKLargest(emptyArray, k);
        Integer[] expected = {};
        assertArrayEquals(expected, result);
    }

    @Test
    void testKGreaterThanArrayLength() {
        k = 11;
        Comparable[] result = kLargest.getKLargest(evenSizeArray, k);
        Integer[] expected = {};
        assertArrayEquals(expected, result);
    }

    @Test
    void testKSmallerThanZero() {
        k = -1;
        Comparable[] result = kLargest.getKLargest(evenSizeArray, k);
        Integer[] expected = {};
        assertArrayEquals(expected, result);
    }
}