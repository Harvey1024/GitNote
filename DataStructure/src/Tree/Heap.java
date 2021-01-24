import jdk.javadoc.internal.doclets.formats.html.resources.standard;

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

}
