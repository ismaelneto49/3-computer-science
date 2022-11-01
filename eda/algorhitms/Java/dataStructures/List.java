package dataStructures;

public interface List<T> {

    public void add(T element);

    public void remove(T element);

    public T get();

    public T get(int index);

    public boolean contains(T element);

    public int size();

    public boolean isEmpty();

}