package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

    private void quickSort(T[] array, int start, int end) {
        if (start < end) {
            int pivot = partition(array, start, end);
            quickSort(array, start, pivot - 1);
            quickSort(array, pivot + 1, end);
        }
    }

    private int partition(T[] array, int start, int end) {
        choosePivot(array, start, end);

        T pivot = array[start];
        int k = start;
        for (int i = k + 1; i <= end; i++) {
            boolean isElementSmallerThanPivot = array[i].compareTo(pivot) <= 0;
            if (isElementSmallerThanPivot) {
                k++;
                Util.swap(array, k, i);
            }
        }
        Util.swap(array, start, k);
        return k;
    }

    private void choosePivot(T[] array, int start, int end) {
        int range = end - start + 1;
        int randomIndex = (int) (Math.random() * range) + start;
        Util.swap(array, start, randomIndex);
    }

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        quickSort(array, leftIndex, rightIndex);
    }
}
