
def Dijkstra(n: int, u: int, dist: float, p: int, c: int):
    # n: point number count, u: source point, c[n][n]: matrix,
    # dist[i]: min. distance between origin point to point i
    # previous point on the chian of min. distance
    S = [0]*n
    for i in range(n):
        dist[i] = c[u][i]
        S[i] = False
        if(dist[i] == 9999):
            p[i] = -1
        else:
           p[i] = u
    print(dist)
    print(p)
    S[u] = True
    for i in range(n):
        temp = 9999
        t = u
        # 找到距离最短的顶点j,加入到S集合内
        for j in range(n):
            if(not S[j] and dist[j] < temp): #不在S集合内且当前最小
                t = j
                temp = dist[j]  #temp 存储当前最小的数，当有更小的数时替换
        if(t == u):
            break
        S[t] = True
        print('S is  '+str(S))
        print('add point ' + str(t) +' to S')
        # update the dist between source point n and point next to t
        # 更新其他顶点相对S集合的距离
        print(dist)
        for j in range(n):
            if(not S[j] and c[t][j] < 9999):
                if(dist[j] > dist[t]+c[t][j]):
                    dist[j] = dist[t]+c[t][j]
                    p[j] = t

        print('to '+ str(dist))


if __name__ == '__main__':
    n = 5
    u = 0
    dist = [0]*n
    p = [0]*n
    c = [[0, 8, 32, 9999, 9999], 
        [12,0,16,15,9999], 
        [9999,29,0,13,9999],
        [9999,21,9999,0,7],
        [9999,9999,27,19,0]]
    Dijkstra(n, u, dist, p, c)
    print('final')
    print(p)
    print(dist)
