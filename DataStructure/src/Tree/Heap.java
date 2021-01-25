
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

  public boolean deleteMax() {

    return true;
  }
}
