package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

    @Override
    public Integer floor(Integer[] array, double numero) {
        for (Integer element : array) {
            this.insert(element);
        }
        int number = (int) numero;
        Integer result = this.floor(this.root, number);
        return result.equals(Integer.MAX_VALUE) ? null : result;
    }

    private Integer floor(BSTNode<Integer> node, int number) {
        if (!node.isEmpty()) {
            if (node.getData().compareTo(number) == 0) {
                return node.getData();
            }
            if (node.getData().compareTo(number) > 0) {
                return floor((BSTNode<Integer>) node.getLeft(), number);
            }
            Integer result = floor((BSTNode<Integer>) node.getRight(), number);
            return (result.compareTo(number) <= 0) ? result : node.getData();
        }
        return Integer.MAX_VALUE;
    }

    @Override
    public Integer ceil(Integer[] array, double numero) {
        for (Integer element : array) {
            this.insert(element);
        }
        int number = (int) numero;
        Integer result = this.ceil(this.root, number);
        return result.equals(Integer.MIN_VALUE) ? null : result;
    }

    private Integer ceil(BSTNode<Integer> node, int number) {
        if (!node.isEmpty()) {
            if (node.getData().compareTo(number) == 0) {
                return node.getData();
            }
            if (node.getData().compareTo(number) < 0) {
                return ceil((BSTNode<Integer>) node.getRight(), number);
            }
            Integer result = ceil((BSTNode<Integer>) node.getLeft(), number);
            return (result.compareTo(number) >= 0) ? result : node.getData();
        }
        return Integer.MIN_VALUE;
    }

}
