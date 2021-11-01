import java.util.HashSet;
import java.util.Set;

/*
 Two Number Sum

 Understanding the problem
 Given an array of integers, no number in this array is repeated,
 and an integer representing the target sum, implement a function
 that find whether there's a pair of numbers in the array that
 adds up to the target sum. Return the pair in an array.
 If such pair does not exist, return an empty array.

 Sample Input:
 array = [3,5,-4,8,11,1,-1,6]
 targetSum = 10

 Sample Output:
 [-1,11]
 */
public class TwoNumberSum {
 public static void main (String[] args) {
     int[] array = new int[]{3,5,-4,8,11,1,-1,6};
     int targetSum = 10;
     int result[] = twoNumberSumSolution1(array, targetSum);
     int result2[] = twoNumberSumSolution2(array, targetSum);
     int result3[] = twoNumberSumSolution3(array, targetSum);
     System.out.println("TwoNumberSum for the given inputs through Solution1  :" +result[0]+result[1]);
     System.out.println("TwoNumberSum for the given inputs through Solution2  :" +result2[0]+result2[1]);
     System.out.println("TwoNumberSum for the given inputs through Solution3  :" +result3[0]+result3[1]);

 }

    /**
     * Time Complexity O(n^2) and SpaceComplexity O(1)
     * @param array
     * @param targetSum
     * @return
     */
 public static int[] twoNumberSumSolution1 (int[] array, int targetSum) {
     for (int i = 0; i < array.length-1; i++ ) {
         int firstNum = array [i];
         for ( int j = i+1; j < array.length ; j++ ) {
             int secondNum = array [j];
             if( firstNum +secondNum == targetSum) {
                 return new int[] {firstNum, secondNum};
             }
         }
     }
     return new int[0];
 }
    /**
     * Time Complexity O(n) and Space Complexity O(n)
     */
    public static int[] twoNumberSumSolution2 ( int [] array, int targetSum) {
        Set<Integer> nums = new HashSet<>();
        for ( int num : array) {
            int potentialMatch = targetSum - num;
            if(nums.contains(potentialMatch)) {
                return new int[] {potentialMatch, num};
            }
            else {
                nums.add(num);
            }
        }
        return new int[0];
    }

    /**
     * Time Complexity O(nlogn)for sorting + traversing array O(n)= O(nlogn)
     * Space Complexity O(1)
     * @param array
     * @param targetSum
     * @return
     */

    public static int[] twoNumberSumSolution3 (int [] array, int targetSum) {
        int left = 0;
        int right = array.length-1;
        while (left < right) {
            int currentSum = array[left] + array[right] ;
            if(currentSum == targetSum) {
                return new int[] {array[left], array[right]};
            }
            else if (currentSum < targetSum) {
                left ++;
            }
            else if (currentSum > targetSum) {
                right --;
            }
        }
        return new int[0];
    }
}
