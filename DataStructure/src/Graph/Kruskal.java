import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kruskal {
  int[][] data;
  int[] parent;
  private final static int INFNITY = 99;

  Kruskal(int[][] data) {
    this.data = data;
    int n = data.length;
    this.parent = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }

  }

  public void mst() {
    int n = data.length;
    // 最小生成树加入边的集合
    List<Edge> mst = new ArrayList<>();
    int miniCost = 0;
    // 生成最小堆
    Heap minHeap = new Heap(n * n);
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (data[i][j] < INFNITY) {
          Edge edge = new Edge(i, j, data[i][j]);
          minHeap.insert(edge);
        }

      }
    }
    while (mst.size() < n - 1) {
      // 取得最小边
      Edge k = minHeap.delete();
      if (k.weight == -1) {
        break;
      }

      // 使用并查集，查看边的两个结点是否有相同的parent
      // 如果没有相同的parent，则加入边后不会形成回路
      // 加入该边，更新并查集
      int rootV = find(k.v);
      int rootW = find(k.w);
      if (rootV != rootW) {
        union(rootV, rootW);
        mst.add(k);
        miniCost += k.weight;
      }
    }
    // 输出结果
    System.out.printf("parent: %s %n", Arrays.toString(parent));
    System.out.printf("Kruskal min cost: %d %n", miniCost);
    for (Edge edge : mst) {
      System.out.printf("Edge: %d - %d : %d %n", edge.v, edge.w, edge.weight);

    }

  }

  public void union(int v, int w) {
    parent[v] = w;
  }

  public int find(int i) {
    int rootI = parent[i];
    if (rootI != i) {
      rootI = find(rootI);
    }
    return rootI;
  }
}
