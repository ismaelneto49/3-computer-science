package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	private void bidirectionalBubbleSort(T[] array, int start, int end) {
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
		bidirectionalBubbleSort(array, leftIndex, rightIndex);
	}
}
