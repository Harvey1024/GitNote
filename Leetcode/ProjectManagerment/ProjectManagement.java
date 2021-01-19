
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class ProjectManagerment {
  public static void main(String[] args) {
    List<List<Integer>> beforeItems = new ArrayList<>();
    beforeItems.add(new ArrayList<>());
    beforeItems.add(Arrays.asList(6));
    beforeItems.add(Arrays.asList(5));
    beforeItems.add(Arrays.asList(6));
    beforeItems.add(Arrays.asList(3, 6));
    beforeItems.add(new ArrayList<>());
    beforeItems.add(new ArrayList<>());
    beforeItems.add(new ArrayList<>());
    int[] group = { -1, -1, 1, 0, 0, 1, 0, -1 };
    int n = 8;
    int m = 2;
    int[] ret = sortItems(n, m, group, beforeItems);
    System.out.println("group" + Arrays.toString(ret));
  }

  public static int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
    // 1. 没有组号的不要求在一起排序，因此没有组号的单独排序， 也就是需要将组为-1的分配一个新的组号
    for (int i = 0; i < group.length; i++) {
      if (group[i] == -1) {
        group[i] = m++;
      }
    }
    // 2.实例化组合项目的邻接表
    // 每个组有自己的空间，存放后置项目，
    List<Integer>[] groupAdj = new ArrayList[m];
    // 项目i的后置项目
    List<Integer>[] itemAdj = new ArrayList[n];
    for (int i = 0; i < m; i++) {
      groupAdj[i] = new ArrayList<>();
    }
    for (int i = 0; i < n; i++) {
      itemAdj[i] = new ArrayList<>();
    }
    // 3. 建图和统计入度数组
    // group的
    int[] groupIndegree = new int[m];
    int[] itemsIndegree = new int[n];
    int len = group.length;
    for (int i = 0; i < len; i++) {
      int currentGroup = group[i];
      for (int beforeItem : beforeItems.get(i)) {
        int beforeGroup = group[beforeItem];
        if (beforeGroup != currentGroup) {
          groupAdj[beforeGroup].add(currentGroup);
          groupIndegree[currentGroup]++;
        }
      }
    }
    for (int i = 0; i < n; i++) {
      for (Integer item : beforeItems.get(i)) {
        itemAdj[item].add(i);
        itemsIndegree[i]++;
      }
    }

    // 4. 得到组合项目的拓扑排序结果
    System.out.println("groupIndegree = " + Arrays.toString(groupIndegree));

    List<Integer> groupList = topologicalSort(groupAdj, groupIndegree, m);
    if (groupList.size() == 0) {
      return new int[0];
    }
    System.out.println("item" + Arrays.toString(itemAdj));
    System.out.println("indegree" + Arrays.toString(itemsIndegree));
    List<Integer> itemsList = topologicalSort(itemAdj, itemsIndegree, n);
    System.out.println(itemsList);
    if (itemsList.size() == 0) {
      return new int[0];
    }

    // 5. 根据项目的拓扑排序结果，项目到组的多对一关系，建立组到项目的一对多关系
    // key group, value: 同一组的项目列表
    Map<Integer, List<Integer>> grops2Items = new HashMap<>();
    for (Integer item : itemsList) {
      // group[item]存在的话，返回get，否则，执行洗衣歌语句，并将结果put到hashMap内。
      grops2Items.computeIfAbsent(group[item], key -> new ArrayList<>()).add(item);
    }
    // 6. 将hashmap的结果输出
    List<Integer> res = new ArrayList<>();
    for (int groupId : groupList) {
      List<Integer> items = grops2Items.getOrDefault(groupId, new ArrayList<>());
      res.addAll(items);
    }
    System.out.println(Arrays.toString(res.stream().toArray()));
    return res.stream().mapToInt(Integer::valueOf).toArray();
  }

  public static List<Integer> topologicalSort(List<Integer>[] adj, int[] inDegree, int n) {
    List<Integer> res = new ArrayList<>();
    // 队列，先进先出
    Queue<Integer> queue = new LinkedList<>();
    // 找到入度为0的点
    for (int i = 0; i < n; i++) {
      if (inDegree[i] == 0) {
        queue.offer(i);
      }
    }
    while (!queue.isEmpty()) {
      Integer front = queue.poll();
      // 将queue内依次加入到res
      res.add(front);
      for (int sucessor : adj[front]) {
        // 删除指向该节点的一条边
        inDegree[sucessor]--;
        // 全部删除后，将该节点加入到入度为0的队列中
        if (inDegree[sucessor] == 0) {
          queue.offer(sucessor);
        }
      }
    }
    if (res.size() == n) {
      return res;
    }
    return new ArrayList<>();
  }
}