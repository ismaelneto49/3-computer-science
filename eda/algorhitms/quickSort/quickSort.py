import random


def quickSort(array, start, end):
    if start < end:
        pivot = partition(array, start, end)
        quickSort(array, start, pivot - 1)
        quickSort(array, pivot + 1, end)


def partition(array, start, end):
    choosePivot(array, start, end)
    pivot = array[start]
    k = start
    for i in range(start + 1, end + 1, 1):
        if array[i] <= pivot:
            k += 1
            swap(array, i, k)

    swap(array, start, k)
    return k


def choosePivot(array, start, end):
    randomPivot = random.randint(start, end)
    swap(array, randomPivot, start)


def swap(array, id1, id2):
    temp = array[id1]
    array[id1] = array[id2]
    array[id2] = temp


array = [9, 3, 7, 99, 5, 2]
quickSort(array, 0, len(array) - 1)
print(array)
