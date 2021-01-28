public class AVLTree {

  AVLTree() {
  }

  public int max(int a, int b) {
    return a > b ? a : b;
  }

  public AVLNode insert(AVLNode tree, int x) {
    if (tree == null) {
      tree = new AVLNode(x);
      tree.height = 1;
    } else if (x < tree.val) {
      // 插入左子树
      tree.left = insert(tree.left, x);
      // 如果需要左旋
      if (getHeight(tree.left) - getHeight(tree.right) == 2) {
        if (x < tree.left.val) {
          tree = singleLeftRotation(tree);
        } else {
          tree = doubleLeftRightRotation(tree);
        }
      }
    } else if (x > tree.val) {
      // 插入右子树
      tree.right = insert(tree.right, x);
      // 如果需要右旋
      if (getHeight(tree.left) - getHeight(tree.right) == -2) {
        if (x > tree.right.val) {
          tree = singleRightRotation(tree);
        } else {
          tree = doubleRightLeftRotation(tree);
        }
      }
    }
    tree.height = max(getHeight(tree.left), getHeight(tree.right)) + 1;

    return tree;
  }

  public int getHeight(AVLNode tree) {
    int leftHeight;
    int rightHeight;
    int maxHeight;
    if (tree != null) {
      leftHeight = getHeight(tree.left);
      rightHeight = getHeight(tree.right);
      maxHeight = leftHeight > rightHeight ? leftHeight : rightHeight;
      return maxHeight + 1;
    } else {
      return 0;
    }
  }

  public AVLNode singleLeftRotation(AVLNode tree) {
    return tree;
  }

  public AVLNode doubleLeftRightRotation(AVLNode tree) {
    return tree;
  }

  public AVLNode singleRightRotation(AVLNode tree) {
    return tree;
  }

  public AVLNode doubleRightLeftRotation(AVLNode tree) {
    return tree;
  }
}
