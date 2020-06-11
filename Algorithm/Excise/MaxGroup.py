''' max group problem
  A undirected graph G = <V,E>
  find the max grop of G
  output: x = list[n], x[i]=1 mean i in group
'''


def MaxGroup(n: int, E: list(list())):
    x = [0]*n
    maxX = ''
    B = 0
    i = 0
    F = n
    while i < n:
        if i == n-1 or F <= B:
            if i == n-1:
                x[i] = Place(E, i, x)
                F = sum(x[0:i+1])+n-i-1
                if F > B:
                    B = F
                    maxX = str(x)
            [i, x] = backtracking(i, x, B)
            print(x)
            if i == 0:
                return B, maxX
            i = i+1
            continue

        x[i] = Place(E, i, x)
        F = sum(x[0:i+1])+n-i-1
        i = i+1


def Place(t, i, x):
    for j in range(len(t)):
        if x[j] == 1 and t[i][j] == 0:
            return 0
    return 1


def backtracking(i, x, B):
    while i > 0:
        i = i-1
        if x[i] == 1:
            x[i] = 0
            for k in range(n-i-1):
                x[k+i+1] = 0
            break
    F = sum(x[0:i+1])+n-i-1
    if F <= B and not i == 0:
        [i, x] = backtracking(i, x, B)
    return i, x


if __name__ == '__main__':
    V = [1, 2, 3, 4, 5]
    n = len(V)
    E = [[1, 1, 1, 1, 1],
         [1, 1, 0, 1, 0],
         [1, 0, 1, 1, 1],
         [1, 1, 1, 1, 1],
         [1, 0, 1, 1, 1]]
    [B, x] = MaxGroup(n, E)
    print('Max group node number: '+str(B))
    print('Max group = ' + x)
