import java.util.Arrays;

public class CommonSubsequence {
  String[] list0;
  String[] list1;
  String[] common;

  CommonSubsequence(String[] list0, String[] list1) {
    this.list0 = list0;
    this.list1 = list1;
  }

  public void lcs() {
    int n = list0.length + 1;
    int m = list1.length + 1;
    int[][] c = new int[n][m];
    int[][] b = new int[n][m];
    // for (int i = 0; i < n; i++) {
    // c[i][0] = 0;
    // }
    // for (int i = 0; i < m; i++) {
    // c[0][i] = 0;
    // }
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        if (list0[i - 1] == list1[j - 1]) {
          c[i][j] = c[i - 1][j - 1] + 1;
          b[i][j] = 1;
        } else {
          c[i][j] = Math.max(c[i][j - 1], c[i - 1][j]);
          if (c[i][j - 1] > c[i - 1][j]) {
            b[i][j] = 2;
          } else {
            b[i][j] = 3;
          }
        }
      }
    }
    int maxLength = c[n - 1][m - 1];
    common = new String[maxLength];
    System.out.printf("max length: %d %n", c[n - 1][m - 1]);
    print(b, n - 1, m - 1, maxLength);
    System.out.printf("longest common subsequence: %s %n", Arrays.toString(common));
  }

  public void print(int[][] b, int i, int j, int commonLen) {
    if (b[i][j] == 1) {
      System.out.println(list0[i - 1]);
      common[--commonLen] = list0[i - 1];
      print(b, i - 1, j - 1, commonLen);
    }
    if (b[i][j] == 2) {
      print(b, i, j - 1, commonLen);
    }
    if (b[i][j] == 3) {
      print(b, i - 1, j, commonLen);
    }
  }
}