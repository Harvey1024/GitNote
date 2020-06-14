''' Traveling salesman problem
  A undirected graph G = <V,E>
  V: cities
  E: distance between cities
  find the max the road list that the total length of salesman
  passing through is minimum.
'''


def Traveling(n: int, E: list) -> [int, list]:
    treelist = generateTree(n)
    min_road = []
    B = 0
    for i in range(len(treelist)):
        for j in range(n):
            F = cost_func(treelist[i], j, E)
            if F > B and B > 0:
                break
            if (j == n-1 and F < B) or (j == n-1 and i == 0):
                B = F
                min_road = treelist[i][:]
    return B, min_road


def cost_func(t, j, E):
    L = 0
    for i in range(j):
        L = L + E[t[i]][t[i+1]]
    if j < len(t)-1:
        L = L + min_dist(t[j], E[t[j]]) + total_min_dist(t[j+1:len(t)], E)
    else:
        L = L+E[t[j]][t[0]]
    return L


def total_min_dist(a, E):
    L = 0
    for i in a:
        L = L + min_dist(i, E[i])
    return L


def min_dist(i, d):
    temp = d[:]
    temp.pop(i)
    return min(temp)


def generateTree(n):
    treelist = []
    city = [i for i in range(n)]
    citysign = [0]*n
    y = [0]*n
    i = 0
    while i < n:
        y[i] = next_value(y[0:i], city)
        citysign[i] = 1
        if i == n-1:
            # print(y)
            treelist.append(y[:])
            [y, i] = tree_back(y, i, city)
            if i == 0:
                break
        i = i+1
    return treelist


def tree_back(y, i, city):
    i = i-1
    if i == 0:
        return y, i
    if y[i]+1 <= len(city)-1:
        y[i] = y[i]+1
        if y[i] in y[0:i]:
            [y, i] = tree_back(y, i+1, city)
    else:
        [y, i] = tree_back(y, i, city)
    return y, i


def next_value(y, c):
    temp = c[:]
    for i in y:
        if i in temp:
            temp.pop(temp.index(i))
    return temp[0]


class tree:
    def __init__(self, data):
        self.data = data
        self.children = []


if __name__ == '__main__':
    E = [[0, 5, 9, 4],
         [5, 0, 13, 2],
         [9, 13, 0, 7],
         [4, 2, 7, 0]]
    n = 4
    [min_length, min_road]=Traveling(4, E)
    min_road = [i+1 for i in min_road]
    print('minimum traveling road: '+str(min_road))
    print('minimum length is '+ str(min_length) + ' km')
