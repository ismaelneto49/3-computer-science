import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{12, 4, 9, 10, 9, 11, 4};
        System.out.println(Arrays.toString(array));
        countingSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void countingSort(Integer[] array, int start, int end) {
        int[] c = registerFrequency(array, start, end);
        cumulative(c);
        sort(array, start, end, c);
    }

    private static int[] registerFrequency(Integer[] array, int start, int end) {
        int biggest = findBiggest(array, start, end);
        int frequencyArray[] = new int[biggest];
        for (int i = start; i <= end; i++) {
            frequencyArray[array[i] - 1] += 1;
        }
        return frequencyArray;
    }

    private static int findBiggest(Integer[] array, int start, int end) {
        int biggest = array[start];
        for (int i = start + 1; i <= end; i++) {
            if (array[i] > biggest) {
                biggest = array[i];
            }
        }
        return biggest;
    }

    private static void cumulative(int[] c) {
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }
    }

    private static void sort(Integer[] array, int start, int end, int[] c) {
        int[] finalArray = new int[end - start + 1];
        for (int i = end; i >= start ; i--) {
            finalArray[c[array[i] - 1] - 1] = array[i];
            c[array[i] - 1] -= 1;
        }
        for (int i = start; i <= end; i++) {
            array[i] = finalArray[i - start];
        }
    }
}