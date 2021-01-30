import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
  public static void main(String[] args) {
    minTree();
  }

  public static void println(String s) {
    System.out.println(s);
  }

  public static void search() {
    int[][] graph = { { 0, 1, 0, 1 }, { 1, 0, 1, 0 }, { 0, 1, 0, 1 }, { 1, 0, 1, 0 } };
    for (int i = 0; i < graph.length; i++) {
      System.out.println(Arrays.toString(graph[i]));
    }
    Graph g = new Graph(graph);
    println("bread first search");
    g.breadFirstSearch(2);
    g.clearVisited();
    println("depth first search");
    g.depthFirstSearch(0);
  }

  public static void sort() {
    List<Integer> adj[] = new ArrayList[6];
    for (int i = 0; i < adj.length; i++) {
      adj[i] = new ArrayList<>();
    }
    adj[0].add(1);
    adj[0].add(2);
    adj[1].add(4);
    adj[1].add(5);
    adj[2].add(5);
    adj[3].add(5);
    System.out.println(Arrays.toString(adj));

    TopologicSorting topoSort = new TopologicSorting(adj);
    topoSort.sort();
  }

  public static void minTree() {
    int[][] graph = { { 0, 6, 1, 5, 99, 99 }, { 6, 0, 5, 99, 3, 99 }, { 1, 5, 0, 5, 6, 4 }, { 5, 99, 5, 0, 99, 2 },
        { 99, 3, 6, 99, 0, 6 }, { 99, 99, 4, 2, 6, 0 } };
    MST mst = new MST(graph);
    int[] dist = mst.prim(0);
    System.out.println(Arrays.toString(dist));
    int[] kk = { 0, 1, 2, 3, 4, 5 };
    println(Arrays.toString(kk));
  }
}
