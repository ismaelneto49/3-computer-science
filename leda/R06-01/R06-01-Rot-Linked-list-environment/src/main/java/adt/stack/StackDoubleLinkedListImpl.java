package adt.stack;

import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

    protected DoubleLinkedListImpl<T> top;
    protected int size;

    public StackDoubleLinkedListImpl(int size) {
        this.size = size;
        this.top = new DoubleLinkedListImpl<T>();
    }

    @Override
    public void push(T element) throws StackOverflowException {
        if (this.isFull()) {
            throw new StackOverflowException();
        }
        this.top.insert(element);
    }

    @Override
    public T pop() throws StackUnderflowException {
        if (this.isEmpty()) {
            throw new StackUnderflowException();
        }
        T result = this.top.getLast().getPrevious().getData();
        this.top.removeLast();
        return result;
    }

    @Override
    public T top() {
        return this.top.getLast().getPrevious().getData();
    }

    @Override
    public boolean isEmpty() {
        return this.top.isEmpty();
    }

    @Override
    public boolean isFull() {
        return this.size == this.top.size();
    }
}
