import java.util.Arrays;
import java.util.Map;

public class test {

  public static void main(String[] args) {
    testHuffman();
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

  public static void testHuffman() {
    String[] characters = { "f", "e", "c", "b", "d", "a" };
    int[] weight = { 5, 9, 12, 13, 16, 45 };
    String[] charCode = new String[weight.length];
    Huffman huffman = new Huffman(weight);
    TreeNode huffmanTree = huffman.getTree();
    System.out.println("ok");
    huffman.getCode(huffmanTree, true);
    Map<Integer, String> hashMap = huffman.hashMap;
    for (int i = 0; i < weight.length; i++) {
      charCode[i] = hashMap.get(weight[i]);
    }
    System.out.println(Arrays.toString(charCode));

  }
}
