package LinkedList;

public interface LinkedList<T extends Comparable<T>> {

    void add(T element);

    void remove(int index);

    T get(int index);

    void set(int index, T element);

    boolean contains(T element);

    int size();

    boolean isEmpty();
}
