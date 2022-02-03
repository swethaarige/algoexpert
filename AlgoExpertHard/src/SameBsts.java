/*
Given two arrays of integers that are used to create BSTs.
Imagine we make a Binary Search Tree (BST) from each array. We need to tell whether two
BSTs will be identical or not without actually constructing the tree.
Approach #1
O(n^2) Time and O(n^2) Space
1) Compare sizes of two arrays. If not same, return false.
2) Compare first values of two arrays. If not same, return false.
3) Create two lists from each given array such that the first list contains values smaller than first item of the corresponding array. And second list contains greater values.
4) Recursively check the first list of first array with first list of second and same for second list.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SameBsts {
    public static void main (String[] args) {
        ArrayList<Integer> aL1 =
                new ArrayList<Integer>(Arrays.
                        asList(3, 5, 4, 6, 1, 0, 2));
        ArrayList<Integer> aL2 =
                new ArrayList<Integer>(Arrays.
                        asList(3, 1, 5, 2, 4, 6, 0));

        System.out.println(sameBSTs(aL1, aL2));
    }

    public static boolean sameBSTs(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if (arrayOne.size() != arrayTwo.size()) return false;
        if (arrayOne.size() == 0 && arrayTwo.size() == 0) return true;
        if (arrayOne.get(0).intValue() != arrayTwo.get(0).intValue()) return false;

        List<Integer> leftOne = getSmaller(arrayOne);
        List<Integer> leftTwo = getSmaller(arrayTwo);
        List<Integer> rightOne = getBiggerOrEqual(arrayOne);
        List<Integer> rightTwo = getBiggerOrEqual(arrayTwo);

        return sameBSTs(leftOne, leftTwo) && sameBSTs(rightOne, rightTwo);

    }
    public static List<Integer> getSmaller(List<Integer> array) {
        List<Integer> smaller = new ArrayList<>();
        for (int i = 1 ; i < array.size(); i++) {
            if (array.get(i).intValue() < array.get(0).intValue()) {
                smaller.add(array.get(i).intValue());
            }
        }
        return smaller;
    }
    public static List<Integer> getBiggerOrEqual(List<Integer> array) {
        List<Integer> biggerOrEqual = new ArrayList<>();
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i).intValue() >= array.get(0).intValue()) {
                biggerOrEqual.add(array.get(i).intValue());
            }
        }
        return biggerOrEqual;
    }

}
