public class Main {
    public static void main(String[] args) {

        int[] numbers = new int[] { 1, 13, 3, 4, 5 };
        trocaVizinhos(numbers);
        int[] expectedNumbers = new int[] { 13, 1, 4, 3, 5 };
        for (int i = 0; i < numbers.length; i++) {
            assert numbers[i] == expectedNumbers[i];
        }
        numbers = new int[] {};
        trocaVizinhos(numbers);
        expectedNumbers = new int[] {};
        for (int i = 0; i < numbers.length; i++) {
            assert numbers[i] == expectedNumbers[i];
        }

        String[] word1 = "arara".split("");
        assert ehPalindromo(word1);
        String[] word2 = "amalero".split("");
        assert !ehPalindromo(word2);

        int[] numbers2 = new int[] { 1, 13, 0, 4, 5 };
        int target = 5;
        int[] expectedNumbers2 = new int[] { 1, 4 };
        int[] result = twoSum(numbers2, target);
        for (int i = 0; i < result.length; i++) {
            assert result[i] == expectedNumbers2[i];
        }

        assert ehPrimo(2);
        assert !ehPrimo(1);
        assert !ehPrimo(10);

        int[] numbers3 = new int[] { 1, 2, 3, 4, 2, 5 };
        assert temRepetido(numbers3);
        int[] numbers4 = new int[] { 1, 2, 3, 4, 5 };
        assert !temRepetido(numbers4);

        int[] numbers5 = new int[] { 4, 5, 6, 1 };
        assert "4 5 6 1 4 5".equals(vetorCircular(numbers5, 6));
        int[] numbers6 = new int[] { 3, 4, 2 };
        assert "3 4 2 3 4 2 3 4".equals(vetorCircular(numbers6, 8));
    }

    public static void trocaVizinhos(int[] numbers) {
        // f(n) = c2(n + 1) / 2 + c3(n / 2) + c4(n / 2) + c1

        //        c1    c2((n + 1) / 2)        c3(n / 2) 
        for (int i = 0; i < numbers.length - 1; i += 2) {
            // c4(n / 2)
            swap(i, i + 1, numbers);
        }
    }

    public static void swap(int id1, int id2, int[] array) {
        int temp = array[id1];
        array[id1] = array[id2];
        array[id2] = temp;
    }

    public static boolean ehPalindromo(String[] word) {
        // f(n) = c1 + c2(n+1) + c3(n) + n( c4+c5+c6+c7+c8) + c10

        //         c1    c2(n + 1)      c3(n)
        for (int i = 0; i < word.length; i++) {
            //n(c4    c5    c6    c7                 c8)
            if (!(word[i].equals(word[word.length - 1 - i]))) {
                // c9
                return false;
            }
        }
        // c10
        return true;
    }

    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length - 1; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[] { numbers[i], numbers[j] };
                }
            }
        }
        return new int[0];
    }

    public static boolean ehPrimo(int number) {
        if (number == 1) {
            return false;
        }
        if (number != 2 && number % 2 == 0) {
            return false;
        }

        // f(n) = c1 + c2((n + 1) / 2) + c3(n / 2) + c4(n/2) + c5(n/2) + c6

        //         c1   c2((n+1)/2) c3(n/2)
        for (int i = 3; i < number; i += 2) {
            //         c4(n)   c5(n)
            if (number % i == 0) {
                return false;
            }
        }
        //c6
        return true;
    }

    public static boolean temRepetido(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length - 1; j++) {
                if (numbers[i] == numbers[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String vetorCircular(int[] array, int quantity) {
        // f(n) = c1 + c2 + c3(n+1) + c4(n) + c5 + c6 + c7 + c8

        //            c1
        String result = "";

        //         c2   c3(n+1)      c4(n)
        for (int i = 0; i < quantity; i++) {
            //     c5          c6             c7
            result += array[i % array.length] + " ";
        }
        //           c8
        return result.trim();
    }
}
