package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements DoubleLinkedList<T> {

    protected DoubleLinkedListNode<T> last;

    public DoubleLinkedListImpl() {
        this.last = new DoubleLinkedListNode<T>();
        this.last.setPrevious(new DoubleLinkedListNode<T>());
        this.last.previous.next = this.last;
    }

    @Override
    public void insert(T element) {
        super.insert(element);
        this.last.previous = new DoubleLinkedListNode<T>(element, this.last, this.last.previous);
    }

    @Override
    public void remove(T element) {
        super.remove(element);
        DoubleLinkedListNode<T> temp = this.last;
        while (!temp.previous.isNIL()) {
            if (temp.previous.data.equals(element)) {
                temp.setPrevious(temp.previous.previous);
                break;
            }
            temp = temp.previous;
        }
    }

    @Override
    public void insertFirst(T element) {
        SingleLinkedListNode<T> node = new SingleLinkedListNode<T>(element, this.head.next);
        this.head.next = node;

        DoubleLinkedListNode<T> temp = this.last;
        while (!temp.previous.isNIL()) {
            temp = temp.previous;
        }
        DoubleLinkedListNode<T> doubleNode = new DoubleLinkedListNode<T>(element, temp, temp.previous);
        temp.previous.next = doubleNode;
        temp.previous = doubleNode;
    }

    @Override
    public void removeFirst() {
        this.remove(this.head.next.data);
    }

    @Override
    public void removeLast() {
        this.remove(this.last.previous.data);
    }

    public DoubleLinkedListNode<T> getLast() {
        return last;
    }

    public void setLast(DoubleLinkedListNode<T> last) {
        this.last = last;
    }

}
