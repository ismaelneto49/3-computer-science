package List.HashTable;

public interface HashTable<T> {

    int hash(int key);

    int size();

    T get(int key);

    void put(int key, T element);

    void remove(int key);

    Integer[] keys();

    boolean isEmpty();

}
