def Quicksort(A, p, r):
    if p < r:
        q = Partition(A, p, r)
        [A[q], A[p]] = swap(A[q], A[p])
        print('q = '+str(q))
        print(A)
        Quicksort(A, p, q-1)
        Quicksort(A, q+1, r)


def Partition(A, p, r):
    x = A[p]
    i = p
    j = r
    while True:
        while A[j] > x and j > p:
            j = j-1
        while A[i] <= x and i < r:
            i = i+1
        print('i = '+str(i) + ' j = '+str(j))
        print('ai = ' + str(A[i]) + ' aj = ' + str(A[j]))
        if i < j:
            [A[i], A[j]] = swap(A[i], A[j])
        else:
            return j


def swap(a, b):
    return b, a


if __name__ == '__main__':
    # A = [27, 99, 0, 8, 13, 64, 86, 16, 7, 10, 88, 25, 90]
    # A = [1,1,1]
    # A  = [1,2,3]
    # A = [3,2,1]
    A = [1,2,3,3,2,1]
    p = 0
    r = len(A)-1
    Quicksort(A, p, r)
    print(A)
