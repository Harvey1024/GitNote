import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Hanota {
  public static void main(String[] args) {
    int[] a = { 2, 1, 0 };
    List<Integer> A = Arrays.stream(a).boxed().collect(Collectors.toList());
    List<Integer> B = new ArrayList<>();
    List<Integer> C = new ArrayList<>();

    move(A.size(), A, C, B);
    System.out.println(C);
  }

  /**
   * 
   * @param n     金片个数
   * @param start 起始针
   * @param goal  目标针
   * @param temp  过渡针
   */
  public static void move(int n, List<Integer> start, List<Integer> goal, List<Integer> temp) {
    if (n > 0) {
      move(n - 1, start, temp, goal);
      goal.add(start.remove(start.size() - 1));
      move(n - 1, temp, goal, start);
    }
  }
}