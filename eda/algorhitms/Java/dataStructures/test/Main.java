package dataStructures.test;

import dataStructures.main.Linked.Linked;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Main {

    Linked<Integer> list;

    @BeforeEach
    void initialize() {
        this.list = new Linked<>();
    }

    @Test
    void testAdd() {
        this.list.add(5);
    }

    @Test
    void testGetSize() {
        assertEquals(0, this.list.size());
        this.list.add(2);
        this.list.add(3);
        assertEquals(2, this.list.size());
        this.list.remove(new Integer(3));
        assertEquals(1, this.list.size());
    }
}
