package problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class FloorBinarySearchImplTest {

    private Integer[] evenSizeArray;
    private Integer[] oddSizeArray;
    private Integer[] emptyArray = {};
    private Integer[] duplicatesArray;
    private Integer[] equalValuesArray;

    private Floor floor;

    @BeforeEach
    void initialize() {
        fillEvenSizeArray(new Integer[]{30, 28, 7, 29, 11, 26, 4, 22, 23, 31});
        fillOddSizeArray(new Integer[]{6, 41, 32, 7, 26, 4, 37, 49, 11, 18, 36});
        fillDuplicatesArray(new Integer[]{4, 9, 3, 4, 0, 5, 1, 4});
        fillEqualValuesArray(new Integer[]{6, 6, 6, 6, 6, 6});

        floor = new FloorBinarySearchImpl();
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
        Integer result = floor.floor(evenSizeArray, 13);
        Integer expected = 11;
        assertEquals(expected, result);
    }

    @Test
    void testEmptyArray() {
        Integer result = floor.floor(emptyArray, 13);
        assertNull(result);
    }

    @Test
    void testDuplicatesArray() {
        Integer result = floor.floor(duplicatesArray, 9);
        Integer expected = 9;
        assertEquals(expected, result);
    }

    @Test
    void testEqualValuesArray() {
        Integer result = floor.floor(equalValuesArray, 13);
        Integer expected = 6;
        assertEquals(expected, result);
    }

    @Test
    void testFloorShouldNotExist() {
        Integer result = floor.floor(evenSizeArray, -13);
        assertNull(result);
    }
}
