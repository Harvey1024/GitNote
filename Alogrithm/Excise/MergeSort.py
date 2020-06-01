
def merge(A, p, q, r):
    B = [0]*(len(A))
    i = p
    j = q+1
    k = p
    while i<=q and j<=r:
        if(A[i]<=A[j]):
            B[k] = A[i]
            k = k+1
            i = i+1
        else:
            B[k] = A[j]
            k = k+1
            j = j+1

    while i<=q:
        B[k]=A[i]
        k = k+1
        i = i+1
    while j<=r:
        B[k]=A[j]
        k = k+1
        j = j+1
    # copy list from B to A
    k = p
    print(B)
    for i in range(r-p+1):
        A[k] = B[k]
        k = k+1
    print(A)


def mergeSort(A, p, r):
    if(p < r):
        q = int((p+r)/2)
        print(r)
        mergeSort(A, p, q)
        mergeSort(A, q+1, r)
        merge(A,p,q,r)

if __name__ == '__main__':
    A = [8, 3, 2, 9, 7, 1, 5, 4]
    p = 0
    q = len(A)-1
    mergeSort(A, p, q)
    print(A)
    # A = [3,8,19,1]
    # merge(A,0,1,2)
    # print(A)