package LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    private LinkedList<Integer> list;

    @BeforeEach
    void init() {
        this.list = new LinkedListImpl<Integer>();
        this.list.add(1);
        this.list.add(2);
    }

    @Test
    void testSize() {
        assertEquals(2, this.list.size());
        this.list.remove(1);
        assertEquals(1, this.list.size());
        this.list.add(2);
        assertEquals(2, this.list.size());
    }

    @Test
    void testAdd() {
        this.list.add(3);
    }

    @Test
    void testRemove() {
        this.list.remove(1);
        assertEquals(1, this.list.size());
    }

    @Test
    void testGet() {
        Integer element = this.list.get(0);
        assertEquals(1, element);
    }

    @Test
    void testSet() {
        Integer element = this.list.get(0);
        this.list.set(0, 13);
        assertEquals(13, this.list.get(0));
    }

    @Test
    void testContains() {
        assertTrue(this.list.contains(1));
        assertFalse(this.list.contains(45));
    }

    @Test
    void testIsEmpty() {
        assertFalse(this.list.isEmpty());
        this.list.remove(0);
        this.list.remove(0);
        assertTrue(this.list.isEmpty());
    }
}
