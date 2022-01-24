/*
Construct Binary Search Tree from a given Preorder Traversal using Recursion
Objective: – Given a preorder traversal, construct BST from that.

Input: Preorder traverse
Approach # 1 Brute Force
Preorder- first value will be root
And then iterate through the list of preorder traverse values and if you find the value greater than the root value
then right subtree index starts from that number.
O(n^2) time complexity and O(n) space complexity

Approach # 2 Optimal Solution

“Your root value can have any value between -∞ to + ∞, say it is 30 here,
When you validate the right child of 30, it can take any value between 30 and + ∞.
When you validate the left child of 30, it can take any value between — ∞ and 30. likewise,
So the idea is Pass the minimum and maximum values between which the node’s value must lie.
Example: int[] preOrder = { 20, 10, 5, 1, 7, 15, 30, 25, 35, 32, 40 };
First element in the preorder[] will definitely be the root, which is 20 here.
we start with the range minimum = Integer.MIN_VALUE and maximum = Integer.MAX_VALUE,
so your root can take any value between this range.
So when putting the left node of 20(root), it must lie within the range to minimum = Integer.MIN_VALUE
and maximum = 20, so check the next element in the preorder[], if it lies in this range,
make it the left child to the root, else it must the  right child of the root and so on.
Solve it recursively.
Time Complexity: O(n)
 */

import java.util.List;

public class ReconstructBSTFromPreOrderTraversal {
  static class BST {
      public int value;
      public BST left = null;
      public BST right = null;

      public BST (int value) {
          this.value = value;
      }
  }
    // O(n^2) Time and O(n) space
    public BST reconstructBst(List<Integer> preOrderTraversalValues) {
      if (preOrderTraversalValues.size() == 0) {
          return null;
      }
      int currentValue = preOrderTraversalValues.get(0);
      int rightSubtreeRootIdx = preOrderTraversalValues.size();

      for (int idx = 1; idx < preOrderTraversalValues.size(); idx++) {
          int value = preOrderTraversalValues.get(idx);
          if (value >= currentValue) {
              rightSubtreeRootIdx = idx;
              break;
          }
      }
      BST leftSubTree = reconstructBst(preOrderTraversalValues.subList(1, rightSubtreeRootIdx));
      BST rightSubTree = reconstructBst(preOrderTraversalValues.subList(rightSubtreeRootIdx,
              preOrderTraversalValues.size()));
      BST bst = new BST(currentValue);
      bst.left = leftSubTree;
      bst.right = rightSubTree;
      return bst;
    }

    //Optimal Solution
    static class TreeInfo {
      public int rootIdx;
      public TreeInfo (int rootIdx) {
          this.rootIdx = rootIdx;
      }
    }
    public BST reconstructBst2(List<Integer> preOrderTraversalValues) {
      TreeInfo treeInfo = new TreeInfo(0);
      return reconstructBstFromRange(Integer.MIN_VALUE, Integer.MAX_VALUE,
              preOrderTraversalValues, treeInfo);

    }
    public static BST reconstructBstFromRange(int lowerBound, int upperBound, List<Integer> preOrderList,
                                              TreeInfo currentSubTreeInfo) {
      if (currentSubTreeInfo.rootIdx == preOrderList.size()) {
          return null;
      }
      int rootValue = preOrderList.get(currentSubTreeInfo.rootIdx);
      if (rootValue < lowerBound || rootValue > upperBound) {
          return null;
      }
      currentSubTreeInfo.rootIdx += 1;
      BST leftTree = reconstructBstFromRange(lowerBound, rootValue, preOrderList, currentSubTreeInfo);
      BST rightTree = reconstructBstFromRange(rootValue, upperBound, preOrderList, currentSubTreeInfo);

      BST bst = new BST(rootValue);
      bst.left = leftTree;
      bst.right = rightTree;
      return bst;
    }

  }
