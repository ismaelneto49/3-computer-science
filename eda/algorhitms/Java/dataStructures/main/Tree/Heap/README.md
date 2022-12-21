# Heap

## Methods

### insert(element)

    • guarantees that the heap has enough space
    • adds element to the end of the array
    • swaps elements until parent is greater than element

    ensureCapacity()
    heap[++tail] = element
    index = tail
    while index > 0 and parent(index) < heap[index]
        swap(index, parent(index))
        index = parent(index)

### remove()

    removes the root of the heap
    root = heap[tail--] 
    heapify(0)

### heapify(index)

    if !isLeaf(index) and isValid(index)
        gets the index of the greatest value among an element, its left and its right
        maxElementIndex = getMaxElementIndex(index, left(index), right(index))
        if maxElementIndex != index
            swap(index, maxElementIndex)
            heapify(maxElementIndex)

### buildHeap(array)

    receives an array and returns a heap made from it
    heap = array
    for index from parent(tail) to 0, descending
        heapify(index)

### parent(index)

    returns (index - 1) / 2

### left(index)

    returns 2 * index + 1

### right(index)

    returns 2 * index + 2

### isValid(index)

    return if index is between 0 and tail
    index >= 0 and index <= tail

### isLeaf(index)

    returns if index is between tail parent and tail itself
    index > parent(tail) and index <= tail

### size()

    return tail + 1