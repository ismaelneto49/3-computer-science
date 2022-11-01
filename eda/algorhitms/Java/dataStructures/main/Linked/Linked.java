package dataStructures.main.Linked;

import dataStructures.main.List;
import dataStructures.main.Node;

public class Linked<T> implements List<T> {

    private Node<T> start;
    private int size = 0;

    @Override
    public void add(T element) {
        Node<T> node = new Node<T>(element);
        if (this.size == 0) {
            this.start = node;
        } else {
            Node<T> temp = this.start;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(node);
            node.setPrevious(temp);
        }
        this.size += 1;
    }

    @Override
    public void remove(int index) {
        Node<T> temp = this.start;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        Node<T> previous = temp.getPrevious();
        Node<T> next = temp.getNext();

        if (previous != null) {
            previous.setNext(next);
        }
        if (next != null) {
            next.setPrevious(previous);
        }
        this.size -= 1;
    }

    @Override
    public void remove(T element) {
        if (this.size == 0) {
            return;
        }
        Node<T> temp = this.start;
        while (!temp.getValue().equals(element)) {
            temp = temp.getNext();
        }
        Node<T> previous = temp.getPrevious();
        Node<T> next = temp.getNext();

        if (previous != null) {
            previous.setNext(next);
        }
        if (next != null) {
            next.setPrevious(previous);
        }
        this.size -= 1;
    }

    @Override
    public T get(int index) {
        Node<T> temp = this.start;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return (T) temp.getValue();
    }

    @Override
    public void set(int index, T element) {
        Node<T> temp = this.start;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        temp.setValue(element);
    }

    @Override
    public boolean contains(T element) {
        Node<T> temp = this.start;
        while (temp.getNext() != null) {
            if (temp.getValue().equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}
