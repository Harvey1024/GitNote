import java.util.concurrent.DelayQueue;

public class Heap {
  Edge[] data;
  int size;
  int capacity;
  private final int MINDATA = -1;

  Heap(int maxSize) {
    this.data = new Edge[maxSize];
    this.size = 0;
    this.capacity = maxSize;
    this.data[0] = new Edge(MINDATA);
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

  public boolean isEmpty() {
    return size == 1;
  }

  public Edge delete() {
    Edge minEdge = data[1];
    int parent = 1;
    int child;
    Edge temp = data[size--];
    if (isEmpty()) {
      return temp;
    }
    for (; parent * 2 < size; parent = child) {
      child = 2 * parent;
      if (child != size && data[child].weight > data[child + 1].weight) {
        child++;
      }
      if (temp.weight <= data[child].weight) {
        break;
      } else {
        data[parent] = data[child];
      }
    }
    data[parent] = temp;
    return minEdge;
  }

}
