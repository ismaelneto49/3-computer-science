package Tree.BinarySearchTree;

public interface BinarySearchTree<T extends Comparable<T>> {

    void insert(T element);

    void remove(T element);

    int height();

    int size();

    boolean isEmpty();

    boolean contains(T element);

    T minimum();

    T maximum();

    T successor(T element);

    T predecessor(T element);

    T[] preOrder();

    T[] inOrder();

    T[] postOrder();

    T[] breadthFirst();
}
