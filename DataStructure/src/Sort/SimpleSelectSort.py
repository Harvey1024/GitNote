from typing import List


def SimpleSelectSort(a: List[int]) -> List[int]:
    n = len(a)
    k = 0
    for i in range(n-1):
        k = findMin(a[i:n])
        k = i + k
        swap(a, i, k)
    return a

def findMin(a):
    minA = a[0]
    k = 0
    for i in range(len(a)):
        if (a[i] < minA):
            minA = a[i]
            k = i
    return k


def swap(a, i: int, j: int):
    z = a[i]
    a[i] = a[j]
    a[j] = z


if __name__ == "__main__":
    a = [3, 2, 1, 0, 4, 8]
    print(SimpleSelectSort(a))
