from typing import List


def heapSort(a: List[int]):
    n: int = len(a)
    i = int(n / 2 - 1)
    while (i >= 0):
        percDown(a, i, n)
        i = i - 1
    i = n-1
    while (i > 0):
        swap(a, 0, i)
        percDown(a, 0, i)


def swap(a: List[int], i: int, j: int):
    k = a[i]
    a[i] = a[j]
    a[j] = k


def percDown(a: List[int], p: int, n: int):
    x = a[p]
    parent = p
    while ((parent * 2 + 1) < n):
        child = parent * 2 + 1
        if (child != n - 1 and a[child] < a[child - 1]):
            child = child + 1
        if (x >= a[child]):
            break
        else:
            a[parent] = a[child]
        parent = child
    a[parent] = x


if __name__ == "__main__":
    a = [0, 4, 2, 3, 1]
    print(heapSort(a))
