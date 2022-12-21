package Tree.AVLTree;


import Tree.BinarySearchTree.BinarySearchTreeImpl;

public class AVLTreeImpl<T extends Comparable<T>> extends BinarySearchTreeImpl<T> implements AVLTree<T> {

    private Node<T> root;
    private int size;

    public AVLTreeImpl() {
        this.root = new Node<>();
    }

    @Override
    public void insert(T element) {
        if (this.isEmpty()) {
            this.root = new Node<>(element, null);
        } else {
            this.insert(this.root, element);
        }
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
            this.rebalance(current);
        } else if (isElementGreater) {
            if (current.right.isNihil()) {
                current.right = new Node<>(element, current);
            } else {
                this.insert(current.right, element);
            }
            this.rebalance(current);
        }
    }

    private void rebalance(Node<T> node) {
        int balance = this.calculateBalance(node);
        if (Math.abs(balance) >= 2) {
            this.useBestRotation(node);
        }
    }

    private int calculateBalance(Node<T> node) {
        return this.height(node.left) - this.height(node.right);
    }

    private void useBestRotation(Node<T> node) {
        if (this.isLeaningLeft(node)) {
            Node<T> left = node.left;
            Node<T> lefter = left.left;
            if (lefter != null && !lefter.isNihil()) {
                this.rotateRight(node);
            } else {
                this.rotateLeft(left);
                this.rotateRight(node);
            }
        } else if (this.isLeaningRight(node)) {
            Node<T> right = node.right;
            Node<T> righter = right.right;
            if (righter != null && !righter.isNihil()) {
                this.rotateLeft(node);
            } else {
                this.rotateRight(right);
                this.rotateLeft(node);
            }
        }
    }

    private boolean isLeaningLeft(Node<T> node) {
        return this.calculateBalance(node) >= 1;
    }

    private boolean isLeaningRight(Node<T> node) {
        return this.calculateBalance(node) <= -1;
    }

    private boolean isBalanced(Node<T> node) {
        return this.calculateBalance(node) == 0;
    }

    private void rotateRight(Node<T> node) {
        Node<T> newRoot = node.left;
        newRoot.parent = node.parent;
        node.left = newRoot.right;
        newRoot.right = node;
        node.parent = newRoot;

        Node<T> parent = newRoot.parent;
        if (!parent.isNihil()) {
            if (parent.left.equals(node)) {
                parent.left = newRoot;
            } else {
                parent.right = newRoot;
            }
        } else {
            this.root = newRoot;
        }

    }

    private void rotateLeft(Node<T> node) {
        Node<T> newRoot = node.right;
        newRoot.parent = node.parent;
        node.right = newRoot.left;
        newRoot.left = node;
        node.parent = newRoot;

        Node<T> parent = newRoot.parent;
        if (!parent.isNihil()) {
            if (parent.right.equals(node)) {
                parent.right = newRoot;
            } else {
                parent.left = newRoot;
            }
        } else {
            this.root = newRoot;
        }
    }


    @Override
    public void remove(T element) {
        super.remove(element);
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
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node<T> node = (Node<T>) o;
            return node.value.compareTo(this.value) == 0;
        }

        @Override
        public String toString() {
            return this.isNihil() ? "nihil" : this.value.toString();
        }
    }

}
