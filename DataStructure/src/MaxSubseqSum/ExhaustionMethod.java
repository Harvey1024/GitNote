import java.util.ArrayList;

/**
 * 穷举算法，时间复杂度：O(N^3)
 * 
 */
public class ExhaustionMethod {
  public int MaxSubDequqSum(int[] sequence) {
    int thisSum = 0;
    int maxSum = 0;
    ArrayList<Integer> maxList = new ArrayList<>();
    ArrayList<Integer> thisList = new ArrayList<>();

    for (int i = 0; i < sequence.length; i++) {
      for (int j = i; j < sequence.length; j++) {
        thisSum = 0;
        thisList.clear();
        for (int k = i; k <= j; k++) {
          thisSum = thisSum + sequence[k];
          thisList.add(sequence[k]);
        }
        if (thisSum > maxSum) {
          maxSum = thisSum;
          maxList = (ArrayList<Integer>) thisList.clone();
        }
      }
    }
    System.out.println("穷举");
    System.out.println("MaxSequence: " + maxList);
    System.out.printf("Max sum: %d %n", maxSum);
    return maxSum;
  }
}
