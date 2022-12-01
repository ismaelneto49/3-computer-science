package problems;

import adt.linkedList.SingleLinkedListNode;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class LinkedListMergeTest {

    private SingleLinkedListNode<Integer> node1;
    private SingleLinkedListNode<Integer> node2;

    private SingleLinkedListNode<Integer> node3;
    private SingleLinkedListNode<Integer> node4;
    private int randomHead1;
    private int randomHead2;
    private LinkedListMerge<Integer> linkedListMerge;


    @Before
    public void init() {
        node1 = new SingleLinkedListNode<>();
        node2 = new SingleLinkedListNode<>();
        node3 = new SingleLinkedListNode<>();
        node4 = new SingleLinkedListNode<>();
        linkedListMerge = new LinkedListMergeImpl<>();

        SingleLinkedListNode<Integer> temp1 = node1;
        for (int i = 1; i <= 10; i += 2) {
            temp1.setData(i);
            temp1.setNext(new SingleLinkedListNode<>());
            temp1 = temp1.getNext();
        }
        SingleLinkedListNode<Integer> temp2 = node2;
        for (int i = 2; i <= 10; i += 2) {
            temp2.setData(i);
            temp2.setNext(new SingleLinkedListNode<>());
            temp2 = temp2.getNext();
        }

        Random rnd = new Random(13);
        int[] array1 = new int[10];
        for (int i = 0; i < 10; i++) {
            array1[i] = rnd.nextInt(100);
        }
        Arrays.sort(array1);
        randomHead1 = array1[0];
        SingleLinkedListNode<Integer> temp3 = node3;
        for (int element : array1) {
            temp3.setData(element);
            temp3.setNext(new SingleLinkedListNode<>());
            temp3 = temp3.getNext();
        }

        Random rnd2 = new Random(7);
        int[] array2 = new int[10];
        for (int i = 0; i < 10; i++) {
            array1[i] = rnd2.nextInt(100);
        }
        Arrays.sort(array2);
        randomHead2 = array2[0];
        SingleLinkedListNode<Integer> temp4 = node4;
        for (int element : array2) {
            temp4.setData(element);
            temp4.setNext(new SingleLinkedListNode<>());
            temp4 = temp4.getNext();
        }
    }

    @Test
    public void testListsAreFilled() {
        assertEquals(new Integer(1), node1.getData());
        assertEquals(new Integer(2), node2.getData());
        assertEquals((Integer) randomHead1, node3.getData());
        assertEquals((Integer) randomHead2, node4.getData());
    }

    @Test
    public void testAlternatedMerge() {
        SingleLinkedListNode<Integer> result = linkedListMerge.merge(node1, node2);
        assertEquals(new Integer(1), result.getData());
    }

    @Test
    public void testRandomMerge() {
        SingleLinkedListNode<Integer> result = linkedListMerge.merge(node3, node4);
        int initialElement = Math.min(randomHead1, randomHead2);
        assertEquals((Integer) initialElement, result.getData());
    }

    @Test
    public void testEmptyList() {
        node2 = new SingleLinkedListNode<>();
        SingleLinkedListNode<Integer> result = linkedListMerge.merge(node1, node2);
        assertEquals(new Integer(1), result.getData());
    }

    @Test
    public void testBothEmptyLists() {
        node1 = new SingleLinkedListNode<>();
        node2 = new SingleLinkedListNode<>();
        SingleLinkedListNode<Integer> result = linkedListMerge.merge(node1, node2);
        assertNull(result.getData());
    }

    @Test
    public void testOneElementLists() {
        node1 = new SingleLinkedListNode<>(10, new SingleLinkedListNode<>());
        node2 = new SingleLinkedListNode<>(5, new SingleLinkedListNode<>());
        SingleLinkedListNode<Integer> result = linkedListMerge.merge(node1, node2);
        assertEquals(new Integer(5), result.getData());
    }
}
