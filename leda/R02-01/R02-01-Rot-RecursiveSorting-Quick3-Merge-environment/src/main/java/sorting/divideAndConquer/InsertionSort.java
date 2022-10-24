package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

    private void insertionSort(T[] array, int start, int end) {
        for (int i = start + 1; i < end + 1; i++) {
            for (int j = i; j > start; j--) {
                boolean isCurrentSmallerThanPrevious = array[j].compareTo(array[j - 1]) < 0;
                if (isCurrentSmallerThanPrevious) {
                    Util.swap(array, j - 1, j);
                }
            }
        }
    }

    public void sort(T[] array, int leftIndex, int rightIndex) {
        insertionSort(array, leftIndex, rightIndex);
    }
}
