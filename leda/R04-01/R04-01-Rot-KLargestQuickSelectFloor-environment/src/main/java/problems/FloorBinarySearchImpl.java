package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

    @Override
    public Integer floor(Integer[] array, Integer x) {
        quickSort(array, 0, array.length - 1);
        int index = binarySearch(array, 0, array.length - 1, x);
        return index != -1 ? array[index] : null;
    }

    private void quickSort(Integer[] array, int start, int end) {
        if (array.length == 0 || array.length == 1) {
            return;
        }
        if (start < end) {
            int pivot = partition(array, start, end);
            quickSort(array, start, pivot - 1);
            quickSort(array, pivot + 1, end);
        }
    }

    private int partition(Integer[] array, int start, int end) {
        choosePivot(array, start, end);

        Integer pivot = array[start];
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

    private void choosePivot(Integer[] array, int start, int end) {
        int range = end - start + 1;
        int randomIndex = (int) (Math.random() * range) + start;
        Util.swap(array, start, randomIndex);
    }

    public int binarySearch(Integer[] array, int start, int end, Integer element) {
        if (start > end) {
            return -1;
        }
        boolean isElementSmallerThanArraySmallest = element.compareTo(array[0]) < 0;
        if (isElementSmallerThanArraySmallest) {
            return -1;
        }
        boolean isElementGreaterThanBiggestElement = element.compareTo(array[array.length - 1]) >= 0;
        if (isElementGreaterThanBiggestElement) {
            return array.length - 1;
        }

        int mid = (start + end) / 2;
        boolean foundElement = array[mid].compareTo(element) <= 0 && array[mid + 1].compareTo(element) > 0;
        if (foundElement) {
            return mid;
        }
        boolean currentIsGreaterThanElement = array[mid].compareTo(element) > 0;
        if (currentIsGreaterThanElement) {
            return binarySearch(array, start, mid - 1, element);
        } else {
            return binarySearch(array, mid + 1, end, element);
        }
    }
}
