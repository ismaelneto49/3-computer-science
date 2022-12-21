package Heap;

import java.util.Arrays;
import java.util.List;

public class HeapImpl<Integer extends Comparable<Integer>> implements Heap<Integer> {

    private Integer[] heap;
    private int tail;

    public HeapImpl(Integer[] array) {
        this.heap = array;
        this.tail = -1;
        this.buildHeap();
    }

    private void buildHeap() {
    }

    @Override
    public void insert(Integer element) {
        this.ensureCapacity();
        this.heap[++this.tail] = element;

        int i = this.tail;
        while (i > 0 && this.heap[parent(i)].compareTo(this.heap[i]) < 0) {
            this.swap(i, parent(i));
            i = parent(i);
        }
    }

    @Override
    public Integer remove() {
        if (!this.isEmpty()) {
            Integer result = this.heap[0];
            this.heap[0] = this.heap[this.tail--];
            this.heapify(0);
            return result;
        }
        return null;
    }

    private void heapify(int i) {
        if (!this.isLeaf(i) && this.isValidIndex(i)) {
            int greatestElementIndex = this.getGreatestElementIndex(new int[]{i, this.left(i), this.right(i)});
            if (greatestElementIndex != i) {
                this.swap(i, greatestElementIndex);
                heapify(greatestElementIndex);
            }
        }
    }

    private int getGreatestElementIndex(int[] indexes) {
        int greatest = indexes[0];
        for (int i = 0; i < indexes.length; i++) {
            if (this.heap[i].compareTo(this.heap[greatest]) > 0) {
                greatest = i;
            }
        }
        return greatest;
    }

    @Override
    public Integer peek() {
        if (!this.isEmpty()) {
            return this.heap[0];
        }
        return null;
    }

    private int parent(int index) {
        if (this.isValidIndex(index)) {
            return (index - 1) / 2;
        }
        return -1;
    }

    private int left(int index) {
        if (this.isValidIndex(index)) {
            return 2 * index + 1;
        }
        return -1;
    }

    private int right(int index) {
        if (this.isValidIndex(index)) {
            return 2 * index + 2;
        }
        return -1;
    }

    private boolean isLeaf(int index) {
        return index >= this.parent(this.tail) && index <= this.tail;
    }

    @Override
    public boolean isEmpty() {
        return this.tail == -1;
    }

    @Override
    public int size() {
        return this.tail + 1;
    }

    private void ensureCapacity() {
        boolean isFull = this.tail == this.heap.length - 1;
        if (isFull) {
            this.resize();
        }
    }

    private void resize() {
        this.heap = Arrays.copyOf(this.heap, this.heap.length * 2);
    }

    private void swap(int index1, int index2) {
        Integer temp = this.heap[index1];
        this.heap[index1] = this.heap[index2];
        this.heap[index2] = temp;
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < this.heap.length;
    }
}
