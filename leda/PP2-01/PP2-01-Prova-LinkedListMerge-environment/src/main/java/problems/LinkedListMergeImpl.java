package problems;

import adt.linkedList.SingleLinkedListNode;

public class LinkedListMergeImpl<T extends Comparable<T>> implements LinkedListMerge<T> {
    public SingleLinkedListNode<T> merge(SingleLinkedListNode<T> node1, SingleLinkedListNode<T> node2) {
        SingleLinkedListNode<T> temp = new SingleLinkedListNode<>();
        SingleLinkedListNode<T> head = temp;
        SingleLinkedListNode<T> tempNode1 = node1;
        SingleLinkedListNode<T> tempNode2 = node2;

        while (!tempNode1.isNIL() && !tempNode2.isNIL()) {
            T data1 = tempNode1.getData();
            T data2 = tempNode2.getData();
            if (data1.compareTo(data2) <= 0) {
                temp.setData(data1);
                tempNode1 = tempNode1.getNext();
            } else {
                temp.setData(data2);
                tempNode2 = tempNode2.getNext();
            }
            temp.setNext(new SingleLinkedListNode<>());
            temp = temp.getNext();
        }

        while (!tempNode1.isNIL()) {
            temp.setData(tempNode1.getData());
            temp.setNext(new SingleLinkedListNode<>());
            tempNode1 = tempNode1.getNext();
            temp = temp.getNext();
        }

        while (!tempNode2.isNIL()) {
            temp.setData(tempNode2.getData());
            temp.setNext(new SingleLinkedListNode<>());
            tempNode2 = tempNode2.getNext();
            temp = temp.getNext();
        }
        return head;
    }
}
