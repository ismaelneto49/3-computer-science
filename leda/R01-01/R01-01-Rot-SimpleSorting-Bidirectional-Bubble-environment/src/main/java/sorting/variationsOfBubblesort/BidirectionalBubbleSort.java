package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends
        AbstractSorting<T> {

    private boolean isOrdered;

    private void bidirectionalBubbleSort(T[] array, int start, int end) {
        if(array.length == 0 || array.length == 1) {
            return;
        }
        for (int i = start; i < end; i++) {
            this.isOrdered = true;
            if (i % 2 == 0) {
                dragToEnd(array, start, end);
            } else {
                dragToStart(array, start, end);
            }
            if (this.isOrdered) {
                break;
            }
        }
    }

    private void dragToEnd(T[] array, int start, int end) {
        for (int j = start; j < end; j++) {
            boolean isCurrentGreaterThanNext = array[j].compareTo(array[j + 1]) > 0;
            if (isCurrentGreaterThanNext) {
                Util.swap(array, j, j + 1);
                this.isOrdered = false;
            }
        }
    }

    private void dragToStart(T[] array, int start, int end) {
        for (int j = end; j > start; j--) {
            boolean isCurrentSmallerThanPrevious = array[j].compareTo(array[j - 1]) < 0;
            if (isCurrentSmallerThanPrevious) {
                Util.swap(array, j, j - 1);
                this.isOrdered = false;
            }
        }
    }

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        bidirectionalBubbleSort(array, leftIndex, rightIndex);
    }
}
