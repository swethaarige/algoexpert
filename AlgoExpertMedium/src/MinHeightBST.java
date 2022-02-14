import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a sorted array with unique elements, Create a binary search tree with minimal height.
Input: A one dimensional array
Output: Binary Search Tree of Minimal Height
Sorted Array To BST Example
Approach:
Recursion:
Get the middle of the array make it as root. (By doing this we will ensure that half of the elements of array
will be on the left side of the root and half on the right side.)
Take the left half of the array, call recursively and add it to root.left.
Take the right half of the array, call recursively and add it to root.right.
return root.
Time Complexity - O(n) Space Complexity - O(n)
 */
public class MinHeightBST {
    public static void main(String[] args) {
        int[] arrA = {2, 3, 6, 7, 8, 9, 12, 15, 16, 18, 20};
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2); list.add(3); list.add(6); list.add(7); list.add(8); list.add(9);
        list.add(12); list.add(15); list.add(16); list.add(18); list.add(20);
        MinHeightBST s = new MinHeightBST();
        BST x = s.minHeightBst(list);
        System.out.println("Tree Display : ");
        s.displayTree(x);
    }
    public void displayTree(BST root){
        if(root!=null){
            displayTree(root.left);
            System.out.print(" " + root.value);
            displayTree(root.right);
        }
    }

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
