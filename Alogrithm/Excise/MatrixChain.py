
def MatrixChain(P, n):
    # Maxrix Ai: row = P[i-1], colum = P[i]
    # Matrix A1~An
    m = [[0 for i in range(n)] for j in range(n)]
    s = [[0 for i in range(n)] for j in range(n)]
    for r in range(n-2):
        # r = 2~n
        r = r+2
        for i in range(n-r):
            #  i = 1~n-r+1
            i = i + 1
            j = i+r-1
            m[i][j] = m[i][j-1]+P[i-1]*P[j-1]*P[j]
            s[i][j] = j-1
            for k in range(r-2):
                k = k+i
                t = m[i][k] + m[k+1][j] + P[i-1]*P[k]*P[j]
                if t < m[i][ j]:
                    m[i][j] = t
                    s[i][j] = k
    print(m)
    print(s)


if __name__ == '__main__':
    P = [30, 35, 15, 5, 10, 20]
    # P = [3,2,5,10,2,3]
    n = len(P)
    MatrixChain(P, n)

