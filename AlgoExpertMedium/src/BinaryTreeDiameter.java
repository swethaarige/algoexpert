/*
Given the root of a binary tree, return the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
This path may or may not pass through the root.
The length of a path between two nodes is represented by the number of edges between them.
https://leetcode.com/problems/diameter-of-binary-tree/
 */

public class BinaryTreeDiameter {
    static class BinaryTree{
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
    static class TreeInfo {
        public int diameter;
        public int height;
        public TreeInfo(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }
    public int binaryTreeDiameter(BinaryTree tree) {

        return getTreeInfo(tree).diameter;
    }
    public TreeInfo getTreeInfo(BinaryTree tree) {

        if (tree == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo leftTreeInfo = getTreeInfo(tree.left);
        TreeInfo rightTreeInfo = getTreeInfo(tree.right);
        int longestPathThroughRoot = leftTreeInfo.height + rightTreeInfo.height;

        int maxDiameterSoFar = Math.max(leftTreeInfo.diameter, rightTreeInfo.diameter);
        int currentDiameter = Math.max(longestPathThroughRoot, maxDiameterSoFar);
        int currentHeight = 1 + Math.max(leftTreeInfo.height, rightTreeInfo.height);

        return new TreeInfo(currentDiameter, currentHeight);
    }
}
