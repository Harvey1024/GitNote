public class UnionFind {
  private int[] parent;
  private int[] rank;

  public UnionFind(int n) {
    this.parent = new int[n];
    this.rank = new int[n];
    for (int i = 0; i < n; i++) {
      this.parent[i] = i;
      this.rank[i] = 1;
    }
  }

  public void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    if (rootX == rootY) {
      return;
    }
    if (rank[rootX] == rank[rootY]) {
      parent[rootX] = rootY;
      rank[rootY]++;
    } else if (rank[rootX] < rank[rootY]) {
      parent[rootX] = rootY;
    } else {
      parent[rootY] = rootX;
    }
  }

  public int find(int x) {
    if (x != parent[x]) {
      parent[x] = find(parent[x]);
    }
    return parent[x];
  }
}