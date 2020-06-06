# Binary Tree Search Algorithm
def BinaryTreeSearch(S, a, b):
    n = len(S)
    m = [[0.0 for i in range(n+1)] for j in range(n+2)]
    w = [[0.0 for i in range(n+1)] for j in range(n+2)]
    for i in range(n):
        i = i+1
        w[i][i-1] = a[i-1]
        m[i][i] = b[0]
    print(w)
    print('t = '+str([1+item for item in range(n)]))
    for t in range(n):
        
        # t: 2~n
        t = t+1
        # i: [1~n-1]~[1~1]
        # j: [2~n]~[n~n]
        print('t2 = ' + str(list((range(n-t+1)))))
        print('i = '+str([1+item for item in range(n-t+1)]))
        print('j = '+str([t+item for item in range(n-t+1)]))
        for i in range(n-t+1):
            i = i+1
            j = i+t-1
            w[i][j] = w[i][j-1] + a[j]+b[j]
            print('k = ' + str([i+item for item in(range(j-i+1))]))
            for k in range(j-i+1):
                k = k+i
                print('m[i][k-1]+m[k+1][j]+ w[i][j] = '+str(m[i][k-1]+m[k+1][j]+ w[i][j]))
                if k == i:
                    m[i][j] = m[i][k-1]+m[k+1][j]+ w[i][j]
                if m[i][j] > m[i][k-1]+m[k+1][j]+ w[i][j]:
                    m[i][j] = m[i][k-1]+m[k+1][j]+ w[i][j]
            # round(m[i][j],2)
    print(m)


if __name__ == '__main__':
    S = [1, 2, 3, 4, 5]
    a = [0.05, 0.1, 0.05, 0.05, 0.05, 0.1]
    b = [0, 0.15, 0.1, 0.05, 0.1, 0.2]
    x = 3.4
    BinaryTreeSearch(S, a, b)
    print('ok')
