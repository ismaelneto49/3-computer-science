package adt.bst;

/**
 * Performs consistency validations within a BST instance
 *
 * @param <T>
 * @author Claudio Campelo
 */
public class BSTVerifierImpl<T extends Comparable<T>> implements BSTVerifier<T> {

    private BSTImpl<T> bst;

    public BSTVerifierImpl(BST<T> bst) {
        this.bst = (BSTImpl<T>) bst;
    }

    private BSTImpl<T> getBSt() {
        return bst;
    }

    @Override
    public boolean isBST() {
        return this.isBST(this.bst.root);
    }

    private boolean isBST(BSTNode<T> node) {
        if (node.isEmpty()) {
            return true;
        }

        T maximum = this.maxValue((BSTNode<T>) node.getLeft());
        if (maximum != null) {
            boolean isLeftGreater = maximum.compareTo(node.getData()) > 0;
            if (!node.getLeft().isEmpty() && isLeftGreater) {
                return false;
            }
        }

        T minimum = this.minValue((BSTNode<T>) node.getRight());
        if (minimum != null) {
            boolean isRightSmaller = minimum.compareTo(node.getData()) < 0;
            if (!node.getRight().isEmpty() && isRightSmaller) {
                return false;
            }
        }

        if (!this.isBST((BSTNode<T>) node.getLeft()) || !this.isBST((BSTNode<T>) node.getRight())) {
            return false;
        }
        return true;
    }

    private T maxValue(BSTNode<T> current) {
        if (!current.isEmpty()) {
            if (current.getRight().isEmpty()) {
                return current.getData();
            }
            return this.maxValue((BSTNode<T>) current.getRight());
        }
        return null;
    }

    private T minValue(BSTNode<T> current) {
        if (!current.isEmpty()) {
            if (current.getLeft().isEmpty()) {
                return current.getData();
            }
            return this.maxValue((BSTNode<T>) current.getLeft());
        }
        return null;
    }

}
