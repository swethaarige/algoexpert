/*
Understanding the problem
Given a Binary Search Tree and a target integer value, I am asked to write a function that
returns the closest value to that target value that's contained in the BST. There will
be only one closest value.

For example,

bst =   10
      /     \
     5      15
   /   \   /   \
  2     5 13   22
 /          \
1           14
target = 12
The closest value to the target value in the BST is 13.

Approach
We are going to use a variable to keep track of the current node and initialize it to the root node
of the BST. In addition, we also need a variable to keep track of the closest value in the BST so far;
initialize it to the value of the root node.
While current node is not null,
compute the absolute difference between the value of the current node and the target value, compare
the result to the absolute difference between the closest value we've seen so far and the target.
If we get to a smaller absolute difference, set the value of the current node as the current closest value.
Compare the target value to the current node's value:
if the target value is less than the current node's value, explore the left subtree of the current node;
if the target value is greater than the current node's value, explore the right subtree;
otherwise break out of the while loop, since the current node's value and the target value are equal to
each other, which means there is no other value that can be closer to the target value than this value.
Return the closest value.
Time & Space Complexity
Iterative:

Average: O(log(n)) time | O(1) space, where n is the number of nodes in the Binary Search Tree.

Worst: O(n) time | O(1) space, , where n is the number of nodes in the Binary Search Tree.

 */

public class FindClosestValueInBST {

    public static int findClosestValueInBst(BST tree, int target) {
        return findclosestValueInBst(tree, target, tree.value);
    }
     public static int findclosestValueInBst(BST tree, int target, int closest) {
        BST currentNode = tree;
        while(currentNode != null) {
            if (Math.abs(target - closest) > Math.abs(target - currentNode.value)) {
                closest = currentNode.value;
            }
            if (target < currentNode.value) {
                currentNode = currentNode.left;
            }
            else if (target > currentNode.value) {
                currentNode = currentNode.right;
            }
            else {
                break;
            }
        }
        return  closest;
     }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST (int value) {
            this.value = value;
        }
    }
}
