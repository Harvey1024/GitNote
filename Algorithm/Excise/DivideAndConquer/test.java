public class test {
  public static void main(String[] args) {
    sort();
  }

  public static void search() {
    int[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    Search search = new Search(data);
    int res = search.get(-1);
    System.out.println(res);
  }

  public static void sort() {
    int[] a = { 35, 52, 85 };
    Sort sort = new Sort(a);
    sort.merge(0, 1, 2);
  }
}
