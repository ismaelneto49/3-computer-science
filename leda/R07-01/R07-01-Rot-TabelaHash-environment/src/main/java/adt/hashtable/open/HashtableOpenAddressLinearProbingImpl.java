package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends AbstractHashtableOpenAddress<T> {

    public HashtableOpenAddressLinearProbingImpl(int size, HashFunctionClosedAddressMethod method) {
        super(size);
        hashFunction = new HashFunctionLinearProbing<T>(size, method);
        this.initiateInternalTable(size);
    }

    @Override
    public void insert(T element) {
        for (int i = 0; i < this.table.length; i++) {
            int keyHash = ((HashFunctionLinearProbing) this.hashFunction).hash(element, i);
            if (this.table[keyHash] != null && !this.table[keyHash].equals(deletedElement)) {
                if (this.table[keyHash].equals(element)) {
                    this.table[keyHash] = element;
                } else {
                    this.COLLISIONS++;
                }
            } else {
                this.table[keyHash] = element;
                this.elements++;
                break;
            }
        }
    }

    @Override
    public void remove(T element) {
        if (!this.isEmpty()) {
            for (int i = 0; i < this.table.length; i++) {
                int keyHash = ((HashFunctionLinearProbing) this.hashFunction).hash(element, i);
                if (this.table[keyHash] != null) {
                    if (this.table[keyHash].equals(element)) {
                        this.table[keyHash] = this.deletedElement;
                        this.elements--;
                        break;
                    }
                }
            }
        }
    }

    @Override
    public T search(T element) {
        return this.indexOf(element) == -1 ? null : element;
    }

    @Override
    public int indexOf(T element) {
        for (int i = 0; i < this.table.length; i++) {
            int keyHash = ((HashFunctionLinearProbing) this.hashFunction).hash(element, i);
            if (this.table[keyHash] != null) {
                if (this.table[keyHash].equals(element)) {
                    return keyHash;
                }
            }
        }
        return -1;
    }

}
