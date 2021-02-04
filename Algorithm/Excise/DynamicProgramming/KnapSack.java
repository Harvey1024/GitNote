import java.util.ArrayList;
import java.util.Arrays;

public class KnapSack {
  int[] weight;
  int[] value;
  int capacity;

  KnapSack(int[] weight, int[] value, int capacity) {
    this.capacity = capacity;
    int n = weight.length;
    this.weight = new int[n + 1];
    this.value = new int[n + 1];
    System.arraycopy(weight, 0, this.weight, 1, n);
    System.arraycopy(value, 0, this.value, 1, n);
  }

  public int[] solution() {
    int[][] c = new int[weight.length][capacity + 1];
    for (int i = 1; i < weight.length; i++) {
      for (int j = 1; j < capacity + 1; j++) {
        // 物品i的重量超过总容量j时，不装入
        if (weight[i] > j) {
          c[i][j] = c[i - 1][j];
        } else {
          c[i][j] = Math.max(c[i - 1][j], c[i - 1][j - weight[i]] + value[i]);
        }
      }
    }
    System.out.println("矩阵c:");
    for (int[] k : c) {
      System.out.println(Arrays.toString(k));
    }
    // 最优解
    int[] res = new int[weight.length];
    int j = capacity;
    for (int i = weight.length - 1; i > 0; i--) {
      // 比上一个大，说明这个物品加入背包了
      if (c[i][j] > c[i - 1][j]) {
        res[i] = 1;
        // 更新背包重量，减去被放入的这个物品重量
        j = j - weight[i];
      } else {
        res[i] = 0;
      }
    }
    return Arrays.copyOfRange(res, 1, res.length);
  }
}