import java.util.ArrayDeque;

/*
Given the root of a binary tree, invert the tree,
The function should swap every left node in the tree to its corresponding right node.
1. Recursive Solution O(n) Time and O(d) Space
This is one of the most famous interview questions and can be easily solved recursively.
The idea is to traverse the tree in a preorder fashion, and for every node encountered,
swap its left and right child before recursively inverting its left and right subtree.
2. Iterative solution using queue
Steps to invert a Binary Tree iteratively using Queue:
If root/ current node is NULL, inverting is done.
Define a queue Q.
Add root node to queue Q.
While queue Q is not empty:
4.1. Pop node N from queue Q from left side.
4.2. Swap left and right child of node N
4.3. Push new left and right child of node N to queue Q.
The Binary Tree is inverted.
Iterative solution using queue	O(n)	O(n)
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
    public static void invertBinaryTree2(BinaryTree tree) {
        ArrayDeque<BinaryTree> queue = new ArrayDeque<>();
        queue.addLast(tree);
        while (queue != null) {
            BinaryTree current = queue.pollFirst();
            swapLeftAndRight(current);
            if (current.left != null) {
                queue.addLast(current.left);
            }
            if (current.right != null) {
                queue.addLast(current.right);
            }
        }
    }
}
