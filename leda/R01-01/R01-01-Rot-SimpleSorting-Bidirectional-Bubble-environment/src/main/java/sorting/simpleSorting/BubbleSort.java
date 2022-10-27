package sorting.simpleSorting;

import javax.swing.text.TabExpander;

import sorting.AbstractSorting;
import util.Util;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

    private void bubbleSort(T[] array, int start, int end) {
        if(array.length == 0 || array.length == 1) {
            return;
        }
        for (int i = start; i < end; i++) {
            boolean isOrdered = true;
            for (int j = start; j < end - i; j++) {
                boolean isCurrentGreaterThanNext = array[j].compareTo(array[j + 1]) > 0;
                if (isCurrentGreaterThanNext) {
                    Util.swap(array, j, j + 1);
                    isOrdered = false;
                }
            }
            if (isOrdered) {
                break;
            }
        }
    }

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        bubbleSort(array, leftIndex, rightIndex);
    }
}
