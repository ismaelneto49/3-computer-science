package adt.queue;

public class CircularQueue<T> implements Queue<T> {

    private T[] array;
    private int tail;
    private int head;
    private int elements;

    public CircularQueue(int size) {
        array = (T[]) new Object[size];
        head = -1;
        tail = -1;
        elements = 0;
    }

    @Override
    public void enqueue(T element) throws QueueOverflowException {
        if (this.isFull()) {
            throw new QueueOverflowException();
        }
        if (this.isEmpty()) {
            this.head++;
        }
        int index = (this.tail + 1) % this.array.length;
        this.tail = index;
        this.array[index] = element;
    }

    @Override
    public T dequeue() throws QueueUnderflowException {
        if (this.isEmpty()) {
            throw new QueueUnderflowException();
        }
        boolean dequeueWillEmpty = this.tail % this.array.length == this.head % this.array.length;
        int index = (this.head + 1) % this.array.length;
        T element = this.array[this.head];
        this.head = index;
        if (dequeueWillEmpty) {
            this.head = -1;
            this.tail = -1;
        }
        return element;
    }

    @Override
    public T head() {
        if (this.isEmpty()) {
            return null;
        }
        return this.array[this.head];
    }

    @Override
    public boolean isEmpty() {
        return this.head == -1;
    }

    @Override
    public boolean isFull() {
        int index = (this.tail + 1) % this.array.length;
        return index == this.head;
    }
}
