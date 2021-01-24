public class test {

  public static void main(String[] args) {
    testBST();
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

}
