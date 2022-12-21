# Binary Search Tree

## Methods

### insert(element)

    if the bst isEmpty(), bst root = element
    else, calls insert recursively starting from the root
        recursiveInsert(currentNode)
            if currentNode is smaller than its parent
                if currentNode does not have left, then it is added to the left of its parent
                else, call recursiveInsert(currentNode.left)
            if currentNode is greater than its parent
                if currentNode does not have right, then it is added to the right of its parent
                else, call recursiveInsert(currentNode.right)

### remove(element)

    searchs for the node which has element for value
    calls remove(node)
    remove has three cases:
        • if node has 0 children (node is a leaf)
            if node is the root, then root = nihil
            else 
                if node isLeftChild(), then set parent.left = nihil
            else
                if node isRightChild(), then set parent.right = nihil

        • if node has 1 child
            if node hasOnlyLeftChild()
                if node is the root, then root = node.left
                else 
                    node.left.parent = node.parent
                    if node isLeftChild()
                        node.parent.left = node.left
                    if node isRightChild()
                        node.parent.right = node.left
            if node hasOnlyRightChild()
                if node is the root, then root = node.right
                else
                    node.right.parent = node.parent
                    if node isLeftChild()
                        node.parent.left = node.right
                    if node isRightChild()
                        node.parent.right = node.right

        • else if node has 2 children
            successor = successor(element)
            node.value = successor.value
            remove(successor)

### height()

    calls height(root)
        if the bst isEmpty(), returns -1
        else, returns 1 + max(height(current.left), height(current.right))

### size()

    calls preOrder() and returns array length

### isEmpty()

    returns whether the bst root is empty

### contains(element)

    if the bst isEmpty(), return null
    else calls contains(root, element)
        if current node is equal to element, returns true and stops recursion

### minimum(element)

    if the bst isEmpty(), return null
    else calls minimum(root)
        while current node has left, walk left
        returns leftest element

### maximum(element)

    if the bst isEmpty(), return null
    else calls maximum(root)
        while current node has right, walk right
        returns rightest element

### successor(element)

    if the bst isEmpty(), return null
    if node hasRight(), return minimum(node.right)
    else 
        walks backwards until the parent is greater than the node
        temp = node.parent
        while temp != null and temp.value < node.value
            temp = temp.parent
        return temp

### predecessor(element)

    if the bst isEmpty(), return null
    if node hasLeft(), return maximum(node.left)
    else 
        walks backwards until the parent is smaller than the node
        temp = node.parent
        while temp != null and temp.value > node.value
            temp = temp.parent
        return temp

### preOrder()

    walks recursively over the bst, following the order:
        • visit the node
        • visit node.left
        • visit node.right
    the result is unique to each bst

### inOrder()

    walks recursively over the bst, following the order:
        • visit node.left
        • visit the node
        • visit node.right
    the result is the bst elements ordered

### postOrder()

    walks recursively over the bst, following the order:
        • visit node.left
        • visit node.right
        • visit the node