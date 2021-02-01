import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dijkstra {
  int[] dist;
  int[] parent;
  int[][] element;
  private final static int INFINIY = 99;
  int minDist = 0;
  boolean[] visited;

  Dijkstra(int[][] element) {
    int n = element.length;
    this.element = element;
    this.dist = new int[n];
    this.parent = new int[n];
    this.visited = new boolean[n];
  }

  public int[] find() {
    int n = element.length;
    List<Integer> road = new ArrayList<>();
    dist = Arrays.copyOf(element[0], n);
    // System.arraycopy(element[0], 0, dist, 0, n);

    road.add(0);
    visited[0] = true;
    while (road.size() < n) {
      int v = findMinDist();
      road.add(v);
      visited[v] = true;
      for (int i = 0; i < n; i++) {
        int distnow = dist[v] + element[v][i];
        if (!visited[i] && distnow < dist[i]) {
          dist[i] = dist[v] + element[v][i];
          parent[i] = v;
        }
      }
    }
    System.out.println(road);
    System.out.println(Arrays.toString(parent));

    return dist;
  }

  public int findMinDist() {
    int n = element.length;
    int minId = 0;
    int mindist = INFINIY;
    for (int i = 0; i < n; i++) {
      if (dist[i] < mindist && !visited[i]) {
        mindist = dist[i];
        minId = i;
      }
    }
    return minId;
  }
}
