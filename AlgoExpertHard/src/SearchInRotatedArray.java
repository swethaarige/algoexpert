/*
Problem statement: Search for a given number in a sorted array, with unique elements,
that has been rotated by some arbitrary number, assuming that the array does not contain
duplicates. Return -1 if the number does not exist.

The solution is like a binary search with some modifications.
Notice that at least one half of the array is always sorted. If the number n lies within
the sorted half of the array, then our problem is a basic binary search. Otherwise, discard
the sorted half and examine the unsorted half.
Runtime complexity: Logarithmic, O(log n)
Memory complexity: Logarithmic, O(1)
 */
public class SearchInRotatedArray {
    public static void main (String[] args) {
        int[] v1 = {6, 7, 1, 2, 3, 4, 5};
        System.out.println("Key(3) found at: " + shiftedBinarySearch(v1, 3));
        System.out.println("Key(6) found at: " + shiftedBinarySearch(v1, 6));

        int[] v2 = {4, 5, 6, 1, 2, 3};
        System.out.println("Key(3) found at: " + shiftedBinarySearch(v2, 3));
        System.out.println("Key(6) found at: " + shiftedBinarySearch(v2, 6));

    }
    public static int shiftedBinarySearch(int[] array, int target) {
        return shiftedBinarySearch(array, target, 0, array.length - 1);
    }
    public static int shiftedBinarySearch(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int leftNum = array[left];
        int rightNum = array[right];
        int middle = (left + right) / 2;
        int potentialMatch = array[middle];
        if (target == potentialMatch)
            return middle;

        else if (leftNum <= potentialMatch) {
            if (target >= leftNum && target < potentialMatch) {
                return shiftedBinarySearch(array, target, left, middle - 1);

            } else {
                return shiftedBinarySearch(array, target, middle + 1, right);
            }

        } else {
            if (target <= rightNum && target > potentialMatch) {
                return shiftedBinarySearch(array, target, middle + 1, right);
            } else {
                return shiftedBinarySearch(array, target, left, middle - 1);
            }

        }
    }
}
