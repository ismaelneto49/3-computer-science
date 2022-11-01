package dataStructures.main;

public interface List<T> {

    void add(T element);

    void remove(int index);

    void remove(T element);

    T get(int index);

    void set(int index, T element);

    boolean contains(T element);

    int size();

    boolean isEmpty();

}