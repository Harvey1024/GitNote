import java.util.ArrayList;
import java.util.List;

public class MST {
  // minimum spanning tree
  int[][] data;
  private final int INFNITY = 99;

  MST(int[][] data) {
    this.data = data;
  }

  public int[] prim(int v) {
    int n = data.length;
    int[] dist = new int[n];
    int[] parent = new int[n];
    for (int i = 0; i < n; i++) {
      dist[i] = data[v][i];
      parent[i] = v;
    }
    List<Integer> mst = new ArrayList<>();
    mst.add(v);
    parent[v] = -1;
    while (mst.size() < n) {
      int m = findMinDist(dist);
      mst.add(m);
      // 距离=0 表示已经在集合内
      dist[m] = 0;
      // 更新其余点距离mst集合的距离
      for (int i = 0; i < n; i++) {
        if (dist[i] != 0 && data[m][i] < dist[i]) {
          parent[i] = m;
          dist[i] = data[m][i];
        }
      }
    }
    return parent;
  }

  public int findMinDist(int[] dist) {
    int n = dist.length;
    int minDistNo = 0;
    int minDist = 99;
    for (int i = 0; i < n; i++) {
      if (dist[i] != 0 && dist[i] < minDist) {
        minDist = dist[i];
        minDistNo = i;
      }
    }
    return minDistNo;
  }

  public void kruskal() {
    int n = data.length;
    int[][] data2 = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        data2[i][j] = INFNITY;
      }
    }
    int[] dist = new int[n];
    int[] parent = new int[n];
    Heap minHeap = new Heap(n * n);
    if (countEdges(data2) < n - 1) {
      Edge k = minHeap.delete();
      int v = k.v;
      int w = k.w;
      UnionFind unionFind = new UnionFind();
      if (unionFind.find(v) != unionFind.find(w)) {
        parent[v] = w;
      }
    }

  }

  public int countEdges(int[][] graph) {
    int n = graph.length;
    int edge = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (graph[i][j] < INFNITY) {
          edge++;
        }
      }
    }
    return edge;
  }
}
