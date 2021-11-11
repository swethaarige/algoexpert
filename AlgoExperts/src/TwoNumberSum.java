import java.util.Arrays;
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
     * Approach 2
     * Iterate through every number in the array. At each number, traverse through the rest of the array, if adding any number in the rest of the array to the number yields the target sum, return the pair.
     *
     * Time & Space Complexity
     * O(n^2) time | O(1) space, where n is the length of the input array.
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
     * Approach 1
     * I can solve the problem by looping through each integer in the array and
     * find if there is another integer in the rest of array that is equals to
     * target sum - current integer. But that means I have to use a nested for loop,
     * the outer for loop traverses the array and the inner for loop traverses
     * the rest of the array to find the complement. Instead of the nested for loop,
     * I can keep track of the complement of each integer (target sum - integer)
     * in a hash table, which provides a constant-time lookup on average.
     * In the hash table, the key is the complement and the value is the integer.
     * At each iteration, look up the integer in the hash table, if it is already
     * in the hash table, then the pair is found, return the pair, otherwise,
     * calculate the complement and add the key/value pair into the hash table.
     * If I get out of the for loop without returning the pair, return an empty array.
     *
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
     * Approach 3
     * Use two pointers approach. First sort the array in ascending order.
     * Then initialize two pointers, one pointing to the first element in the sorted array,
     * and the other pointing to the last element in the sorted array.
     * Sum up the values that the two pointers point to.
     * If their sum is smaller than the targetSum, shift the left pointer
     * to right by one, because the array is sorted in ascending order,
     * if I move the right pointer to left, the new sum is even smaller than
     * the current sum, which is already smaller than the targetSum.
     * If their sum is greater than the targetSum, shift the right pointer
     * to left by one. Keep moving the pointers until I get the sum as targetSum
     * or the pointers get equal to each other, which means the pointers are
     * pointing to the same number.
     *
     * Time Complexity O(nlogn)for sorting + traversing array O(n)= O(nlogn)
     * Space Complexity O(1)
     * @param array
     * @param targetSum
     * @return
     */

    public static int[] twoNumberSumSolution3 (int [] array, int targetSum) {
        Arrays.sort(array);
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
