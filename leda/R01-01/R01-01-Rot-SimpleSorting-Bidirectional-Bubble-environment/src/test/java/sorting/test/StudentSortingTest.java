package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.simpleSorting.BubbleSort;
import sorting.simpleSorting.InsertionSort;
import sorting.simpleSorting.SelectionSort;
import sorting.variationsOfBubblesort.BidirectionalBubbleSort;
import sorting.variationsOfBubblesort.RecursiveBubbleSort;
import sorting.variationsOfSelectionsort.RecursiveSelectionSort;

public class StudentSortingTest {

    private Integer[] vetorTamPar;
    private Integer[] vetorTamImpar;
    private Integer[] vetorVazio = {};
    private Integer[] vetorValoresRepetidos;
    private Integer[] vetorValoresIguais;

    public AbstractSorting<Integer> implementation;

    @Before
    public void setUp() {
        populaVetorTamanhoPar(new Integer[]{30, 28, 7, 29, 11, 26, 4, 22, 23, 31});
        populaVetorTamanhoImpar(new Integer[]{6, 41, 32, 7, 26, 4, 37, 49, 11, 18, 36});
        populaVetorRepetido(new Integer[]{4, 9, 3, 4, 0, 5, 1, 4});
        populaVetorIgual(new Integer[]{6, 6, 6, 6, 6, 6});

        getImplementation();
    }

    // // MÉTODOS AUXILIARES DA INICIALIZAÇÃO

    /**
     * Método que inicializa a implementação a ser testada com a implementação
     * do aluno
     */
    private void getImplementation() {
        // TODO O aluno deve instanciar sua implementação abaixo ao invés de
        // null
        this.implementation = new RecursiveBubbleSort<>();
    }

    public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
        this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
    }

    public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
        this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
    }

    public void populaVetorRepetido(Integer[] arrayPadrao) {
        this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
    }

    public void populaVetorIgual(Integer[] arrayPadrao) {
        this.vetorValoresIguais = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
    }

    // FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

    // MÉTODOS DE TESTE

    public void genericTest(Integer[] array) {
        Integer[] copy1 = {};
        if (array.length > 0) {
            copy1 = Arrays.copyOf(array, array.length);
        }
        implementation.sort(array);
        Arrays.sort(copy1);
        Assert.assertArrayEquals(copy1, array);
    }

    public void genericDefinedIndexesTest(Integer[] array, int leftIndex, int rightIndex) {
		Integer[] copy1 = {};
		Integer[] copy2 = {};
		Integer[] copy3 = {};
		if (array.length > 0) {
			copy1 = Arrays.copyOf(array, leftIndex);
			copy2 = Arrays.copyOfRange(array, leftIndex, rightIndex + 1);
			copy3 = Arrays.copyOfRange(array, rightIndex + 1, array.length);
		}
		Arrays.sort(copy2);
		Integer[] copy = new Integer[copy1.length + copy2.length + copy3.length];
		int k = 0;
		for (int i = 0; i < copy1.length; i++) {
			copy[k] = copy1[i];
			k++;
		}
		for (int i = 0; i < copy2.length; i++) {
			copy[k] = copy2[i];
			k++;
		}
		for (int i = 0; i < copy3.length; i++) {
			copy[k] = copy3[i];
			k++;
		}
		implementation.sort(array, leftIndex, rightIndex);
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(copy));
		Assert.assertArrayEquals(copy, array);

	}

    @Test
    public void testSort01() {
        genericTest(vetorTamPar);
    }

    @Test
    public void testSort02() {
        genericTest(vetorTamImpar);
    }

    @Test
    public void testSort03() {
        genericTest(vetorVazio);
    }

    @Test
    public void testSort04() {
        genericTest(vetorValoresIguais);
    }

    @Test
    public void testSort05() {
        genericTest(vetorValoresRepetidos);
    }

    @Test
    public void testSort06() {
        genericDefinedIndexesTest(vetorTamPar, 2, 4);
    }

    // MÉTODOS QUE OS ALUNOS PODEM CRIAR
    /**
     * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
     * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
     * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
     * UMA PARTE DO ARRAY.
     */
}