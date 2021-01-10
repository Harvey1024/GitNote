/**
 * 分治算法：
 * 
 * 数组分两份，求左右的最大子列和。 求跨过分界线的最大子列和S中， Smax = max(S左，S中，S右)
 */
public class DivideAndConquer {
  public static int MaxSubDequqSum(int[] sequence) {
    return divideAndConquer(sequence, 0, sequence.length - 1);
  }

  public static int divideAndConquer(int[] list, int left, int right) {
    int center;
    int maxLeftSum, maxRightSum;
    int maxLeftBorderSum = 0;
    int maxRightBorderSum = 0;
    int leftBorderSum = 0;
    int rightBorderSum = 0;
    // 终止条件：当子列只有一个数字
    if (left == right) {
      if (list[left] > 0) {
        return list[left];
      } else {
        return 0;
      }
    }
    // 计算中间位置
    center = (left + right) / 2;
    maxLeftSum = divideAndConquer(list, left, center);
    maxRightSum = divideAndConquer(list, center + 1, right);
    // 求跨越分界线的最大子列和
    // 左边扫描
    for (int i = center; i >= left; i--) {
      leftBorderSum = leftBorderSum + list[i];
      if (leftBorderSum > maxLeftBorderSum) {
        maxLeftBorderSum = leftBorderSum;
      }
    }
    // 右边扫描
    for (int i = center + 1; i <= right; i++) {
      rightBorderSum += list[i];
      if (rightBorderSum > maxRightBorderSum) {
        maxRightBorderSum = rightBorderSum;
      }
    }
    System.out.printf("max left: %d, max right: %d, max center: %d %n", maxLeftSum, maxRightSum,
        maxLeftBorderSum + maxRightBorderSum);
    return max3(maxLeftSum, maxRightSum, maxLeftBorderSum + maxRightBorderSum);
  }

  public static int max3(int a, int b, int c) {
    if (a > b) {
      return Math.max(a, c);
    } else {
      return Math.max(b, c);
    }
  }

}
