import java.util.ArrayList;
import java.util.List;

public class MST {
  // minimum spanning tree
  int[][] data;
  private final int INFNITY = 99;
  int mincost;

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
      mincost += dist[m];
      dist[m] = 0;
      // 更新其余点距离mst集合的距离
      for (int i = 0; i < n; i++) {
        if (dist[i] != 0 && data[m][i] < dist[i]) {
          parent[i] = m;
          dist[i] = data[m][i];
        }
      }
    }
    System.out.printf("min cost: %d %n", mincost);
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

}
