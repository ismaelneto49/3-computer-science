package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
        AbstractSorting<T> {

    private void quickSort3(T[] array, int start, int end) {
        if (start < end) {
            int pivot = partition(array, start, end);
            quickSort3(array, start, pivot - 1);
            quickSort3(array, pivot + 1, end);
        }
    }

    private int partition(T[] array, int start, int end) {
        int pivotIndex = median(array, start, end);
        Util.swap(array, start, pivotIndex);

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

    private int median(T[] array, int start, int end) {
        int mid = (start + end) / 2;
        T[] values = (T[]) new Comparable[]{array[start], array[mid], array[end]};
        insertionSort(values, 0, 2);
        int index = indexOf(array, values[1]);
        return index >= 0 ? index : 0;
    }

    private int indexOf(T[] array, T value) {
        for (int i = 0; i < array.length; i++) {
            boolean foundElement = array[i].compareTo(value) == 0;
            if (foundElement) {
                return i;
            }
        }
        return -1;
    }

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

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        quickSort3(array, leftIndex, rightIndex);
    }
}
