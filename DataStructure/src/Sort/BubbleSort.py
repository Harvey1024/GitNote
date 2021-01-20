from typing import List


def BubbleSort(a: List[int]):
    N = len(a)
    i = 0
    key = 1
    count = 0
    while (key == 1):
        key = 0
        for j in range(N-1):
            if (a[j] > a[j + 1]):
                swap(a, j, j + 1)
                key = 1
        count = count + 1
    print(count)


def swap(a: List[int], i: int, j: int):
    k = a[i]
    a[i] = a[j]
    a[j] = k


if __name__ == "__main__":
    a = [8, 4, 5, 1, 3, 8, 2, 4]
    BubbleSort(a)
    print(a)
