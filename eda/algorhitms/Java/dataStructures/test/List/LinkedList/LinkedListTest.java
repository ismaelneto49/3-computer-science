package List.LinkedList;

import List.LinkedList.LinkedList;
import List.LinkedList.LinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    private LinkedList<Integer> list;
    private LinkedList<Integer> emptyList;
    private Integer[] elements;
    private final int LIST_SIZE = 10;

    @BeforeEach
    void init() {
        this.list = new LinkedListImpl<>();
        this.emptyList = new LinkedListImpl<>();
        this.elements = new Integer[]{-16, 65, 48, -52, 10, 17, 56, -9, 19, 99};
        this.fill(this.list, this.elements);
    }

    private void fill(LinkedList<Integer> list, Integer[] elements) {
        for (Integer element : elements) {
            list.insert(element);
        }
    }

    @Test
    void testInsert() {
        for (int i = 0; i < 10; i++) {
            assertEquals(i, this.emptyList.size());
            this.emptyList.insert(i * 2);
            assertEquals(i + 1, this.emptyList.size());
            assertTrue(this.emptyList.contains(i * 2));
        }
    }

    @Test
    void testRemove() {
        for (int i = 0; i < 10; i++) {
            assertEquals(LIST_SIZE - i, this.list.size());
            Integer elementToBeRemoved = this.list.get(0);
            this.emptyList.remove(0);
            assertEquals(i - 1, this.emptyList.size());
            assertFalse(this.emptyList.contains(elementToBeRemoved));
        }
    }

    @Test
    void testGet() {
        for (int i = 0; i < 10; i++) {
            assertEquals(this.elements[i], this.list.get(i));
        }
    }

    @Test
    void testSet() {
        for (int i = 0; i < 10; i++) {
            this.list.set(i, -13);
            assertEquals(-13, this.list.get(i));
        }
    }

    @Test
    void testContains() {
        for (Integer element : this.elements) {
            assertTrue(this.list.contains(element));
        }
        assertFalse(this.list.contains(100));
    }

    @Test
    void testIndexOf() {
        for (int i = 0; i < 10; i++) {
            assertEquals(i, this.list.indexOf(this.elements[i]));
        }
    }

    @Test
    void testSize() {
        assertEquals(LIST_SIZE, this.list.size());
        assertEquals(0, this.emptyList.size());
    }

    @Test
    void testIsEmpty() {
        assertFalse(this.list.isEmpty());
        assertTrue(this.emptyList.isEmpty());
    }

}
