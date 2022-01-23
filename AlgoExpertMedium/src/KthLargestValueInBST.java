/*
Given a Binary Search Tree, find the Kth Largest element in the given tree.
Find k'th largest element in a BST
Solution1 : Brute Force
A very simple solution is to perform inorder traversal and store the elements of BST in an
array which will give us all elements in sorted order. So the largest element will be present in (n - 1)th position
to find kth largest element it will be (n- k)th index.
By traversing the array in reverse order
and maintaining a count, we can return the Kth largest element.
Time Complexity: Traversing the tree for storing elements in an array +
Traversing the array in reverse order = O(n) + O(n) = O(n)
Space Complexity: O(n) (We are using an extra array of n size, where n is the number of nodes.)

2. Using Reverse Inorder Traversal
The idea is to do reverse inorder traversal of BST which helps to explore all the nodes
in decreasing order. While doing the traversal, we keep track of count of nodes visited so far.
When the count becomes equal to K, we stop the traversal and return the value stored in the node.
Complexity Analysis
Time complexity: Traversing tree in reverse in-order = O(n)
Space complexity: O(h) for recursion call stack, where h is the height of the tree.
 */

import java.util.ArrayList;

public class KthLargestValueInBST {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST (int value) {
            this.value = value;
        }
    }
    public int findKthLargestValueInBst(BST tree, int k) {
        ArrayList<Integer> sortedNodeValues = new ArrayList<>();
        inOrderTraverse(tree, sortedNodeValues);
        return sortedNodeValues.get(sortedNodeValues.size() - k);
    }

    public static void inOrderTraverse(BST tree, ArrayList<Integer> list) {
        if (tree == null) return;

        inOrderTraverse(tree.left, list);
        list.add(tree.value);
        inOrderTraverse(tree.right, list);
    }

    //Solution2
    static class TreeInfo {
        public int numberOfNodesVisited;
        public int latestVisitedNodeValue;

        public TreeInfo(int numberOfNodesVisited, int latestVisitedNodeValue) {
            this.numberOfNodesVisited = numberOfNodesVisited;
            this.latestVisitedNodeValue = latestVisitedNodeValue;
        }
    }
    public int findKthLargestValueInBst2(BST tree, int k) {
        TreeInfo treeInfo = new TreeInfo(0, -1);
        reverseInOrderTraversal(tree, k, treeInfo);
        return treeInfo.latestVisitedNodeValue;
    }
    public void reverseInOrderTraversal(BST tree, int k, TreeInfo treeInfo) {
        if (tree == null || treeInfo.numberOfNodesVisited >= k) return;

        reverseInOrderTraversal(tree.right, k, treeInfo);
        if (treeInfo.numberOfNodesVisited < k) {
            treeInfo.numberOfNodesVisited += 1;
            treeInfo.latestVisitedNodeValue = tree.value;
            reverseInOrderTraversal(tree.left, k, treeInfo);
        }
    }

}
