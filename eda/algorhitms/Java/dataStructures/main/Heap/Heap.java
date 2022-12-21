package Heap;

public interface Heap<T extends Comparable<T>> {

    void insert(T element);

    T remove();

    T peek();

    boolean isEmpty();

    int size();
}
