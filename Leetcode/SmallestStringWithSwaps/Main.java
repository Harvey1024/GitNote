import java.util.List;
import java.util.Map;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
 * 
 * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
 * 
 * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。 示例 1:
 * 
 * 输入：s = "dcab", pairs = [[0,3],[1,2]] 输出："bacd" 解释： 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[1] 和 s[2], s = "bacd"
 * 
 * 解题要点：
 * 
 * 1.索引对存在并集关系，考虑使用并查集。
 * 2.具有相同父节点的节点，按照ASCII码排序，使用优先队列排序PriorityQueue的offer()方法和poll()方法输出。
 * 3.使用HashMap将字符串分成具有相同parent的几个部分
 * 4.使用StringBuilder.append()将每个字符合成字符串，使用toString()方法输出字符串。
 */
class Main {
  public static void main(String[] args) {
    String s = "dcab";
    List<List<Integer>> pairs = new ArrayList<>();
    pairs.add(Arrays.asList(0, 3));
    pairs.add(Arrays.asList(1, 2));
    // pairs.add(Arrays.asList(0, 2));
    String result = smallestStringWithSwaps(s, pairs);
    System.out.println(result);
  }

  public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
    if (pairs.size() == 0) {
      return s;
    }
    // 将任意交换的结点对输入并查集
    int len = s.length();
    UnionFind unionFind = new UnionFind(len);
    for (List<Integer> pair : pairs) {
      int index0 = pair.get(0);
      int index1 = pair.get(1);
      unionFind.union(index0, index1);
    }
    // 构建映射关系
    // 查找字符在并查集中的parent, 具有相同parent的字符，放到同一个hashMap子项里，子项里的子项根据PriorityQueue自动排序。
    char[] charArray = s.toCharArray();
    Map<Integer, PriorityQueue<Character>> hashMap = new HashMap<>(len);
    for (int i = 0; i < len; i++) {
      int root = unionFind.find(i);
      if (hashMap.containsKey(root)) {
        hashMap.get(root).offer(charArray[i]);
      } else {
        PriorityQueue<Character> minHeap = new PriorityQueue<>();
        minHeap.offer(charArray[i]);
        hashMap.put(root, minHeap);
      }
      // hashMap.computeIfAbsent(root, key -> new
      // PriorityQueue<>()).offer(charArray[i]);
    }
    // 输出hashMap内容。
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < len; i++) {
      int root = unionFind.find(i);
      stringBuilder.append(hashMap.get(root).poll());
    }

    return stringBuilder.toString();
  }
}