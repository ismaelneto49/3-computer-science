package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements DoubleLinkedList<T> {

    protected DoubleLinkedListNode<T> last;

    @Override
    public void insertFirst(T element) {
        DoubleLinkedListNode<T> previous = (DoubleLinkedListNode<T>) this.head;
        DoubleLinkedListNode<T> next = (DoubleLinkedListNode<T>) this.head.next;
        DoubleLinkedListNode<T> node = new DoubleLinkedListNode<T>(element, next, previous);

        this.head.setNext(node);
        if (!isEmpty()) {
            next.setPrevious(node);
        }
    }

    @Override
    public void removeFirst() {
        if (!isEmpty()) {
            DoubleLinkedListNode<T> node = (DoubleLinkedListNode<T>) this.head.next;
            DoubleLinkedListNode<T> previous = node.previous;
            DoubleLinkedListNode<T> next = (DoubleLinkedListNode<T>) node.next;

            previous.next = next;
            if (next != null) {
                next.previous = previous;
            }
        }
    }

    @Override
    public void removeLast() {
        DoubleLinkedListNode<T> nil = new DoubleLinkedListNode<T>();
        this.last.previous.next = nil;
    }

    public DoubleLinkedListNode<T> getLast() {
        return last;
    }

    public void setLast(DoubleLinkedListNode<T> last) {
        this.last = last;
    }

}
