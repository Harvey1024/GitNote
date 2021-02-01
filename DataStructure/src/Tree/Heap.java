
public class Heap {
  int[] data;
  int size;
  int capacity;

  private final int MAXDATA = 1000;

  Heap(int maxSize) {
    this.data = new int[maxSize];
    this.size = 0;
    this.capacity = maxSize;
    this.data[0] = MAXDATA;
  }

  public boolean insert(int x) {
    if (isFull()) {
      return false;
    }
    int i = ++size;
    for (; data[i / 2] < x; i /= 2) {
      data[i] = data[i / 2];
    }
    data[i] = x;
    return true;
  }

  public boolean isFull() {
    return data[capacity - 1] != 0;
  }

  public boolean isEmpty() {
    return size == 1;
  }

  public int deleteMax() {
    int parent;
    int child;
    int maxItem;
    int temp;
    if (isEmpty()) {
      System.out.println("Heap is empty");
      return -1;
    }
    maxItem = data[1];
    // 将最大堆的最后一个元素从根节点开始向下搜索，直到找到合适的位置
    temp = data[size--];
    for (parent = 1; parent * 2 < size; parent = child) {
      child = 2 * parent;
      if (child != size && data[child] < data[child + 1]) {
        child++;
      }
      if (temp >= data[child]) {
        break;
      } else {
        // 移动temp到下一层 parent = child
        data[parent] = data[child];
      }
    }
    // 找到temp合适的位置
    data[parent] = temp;
    return maxItem;
  }
}
