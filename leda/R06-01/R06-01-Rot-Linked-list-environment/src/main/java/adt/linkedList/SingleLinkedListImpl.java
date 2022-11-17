package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head == null;
	}

	@Override
	public int size() {
		if (this.isEmpty()) {
			return 0;
		}
		int size = 0;
		SingleLinkedListNode<T> temp = this.head;
		while (temp.next != null) {
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
		SingleLinkedListNode<T> temp = this.head;
		while(temp.next != null) {
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
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = new SingleLinkedListNode<T>(element, null);
	}

	@Override
	public void remove(T element) {
		SingleLinkedListNode<T> temp = this.head;
		while(temp.next != null) {
			if (temp.next.data.equals(element)) {
				temp.next = temp.next.next;
			}
			temp = temp.next;
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Comparable[this.size()];
		SingleLinkedListNode<T> temp = this.head;
		int count = 0;
		while(temp.next != null) {
			array[count++] = (T) temp.data;
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
