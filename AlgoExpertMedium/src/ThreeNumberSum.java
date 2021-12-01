/*
Three Number Sum Problem (Find all triplets with the given sum)

Given an array of integers, find all triplets in the array that sum up to a given target value.
In other words, given an array arr and a target value target, return all triplets a, b, c
such that a + b + c = target.
If no three numbers sum upto target sum, the function should return an empty array.
Example:
Input array: [7, 12, 3, 1, 2, -6, 5, -8, 6]
Target sum: 0
Output: [[2, -8, 6], [3, 5, -8], [1, -6, 5]]
 */
/*
METHOD 1. Naive approach: Use three for loops
The naive approach is to just use three nested for loops and check if the sum of any three elements
in the array is equal to the given target.
class ThreeSum {

  // Time complexity: O(n^3)
  private static List<Integer[]> findThreeSum_BruteForce(int[] nums, int target) {
    List<Integer[]> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          if (nums[i] + nums[j] + nums[k] == target) {
            result.add(new Integer[] { nums[i], nums[j], nums[k] });
          }
        }
      }
    }
    return result;
  }
 */
/*
METHOD 2. Use Sorting along with the two-pointer approach
Another approach is to first sort the array, then -

Iterate through each element of the array and for every iteration,
Fix the first element (nums[i])
Try to find the other two elements whose sum along with nums[i] gives target.
This boils down to the two sum problem.
Time complexity: O(n^2)
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {
    public static void main (String[] args) {
        int[] array = { 12, 3, 1, 2, -6, 5, -8, 6};
        int targetSUm = 0;
        List<Integer[]> resultArray = threeNumberSum(array, targetSUm);
        System.out.println("Triplets in the given array that sum up to a given target value are ");
        for (int i = 0; i < resultArray.size(); i++) {
            Integer[] triplet = resultArray.get(i);
            System.out.println(" [ " +triplet[0] + "," +triplet[1] + "," +triplet[2] + " ]");
        }
    }
    public static List<Integer[]> threeNumberSum (int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> triplets = new ArrayList<>();
        for (int i = 0; i < array.length - 2; i++) {
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                int currentSum = array[left] + array[i] + array[right];
                if (currentSum == targetSum) {
                    Integer[] newTriplet = {array[i], array[left], array[right]};
                    triplets.add(newTriplet);
                    left++;
                    right--;
                }
                else if (currentSum < targetSum) {
                    left++;
                }
                else if (currentSum > targetSum) {
                    right--;
                }
            }
        }
        return triplets;
    }
}
