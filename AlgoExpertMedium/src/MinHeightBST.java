import java.util.List;

/*
Given a sorted array with unique elements, Create a binary search tree with minimal height.
Input: A one dimensional array
Output: Binary Search Tree of Minimal Height
Sorted Array To BST Example
Approach:
Recursion:
Get the middle of the array
make it as root. (By doing this we will ensure that half of the elements of array will be on the left
side of the root and half on the right side.)
Take the left half of the array, call recursively and add it to root.left.
Take the right half of the array, call recursively and add it to root.right.
return root.
Time Complexity - O(n) Space Complexity - O(n)
 */
public class MinHeightBST {
    public static BST minHeightBst(List<Integer> array) {
       return constructMinHeightBST(array, 0, array.size() - 1);
    }
    public static BST constructMinHeightBST(List<Integer> array, int startIdx, int endIdx) {
        if (endIdx < startIdx) {
            return null;
        }
        int middle = (startIdx + endIdx) / 2;
        BST bst = new BST(array.get(middle));
        bst.left = constructMinHeightBST(array, startIdx, middle - 1);
        bst.right = constructMinHeightBST(array, middle + 1, endIdx);
        return bst;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST (int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
