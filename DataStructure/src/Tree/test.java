import java.util.Arrays;

public class test {

  public static void main(String[] args) {
    testHeap();
  }

  public static void testBST() {
    int[] c = { 30, 15, 41, -1, -1, 33, 50 };
    BST bst = new BST();
    Tree tree = new Tree();
    TreeNode binarySearchTree = tree.createTreeLevelMethod(c);
    bst.insertBST(binarySearchTree, 49);
    tree.LevelorderTraversal(binarySearchTree);
    bst.delete(binarySearchTree, 50);
    System.out.println("delet 50");
    tree.LevelorderTraversal(binarySearchTree);

  }

  public static void test2() {
    TreeNode tree = new TreeNode(1);
    tree = null;
    System.out.println("Hello");
  }

  public static void testHeap() {
    Heap hp = new Heap(5);
    int[] a = { 25, 44, 18, 10, 31, 68 };
    for (int i = 0; i < a.length; i++) {
      hp.insert(a[i]);
    }
    System.out.println(Arrays.toString(hp.data));
  }

}
