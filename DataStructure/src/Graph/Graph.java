import java.util.LinkedList;
import java.util.Queue;

class Graph {
  int[][] data;
  int[][] data2;
  boolean[] visited;

  Graph(int[][] data) {
    this.data = data;
    this.visited = new boolean[data.length];
    for (int i = 0; i < data.length; i++) {
      this.visited[i] = false;
    }
  }

  // 广度优先搜索
  public void breadFirstSearch(int i) {
    Queue<Integer> queue = new LinkedList<>();
    visit(i);
    queue.offer(i);
    while (!queue.isEmpty()) {
      int s = queue.poll();
      for (int j = 0; j < data[i].length; j++) {
        int x = data[s][j];
        if (x != 0 && !visited[j]) {
          visit(j);
          queue.offer(j);
        }
      }
    }
  }

  // 深度优先搜索
  public void depthFirstSearch(int i) {
    if (!visited[i]) {
      visit(i);
    }
    for (int j = 0; j < data.length; j++) {
      if (data[i][j] != 0 && !visited[j]) {
        visit(j);
        depthFirstSearch(j);
      }
    }

  }

  public void visit(int i) {
    System.out.printf("visit %d %n", i);
    visited[i] = true;
  }

  public void clearVisited() {
    for (int i = 0; i < data.length; i++) {
      visited[i] = false;
    }
  }

}