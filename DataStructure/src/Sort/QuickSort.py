from typing import List


def QSort(a: List[int]):
    QuickSort(a, 0, len(a)-1)


def QuickSort(a: List[int], i: int, j: int):
    left = i
    right = j
    k = left + int((j-i)/2)
    swap(a, k, right)
    pivot = median(a, left, right)
    while(i < j):
        while (a[i] <= pivot):
            i = i + 1
        while (a[j] > pivot):
            j = j - 1
    swap(a, i, right)
    QuickSort(a, left, i-1)
    QuickSort(a, i+1, right)


def median(a, left, right):
    center = int((left + right) / 2)
    if (a[left] > a[center]):
        swap(a, left, center)
    if (a[left] > a[right]):
        swap(a, left, right)
    if (a[center] > a[right]):
        swap(a, center, right)
    swap(a, center, right-1)
    return a[right-1]


def swap(a: List[int], i: int, j: int):
    k = a[i]
    a[i] = a[j]
    a[j] = k


if __name__ == "__main__":
    a = [4, 1, 2, 6, 3, 2, 7, 8, 9, 2, 3]
    QSort(a)
    print(a)
