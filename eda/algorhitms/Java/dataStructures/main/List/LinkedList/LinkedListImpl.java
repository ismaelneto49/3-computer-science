package List.LinkedList;

public class LinkedListImpl<T extends Comparable<T>> implements LinkedList<T> {

    private Node<T> start;
    private Node<T> end;
    private int size;

    @Override
    public void add(T element) {
        Node<T> node = new Node<T>(element);
        if (this.isEmpty()) {
            this.start = node;
        } else {
            this.end.next = node;
            node.previous = this.end;
        }
        this.end = node;
        this.size++;
    }

    @Override
    public void remove(int index) {
        if (this.isEmpty()) {
            return;
        }
        boolean isFirstElement = index == 0;
        boolean isLastElement = index == this.size - 1;
        if (isFirstElement) {
            this.start = this.start.next;
            this.start.previous = null;
        } else if (isLastElement) {
            this.end = this.end.previous;
            this.end.next = null;
        } else {
            Node<T> temp = this.start;
            int count = 0;
            while (temp.next != null && count != index) {
                temp = temp.next;
                count++;
            }
            temp.previous.next = temp.next;
            temp.next.previous = temp.previous;
        }
        this.size--;
    }

    @Override
    public T get(int index) {
        Node<T> temp = this.start;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.value;
    }

    @Override
    public void set(int index, T element) {
        Node<T> temp = this.start;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.value = element;
    }

    @Override
    public boolean contains(T element) {
        Node<T> temp = this.start;
        while (temp.next != null) {
            if (temp.value.equals(element)) {
                return true;
            }
            temp = temp.next;
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

    private class Node<T> {
        private T value;
        private Node<T> previous;
        private Node<T> next;

        private Node(T value) {
            this.value = value;
        }

        private Node(T value, Node<T> previous, Node<T> next) {
            this(value);
            this.previous = previous;
            this.next = next;
        }
    }
}
