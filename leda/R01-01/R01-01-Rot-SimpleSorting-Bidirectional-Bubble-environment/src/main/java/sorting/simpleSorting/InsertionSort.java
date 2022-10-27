package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

    private void insertionSort(T[] array, int start, int end) {
        if(array.length == 0 || array.length == 1) {
            return;
        }
        for (int i = start + 1; i <= end; i++) {
            for (int j = i; j > start; j--) {
                boolean isCurrentSmallerThanPrevious = array[j].compareTo(array[j - 1]) < 0;
                if (isCurrentSmallerThanPrevious) {
                    Util.swap(array, j - 1, j);
                }
            }
        }
    }

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        insertionSort(array, leftIndex, rightIndex);
    }
}
