import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
  public static void main(String[] args) {
    System.out.println("Tree");
    int[] a = { 1, 2, 3, 4, 5 };
    int[] b = { 1, 2, 3, 4 };

    TreeNode t1 = createTree(a);
    TreeNode t2 = createTree(b);
    boolean k = isSameTree(t1, t2);
    // System.out.printf("same tree? %s %n", String.valueOf(k));
    // isSameTree2(t1, t2);
    LevelorderTraversal(t1);
  }

  public static boolean isSameTree(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) {
      return true;
    } else if (t1 == null || t2 == null) {
      return false;
    } else if (t1.val != t2.val) {
      return false;
    } else {
      return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }
  }

  public static void InorderTraversal(TreeNode t) {
    Stack<TreeNode> s = new Stack<>();

    TreeNode kk = t;
    while (kk != null || !s.empty()) {
      while (kk != null) {
        s.push(kk);
        kk = kk.left;
      }
      kk = s.pop();
      System.out.println(kk.val);
      kk = kk.right;
    }
  }

  public static void LevelorderTraversal(TreeNode t) {
    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode treeNode = new TreeNode();
    if (t == null) {
      return;
    }
    queue.offer(t);
    while (!queue.isEmpty()) {
      treeNode = queue.poll();
      System.out.println(treeNode.val);
      if (treeNode.left != null) {
        queue.offer(treeNode.left);
      }
      if (treeNode.right != null) {
        queue.offer(treeNode.right);
      }
    }
  }

  public static TreeNode createTree(int[] a) {
    int level = 0;
    double b = 0;
    while (true) {
      b = Math.pow(2, level) - 1;
      if (a.length <= b) {
        break;
      }
      level++;
    }
    TreeNode[] trees = new TreeNode[a.length];
    int kk = (int) Math.pow(2, level - 1) - 1;
    while (kk >= 0) {
      for (int i = kk; i < a.length; i++) {
        TreeNode t = new TreeNode();
        t.val = a[i];
        if (2 * i + 1 > a.length - 1) {
          t.left = null;
        } else {
          t.left = trees[2 * i + 1];
        }
        if (2 * i + 2 > a.length - 1) {
          t.right = null;
        } else {
          t.right = trees[2 * i + 2];
        }
        trees[i] = t;
      }
      kk = (int) Math.pow(2, --level - 1) - 1;
    }

    return trees[0];
  }

}
