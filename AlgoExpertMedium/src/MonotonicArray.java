/*
An array is monotonic if it is either monotone increasing or monotone decreasing.
An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j].
An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
Given an integer array nums, return true if the given array is monotonic, or false otherwise.
 */
//O(n) Time O(1) Space
/*
Intuition and Algorithm
To perform this check in one pass, we want to remember if it is monotone increasing or monotone decreasing.
It's monotone increasing if there aren't some adjacent values A[i], A[i+1] with A[i] > A[i+1],
and similarly for monotone decreasing.
If it is either monotone increasing or monotone decreasing, then A is monotonic.
 */
public class MonotonicArray {
    public static void main(String[] args) {
        int[] array = {-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        System.out.println("Given Array is Monotonic  :" +isMonotonic(array));
    }
    public static boolean isMonotonic(int[] array) {
        boolean isNonDecreasing = true;
        boolean isNonIncreasing = true;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                isNonIncreasing = false;
            }
            if (array[i] < array[i - 1]) {
                isNonDecreasing = false;
            }
        }
        return isNonDecreasing || isNonIncreasing;
    }
}
