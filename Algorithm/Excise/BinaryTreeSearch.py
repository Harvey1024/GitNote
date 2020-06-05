# Binary Tree Search Algorithm
def BinaryTreeSearch(S, a, b):
    n = len(S)
    m = [[0 for i in range(n+1)] for j in range(n+2)]
    w = [[0 for i in range(n+1)] for j in range(n+2)]
    for i in range(n):
        i = i+1
        w[i][i-1] = a[i-1]
    for t in range(n-1):
        # t: 2~n
        t = t+2
        # i: [1~2]~[1~n]
        for i in range(t):
            i = i+1
            j = i+t-1
            w[i][j] = w[i][j-1] + a[j]+b[j-1]
            for k in range(j-i+1):
                k = k+i
                m[i][j] = min(m[i][k-1]+m[k+1][j])+w[i][j]
    print(m)


if __name__ == '__main__':
    S = [1, 2, 3, 4, 5]
    a = [0.04, 0.02, 0.02, 0.05, 0.06, 0.01]
    b = [0.1, 0.3, 0.1, 0.2, 0.1]
    x = 3.4
    BinaryTreeSearch(S, a, b)
