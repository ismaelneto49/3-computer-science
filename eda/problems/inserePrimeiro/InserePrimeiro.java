package problems.inserePrimeiro;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InserePrimeiro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer[] array = Arrays.stream(sc.nextLine().split(" "))
                .map((e) -> Integer.parseInt(e))
                .collect(Collectors.toList())
                .toArray(new Integer[]{});
        int idxPrimeiro = array[0];
        for (int i = 0; i < array.length - 2; i++) {
            if (array[idxPrimeiro] > array[i + 1]) {
                int temp = array[i + 1];
                array[i + 1] = array[idxPrimeiro];
                array[idxPrimeiro] = temp;
                idxPrimeiro = i + 1;
            } else {
                break;
            }
            for (Integer a : array) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
        String output = "[";
        for (Integer a : array) {
            output += a + ", ";
        }
        output = output.substring(0, output.length() - 2) + "]";
        System.out.println(output);
    }
}