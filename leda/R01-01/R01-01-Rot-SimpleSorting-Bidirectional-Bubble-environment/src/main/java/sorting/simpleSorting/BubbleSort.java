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

	public void bubbleSort(T[] array, int stopIndex) {
        // basic bubblesort
    }

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		bubbleSort(array, array.length-1);
	}
}
