package List.LinkedList;

public class LinkedListImpl<T extends Comparable<T>> implements LinkedList<T> {

    private Node<T> start;
    private Node<T> end;
    private int size;

    public LinkedListImpl() {
        this.start = new Node<>();
        this.end = new Node<>();

        this.start.next = this.end;
        this.end.previous = this.start;
        this.size = 0;
    }

    @Override
    public void insert(T element) {
        if (this.isEmpty()) {
            Node<T> newNode = new Node<>(element, this.start, this.end);
            this.start.next = newNode;
            this.end.previous = newNode;
        } else {
            this.insert(this.start, element);
        }
        this.size++;
    }

    private void insert(Node<T> current, T element) {
        if (current.next.isNihil()) {
            Node<T> newNode = new Node<>(element, current, current.next);
            current.next.previous = newNode;
            current.next = newNode;
        } else {
            this.insert(current.next, element);
        }
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException("Not yet implemented!");
    }

    @Override
    public T get(int index) {
        if (this.isEmpty()) {
            return null;
        }
        if (index >= this.size) {
            return null;
        }
        Node<T> temp = this.start;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
            if (temp.isNihil()) {
                return null;
            }
        }
        return temp.next.value;
    }

    @Override
    public void set(int index, T element) {
        if (this.isEmpty()) {
            return;
        }
        if (index >= this.size) {
            return;
        }
        Node<T> temp = this.start;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
            if (temp.isNihil()) {
                return;
            }
        }
        temp.next.value = element;
    }

    @Override
    public boolean contains(T element) {
        return this.indexOf(element) != -1;
    }

    @Override
    public int indexOf(T element) {
        if (this.isEmpty()) {
            return -1;
        }
        int index = 0;
        Node<T> temp = this.start;
        while (!temp.next.isNihil()) {
            boolean foundElement = temp.next.value.compareTo(element) == 0;
            if (foundElement) {
                break;
            }
            temp = temp.next;
            index++;
        }
        if (index == this.size) {
            return -1;
        }
        return index;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    private class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> previous;
        private Node<T> next;

        Node(T value, Node<T> previous, Node<T> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }

        Node() {
            this.value = null;
            this.previous = null;
            this.next = null;
        }

        private boolean isNihil() {
            return this.value == null;
        }

        @Override
        public String toString() {
            return this.isNihil() ? "nihil" : this.value.toString();
        }
    }
}
