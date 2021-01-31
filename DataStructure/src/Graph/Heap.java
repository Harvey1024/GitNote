public class Heap {
  Edge[] data;
  int size;
  int capacity;
  private final int MINDATA = -1;

  Heap(int maxSize) {
    this.data = new Edge[maxSize];
    this.size = 0;
    this.capacity = maxSize;
    this.data[0] = new Edge();
  }

  public boolean insert(Edge x) {
    if (isFull()) {
      return false;
    }
    int i = ++size;
    for (; data[i / 2].weight > x.weight; i /= 2) {
      data[i] = data[i / 2];
    }
    data[i] = x;
    return true;
  }

  public boolean isFull() {
    return data[capacity - 1] != null;
  }

  public Edge delete() {
    return data[1];
  }

}
