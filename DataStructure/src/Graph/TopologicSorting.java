import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.ArrayList;

public class TopologicSorting {
  List<Integer>[] adj;
  int[] indegree;

  TopologicSorting(List<Integer>[] adj) {
    this.adj = adj;
    this.indegree = new int[adj.length];
    Map<Integer, Integer> hashMap = new HashMap<>();
    for (int i = 0; i < adj.length; i++) {
      for (int j = 0; j < adj[i].size(); j++) {
        int key = adj[i].get(j);
        if (hashMap.containsKey(key)) {
          hashMap.put(key, hashMap.get(key) + 1);
        } else {
          hashMap.put(key, 1);
        }
      }
    }
    for (int i = 0; i < adj.length; i++) {
      this.indegree[i] = hashMap.computeIfAbsent(i, k -> 0);
    }
  }

  public void sort() {
    List<Integer> res = new ArrayList<>();
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < adj.length; i++) {
      if (indegree[i] == 0) {
        queue.offer(i);
      }
    }
    while (!queue.isEmpty()) {
      int s = queue.poll();
      res.add(s);
      for (int j = 0; j < adj[s].size(); j++) {
        int x = adj[s].get(j);
        if (--indegree[x] == 0) {
          queue.offer(x);
        }
      }
    }
    System.out.println(res);

  }

}
