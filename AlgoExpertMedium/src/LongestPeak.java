/*
You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given an integer array arr, return the length of the longest subarray,
which is a mountain. Return 0 if there is no mountain subarray

Example 1:

Input: arr = [2,1,4,7,3,2,5]
Output: 5
Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
//O(n) Time O(1) Space
 */

public class LongestPeak {
    public static void main(String[] args) {
      int[] array = {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
      System.out.println("Longest Peak length in the given array is :" +longestPeak(array));
    }
    public static int longestPeak(int[] array) {
        int longestPeakLength = 0;
        int i = 1;
        while (i < array.length - 1) {
            boolean isPeak = array[i] > array[i - 1] && array[i] > array[i + 1];
            if (!isPeak) {
                i += 1;
                continue;
            }
            int leftIdx = i - 2;
            while (leftIdx >= 0 && array[leftIdx] < array[leftIdx + 1]) {
                leftIdx -= 1;
            }
            int rightIdx = i + 2;
            while (rightIdx < array.length  && array[rightIdx] < array[rightIdx - 1]) {
                rightIdx += 1;
            }
            int currentPeakLength = rightIdx - leftIdx - 1;
            if (longestPeakLength < currentPeakLength) {
                longestPeakLength = currentPeakLength;
            }
            i = rightIdx;
        }
        return longestPeakLength;
    }

}
