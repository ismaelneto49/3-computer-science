package List.LinkedList;

public interface LinkedList<T extends Comparable<T>> {

    void insert(T element);

    T remove(int index);

    T get(int index);

    void set(int index, T element);

    boolean contains(T element);

    int indexOf(T element);

    int size();

    boolean isEmpty();
}
