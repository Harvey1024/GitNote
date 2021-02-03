import java.util.Arrays;

public class Sort {
  int[] data;

  Sort(int[] data) {
    this.data = data;
  }

  // 二分归并排序
  public void sort(int left, int right) {
    if (left < right) {
      int middle = (left + right) / 2;
      sort(left, middle);
      sort(middle + 1, right);
      merge2(left, middle, right);
    }
  }

  public void merge2(int left, int middle, int right) {
    int[] temp = new int[right - left + 1];
    int i = left;
    int j = middle + 1;
    int k = 0;

    // 将比较插入和 剩余元素复制 两个步骤分开：
    while (i <= middle && j <= right) {
      if (data[i] > data[j]) {
        temp[k++] = data[j++];
      } else {
        temp[k++] = data[i++];
      }
    }
    while (i <= middle) {
      temp[k++] = data[i++];
    }
    while (j <= right) {
      temp[k++] = data[j++];
    }
    // 将temp数组复制到data数组
    for (i = left, k = 0; i <= right; i++, k++) {
      data[i] = temp[k];
    }
    System.out.println(Arrays.toString(temp));
  }

  // 快速排序
  public void quickSort(int left, int right) {
    System.out.printf("Before: %d - %d %n", left, right);
    if (left >= right) {
      return;
    }
    int pivot = (left + right) / 2;
    int temp = 0;
    // swap(right, pivot);
    // pivot = right;
    for (int i = left; i <= right; i++) {
      if (i > pivot && data[i] < data[pivot]) {
        // 在基准元素后面，且比基准元素小时，移动到基准元素前面，其他元素向后平移
        // move(i, pivot);
        // pivot++;

        // 较小的元素在基准元素后时，交换，i从基准元素原位置后面一位接着进行比较
        swap(i, pivot);
        temp = pivot;
        pivot = i;
        i = temp + 1;
        System.out.println(Arrays.toString(data));

      }
      // 较大的元素在基准元素前面时，交换
      if (i < pivot && data[i] > data[pivot]) {
        swap(i, pivot);
        pivot = i;
        System.out.println(Arrays.toString(data));

      }
    }

    quickSort(left, pivot - 1);
    System.out.printf("Center: : %d - %d %n", left, pivot - 1);
    quickSort(pivot + 1, right);
    System.out.printf("After: : %d - %d %n", pivot + 1, right);

  }

  public void move(int i, int pivot) {
    int temp = data[i];
    for (int k = i; k > pivot; k--) {
      data[k] = data[k - 1];
    }
    data[pivot] = temp;
  }

  public void swap(int i, int pivot) {
    int temp = data[i];
    data[i] = data[pivot];
    data[pivot] = temp;
  }

  public void quickSort2(int left, int right) {
    if (left >= right) {
      return;
    }
    int pivot = data[left];
    int i = left;
    int j = right;
    // 两个指针，分别从两边扫描
    while (i < j) {
      // 从右扫描，找到第一个小于pivot的值，交换
      while (i < j && data[j] >= pivot) {
        j--;
      }
      if (i < j) {
        swap(i++, j);
      }
      // 从左边扫描，找到第一个大于pivot的值，交换
      while (i < j && data[i] <= pivot) {
        i++;
      }
      if (i < j) {
        swap(i, j--);
      }
    }
    quickSort2(left, i - 1);
    quickSort2(i + 1, right);
  }
}
