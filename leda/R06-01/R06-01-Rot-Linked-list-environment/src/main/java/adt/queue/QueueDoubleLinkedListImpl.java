package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.DoubleLinkedListNode;
import adt.linkedList.SingleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

    protected DoubleLinkedListImpl<T> list;
    protected int size;

    public QueueDoubleLinkedListImpl(int size) {
        this.size = size;
        this.list = new DoubleLinkedListImpl<T>();
    }

    @Override
    public void enqueue(T element) throws QueueOverflowException {
        if (this.isFull()) {
            throw new QueueOverflowException();
        }
        this.list.insert(element);
    }

    @Override
    public T dequeue() throws QueueUnderflowException {
        if (this.isEmpty()) {
            throw new QueueUnderflowException();
        }
        DoubleLinkedListNode<T> temp = this.list.getLast();
        while (!temp.getPrevious().isNIL()) {
            temp = temp.getPrevious();
        }
        this.list.removeFirst();
        return temp.getData();
    }

    @Override
    public T head() {
        return this.list.getHead().getNext().getData();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public boolean isFull() {
        return this.size == this.list.size();
    }

}
