''' Traveling salesman problem
  A undirected graph G = <V,E>
  V: cities
  E: distance between cities
  find the max the road list that the total length of salesman
  passing through is minimum.
'''


def Traveling(n: int, E: list) -> list:
    x = [0]*n
    xo = x[:]
    i = 0
    while i < n:

        i = i+1


def min_dist(i, d):
    temp = d[:]
    temp.pop(i)
    return min(temp)


def factorial(n):
    if(n > 1):
        z = n*factorial(n-1)
        return z
    else:
        return 1


def generateTree(n):
    treelist = []
    city = [i+1 for i in range(n)]
    citysign = [0]*n
    y = [0]*n
    i = 0
    while i < n:
        y[i] = next_value(y[0:i], city)
        citysign[i] = 1
        if i == 3:
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
    if y[i]+1 <= 4:
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
    # Traveling(4,E)
    # a = factorial(3)
    # print(a)
    treelist = generateTree(4)
    print(treelist)
