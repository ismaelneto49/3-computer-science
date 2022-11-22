package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements DoubleLinkedList<T> {

    protected DoubleLinkedListNode<T> last;

    public DoubleLinkedListImpl() {
        DoubleLinkedListNode<T> first = new DoubleLinkedListNode<>(null, this.last, null);
        this.head = first;
        this.last = new DoubleLinkedListNode<>(null, null, first);
    }

    @Override
    public void insert(T element) {
        DoubleLinkedListNode<T> node = new DoubleLinkedListNode<T>(element, this.last, this.last.previous);
        this.last.previous.next = node;
        this.last.previous = node;
    }

    @Override
    public void remove(T element) {
        DoubleLinkedListNode<T> temp = this.last;
        while (!temp.previous.isNIL()) {
            if (temp.previous.data.equals(element)) {
                temp = temp.previous;
                temp.previous.next = temp.next;
                ((DoubleLinkedListNode<T>) temp.next).setPrevious(temp.previous);
            }
            temp = temp.previous;
        }
    }

    @Override
    public void insertFirst(T element) {
        DoubleLinkedListNode<T> first = (DoubleLinkedListNode<T>) this.head;
        DoubleLinkedListNode<T> node = new DoubleLinkedListNode<T>(element, (DoubleLinkedListNode<T>) first.next, first);
        ((DoubleLinkedListNode<T>) first.next).previous = node;
        first.next = node;
    }

    @Override
    public void removeFirst() {
        DoubleLinkedListNode<T> first = (DoubleLinkedListNode<T>) this.head;
        if (!this.isEmpty()) {
            first.next = first.next.next;
            ((DoubleLinkedListNode<T>) first.next).setPrevious(first);
        }
    }

    @Override
    public void removeLast() {
        if (!this.isEmpty()) {
            this.last.previous = this.last.previous.previous;
            this.last.previous.next = this.last;
        }
    }

    public DoubleLinkedListNode<T> getLast() {
        return this.last;
    }

    public void setLast(DoubleLinkedListNode<T> last) {
        this.last = last;
    }
}
