package adt.bst;

import adt.bt.BTNode;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public BSTNode<T> search(T element) {
        if (this.isEmpty()) {
            return null;
        }
        return this.search(element, this.root);
    }

    private BSTNode<T> search(T element, BSTNode<T> node) {
        Integer comparison = node.getData().compareTo(element);
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
        } else {
            this.insert(element, this.root);
        }
    }

    private void insert(T element, BSTNode<T> node) {
        if (node.isEmpty()) {
            node.setData(element);
            node.setLeft(new BSTNode.Builder<T>()
                    .parent(this.root)
                    .build());
            node.setRight(new BSTNode.Builder<T>()
                    .parent(this.root)
                    .build());
        } else {
            Integer comparison = node.getData().compareTo(element);
            boolean elementIsGreater = comparison < 0;

            if (node.isLeaf()) {
                BSTNode<T> newNode = new BSTNode.Builder<T>()
                        .data(element)
                        .left(new BSTNode<T>())
                        .right(new BSTNode<T>())
                        .parent(node)
                        .build();
                newNode.getRight().setParent(newNode);
                newNode.getLeft().setParent(newNode);
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
        if (!node.getRight().isEmpty()) {
            while (!node.isLeaf() && !node.getLeft().isEmpty()) {
                node = (BSTNode<T>) node.getLeft();
            }
        } else {
            boolean isNodeGreater = node.getData().compareTo(element) > 0;
            while (!isNodeGreater && !(node.getParent() == null)) {
                node = (BSTNode<T>) node.getParent();
            }
        }
        return node;
    }

    @Override
    public BSTNode<T> predecessor(T element) {
        return null;
    }

    @Override
    public void remove(T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public T[] preOrder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public T[] order() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public T[] postOrder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Not implemented yet!");
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
