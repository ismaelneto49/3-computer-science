package adt.hashtable.closed;

import adt.hashtable.hashfunction.*;
import adt.hashtable.open.HashtableElement;
import util.Util;

import java.util.LinkedList;
import java.util.List;

public class HashtableClosedAddressImpl<T> extends AbstractHashtableClosedAddress<T> {

    /**
     * A hash table with closed address works with a hash function with closed
     * address. Such a function can follow one of these methods: DIVISION or
     * MULTIPLICATION. In the DIVISION method, it is useful to change the size
     * of the table to an integer that is prime. This can be achieved by
     * producing such a prime number that is bigger and close to the desired
     * size.
     * <p>
     * For doing that, you have auxiliary methods: Util.isPrime and
     * getPrimeAbove as documented bellow.
     * <p>
     * The length of the internal table must be the immediate prime number
     * greater than the given size (or the given size, if it is already prime).
     * For example, if size=10 then the length must
     * be 11. If size=20, the length must be 23. You must implement this idea in
     * the auxiliary method getPrimeAbove(int size) and use it.
     *
     * @param desiredSize
     * @param method
     */

    @SuppressWarnings({"rawtypes", "unchecked"})
    public HashtableClosedAddressImpl(int desiredSize, HashFunctionClosedAddressMethod method) {
        int realSize = desiredSize;

        if (method == HashFunctionClosedAddressMethod.DIVISION) {
            realSize = this.getPrimeAbove(desiredSize); // real size must the
            // the immediate prime
            // above
        }
        initiateInternalTable(realSize);
        HashFunction function = HashFunctionFactory.createHashFunction(method, realSize);
        this.hashFunction = function;
    }

    // AUXILIARY

    /**
     * It returns the prime number that is closest (and greater) to the given
     * number.
     * If the given number is prime, it is returned.
     * You can use the method Util.isPrime to check if a number is
     * prime.
     */
    int getPrimeAbove(int number) {
        while (!Util.isPrime(number)) {
            number++;
        }
        return number;
    }

    @Override
    public void insert(T element) {
        int keyHash = ((HashFunctionClosedAddress) this.hashFunction).hash(element);
        if (this.table[keyHash] == null) {
            this.table[keyHash] = new LinkedList<>();
        } else if (((List<HashtableElement>) this.table[keyHash]).size() > 0) {
            this.COLLISIONS++;
        }
        T value = this.search(element);
        List<HashtableElement> list = ((List<HashtableElement>) this.table[keyHash]);
        HashtableElement node = new HashtableElement((Integer) element);
        if (value == null) {
            list.add(node);
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(element)) {
                    list.add(i, node);
                }
            }
        }
        this.elements++;
    }

    @Override
    public void remove(T element) {
        int keyHash = ((HashFunctionClosedAddress) this.hashFunction).hash(element);
        List<HashtableElement> list = ((List<HashtableElement>) this.table[keyHash]);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(element)) {
                    list.remove(i);
                    this.elements--;
                }
            }
        }
    }

    @Override
    public T search(T element) {
        int keyHash = ((HashFunctionClosedAddress) this.hashFunction).hash(element);
        List<HashtableElement> list = ((List<HashtableElement>) this.table[keyHash]);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(element)) {
                    return element;
                }
            }
        }
        return null;
    }

    @Override
    public int indexOf(T element) {
        for (int i = 0; i < this.table.length; i++) {
            List<HashtableElement> list = ((List<HashtableElement>) this.table[i]);
            if (list != null) {
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).equals(element)) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

}
