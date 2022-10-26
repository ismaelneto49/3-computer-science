def insertionSort(array, start, end):
    for i in range(start, end + 1):
        for j in range(i, start, -1):
            if array[j] <= array[j - 1]:
                swap(array, j, j - 1)
            else:
                break


def swap(array, id1, id2):
    temp = array[id1]
    array[id1] = array[id2]
    array[id2] = temp


array = [9, 3, 7, 99, 5, 2]
insertionSort(array, 0, len(array) - 1)
print(array)
