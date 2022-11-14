package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;

public class QueueUsingStack<T> implements Queue<T> {

    private Stack<T> stack1;
    private Stack<T> stack2;
    private int size;

    public QueueUsingStack(int size) {
        stack1 = new StackImpl<T>(size);
        stack2 = new StackImpl<T>(size);
        this.size = size;
    }

    @Override
    public void enqueue(T element) throws QueueOverflowException {
        if (this.isFull()) {
            throw new QueueOverflowException();
        }
        try {
            this.stack2.push(element);
            Stack<T> tempStack = new StackImpl(this.size);
            while (!this.stack1.isEmpty()) {
                tempStack.push(this.stack1.pop());
            }
            this.stack1.push(element);
            while (!tempStack.isEmpty()) {
                this.stack1.push(tempStack.pop());
            }
        } catch (Exception e) {
            throw new QueueOverflowException();
        }
    }

    @Override
    public T dequeue() throws QueueUnderflowException {
        if (this.isEmpty()) {
            throw new QueueUnderflowException();
        }
        try {
            T element = this.stack1.pop();
            Stack<T> tempStack = new StackImpl(this.size);
            while (!this.stack2.isEmpty()) {
                tempStack.push(this.stack2.pop());
            }
            tempStack.pop();
            while (!tempStack.isEmpty()) {
                this.stack2.push(tempStack.pop());
            }
            return element;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public T head() {
        return this.stack1.top();
    }

    @Override
    public boolean isEmpty() {
        return this.stack2.isEmpty();
    }

    @Override
    public boolean isFull() {
        return this.stack2.isFull();
    }

}
