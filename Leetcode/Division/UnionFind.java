public class UnionFind {
  private int[] parent;
  private double[] weight;

  public UnionFind(int mapSize) {
    parent = new int[mapSize];
    weight = new double[mapSize];
    for (int i = 0; i < mapSize; i++) {
      parent[i] = i;
      weight[i] = 1d;
    }
  }

  public void union(int x, int y, double value) {
    // 当parent是自己的时候，
    int rootX = parent[x];
    int rootY = parent[y];
    if (rootX == rootY) {
      return;
    } else {
      parent[rootX] = rootY;
      weight[rootX] = weight[y] / weight[x] * value;
    }
  }

  /**
   * 路径压缩
   * 
   * @param x
   */
  private int find(int x) {
    if (parent[x] != x) {
      int origin = parent[x];
      parent[x] = find(origin);
      weight[x] = weight[x] * weight[origin];
    }
    return parent[x];
  }

  public double isConnected(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    // 父节点相同，则可以求解
    if (rootX == rootY) {
      return weight[x] / weight[y];
    } else {
      return -1d;
    }

  }

}
