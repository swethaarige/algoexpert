/*
Understanding the problem
Given a Binary Tree, I am asked to write a function that computes all of the branch sums
of the tree and returns them in an array ordered from leftmost branch sum to rightmost
branch sum. In a tree, a branch is a path that starts at the root node and ends at one of
the leaf nodes. A branch sum means the sum of all values in a branch.

Sample Input:

tree =   1
      /     \
     2       3
   /   \   /   \
  4     5 6     7
 / \
8   9
The output should be:

[15, 16, 8, 10, 11]

Approach with recursive DFS
Instead of using a stack to keep track of the next node that needs to be visited and the running sum,
use the call stack to track these info.

Initialize an empty array to store the branch sums.

Define a helper function that will be recursively invoked. The function takes in three parameters.
The first parameter is the node needs to be visited; the second parameter is the running sum;
and the last parameter is the branch sums array. Call the helper function in the main function
passing in the root node of the tree as the node to be visited, 0 as the running sums and the
empty branch sums array. In the helper function:

Check if the node to be visited is null. If it is, return.

Calculate the new running sum by adding the value of the node to the running sum.

If the node doesn't have any children, append the new running sum to the branch sums array.

Recursively call the helper function passing in the left child of the node, the new running sum
and the branch sums array.

Recursively call the helper function passing in the right child of the node, the new running sum
and the branch sums array.

When I get out of the helper function, return the branch sums array as part of the main function.

Time & Space Complexity
O(n) time | O(n) space, where n is the number of nodes in the Binary Tree.

Each recursive call to the helper function adds a new frame on the call stack. On average
we will never have more than log(n) recursive calls on the call stack, since we eliminate
half the nodes in the remaining tree at each recursive call. In the worst case, when we are
dealing with a very imbalanced binary tree, we would have O(n) space from the recursive calls,
since we have n recursive calls on the call stack at once. Besides the space from the recursive calls,
we also return an array of branch sums. The size of the array is same as the number of branches
in the Binary Tree, which is the number of leaf nodes in the Binary Tree.
There are roughly half of n leaf nodes in the Binary Tree and half of n is equal to O(n)
in the space time complexity analysis.
 */

import java.util.ArrayList;
import java.util.List;

public class BranchSums {
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> sums = new ArrayList<Integer>();
        calculateBranchSums(root, 0, sums);
        return sums;
    }

    public static void calculateBranchSums(BinaryTree node, int runningSum, List<Integer> sums) {
        if (node == null)
            return;
        int newRunningSum = runningSum + node.value;
        if (node.left == null && node.right == null) {
            sums.add(newRunningSum);
            return;
        }
        calculateBranchSums(node.left, newRunningSum, sums);
        calculateBranchSums(node.right, newRunningSum, sums);
    }
}
