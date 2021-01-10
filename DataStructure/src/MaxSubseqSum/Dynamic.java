/**
 * 动态规划方法，或者再现处理
 */
public class Dynamic {
  public int MaxSubSeqSum(int[] list) {
    int thisSum = 0;
    int maxSum = 0;
    for (int i = 0; i < list.length; i++) {
      thisSum += list[i];
      if (thisSum > maxSum) {
        maxSum = thisSum;
      } else if (thisSum < 0) {
        thisSum = 0;
      }
    }
    return maxSum;
  }
}
