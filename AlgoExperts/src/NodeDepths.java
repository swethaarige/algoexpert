/*
Given a Binary Tree, I am asked to write a function that is going to find the depth of each node
in the tree, sum up all of these depths and return the sum.

Suppose I am given the following Binary Tree:

tree =   1
      /     \
     2       3
   /   \   /   \
  4     5 6     7
The sum of all nodes' depths in the above Binary Tree is 10, because the depth of the node with
value 1 is 0, the depth of the node with value 2 is 1, the depth of the node with value 3 is 1,
the depth of the node with value 4 is 2...


RECURSIVE APPROACH
Create a variable that is going to keep track of the running sum of the nodes' depths.
To find the depths of every node in the tree, I can traverse the tree, and at each node,
compute its depth by adding 1 to the depth of its parent node, because the node are one level
deeper than its parent node. After getting the depth of the node, add it to the running sum of depths.

I can traverse the tree either iteratively or recursively. I will traverse the Binary Tree recursively,
because with the recursive approach I don't need to use extra data structure to keep track of the next
node that needs to be visit and its depth, depending on whether I performs a iterative depth-first search
or iterative breadth-first search on the tree.

I would define a new function that would be the actual recursive function.
The recursive function is going to be called on each node starting from the root node.
It would calculate the depth of each node and add the depth to the running sum of depths.
Since the recursive function needs to update the running sum of depths, and the data type
Number in JavaScript is not a reference type, meaning when I pass the running sum of depths
to another function, it will create a copy of the variable und update that copy instead of
the original one, I need to make the running sum of depths accessible to the recursive function
without passing it around. So to do that, the recursive function will be defined within the main function.

The recursive function is going to receive two parameters: the first parameter is the node to be visited
and the second parameter is its depth. Initially, the node is the root node and the depth is 0,
because the distance between the root node and itself is 0. At each node, add the depth of the current
node to the running sum of depths and check if the node has any children. If the node does have children,
add 1 to the depth and that would be the depth of the children nodes, then call the recursive function
passing in the child node and the depth of the child node. If the node to be visited is null, return;
this is going to be the base case of the recursive function. When I get out of the recursive function,
return the sum of depths in the main function.

Time & Space Complexity
Average: O(n) time | O(h) space, where n is the number of nodes in the Binary Tree and h is the height
of the Binary Tree.

Worst(imbalanced Binary Tree): O(n) time | O(n) space, where n is the number of nodes in the Binary Tree.

 */

public class NodeDepths {
    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    public static int nodeDepths(BinaryTree root) {
        return nodeDepthsHelper(root, 0);
    }

    public static int nodeDepthsHelper(BinaryTree node, int depth) {
        if(node == null) return 0;
        return nodeDepthsHelper(node.left , depth + 1) +
                nodeDepthsHelper(node.right , depth + 1);
    }
}
