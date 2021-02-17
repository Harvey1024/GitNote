import java.util.Arrays;

import javax.crypto.Mac;

public class test {
  public static void main(String[] args) {
    // maxComList();
    // knapSack();

    String s = "krrgw";
    String t = "zjxss";
    int[] diff = new int[s.length()];
    for (int i = 0; i < s.length(); i++) {
      diff[i] = 19 - Math.abs((int) s.charAt(i) - (int) t.charAt(i));
    }
    System.out.println(Arrays.toString(diff));
    int maxCost = 19;
    int k = 0;
    int maxk = 0;
    for (int j = 0; j < s.length(); j++) {
      k = 0;
      maxCost = 19;
      for (int i = j; i < s.length(); i++) {
        int cost = (int) s.charAt(i) - (int) t.charAt(i);
        if (maxCost - Math.abs(cost) >= 0) {
          maxCost -= Math.abs(cost);
          k++;
        } else {
          break;
        }
      }
      maxk = Math.max(maxk, k);
    }
    System.out.println(maxk);

  }

  public static void maxComList() {
    // 最长公共子序列问题
    String[] list0 = { "A", "B", "C", "B", "D", "A", "B" };
    String[] list1 = { "B", "D", "C", "A", "B", "A" };
    CommonSubsequence mcl = new CommonSubsequence(list0, list1);
    mcl.lcs();
    // System.out.println("helo");
  }

  public static void knapSack() {
    // 0-1背包问题
    int[] weight = { 2, 2, 6, 5, 4 };
    int[] value = { 6, 3, 5, 4, 6 };
    int capacity = 10;
    KnapSack kp = new KnapSack(weight, value, capacity);
    int[] res = kp.solution();
    System.out.println("最优解：");
    System.out.println(Arrays.toString(res));
  }

}
