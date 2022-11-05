package orderStatistic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class QuickSelectTest {

    private Integer[] evenSizeArray;
    private Integer[] oddSizeArray;
    private Integer[] emptyArray = {};
    private Integer[] duplicatesArray;
    private Integer[] equalValuesArray;
    private int k = 5;

    private QuickSelect<Integer> quickSelect;

    @BeforeEach
    void initialize() {
        fillEvenSizeArray(new Integer[]{30, 28, 7, 29, 11, 26, 4, 22, 23, 31});
        fillOddSizeArray(new Integer[]{6, 41, 32, 7, 26, 4, 37, 49, 11, 18, 36});
        fillDuplicatesArray(new Integer[]{4, 9, 3, 4, 0, 5, 1, 4});
        fillEqualValuesArray(new Integer[]{6, 6, 6, 6, 6, 6});

        quickSelect = new QuickSelect<>();
    }

    public void fillEvenSizeArray(Integer[] arrayPadrao) {
        this.evenSizeArray = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
    }

    public void fillOddSizeArray(Integer[] arrayPadrao) {
        this.oddSizeArray = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
    }

    public void fillDuplicatesArray(Integer[] arrayPadrao) {
        this.duplicatesArray = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
    }

    public void fillEqualValuesArray(Integer[] arrayPadrao) {
        this.equalValuesArray = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
    }

    @Test
    void testEvenSizeArray() {
        Comparable<Integer> result = quickSelect.quickSelect(evenSizeArray, k);
        Arrays.sort(evenSizeArray);
        Comparable<Integer> expected = evenSizeArray[k - 1];
        assertEquals(expected, result);
    }

    @Test
    void testOddSizeArray() {
        Comparable<Integer> result = quickSelect.quickSelect(oddSizeArray, k);
        Arrays.sort(oddSizeArray);
        Comparable<Integer> expected = oddSizeArray[k - 1];
        assertEquals(expected, result);
    }

    @Test
    void testEmptyArray() {
        Comparable<Integer> result = quickSelect.quickSelect(emptyArray, k);
        assertNull(result);
    }

    @Test
    void testDuplicatesArray() {
        Comparable<Integer> result = quickSelect.quickSelect(duplicatesArray, k);
        Arrays.sort(duplicatesArray);
        Comparable<Integer> expected = duplicatesArray[k - 1];
        assertEquals(expected, result);
    }

    @Test
    void testEqualValuesArray() {
        Comparable<Integer> result = quickSelect.quickSelect(equalValuesArray, k);
        Arrays.sort(equalValuesArray);
        Comparable<Integer> expected = equalValuesArray[k - 1];
        assertEquals(expected, result);
    }
}
