package problems.insereUltimo;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

class InsereUltimo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer[] array = Arrays.stream(sc.nextLine().split(" "))
                .map((e) -> Integer.parseInt(e))
                .collect(Collectors.toList())
                .toArray(new Integer[]{});
        int idxUltimo = array.length - 1;
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i - 1] > array[idxUltimo]) {
                int temp = array[i - 1];
                array[i - 1] = array[idxUltimo];
                array[idxUltimo] = temp;
                idxUltimo = i - 1;
            }
            else {
                break;
            }
        }
        String output = "[";
        for (Integer a : array) {
          output += a + ", ";
        }
        output = output.substring(0, output.length() - 2) + "]";
        System.out.println(output);
    }
}
