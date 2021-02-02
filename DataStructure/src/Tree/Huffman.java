import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Huffman {
  TreeNode huffmanTree;
  MinHeap miniHeap;
  List<Integer> charCode;
  Map<Integer, String> hashMap;

  Huffman(int[] weight) {
    int n = weight.length;
    this.miniHeap = new MinHeap(n);
    for (int i = 0; i < n; i++) {
      TreeNode tree = new TreeNode(weight[i]);
      this.miniHeap.insert(tree);
    }
    this.charCode = new ArrayList<>();
    this.hashMap = new HashMap<>();
  }

  public TreeNode getTree() {
    while (miniHeap.size > 1) {
      TreeNode tree0 = miniHeap.delete();
      TreeNode tree1 = miniHeap.delete();
      TreeNode tree = new TreeNode(tree0.val + tree1.val, tree0, tree1);
      miniHeap.insert(tree);
    }
    huffmanTree = miniHeap.delete();
    return huffmanTree;
  }

  public void getCode(TreeNode tree, boolean key) {
    // 采用递归遍历
    // 先序：记录路径上的值，向左加0，向右加1
    if (tree != null) {
      if (key) {
        System.out.printf("left: %d ", tree.val);
        charCode.add(0);
      } else {
        System.out.printf("right: %d ", tree.val);
        charCode.add(1);
      }

      getCode(tree.left, true);

      // 中序，经过叶结点，
      // 路径上，需要删除访问根结点时时设置的0
      // 将数组转化为字符串
      List<Integer> l2 = new ArrayList<>(charCode); // 复制List
      l2.remove(0);
      System.out.println(l2);
      StringBuilder sb = new StringBuilder();
      for (int i : l2) {
        sb.append(i);
      }
      System.out.println(sb);
      // 使用HashMap 存储生成的编码
      hashMap.computeIfAbsent(tree.val, k -> sb.toString());

      getCode(tree.right, false);
      // 后序列，开始回溯，回溯时删除List的最后一个元素
      System.out.printf("after: %d ", tree.val);
      charCode.remove(charCode.size() - 1);
    }
  }

}
