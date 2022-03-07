import java.util.ArrayList;

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
    // Driver program to test above functions
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.left.left.left = new BinaryTree(8);
        BinaryTree succ = findSuccessor(tree, tree.left.left.left);
        if (succ != null) {
            System.out.println(
                    "Inorder successor of "
                            + tree.value + " is " + succ.value);
        }
        else {
            System.out.println(
                    "Inorder successor does not exist");
        }
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
    //O(h) time where h is the height of the binary tree and O(1) space
    public static BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
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
    //O(n) time and O(n) space where n is the number of nodes in the binary tree
    public BinaryTree findSuccessor2(BinaryTree tree, BinaryTree node) {
        ArrayList<BinaryTree> inOrderTraversalList = new ArrayList<>();
        getInOrderTraversalList(tree, inOrderTraversalList);
        for (int i = 0; i < inOrderTraversalList.size(); i++) {
            BinaryTree currentNode = inOrderTraversalList.get(i);

            if (currentNode != node) {
                continue;
            }
            if (i == inOrderTraversalList.size() - 1) {
                return null;
            }
            return inOrderTraversalList.get(i + 1);
        }
        return null;
    }
    public static void getInOrderTraversalList(BinaryTree node,
                                                     ArrayList<BinaryTree> inOrderTraversalList) {
        if (node == null) return;

        getInOrderTraversalList(node.left, inOrderTraversalList);
        inOrderTraversalList.add(node);
        getInOrderTraversalList(node.right, inOrderTraversalList);

    }
}
