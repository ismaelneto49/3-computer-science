def bubbleSort(array, start, end):
    for i in range(start, end + 1):
        swapped = False
        for j in range(i + 1, end + 1):
            if array[i] >= array[j]:
                swap(array, i, j)
                swapped = True
        if not swapped:
            break


def swap(array, id1, id2):
    temp = array[id1]
    array[id1] = array[id2]
    array[id2] = temp


array = [9, 3, 7, 99, 5, 2]
bubbleSort(array, 0, len(array) - 1)
print(array)
