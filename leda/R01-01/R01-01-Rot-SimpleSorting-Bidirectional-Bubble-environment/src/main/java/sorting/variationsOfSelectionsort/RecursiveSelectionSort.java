package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
        AbstractSorting<T> {

    public void selectionSort(T[] array, int start, int end) {
        if(array.length == 0 || array.length == 1) {
            return;
        }
        if (start < end) {
            drag(array, start, end);
            selectionSort(array, ++start, end);
        }
    }

    public void drag(T[] array, int start, int end) {
        int indexSmallest = start;
        for (int i = start; i <= end; i++) {
            boolean isCurrentSmallestThanNext = array[i].compareTo(array[indexSmallest]) < 0;
            if (isCurrentSmallestThanNext) {
                indexSmallest = i;
            }
        }
        boolean smallestIsInRightPosition = start == indexSmallest;
        if (!smallestIsInRightPosition) {
            Util.swap(array, indexSmallest, start);
        }
    }

    /**
     * Implementação recursiva do selection sort. Você deve implementar apenas
     * esse método sem usar nenhum outro método auxiliar (exceto
     * Util.swap(array,int,int)). Para isso, tente definir o caso base do
     * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
     * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
     * quadrática O(n^2).
     */
    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        selectionSort(array, leftIndex, rightIndex);
    }
}
