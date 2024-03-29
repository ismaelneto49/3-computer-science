package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		SingleLinkedListNode<T> nil = new SingleLinkedListNode<T>();
		this.head = new SingleLinkedListNode<T>(null, nil);
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> temp = this.head;
		while (temp.next != null && !temp.next.isNIL()) {
			temp = temp.next;
			size++;
		}
		return size;
	}

	@Override
	public T search(T element) {
		if (this.isEmpty()) {
			return null;
		}
		SingleLinkedListNode<T> temp = this.head.next;
		while(!temp.next.isNIL()) {
			if (temp.data.equals(element)) {
				return temp.data;
			}
			temp = temp.next;
		}
		return null;
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> temp = this.head;
		while(!temp.next.isNIL()) {
			temp = temp.next;
		}
		SingleLinkedListNode nil = new SingleLinkedListNode<>();
		temp.setNext(new SingleLinkedListNode<T>(element, nil));
	}

	@Override
	public void remove(T element) {
		SingleLinkedListNode<T> temp = this.head;
		while(!temp.next.isNIL()) {
			if (temp.next.data.equals(element)) {
				temp.setNext(temp.next.next);
				break;
			}
			temp = temp.next;
		}
	}

	@Override
	public T[] toArray() {
		if (this.isEmpty()) {
			return (T[]) new Comparable[0];
		}
		T[] array = (T[]) new Comparable[this.size()];
		SingleLinkedListNode<T> temp = this.head;
		int count = 0;
		while(!temp.next.isNIL()) {
			array[count++] = temp.next.data;
			temp = temp.next;
		}
		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return this.head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
