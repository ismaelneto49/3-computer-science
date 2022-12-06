package adt.bst;

/**
 * - Esta eh a unica classe que pode ser modificada
 *
 * @param <T>
 * @author adalbertocajueiro
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

    @Override
    public boolean equals(BST<T> tree1, BST<T> tree2) {
        return this.equals((BSTNode<T>) tree1.getRoot(), (BSTNode<T>) tree2.getRoot());
    }

    private boolean equals(BSTNode<T> node1, BSTNode<T> node2) {
        if (node1.equals(node2)) {
            if (node1.isEmpty()) {
                return true;
            }
            return this.equals((BSTNode<T>) node1.getLeft(), (BSTNode<T>) node2.getLeft()) &&
                    this.equals((BSTNode<T>) node1.getRight(), (BSTNode<T>) node2.getRight());
        }
        return false;
    }

    @Override
    public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
        return this.isSimilar((BSTNode<T>) tree1.getRoot(), (BSTNode<T>) tree2.getRoot());
    }

    private boolean isSimilar(BSTNode<T> node1, BSTNode<T> node2) {
        boolean areBothNodesNIL = node1.isEmpty() && node2.isEmpty();
        boolean isOnlyNode1NIL = node1.isEmpty() && !node2.isEmpty();
        boolean isOnlyNode2NIL = !node1.isEmpty() && node2.isEmpty();
        if (areBothNodesNIL) {
            return true;
        } else if (isOnlyNode1NIL || isOnlyNode2NIL) {
            return false;
        } else {
            return this.isSimilar((BSTNode<T>) node1.getLeft(), (BSTNode<T>) node2.getLeft()) &&
                    this.isSimilar((BSTNode<T>) node1.getRight(), (BSTNode<T>) node2.getRight());
        }
    }

    @Override
    public T orderStatistic(BST<T> tree, int k) {
        if (k < 1 || k > tree.size()) {
            return null;
        }
        int count = 1;
        return this.orderStatistic(tree, tree.minimum(), count, k);
    }

    private T orderStatistic(BST<T> tree, BSTNode<T> node, int count, int k) {
        if (count == k) {
            return node.getData();
        } else {
            BSTNode<T> successor = tree.sucessor(node.getData());
            return orderStatistic(tree, successor, ++count, k);
        }
    }
}
