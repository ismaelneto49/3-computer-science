package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

    public FloorCeilHeapImpl(Comparator<Integer> comparator) {
        super(comparator);
    }

    @Override
    public Integer floor(Integer[] array, double numero) {
        for (Integer i : array) {
            this.insert(i);
        }

        Integer[] result = new Integer[array.length];
        Integer[] invertedResult = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            Integer root = this.extractRootElement();
            result[i] = root;
            invertedResult[array.length - 1 - i] = root;
        }

        boolean isMinHeap = result[0].compareTo(invertedResult[0]) < 0;
        Integer[] finalArray = isMinHeap ? result : invertedResult;
        int number = (int) numero;
        for (int i = finalArray.length - 1; i >= 0; i--) {
            if (finalArray[i].compareTo(number) <= 0) {
                return finalArray[i];
            }
        }
        return null;
    }

    @Override
    public Integer ceil(Integer[] array, double numero) {
        for (Integer i : array) {
            this.insert(i);
        }

        Integer[] result = new Integer[array.length];
        Integer[] invertedResult = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            Integer root = this.extractRootElement();
            result[i] = root;
            invertedResult[array.length - 1 - i] = root;
        }

        boolean isMinHeap = result[0].compareTo(invertedResult[0]) < 0;
        Integer[] finalArray = isMinHeap ? result : invertedResult;
        int number = (int) numero;
        for (int i = 0; i < finalArray.length; i++) {
            if (finalArray[i].compareTo(number) >= 0) {
                return finalArray[i];
            }
        }
        return null;
    }

}
