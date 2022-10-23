package sorting.divideAndConquer;

import sorting.AbstractSorting;

import java.util.Arrays;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

    private void mergeSort(T[] array, int start, int end) {
        int mid = (start + end) / 2;
        if (start < end) {
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, end);
        }
    }

    private void merge(T[] array, int start, int end) {
        T[] helper = Arrays.copyOf(array, array.length);

        int i = start;
        int mid = (start + end) / 2;
        int j = mid + 1;
        int k = start;
        while (i <= mid && j <= end) {
            boolean isStartElementSmallerThanEndElement = helper[i].compareTo(helper[j]) <= 0;
            if (isStartElementSmallerThanEndElement) {
                array[k] = helper[i++];
            } else {
                array[k] = helper[j++];
            }
            k++;
        }
        while (i <= mid) {
            array[k++] = helper[i++];
        }
        while (j <= end) {
            array[k++] = helper[j++];
        }
    }

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        mergeSort(array, leftIndex, rightIndex);
    }
}
