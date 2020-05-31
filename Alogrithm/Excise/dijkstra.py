
def Dijkstra(n: int, u: int, dist: float, p: int, c: int):
    # n: point number, u: source point, c[n][n]: matrix,
    # dist[i]: min. distance between origin point to point i
    # previous point on the chian of min. distance
    s = [0]*n
    for i in range(n):
        dist[i] = c[u][i]
        s[i] = False
        if(dist[i] == 9999):
            p[i] = -1
        else:
           p[i] = u
    s[u] = True
    for i in range(n):
        temp = 9999
        t = u
        for j in range(n):
            if(not s[j] and dist[j] < temp):
                t = j
                temp = dist[j]
        if(t == u):
            break
        s[t] = True
        # update the dist between source point n and point next to t
        for j in range(n):
            if(not s[j] and c[t][j] < 9999):
                if(dist[j] > dist[t]+c[t][j]):
                    dist[j] = dist[t]+c[t][j]
                    p[j] = t
            print(p)
        # print(i)
        # print(s)
        # print(p)
            print(dist)


if __name__ == '__main__':
    n = 5
    u = 0
    dist = [0]*n
    p = [0]*n
    c = [[9999, 8, 32, 9999, 9999], 
        [12,9999,16,15,9999], 
        [9999,29,9999,13,9999],
        [9999,21,9999,9999,7],
        [9999,9999,27,19,9999]]
    Dijkstra(n, u, dist, p, c)
    # print(p)
    # print(dist)
