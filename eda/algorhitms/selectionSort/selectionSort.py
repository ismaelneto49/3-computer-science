def selectionSort(array, start, end):
    for i in range(start, end + 1):
        indexSmallest = getIndexSmallest(array, start + i, end)
        swap(array, indexSmallest, i)


def getIndexSmallest(array, start, end):
    indexSmallest = start
    for i in range(start, end + 1):
        if array[i] < array[indexSmallest]:
            indexSmallest = i
    return indexSmallest


def swap(array, id1, id2):
    temp = array[id1]
    array[id1] = array[id2]
    array[id2] = temp


array = [9, 3, 7, 99, 5, 2]
selectionSort(array, 0, len(array) - 1)
print(array)
