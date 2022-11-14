package adt.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentStackTest {

    public Stack<Integer> stack1;
    public Stack<Integer> stack2;
    public Stack<Integer> stack3;

    @Before
    public void setUp() throws StackOverflowException {

        getImplementations();

        // Pilha com 3 elementos não cheia.
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);

        // Pilha com 2 elementos de tamanho 2, pilha cheia.
        stack2.push(1);
        stack2.push(2);

    }

    private void getImplementations() {
        // TODO O aluno deve ajustar aqui para instanciar sua implementação
        stack1 = new StackImpl<>(4);
        stack2 = new StackImpl<>(2);
        stack3 = new StackImpl<>(5);
    }

    // MÉTODOS DE TESTE
    @Test
    public void testTop() {
        assertEquals(new Integer(3), stack1.top());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(stack1.isEmpty());
    }

    @Test
    public void testIsFull() {
        assertFalse(stack1.isFull()); // vai depender do tamanho que a pilha foi
        // iniciada!!!!
    }

    @Test
    public void testPush() {
        try {
            stack1.push(new Integer(5));
        } catch (StackOverflowException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test(expected = StackOverflowException.class)
    public void testPushComErro() throws StackOverflowException {
        stack2.push(new Integer(5)); // levanta excecao apenas se o tamanhonao
        // permitir outra insercao
    }

    @Test
    public void testPop() {
        try {
            assertEquals(new Integer(3), stack1.pop());
        } catch (StackUnderflowException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test(expected = StackUnderflowException.class)
    public void testPopComErro() throws StackUnderflowException {
        assertEquals(new Integer(3), stack3.pop()); // levanta excecao apenas se
        // stack1 for vazia
    }

    @Test
    public void testPushPilhaVazia() throws StackOverflowException {
        stack3.push(new Integer(13));
    }

    @Test
    public void testPopPilhaVazia() {
        assertThrows(StackUnderflowException.class, () -> stack3.pop());
    }

    @Test
    public void testPushPilhaCheia() {
        assertThrows(StackOverflowException.class, () -> stack2.push(new Integer(13)));
    }

    @Test
    public void testPopPilhaCheia() throws StackUnderflowException {
        assertEquals(new Integer(2), stack2.pop());
    }

    @Test
    public void testEncherPilha() throws StackOverflowException {
        while (!stack3.isFull()) {
            stack3.push(new Integer(13));
        }
        assertThrows(StackOverflowException.class, () -> stack3.push(new Integer(13)));
    }

    @Test
    public void testEsvaziarPilha() throws StackUnderflowException {
        while (!stack1.isEmpty()) {
            stack1.pop();
        }
        assertThrows(StackUnderflowException.class, () -> stack1.pop());
    }
}