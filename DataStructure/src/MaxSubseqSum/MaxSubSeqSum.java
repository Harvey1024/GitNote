
/**
 * 最大子列和问题
 * 
 * 给定n个整数序列，{a1, a2, ... , an} 求f(i,j) = max(0, sum(ai,..,aj))
 * 
 * 
 */
import java.util.Arrays;

public class MaxSubSeqSum {
  public static void main(String[] args) {
    int[] list = { -2, 11, -4, 13, -5, -2 };
    System.out.println("input: " + Arrays.toString(list));
    ExhaustionMethod method1 = new ExhaustionMethod();
    method1.MaxSubDequqSum(list);

    StoreInterValues methd2 = new StoreInterValues();
    methd2.MaxSubDequqSum(list);

    DivideAndConquer method3 = new DivideAndConquer();
    int result = method3.MaxSubDequqSum(list);
    System.out.printf("divide and conquer method: %d %n", result);

    Dynamic method4 = new Dynamic();
    System.out.printf("Dynamic programming method: %d %n", method4.MaxSubSeqSum(list));

  }

}