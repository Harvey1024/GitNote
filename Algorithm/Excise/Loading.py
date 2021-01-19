"""
  Ship loading problem.
  Goods which weight[w1,w2,...wn]
  The max load of two ship is c1 and c2
  find the goods than ship 1 load and ship 2 load.

"""
from typing import List


def Loading(w: List[int], c1: int, c2: int) -> List[List[int]]:
    w.sort()
    w.reverse()
    B = c1
    best = c1
    x = [0]*len(w)
    xlist = []
    i = 0
    while True:
        while i <= len(w)-1:
            sumWeight = sumShip1(x, w)
            if sumWeight+w[i] <= c1:
                x[i] = 1
                B = B-w[i]
                i = i+1
            else:
                x[i] = 0
                i = i+1
        i = i-1
        if B <= best and sum(w)-sumShip1(x, w) <= c2:
            print(x)
            print('B= '+str(B)+' best = '+str(best))
            print(sumWeight+w[i]*x[i])
            xlist.append(tuple(x))
            best = B
        [i, w, B, x] = Backtracking(i, w, B, x)
        if i == 0:
            return xlist
        else:
            continue


def sumShip1(x: int, w: List[int]) -> int:
    sumWeight = 0
    for j in range(len(w)):
        sumWeight = sumWeight + w[j]*x[j]
    return sumWeight


def Backtracking(i: int, w: List[int], B: int, x: List[int]) -> List[int]:
    while i > 0 and x[i] == 0:
        i = i-1
    if x[i] == 1:
        x[i] = 0
        B = B+w[i]
        i = i+1
    return i, w, B, x


if __name__ == '__main__':
    W = [90, 80, 40, 30, 20, 12, 10]
    c1 = 152
    c2 = 130
    x = Loading(W, c1, c2)
    print(x)
