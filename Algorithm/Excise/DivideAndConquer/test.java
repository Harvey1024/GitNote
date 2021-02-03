import java.util.Arrays;

public class test {
  public static void main(String[] args) {
    quickSort();
  }

  public static void search() {
    int[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    Search search = new Search(data);
    int res = search.get(-1);
    System.out.println(res);
  }

  public static void sort() {
    // 二分归并排序
    int[] a = { 0, 6, 2, 1 };
    Sort sort = new Sort(a);
    sort.sort(0, a.length - 1);
    // System.out.println(Arrays.toString(sort.data));
  }

  public static void quickSort() {
    int[] a = { 49, 38, 65, 97, 76, 13, 27 };
    Sort sort = new Sort(a);
    sort.quickSort2(0, a.length - 1);
    System.out.println(Arrays.toString(sort.data));
  }
}
