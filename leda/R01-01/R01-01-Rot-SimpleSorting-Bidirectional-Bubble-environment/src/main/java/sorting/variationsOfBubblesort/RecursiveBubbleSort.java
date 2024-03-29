package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveBubbleSort<T extends Comparable<T>> extends
        AbstractSorting<T> {

    private boolean isOrdered = false;

    private void recursiveBubbleSort(T[] array, int start, int end) {
        if(array.length == 0 || array.length == 1) {
            return;
        }
        if (isOrdered) {
            return;
        }
        boolean isLastRecursiveCall = end <= start;
        if (!isLastRecursiveCall) {
            drag(array, start, end);
            recursiveBubbleSort(array, start, --end);
        }
    }

    private void drag(T[] array, int start, int end) {
        this.isOrdered = true;
        for (int i = start; i < end; i++) {
            boolean isCurrentGreaterThanNext = array[i].compareTo(array[i + 1]) > 0;
            if (isCurrentGreaterThanNext) {
                Util.swap(array, i, i + 1);
                this.isOrdered = false;
            }
        }
    }

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        recursiveBubbleSort(array, leftIndex, rightIndex);
    }

}
