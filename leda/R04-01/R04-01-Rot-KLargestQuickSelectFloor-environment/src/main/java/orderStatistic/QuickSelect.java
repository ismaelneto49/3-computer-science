package orderStatistic;

import util.Util;

/**
 * O quickselect eh um algoritmo baseado no quicksort para
 * descobrir/selectionar, em tempo linear, a k-esima estatistica de ordem
 * (k-esimo menor elemento) de um conjunto de dados.
 * <p>
 * O quiskselect escolhe um elemento para ser o pivot e particiona o array
 * inicial em dois subarrays da mesma forma que o quicksort (elementos menores
 * que o pivot a esquerda do pivot e elementos maiores que o pivot a direita
 * dele). Entretanto, ao inves de chamar o quicksort recursivo nas duas metades,
 * o quickselect eh executado (recursivamente) apenas na metade que contem o
 * elemento que ele procura (o k-esimo menor elemento). Isso reduz a
 * complexidade de O(n.log n) para O(n)
 *
 * @author adalberto e campelo
 */
public class QuickSelect<T extends Comparable<T>> {

    /**
     * O algoritmo quickselect usa a mesma abordagem do quicksort para calcular o
     * k-esimo menor elemento (k-esima estatistica de ordem) de um determinado
     * array de dados comparaveis. Primeiro ele escolhe um elemento como o pivot
     * e particiona os dados em duas partes, baseando-se no pivot (exatemente da
     * mesma forma que o quicksort). Depois disso, ele chama recursivamente o
     * mesmo algoritmo em apenas uma das metades (a que contem o k-esimo menor
     * elemento). Isso reduz a complexidade de O(n.log n) para O(n).
     * <p>
     * Caso o array seja vazio ou a ordem (posicao) do elemento desejado esteja
     * fora do tamanho do array, o metodo deve retornar null.
     *
     * @param array o array de dados a procurar o k-esimo menor elemento
     *              este array normalmente nao esta ordenado
     * @param k     a ordem do elemento desejado. 1 significa primeiro menor
     *              elemento, 2 significa segundo menor elemento e assim por
     *              diante
     * @return
     */
    public T quickSelect(T[] array, int k) {
        Integer orderStatistic = quickSelect(array, 0, array.length - 1, k);
        if (orderStatistic == null) {
            return null;
        }
        return array[orderStatistic];
    }

    private Integer quickSelect(T[] array, int start, int end, int k) {
        boolean isArrayEmpty = array.length == 0;
        boolean isKValid = k > 0 && k <= array.length;
        if (!isArrayEmpty || isKValid) {
            if (start <= end) {
                Integer pivot = partition(array, start, end);
                boolean isPivotGreaterThanK = pivot > k - 1;
                boolean isPivotSmallerThanK = pivot < k - 1;
                if (isPivotGreaterThanK) {
                    pivot = quickSelect(array, start, pivot - 1, k);
                } else if (isPivotSmallerThanK) {
                    pivot = quickSelect(array, pivot + 1, end, k);
                }
                return pivot;
            }
        }
        return null;
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
}