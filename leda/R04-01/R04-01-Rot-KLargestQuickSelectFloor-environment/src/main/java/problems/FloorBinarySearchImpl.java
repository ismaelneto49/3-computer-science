package problems;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		quickSort(array, 0, array.length - 1);
		Integer index = searchFor(x - 1);

		return array[index];
	}

	private void quickSort(T[] array, int start, int end) {
		if (array.length == 0 || array.length == 1) {
			return;
		}
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

	private Integer searchFor(T[] array, T[] element) {
		if (element - 1 < array[0]) {
			return null;
		}
		int index = binarySearch(array, 0, array.length - 1, element);
		if (index == -1) {
			searchFor(array, element - 1);
		}
	}

	private int binarySearch(T[] array, int start, int end, T element) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		boolean foundElement = array[mid].compareTo(element) == 0;
		if (foundElement) {
			return mid;
		}
		boolean isCurrentSmallerThanTarget = array[mid].compareTo(element) < 0;
		if (isCurrentSmallerThanTarget) {
			binarySearch(array, start, mid - 1, element);
		}
		boolean isCurrentGreaterThanTarget = array[mid].compareTo(element) > 0;
		if (isCurrentGreaterThanTarget) {
			binarySearch(array, mid + 1, end, element);
		}

	}
}
