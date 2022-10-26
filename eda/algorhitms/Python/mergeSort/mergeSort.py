def mergeSort(array, start, end):
    mid = (start + end) // 2
    if start < end:
        mergeSort(array, start, mid)
        mergeSort(array, mid + 1, end)
        merge(array, start, end)


def merge(array, start, end):
    helper = []
    for e in array:
        helper.append(e)

    mid = (start + end) // 2
    i = start
    j = mid + 1
    k = start
    while (i <= mid and j <= end):
        if helper[i] <= helper[j]:
            array[k] = helper[i]
            i += 1
        else:
            array[k] = helper[j]
            j += 1
        k += 1

    while (i <= mid):
        array[k] = helper[i]
        k += 1
        i += 1

    while (j <= end):
        array[k] = helper[j]
        k += 1
        j += 1


array = [9, 3, 7, 99, 5, 2]
mergeSort(array, 0, len(array) - 1)
print(array)
