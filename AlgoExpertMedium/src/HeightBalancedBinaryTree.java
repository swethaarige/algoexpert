/*
Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as:
a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
Approach
To check if a tree is height-balanced, get the height of left and right subtrees.
Return true if difference between heights is not more than 1 and left and right subtrees
are balanced, otherwise return false.
A simple solution would be to calculate the height of the left and right subtree
for each node in the tree. If for any node, the absolute difference between the
height of its left and right subtree is more than 1, the tree is unbalanced.
The time complexity of this solution is O(n2) as there are n nodes in the tree,
and for every node, we are calculating the height of its left and right subtree that takes O(n) time.
We can solve this problem in linear time by doing a postorder traversal on the tree.
Instead of calculating the height of the left and right subtree for every tree node,
we can get the height in constant time. The idea is to start from the bottom of the
tree and return the height of the subtree rooted at the given node to its parent.
The height of a subtree rooted at any node is one more than the maximum height of
the left subtree or the right subtree.
 */
//O(n) Time and O(h) space
public class HeightBalancedBinaryTree {
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.left.left.left = new BinaryTree(8);

        if (heightBalancedBinaryTree(tree))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree (int value) {
            this.value = value;
        }
    }
    static class TreeInfo {
        public boolean isBalanced;
        public int height;
        public TreeInfo(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
    public static boolean heightBalancedBinaryTree(BinaryTree tree) {
        TreeInfo treeInfo = getTreeInfo(tree);
        return treeInfo.isBalanced;
    }

    public static TreeInfo getTreeInfo(BinaryTree tree) {
        if (tree == null) {
            return new TreeInfo(true, -1);
        }
        TreeInfo leftTreeInfo = getTreeInfo(tree.left);
        TreeInfo rightTreeInfo = getTreeInfo(tree.right);
        boolean isBalanced = leftTreeInfo.isBalanced && rightTreeInfo.isBalanced
                && Math.abs(leftTreeInfo.height - rightTreeInfo.height) <= 1;
        int height = 1 + Math.max(leftTreeInfo.height, rightTreeInfo.height);
        return new TreeInfo(isBalanced, height);
    }
}
