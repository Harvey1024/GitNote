import java.util.Queue;
import java.util.LinkedList;

public class BST {

  BST() {
  }

  public TreeNode findBinarySearchTree(TreeNode tree, int x) {
    if (tree == null) {
      return null;
    }
    if (x < tree.val) {
      return findBinarySearchTree(tree.left, x);
    } else if (x > tree.val) {
      return findBinarySearchTree(tree.right, x);
    } else {
      return tree;
    }
  }

  public TreeNode findMinOfBST(TreeNode tree) {
    if (tree == null) {
      return null;
    }
    if (tree.left == null) {
      return tree;
    } else {
      return findMinOfBST(tree.left);
    }

  }

  public TreeNode findMaxOfBST(TreeNode tree) {
    if (tree == null) {
      return null;
    }
    if (tree.right == null) {
      return tree;
    } else {
      return findMaxOfBST(tree.right);
    }
  }

  public TreeNode insertBST(TreeNode tree, int x) {
    if (tree == null) {
      tree = new TreeNode(x);
    }
    if (x < tree.val) {
      tree.left = insertBST(tree.left, x);
    } else if (x > tree.val) {
      tree.right = insertBST(tree.right, x);
    }
    return tree;
  }

  public TreeNode delete(TreeNode tree, int x) {
    if (tree == null) {
      System.out.printf("%d not found in tree.", x);
      return null;
    } else {
      if (x < tree.val) {
        tree.left = delete(tree.left, x);
      } else if (x > tree.val) {
        tree.right = delete(tree.right, x);
      } else {
        // 找到了要删除的点
        // 如果被产出的点有左右两个子结点
        if (tree.left != null && tree.right != null) {
          TreeNode temp = findMinOfBST(tree);
          tree.val = temp.val;
          tree.right = delete(tree.right, tree.val);
        } else {
          // 只有一个或者没有子节点
          if (tree.left == null && tree.right != null) {
            tree = tree.right;
          } else if (tree.left != null) {
            tree = tree.left;
          } else {
            tree = null;
          }

        }
      }
    }
    return tree;
  }
}
