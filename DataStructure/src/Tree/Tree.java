import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {
  Tree() {
  }

  // 判断两个树是否相等
  public boolean isSameTree(TreeNode t1, TreeNode t2) {
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

  // 中序遍历，非递归方法
  public void InorderTraversal(TreeNode t) {
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

  // 中序遍历，递归方法
  public void InorderTraversalRecursion(TreeNode treeNode) {
    if (treeNode != null) {
      System.out.println(treeNode.val);
      InorderTraversalRecursion(treeNode.left);
      InorderTraversalRecursion(treeNode.right);
    }
  }

  // 层序遍历，广度优先搜索
  public void LevelorderTraversal(TreeNode t) {
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

  // 求树的高度
  public int getHeight(TreeNode treeNode) {
    int leftHeight;
    int rightHeight;
    int maxHeight;
    if (treeNode != null) {
      leftHeight = getHeight(treeNode.left);
      rightHeight = getHeight(treeNode.right);
      maxHeight = leftHeight > rightHeight ? leftHeight : rightHeight;
      return maxHeight + 1;
    } else {
      return 0;
    }
  }

  // 创建二叉树，层序方法，从上到下，从左到右
  public TreeNode createTreeLevelMethod(int[] a) {
    Queue<TreeNode> queue = new LinkedList<>();
    if (a.length == 0) {
      return new TreeNode();
    }
    int i = 0;
    TreeNode head = new TreeNode(a[i++]);
    queue.offer(head);
    while (!queue.isEmpty()) {
      TreeNode tree = queue.poll();
      TreeNode left = null;
      TreeNode right = null;

      if (i < a.length && a[i] != -1) {
        left = new TreeNode(a[i]);
        queue.offer(left);
      }
      i++;
      if (i < a.length && a[i] != -1) {
        right = new TreeNode(a[i]);
        queue.offer(right);
      }
      i++;
      tree.left = left;
      tree.right = right;

    }
    return head;
  }

  // 创建树，从底部向上
  public TreeNode createTree(int[] a) {
    int level = 0;
    double b = 0;
    while (true) {
      b = Math.pow(2, level) - 1;
      if (a.length <= b) {
        break;
      }
      level++;
    }

    System.out.printf("tree level: %d %n", level);
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
