package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

    private void selectionSort(T[] array, int start, int end) {
        if(array.length == 0 || array.length == 1) {
            return;
        }
        for (int i = start; i < end; i++) {
            int indexSmallest = findIndexSmallest(array, i, end);

            boolean smallestIsInRightPosition = start == indexSmallest;
            if (!smallestIsInRightPosition) {
                Util.swap(array, i, indexSmallest);
            }
        }
    }

    private int findIndexSmallest(T[] array, int start, int end) {
        int indexSmallest = start;
        for (int i = start; i <= end; i++) {
            boolean isCurrentSmallerThanNext = array[i].compareTo(array[indexSmallest]) < 0;
            if (isCurrentSmallerThanNext) {
                indexSmallest = i;
            }
        }
        return indexSmallest;
    }

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        selectionSort(array, leftIndex, rightIndex);
    }
}
