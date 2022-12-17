package BinarySearchTree;

import java.util.ArrayList;

public class BinarySearchTreeImpl<T extends Comparable<T>> implements BinarySearchTree<T> {

    private Node<T> root;
    private int size;

    public BinarySearchTreeImpl() {
        this.root = new Node<>();
    }

    @Override
    public void insert(T element) {
        if (this.isEmpty()) {
            this.root = new Node<>(element, null);
        }
        this.insert(this.root, element);
        this.size++;
    }

    private void insert(Node<T> current, T element) {
        boolean isElementGreater = element.compareTo(current.value) > 0;
        boolean isElementSmaller = element.compareTo(current.value) < 0;
        if (isElementSmaller) {
            if (current.left.isNihil()) {
                current.left = new Node<>(element, current);
            } else {
                this.insert(current.left, element);
            }
        } else if (isElementGreater) {
            if (current.right.isNihil()) {
                current.right = new Node<>(element, current);
            } else {
                this.insert(current.right, element);
            }
        }
    }

    @Override
    public void remove(T element) {
        throw new UnsupportedOperationException("Not yet implemented!");
        //this.size--;
    }

    @Override
    public int height() {
        return this.height(this.root);
    }

    private int height(Node<T> current) {
        if (current.isNihil()) {
            return -1;
        }
        return 1 + Math.max(this.height(current.left), this.height(current.right));
    }


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.root.isNihil();
    }

    @Override
    public boolean contains(T element) {
        return this.contains(this.root, element);
    }

    private boolean contains(Node<T> current, T element) {
        if (current.isNihil()) {
            return false;
        }
        boolean foundElement = element.compareTo(current.value) == 0;
        boolean isElementSmaller = element.compareTo(current.value) < 0;
        if (foundElement) {
            return true;
        } else if (isElementSmaller) {
            return this.contains(current.left, element);
        } else {
            return this.contains(current.right, element);
        }
    }

    @Override
    public T minimum() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this.minimum(this.root);
        }
    }

    private T minimum(Node<T> current) {
        if (current.left.isNihil()) {
            return current.value;
        }
        return this.minimum(current.left);
    }

    @Override
    public T maximum() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this.maximum(this.root);
        }
    }

    private T maximum(Node<T> current) {
        if (current.right.isNihil()) {
            return current.value;
        }
        return this.maximum(current.right);
    }

    @Override
    public T[] preOrder() {
        if (this.isEmpty()) {
            return (T[]) new Comparable[0];
        }
        ArrayList<T> list = new ArrayList<>(this.size);
        this.preOrder(this.root, list);
        return list.toArray((T[]) new Comparable[0]);
    }

    private void preOrder(Node<T> current, ArrayList<T> list) {
        if (!current.isNihil()) {
            list.add(current.value);
            this.preOrder(current.left, list);
            this.preOrder(current.right, list);
        }
    }

    @Override
    public T[] inOrder() {
        if (this.isEmpty()) {
            return (T[]) new Comparable[0];
        }
        ArrayList<T> list = new ArrayList<>(this.size);
        this.inOrder(this.root, list);
        return list.toArray((T[]) new Comparable[0]);
    }

    private void inOrder(Node<T> current, ArrayList<T> list) {
        if (!current.isNihil()) {
            this.inOrder(current.left, list);
            list.add(current.value);
            this.inOrder(current.right, list);
        }
    }

    @Override
    public T[] postOrder() {
        if (this.isEmpty()) {
            return (T[]) new Comparable[0];
        }
        ArrayList<T> list = new ArrayList<>(this.size);
        this.postOrder(this.root, list);
        return list.toArray((T[]) new Comparable[0]);
    }

    private void postOrder(Node<T> current, ArrayList<T> list) {
        if (!current.isNihil()) {
            this.postOrder(current.left, list);
            this.postOrder(current.right, list);
            list.add(current.value);
        }
    }

    @Override
    public T[] breadthFirst() {
        throw new UnsupportedOperationException("Not yet implemented!");
    }

    private class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> parent;
        private Node<T> left;
        private Node<T> right;

        Node(T value, Node<T> parent) {
            this.value = value;
            this.parent = parent;
            this.left = new Node<>();
            this.right = new Node<>();
        }

        Node() {
            this.value = null;
            this.parent = null;
            this.left = null;
            this.right = null;
        }

        private boolean isNihil() {
            return this.value == null;
        }

        @Override
        public String toString() {
            return this.isNihil() ? "nihil" : this.value.toString();
        }
    }
}
