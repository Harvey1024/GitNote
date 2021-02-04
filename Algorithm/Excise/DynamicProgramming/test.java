import java.util.Arrays;

public class test {
  public static void main(String[] args) {
    // maxComList();
    knapSack();
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
