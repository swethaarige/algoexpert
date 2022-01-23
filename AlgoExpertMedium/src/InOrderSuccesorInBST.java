/*
In Binary Tree, Inorder successor of a node is the next node in Inorder traversal of the Binary Tree.
Inorder Successor is NULL for the last node in Inorder traversal.
Method 1 (Uses Parent Pointer)
In this method, we assume that every node has a parent pointer.
The Algorithm is divided into two cases on the basis of the right subtree of the input node being empty or not.

Input: node, root // node is the node whose Inorder successor is needed.
Output: succ // succ is Inorder successor of node.

If right subtree of node is not NULL, then succ lies in right subtree. Do the following.
Go to right subtree and return the left most child of the right subtree
If right subtree of node is NULL, then succ is one of the ancestors. Find the right most Parent.
Complexity Analysis:

Time Complexity: O(h), where h is the height of the tree.
As in the second case(suppose skewed tree) we have to travel all the way towards the root.
Auxiliary Space: O(1).
Due to no use of any data structure for storing values.

 */
public class InOrderSuccesorInBST {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        if (node.right != null) return getLeftMostChild(node.right);
         return getRightMostParent(node);
    }

    public static BinaryTree getLeftMostChild(BinaryTree node) {
        BinaryTree currentNode = node;
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode;
    }

    public static BinaryTree getRightMostParent(BinaryTree node) {
        BinaryTree currentNode = node;
        while (currentNode.parent != null && currentNode.parent.right == currentNode) {
            currentNode = currentNode.parent;
        }
        return  currentNode.parent;
    }
}
