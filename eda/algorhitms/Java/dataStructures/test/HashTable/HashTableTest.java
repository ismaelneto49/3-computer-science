package HashTable;

import List.HashTable.HashTable;
import List.HashTable.HashTableImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {

    private HashTable<Integer> hashTable;
    private final int KEY1 = 123;
    private final int KEY2 = 321;

    @BeforeEach
    void init() {
        this.hashTable = new HashTableImpl<Integer>();
        this.hashTable.put(KEY1, 13);
    }

    @Test
    void testSize() {
        assertEquals(1, this.hashTable.size());
        this.hashTable.put(KEY2, 14);
        assertEquals(2, this.hashTable.size());
        this.hashTable.remove(KEY1);
        assertEquals(1, this.hashTable.size());
    }

    @Test
    void testGet() {
        assertEquals(13, this.hashTable.get(KEY1));
    }

    @Test
    void testPut() {
        this.hashTable.put(KEY2, 14);
    }

    @Test
    void testPutUpdate() {
        assertEquals(13, this.hashTable.get(KEY1));
        this.hashTable.put(KEY1, 15);
        assertEquals(15, this.hashTable.get(KEY1));
    }

    @Test
    void testRemove() {
        this.hashTable.remove(KEY1);
        assertNull(this.hashTable.get(KEY1));
    }

    @Test
    void testKeys() {
        this.hashTable.put(KEY2, 14);
        Integer[] expected = new Integer[]{KEY1, KEY2};
        Integer[] result = this.hashTable.keys();
        Arrays.sort(expected);
        Arrays.sort(result);
        assertArrayEquals(expected, result);
    }
}
