package problems;

public class BitonicPointBinarySearchImpl<T extends Comparable<T>> implements BitonicPointBinarySearch<T> {

  @Override
  public T bitonicPoint(T[] array) {

    boolean isArrayEmpty = array.length == 0;
    if (isArrayEmpty) {
      return null;
    }

    boolean isArrayTrivial = array.length == 1;
    if (isArrayTrivial) {
      return array[0];
    }

    boolean isFirstBitonicPoint = array[1].compareTo(array[0]) <= 0;
    if (isFirstBitonicPoint) {
      return array[0];
    }

    boolean isLastBitonicPoint = array[array.length - 2].compareTo(array[array.length - 1]) <= 0;
    if (isLastBitonicPoint) {
      return array[array.length - 1];
    }

    int indexBitonicPoint = binarySearch(array, 1, array.length - 2);
    return array[indexBitonicPoint];
  }

  private int binarySearch(T[] array, int start, int end) {
    int mid = (start + end) / 2;

    boolean isNextSmallerThanCurrent = array[mid + 1].compareTo(array[mid]) < 0;
    boolean isPreviousSmallerThanCurrent = array[mid - 1].compareTo(array[mid]) < 0;
    boolean foundElement = isPreviousSmallerThanCurrent && isNextSmallerThanCurrent;
    if (foundElement) {
      return mid;
    }

    if (array[mid - 1].compareTo(array[mid]) >= 0) {
      return binarySearch(array, start, mid - 1);
    } else {
      return binarySearch(array, mid + 1, end);
    }
  }
}