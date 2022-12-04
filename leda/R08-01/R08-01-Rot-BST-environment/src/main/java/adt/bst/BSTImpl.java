package adt.bst;

import java.util.ArrayList;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

    protected BSTNode<T> root;

    public BSTImpl() {
        root = new BSTNode<T>();
    }

    public BSTNode<T> getRoot() {
        return this.root;
    }

    @Override
    public boolean isEmpty() {
        return root.isEmpty();
    }

    @Override
    public int height() {
        return height(this.root);
    }

    private int height(BSTNode<T> node) {
        if (node.isEmpty()) {
            return -1;
        }
        return 1 + Math.max(height((BSTNode<T>) node.getLeft()), height((BSTNode<T>) node.getRight()));
    }


    @Override
    public BSTNode<T> search(T element) {
        if (this.isEmpty()) {
            return new BSTNode<>();
        }
        return this.search(element, this.root);
    }

    private BSTNode<T> search(T element, BSTNode<T> node) {
        if (node.isEmpty()) {
            return new BSTNode<>();
        }
        int comparison = node.getData().compareTo(element);
        boolean foundElement = comparison == 0;
        boolean elementIsGreater = comparison < 0;

        if (foundElement) {
            return node;
        }
        if (!node.isLeaf()) {
            if (elementIsGreater) {
                return this.search(element, (BSTNode<T>) node.getRight());
            } else {
                return this.search(element, (BSTNode<T>) node.getLeft());
            }
        } else {
            return new BSTNode<>();
        }
    }

    @Override
    public void insert(T element) {
        if (this.root.isEmpty()) {
            this.root.setData(element);
            this.root.setLeft(new BSTNode<>());
            this.root.setRight(new BSTNode<>());
            this.root.getLeft().setParent(this.root);
            this.root.getRight().setParent(this.root);
        } else {
            this.insert(element, this.root);
        }
    }

    private void insert(T element, BSTNode<T> node) {
        if (node.isEmpty()) {
            node.setData(element);
            node.setLeft(new BSTNode<>());
            node.setRight(new BSTNode<>());
            node.getLeft().setParent(node);
            node.getRight().setParent(node);
        } else {
            int comparison = node.getData().compareTo(element);
            boolean elementIsGreater = comparison < 0;

            if (node.isLeaf()) {
                BSTNode<T> newNode = new BSTNode.Builder<T>().data(element).left(new BSTNode<>()).right(new BSTNode<>()).parent(node).build();
                newNode.getLeft().setParent(newNode);
                newNode.getRight().setParent(newNode);
                if (elementIsGreater) {
                    node.setRight(newNode);
                } else {
                    node.setLeft(newNode);
                }
            } else {
                if (elementIsGreater) {
                    this.insert(element, (BSTNode<T>) node.getRight());
                } else {
                    this.insert(element, (BSTNode<T>) node.getLeft());
                }
            }
        }
    }

    @Override
    public BSTNode<T> maximum() {
        if (this.isEmpty()) {
            return null;
        }
        BSTNode<T> temp = this.root;
        while (!temp.isLeaf() && !temp.getRight().isEmpty()) {
            temp = (BSTNode<T>) temp.getRight();
        }
        return temp;
    }

    @Override
    public BSTNode<T> minimum() {
        if (this.isEmpty()) {
            return null;
        }
        BSTNode<T> temp = this.root;
        while (!temp.isLeaf() && !temp.getLeft().isEmpty()) {
            temp = (BSTNode<T>) temp.getLeft();
        }
        return temp;
    }

    @Override
    public BSTNode<T> sucessor(T element) {
        BSTNode<T> node = this.search(element);
        if (!node.isEmpty()) {
            if (!node.getRight().isEmpty()) {
                node = (BSTNode<T>) node.getRight();
                while (!node.isLeaf() && !node.getLeft().isEmpty()) {
                    node = (BSTNode<T>) node.getLeft();
                }
            } else {
                while (node != null && node.getData().compareTo(element) <= 0) {
                    node = (BSTNode<T>) node.getParent();
                }
            }
            return node;
        }
        return null;
    }

    @Override
    public BSTNode<T> predecessor(T element) {
        BSTNode<T> node = this.search(element);
        if (!node.isEmpty()) {
            if (!node.getLeft().isEmpty()) {
                node = (BSTNode<T>) node.getLeft();
                while (!node.isLeaf() && !node.getRight().isEmpty()) {
                    node = (BSTNode<T>) node.getRight();
                }
            } else {
                while (node != null && node.getData().compareTo(element) >= 0) {
                    node = (BSTNode<T>) node.getParent();
                }
            }
            return node;
        }
        return null;
    }

    @Override
    public void remove(T element) {
        BSTNode<T> node = this.search(element);
        this.remove(node);
    }

    private void remove(BSTNode<T> node) {
        BSTNode<T> parent = (BSTNode<T>) node.getParent();
        T element = node.getData();
        if (node.isLeaf()) {
            boolean isNodeRoot = parent == null;
            if (isNodeRoot) {
                this.root = new BSTNode<>();
            } else {
                boolean isParentGreater = parent.getData().compareTo(element) > 0;
                if (isParentGreater) {
                    parent.setLeft(new BSTNode<>());
                } else {
                    parent.setRight(new BSTNode<>());
                }
            }
        } else if (this.hasOneChild(node)) {
            boolean isNodeRoot = parent == null;
            if (isNodeRoot) {
                this.root = new BSTNode<>();
            } else {
                boolean isParentGreater = parent.getData().compareTo(element) > 0;
                if (this.hasOnlyLeft(node)) {
                    node.getLeft().setParent(parent);
                    if (isParentGreater) {
                        parent.setLeft(node.getLeft());
                    } else {
                        parent.setRight(node.getLeft());
                    }
                } else if (this.hasOnlyRight(node)) {
                    node.getRight().setParent(parent);
                    if (isParentGreater) {
                        parent.setLeft(node.getRight());
                    } else {
                        parent.setRight(node.getRight());
                    }
                }
            }

        } else {
            BSTNode<T> sucessor = this.sucessor(node.getData());
            node.setData(sucessor.getData());
            this.remove(sucessor);
        }
    }

    private boolean hasOneChild(BSTNode<T> node) {
        return this.hasOnlyLeft(node) || this.hasOnlyRight(node);
    }

    private boolean hasOnlyLeft(BSTNode<T> node) {
        boolean onlyLeftChild = node.getRight().isEmpty() && !node.getLeft().isEmpty();
        return onlyLeftChild;
    }

    private boolean hasOnlyRight(BSTNode<T> node) {
        boolean onlyRightChild = node.getLeft().isEmpty() && !node.getRight().isEmpty();
        return onlyRightChild;
    }


    @Override
    public T[] preOrder() {
        if (this.isEmpty()) {
            return (T[]) new Comparable[0];
        }
        ArrayList<T> list = new ArrayList<>();
        list.add(this.root.getData());
        this.preOrder(list, (BSTNode<T>) this.root.getLeft());
        this.preOrder(list, (BSTNode<T>) this.root.getRight());
        return list.toArray((T[]) new Comparable[0]);
    }

    private void preOrder(ArrayList<T> list, BSTNode<T> node) {
        if (!node.isEmpty()) {
            list.add(node.getData());
            this.preOrder(list, (BSTNode<T>) node.getLeft());
            this.preOrder(list, (BSTNode<T>) node.getRight());
        }
    }

    @Override
    public T[] order() {
        if (this.isEmpty()) {
            return (T[]) new Comparable[0];
        }
        ArrayList<T> list = new ArrayList<>();
        this.order(list, (BSTNode<T>) this.root.getLeft());
        list.add(this.root.getData());
        this.order(list, (BSTNode<T>) this.root.getRight());
        return list.toArray((T[]) new Comparable[0]);
    }

    private void order(ArrayList<T> list, BSTNode<T> node) {
        if (!node.isEmpty()) {
            this.order(list, (BSTNode<T>) node.getLeft());
            list.add(node.getData());
            this.order(list, (BSTNode<T>) node.getRight());
        }
    }

    @Override
    public T[] postOrder() {
        if (this.isEmpty()) {
            return (T[]) new Comparable[0];
        }
        ArrayList<T> list = new ArrayList<>();
        this.postOrder(list, (BSTNode<T>) this.root.getLeft());
        this.postOrder(list, (BSTNode<T>) this.root.getRight());
        list.add(this.root.getData());
        return list.toArray((T[]) new Comparable[0]);
    }

    private void postOrder(ArrayList<T> list, BSTNode<T> node) {
        if (!node.isEmpty()) {
            this.postOrder(list, (BSTNode<T>) node.getLeft());
            this.postOrder(list, (BSTNode<T>) node.getRight());
            list.add(node.getData());
        }
    }


    /**
     * This method is already implemented using recursion. You must understand
     * how it work and use similar idea with the other methods.
     */
    @Override
    public int size() {
        return size(root);
    }

    private int size(BSTNode<T> node) {
        int result = 0;
        // base case means doing nothing (return 0)
        if (!node.isEmpty()) { // indusctive case
            result = 1 + size((BSTNode<T>) node.getLeft()) + size((BSTNode<T>) node.getRight());
        }
        return result;
    }

}
