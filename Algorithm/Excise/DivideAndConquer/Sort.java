import java.util.Arrays;

public class Sort {
  int[] data;

  Sort(int[] data) {
    this.data = data;
  }

  public void sort(int left, int right) {
    if (left < right) {
      int middle = (left + right) / 2;
      sort(left, middle);
      sort(middle + 1, right);
      merge(left, middle, right);
    }
  }

  public void merge(int left, int middle, int right) {
    int n = right - left + 1;
    int[] temp = new int[right - left + 1];
    int i = 0;
    int m = middle;
    while (i < n) {
      if (data[left] > data[m + 1] || left > middle) {
        temp[i++] = data[m + 1];
        m++;
        continue;
      }
      if (data[left] <= data[m + 1] || m + 1 > right) {
        temp[i++] = data[left];
        left++;
      }

    }
    System.out.println(Arrays.toString(temp));
  }
}
