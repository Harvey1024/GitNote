public class AVLNode {
  int val;
  AVLNode left;
  AVLNode right;
  int height;

  AVLNode() {
  }

  AVLNode(int x) {
    this.val = x;
  }

  AVLNode(int x, AVLNode left, AVLNode right) {
    this.val = x;
    this.left = left;
    this.right = right;
  }

}
