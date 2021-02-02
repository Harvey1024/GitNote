
public class MinHeap {
  TreeNode[] data;
  int size;
  int capacity;
  private final int MINDATA = -1;

  MinHeap(int maxSize) {
    // 0位置是哨兵，所以数组长度需要+1
    this.data = new TreeNode[maxSize + 1];
    this.size = 0;
    this.capacity = maxSize;
    this.data[0] = new TreeNode(MINDATA);
  }

  public boolean insert(TreeNode x) {
    if (isFull()) {
      return false;
    }
    int i = ++size;
    for (; data[i / 2].val > x.val; i /= 2) {
      data[i] = data[i / 2];
    }
    data[i] = x;
    return true;
  }

  public boolean isFull() {
    return size == capacity;
  }

  public boolean isEmpty() {
    return size == 1;
  }

  public TreeNode delete() {
    TreeNode minEdge = data[1];
    int parent = 1;
    int child;
    TreeNode temp = data[size--];
    if (isEmpty()) {
      return temp;
    }
    for (; parent * 2 < size; parent = child) {
      child = 2 * parent;
      if (child != size && data[child].val > data[child + 1].val) {
        child++;
      }
      if (temp.val <= data[child].val) {
        break;
      } else {
        data[parent] = data[child];
      }
    }
    data[parent] = temp;
    return minEdge;
  }

}
