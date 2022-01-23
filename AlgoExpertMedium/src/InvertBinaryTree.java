/*
Given the root of a binary tree, invert the tree,
The function should swap every left node in the tree to its corresponding right node.
 */
//O(n) Time and O(d) space
public class InvertBinaryTree {
    public static void invertBinaryTree(BinaryTree tree) {
         if (tree == null) {
             return;
         }
         swapLeftAndRight(tree);
         invertBinaryTree(tree.left);
         invertBinaryTree(tree.right);
    }
    public static void swapLeftAndRight(BinaryTree tree) {
        BinaryTree left = tree.left;
        tree.left = tree.right;
        tree.right = left;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
