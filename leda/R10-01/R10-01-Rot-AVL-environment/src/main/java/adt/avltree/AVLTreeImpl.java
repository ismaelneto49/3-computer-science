package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.BTNode;

/**
 * Implementacao de uma arvore AVL
 * A CLASSE AVLTree herda de BSTImpl. VOCE PRECISA SOBRESCREVER A IMPLEMENTACAO
 * DE BSTIMPL RECEBIDA COM SUA IMPLEMENTACAO "OU ENTAO" IMPLEMENTAR OS SEGUITNES
 * METODOS QUE SERAO TESTADOS NA CLASSE AVLTREE:
 * - insert
 * - preOrder
 * - postOrder
 * - remove
 * - height
 * - size
 *
 * @param <T>
 * @author Claudio Campelo
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements AVLTree<T> {

    // TODO Do not forget: you must override the methods insert and remove
    // conveniently.

    @Override
    public void insert(T element) {
        super.insert(element);
        //this.rebalance(this.root);
    }

    @Override
    public void remove(T element) {
        super.remove(element);
        //this.rebalance(this.root);
    }


    // AUXILIARY
    protected int calculateBalance(BSTNode<T> node) {
        return this.height((BSTNode<T>) node.getLeft()) - this.height((BSTNode<T>) node.getRight());
    }

    // AUXILIARY
    protected void rebalance(BSTNode<T> node) {
    }

    // AUXILIARY
    protected void rebalanceUp(BSTNode<T> node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    private void rotateLeft(BSTNode<T> node) {
        BSTNode<T> parent = (BSTNode<T>) node.getParent();
        BSTNode<T> rotated = (BSTNode<T>) node.getRight();
        rotated.setParent(node.getParent());
        rotated.setLeft(node);
        node.setParent(rotated);
        node.setRight(new BSTNode<>());
        node.getRight().setParent(node);

        boolean isNodeLeftChild = parent.getData().compareTo(node.getData()) > 0;
        if (isNodeLeftChild) {
            rotated.getParent().setLeft(rotated);
        } else {
            rotated.getParent().setRight(rotated);
        }
    }

    private void rotateRight(BSTNode<T> node) {
        BSTNode<T> parent = (BSTNode<T>) node.getParent();
        BSTNode<T> grandparent = (BSTNode<T>) parent.getParent();
        parent.setLeft(node.getRight());
        node.setRight(parent);
        node.setParent(grandparent);
        node.getRight().setParent(node);
        parent.getLeft().setParent(parent);
    }
}
