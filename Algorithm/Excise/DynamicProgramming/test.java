public class test {
  public static void main(String[] args) {
    maxComList();
  }

  public static void maxComList() {
    // 最长公共子序列问题
    String[] list0 = { "A", "B", "C", "B", "D", "A", "B" };
    String[] list1 = { "B", "D", "C", "A", "B", "A" };
    CommonSubsequence mcl = new CommonSubsequence(list0, list1);
    mcl.lcs();
    // System.out.println("helo");
  }

}
