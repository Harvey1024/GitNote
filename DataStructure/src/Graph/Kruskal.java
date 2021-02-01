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
    List<Edge> mst = new ArrayList<>();
    int miniCost = 0;
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
      Edge k = minHeap.delete();
      if (k.weight == -1) {
        break;
      }
      int rootV = find(k.v);
      int rootW = find(k.w);
      if (rootV != rootW) {
        union(rootV, rootW);
        mst.add(k);
        miniCost += k.weight;
      }
    }
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
