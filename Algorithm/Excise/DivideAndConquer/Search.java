public class Search {
  int[] data;

  Search(int[] data) {
    this.data = data;
  }

  public int get(int target) {
    int left = 0;
    int right = data.length - 1;
    while (left <= right) {
      int middle = (left + right) / 2;
      if (data[middle] == target) {
        return middle;
      } else if (target < data[middle]) {
        // 如果目标值较小，在左侧，右边界值更新
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }
    // 找不到，返回-1
    return -1;
  }
}
