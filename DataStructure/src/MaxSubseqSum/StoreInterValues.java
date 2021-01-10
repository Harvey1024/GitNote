import java.util.ArrayList;

/**
 * 存在中间值，事件复杂的O(N^2)
 * 
 * @param sequence
 * @return
 */
public class StoreInterValues {
  public int MaxSubDequqSum(int[] sequence) {
    int thisSum = 0;
    int maxSum = 0;
    ArrayList<Integer> maxList = new ArrayList<>();
    ArrayList<Integer> thisList = new ArrayList<>();

    for (int i = 0; i < sequence.length; i++) {
      thisSum = 0;
      thisList.clear();
      for (int j = i; j < sequence.length; j++) {
        thisSum = thisSum + sequence[j];
        thisList.add(sequence[j]);
        if (thisSum > maxSum) {
          maxSum = thisSum;
          maxList = (ArrayList<Integer>) thisList.clone();
        }
      }
    }
    System.out.println("存储中间值");
    System.out.println("MaxSequence: " + maxList);
    System.out.printf("Max sum: %d %n", maxSum);
    return maxSum;
  }
}
