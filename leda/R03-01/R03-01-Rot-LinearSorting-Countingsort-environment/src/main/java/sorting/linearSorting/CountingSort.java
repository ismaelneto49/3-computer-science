package sorting.linearSorting;

import sorting.AbstractSorting;

import java.util.Arrays;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 * <p>
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 * <p>
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 */
public class CountingSort extends AbstractSorting<Integer> {

    private void countingSort(Integer[] array, int start, int end) {
        if (array.length == 0 || array.length == 1) {
            return;
        }
        int[] frequencyArray = registerFrequency(array, start, end);
        cumulative(frequencyArray);
        order(array, start, end, frequencyArray);
    }

    private int[] registerFrequency(Integer[] array, int start, int end) {
        int biggest = findBiggest(array, start, end);
        int[] c = new int[biggest + 1];
        for (int i = start; i <= end; i++) {
            c[array[i]] += 1;
        }
        return c;
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
        Integer[] sortedArray = Arrays.copyOf(array, array.length);
        for (int i = end; i >= start; i--) {
            sortedArray[frequencyArray[array[i]] - 1] = array[i];
            frequencyArray[array[i]] -= 1;
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
