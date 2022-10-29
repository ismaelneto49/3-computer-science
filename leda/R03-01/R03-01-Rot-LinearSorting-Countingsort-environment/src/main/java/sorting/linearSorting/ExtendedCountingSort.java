package sorting.linearSorting;

import sorting.AbstractSorting;

import java.util.Arrays;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

    private void countingSort(Integer[] array, int start, int end) {
        if (array.length == 0 || array.length == 1) {
            return;
        }
        int[] frequencyArray = registerFrequency(array, start, end);
        cumulative(frequencyArray);
        order(array, start, end, frequencyArray);
    }

    private int[] registerFrequency(Integer[] array, int start, int end) {
        int smallest = findSmallest(array, start, end);
        int biggest = findBiggest(array, start, end);
        int[] c = new int[biggest - smallest + 1];
        for (int i = start; i <= end; i++) {
            c[array[i] - smallest] += 1;
        }
        return c;
    }

    private int findSmallest(Integer[] array, int start, int end) {
        int smallest = array[0];
        for (int i = start; i <= end; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
            }
        }
        return smallest;
    }

    private int findBiggest(Integer[] array, int start, int end) {
        int biggest = array[0];
        for (int i = start; i <= end; i++) {
            if (array[i] > biggest) {
                biggest = array[i];
            }
        }
        return biggest;
    }

    private void cumulative(int[] frequencyArray) {
        for (int i = 1; i < frequencyArray.length; i++) {
            frequencyArray[i] += frequencyArray[i - 1];
        }
    }

    private void order(Integer[] array, int start, int end, int[] frequencyArray) {
        int smallest = findSmallest(array, start, end);
        Integer[] sortedArray = Arrays.copyOf(array, array.length);
        for (int i = end; i >= start; i--) {
            sortedArray[frequencyArray[array[i] - smallest] - 1] = array[i];
            frequencyArray[array[i] - smallest] -= 1;
        }
        handleSideEffect(array, start, end, sortedArray);
    }

    private void handleSideEffect(Integer[] array, int start, int end, Integer[] sortedArray) {
        for (int i = start; i <= end; i++) {
            array[i] = sortedArray[i - start];
        }
    }

    @Override
    public void sort(Integer[] array, int leftIndex, int rightIndex) {
        countingSort(array, leftIndex, rightIndex);
    }
}
