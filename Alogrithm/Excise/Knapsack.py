# 0-1 knapsack alogrithm
def Knapsack(w, v, b):
    # initialize max value matrix
    # first line = 0: put no good into knapsack
    # first colum = 0: capacity = 0
    C = [[0 for i in range(b+1)] for j in range(len(w)+1)]
    for i in range(len(w)):
        i = i+1 
        for j in range(b):
            j = j+1  # knapsack capacity [1~b]
            if j < w[i-1]:
                C[i][j] = C[i-1][j]
            else:
                C[i][j] = max(C[i-1][j], C[i-1][j-w[i-1]]+v[i-1])
    print(C)
    # x=1: put the good to knapsack
    x = [0]*len(w)
    j = b
    for i in range(len(w)):
      i = i+1
      if C[i][j] == C[i-1][j]:
          x[i-1] = 0
      else:
         x[i-1] = 1
         # after put the good into knapsack
         # the capacity of knapsack should minus weight of good.  
         j = j-w[i-1]
    print(x)
    print(j)
if __name__ == '__main__':
    # waight
    w = [2, 2, 6, 5, 4]
    # value
    v = [6, 3, 5, 4, 6]
    # knapsack capacity
    b = 10
    Knapsack(w, v, b)
