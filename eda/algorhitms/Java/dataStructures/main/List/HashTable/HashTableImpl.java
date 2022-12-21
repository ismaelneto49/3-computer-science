package List.HashTable;

import java.util.*;

public class HashTableImpl<T extends Comparable<T>> implements HashTable<T> {

    private List<Node<T>>[] table;
    private Set<Integer> keys;
    private final int INITIAL_CAPACITY;
    private int CURRENT_CAPACITY;
    private final int MAXIMUM_CAPACITY;
    private int size;

    public HashTableImpl() {
        this.INITIAL_CAPACITY = 11;
        this.CURRENT_CAPACITY = this.INITIAL_CAPACITY;
        this.MAXIMUM_CAPACITY = this.INITIAL_CAPACITY * 5;
        this.table = (List<Node<T>>[]) new ArrayList[INITIAL_CAPACITY];
        this.keys = new HashSet<>();
    }

    @Override
    public int hash(int key) {
        return key % CURRENT_CAPACITY;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T get(int key) {
        int keyHash = this.hash(key);
        List<Node<T>> list = this.table[keyHash];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).key == key) {
                return list.get(i).value;
            }
        }
        return null;
    }

    @Override
    public void put(int key, T element) {
        this.resizeIfNeeded();
        this.verifyCreateList(key);
        Node<T> node = new Node<T>(key, element);
        int keyHash = this.hash(key);
        if (this.isUpdate(node)) {
            this.table[keyHash].remove(node);
        }
        this.table[keyHash].add(node);
        this.keys.add(key);
        this.size++;
    }

    private void resizeIfNeeded() {
        if (this.size >= MAXIMUM_CAPACITY) {
            this.resize();
        }
    }

    private void resize() {
        this.CURRENT_CAPACITY *= 2;
        this.CURRENT_CAPACITY++;

    }

    @Override
    public void remove(int key) {
        if (this.isEmpty()) {
            return;
        }
        this.verifyCreateList(key);
        int keyHash = this.hash(key);
        this.table[keyHash].remove(new Node<T>(key, null));
        this.keys.remove(key);
        this.size--;
    }

    public Integer[] keys() {
        return this.keys.toArray(new Integer[0]);
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    private void verifyCreateList(int key) {
        int keyHash = this.hash(key);
        if (this.table[keyHash] == null) {
            this.table[keyHash] = new ArrayList<>();
        }
    }

    private boolean isUpdate(Node<T> node) {
        int keyHash = this.hash(node.key);
        List<Node<T>> list = this.table[keyHash];
        for (Node<T> element : list) {
            if (element.equals(node)) {
                return true;
            }
        }
        return false;
    }

    private class Node<T extends Comparable<T>> {
        private int key;
        private T value;

        Node(int key, T value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node<?> node = (Node<?>) o;
            return key == node.key;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }
}
