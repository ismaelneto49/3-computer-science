package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;
import sorting.divideAndConquer.InsertionSort;
import util.Util;

import java.util.Arrays;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * <p>
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 * que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 * interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 * INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

    /**
     * For inputs with size less or equal to this value, the insertionsort
     * algorithm will be used instead of the mergesort.
     */
    public static final int SIZE_LIMIT = 4;

    protected static int MERGESORT_APPLICATIONS = 0;
    protected static int INSERTIONSORT_APPLICATIONS = 0;

    private final InsertionSort insertionSort = new InsertionSort();

    private void hybridMergeSort(T[] array, int start, int end) {
        int mid = (start + end) / 2;

        if (end - start <= SIZE_LIMIT) {
            insertionSort.sort(array, start, end);
            INSERTIONSORT_APPLICATIONS += 1;
        } else {
            hybridMergeSort(array, start, mid);
            hybridMergeSort(array, mid + 1, end);
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
        MERGESORT_APPLICATIONS += 1;
    }

    public void sort(T[] array, int leftIndex, int rightIndex) {
        MERGESORT_APPLICATIONS = 0;
        INSERTIONSORT_APPLICATIONS = 0;
        hybridMergeSort(array, leftIndex, rightIndex);
    }
}
