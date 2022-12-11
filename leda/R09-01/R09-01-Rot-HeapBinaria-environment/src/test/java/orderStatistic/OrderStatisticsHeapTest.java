package orderStatistic;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class OrderStatisticsHeapTest {
    private OrderStatisticsHeapImpl<Integer> orderStatisticsHeap;
    private Integer[] array;
    private Integer[] sortedArray;

    @Before
    public void setUp() {
        this.orderStatisticsHeap = new OrderStatisticsHeapImpl<>();
        this.array = new Integer[]{82, 6, 99, 12, 34, 64, 58, 1};
        this.sortedArray = new Integer[]{82, 6, 99, 12, 34, 64, 58, 1};
        Arrays.sort(sortedArray);
    }

    @Test
    public void testOrderStatistics() {
        for (int i = 1; i <= this.array.length; i++) {
            Integer result = this.orderStatisticsHeap.getOrderStatistics(this.array, i);
            assertEquals(this.sortedArray[i - 1], result);
        }
    }

    @Test
    public void testInvalidKValue() {
        Integer result = this.orderStatisticsHeap.getOrderStatistics(this.array, 0);
        assertNull(result);

        result = this.orderStatisticsHeap.getOrderStatistics(this.array, this.array.length + 1);
        assertNull(result);
    }

    @Test
    public void testEmptyArray() {
        Integer result = this.orderStatisticsHeap.getOrderStatistics(new Integer[]{}, 1);
        assertNull(result);
    }
}
