package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

    protected RecursiveDoubleLinkedListImpl<T> previous;

    public RecursiveDoubleLinkedListImpl() {
    }

    public RecursiveDoubleLinkedListImpl(T element) {
        this.data = element;
    }

    @Override
    public int size() {
        RecursiveDoubleLinkedListImpl<T> temp = this;
        if (temp.previous == null) {
            return 0;
        }
        temp = this.previous;
        return temp.size() + 1;
    }

    @Override
    public void insert(T element) {
        RecursiveDoubleLinkedListImpl<T> node = new RecursiveDoubleLinkedListImpl<>(element);
        node.previous = this.previous;
        node.next = this;
        if (this.previous != null) {
            this.previous.next = node;
        }
        this.previous = node;
    }

    @Override
    public void remove(T element) {
        if (!this.isEmpty()) {
            RecursiveDoubleLinkedListImpl<T> temp = this.previous;
            if (temp.data.equals(element)) {
                this.previous = temp.previous;
                temp.previous.next = this;
            } else {
                temp.remove(element);
            }
        }
    }

    @Override
    public void insertFirst(T element) {
        if (this.previous == null) {
            this.insert(element);
        } else {
            this.previous.insertFirst(element);
        }
    }

    @Override
    public void removeFirst() {
        if (this.previous == null) {
            this.remove(this.data);
        } else {
            this.previous.removeFirst();
        }
    }

    @Override
    public void removeLast() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public T[] toArray() {
        T[] array = (T[]) new Comparable[this.size()];
        RecursiveDoubleLinkedListImpl<T> temp = this;

        if (temp.isEmpty()) {
            return (T[]) new Comparable[0];
        }
        for (int i = this.size() - 1; i >= 0; i--) {
            array[i] = temp.previous.data;
            temp = temp.previous;
        }
        return array;
    }

    public RecursiveDoubleLinkedListImpl<T> getPrevious() {
        return previous;
    }

    public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
        this.previous = previous;
    }

}
