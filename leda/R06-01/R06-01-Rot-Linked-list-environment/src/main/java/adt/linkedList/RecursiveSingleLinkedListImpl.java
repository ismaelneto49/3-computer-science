package adt.linkedList;

import java.util.ArrayList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

    protected T data;
    protected RecursiveSingleLinkedListImpl<T> next;

    public RecursiveSingleLinkedListImpl() {

    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public int size() {
        RecursiveSingleLinkedListImpl<T> temp = this;
        if (temp.next == null) {
            return 0;
        }
        temp = this.next;
        return temp.size() + 1;
    }

    @Override
    public T search(T element) {
        RecursiveSingleLinkedListImpl<T> temp = this;
        if (temp.isEmpty()) {
            return null;
        }
        if (temp.next.data.equals(element)) {
            return temp.next.data;
        }
        temp = temp.next;
        return temp.search(element);
    }

    @Override
    public void insert(T element) {
        RecursiveSingleLinkedListImpl<T> node = new RecursiveSingleLinkedListImpl<>();
        node.setData(element);
        node.setNext(null);

        RecursiveSingleLinkedListImpl<T> temp = this;
        if (!temp.isEmpty()) {
            temp = temp.next;
            temp.insert(element);
        } else {
            temp.next = node;
        }
    }

    @Override
    public void remove(T element) {
        if (!this.isEmpty()) {
            RecursiveSingleLinkedListImpl<T> temp = this.next;
            if (temp.data.equals(element)) {
                this.next = temp.next.next;
            } else {
                temp.remove(element);
            }
        }
    }

    @Override
    public T[] toArray() {
        T[] array = (T[]) new Comparable[this.size()];
        RecursiveSingleLinkedListImpl<T> temp = this;

        if (temp.isEmpty()) {
            return (T[]) new Comparable[0];
        }
        for (int i = 0; i < this.size(); i++) {
            array[i] = temp.next.data;
            temp = temp.next;
        }
        return array;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public RecursiveSingleLinkedListImpl<T> getNext() {
        return next;
    }

    public void setNext(RecursiveSingleLinkedListImpl<T> next) {
        this.next = next;
    }

}
