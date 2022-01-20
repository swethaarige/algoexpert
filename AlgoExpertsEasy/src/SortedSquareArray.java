import java.util.Arrays;

/**
 * Given an array of integers that are sorted in increasing order,
 * write a function that squares all the integers in the array
 * and returns them in a new array, also sorted in increasing order.
 *
 *
 Better Approach (based on the video explanation of AlgoExpert)
 Consider we have the input array [-4, -2, 0, 1, 3], after being squared, we got [16, 4, 0, 1, 9], we can realize the smallest possible squared value which could be end up in the output array is 0. The farther the value is away from 0, regardless of whether it is positive or negative, the larger the squared value will become. And the closer the value is to 0, the smaller the squared value. The number line below illustrates this.

 <--|---|---|---|---|---|---|---|---|-->
 -5  -4  -3  -2  -1   0   1   2   3
 25  16   9   4   1   0   1   4   9
 What the number line also tells us is the largest value in the output array is either going to come from
 the smallest element in the input array or the largest element in the input array. Since we know where
 to find the largest squared value in the input array, we can build the sorted squared values array
 from largest square value to smallest squared value. We can use two pointers to keep track of the
 smallest integer and the largest integer in the input array; compare the absolute value of the two
 integers to find out which integer is larger once squared; square the larger value and put it
 into the resulting array; move the pointer that points to the larger value either to left if
 the largest squared value comes from the largest integer or to right if it comes from the
 smallest integer, so we can find the next largest squared value. Continue until the resulting
 array is filled up.

 Initialize an empty array, called sortedSquares to store the sorted squared values. The size of the array
 is going to be the same as the input array.
 Initialize two pointers, one called smallerValueIdx and other called largerValueIdx.
 Point smallerValueIdx to first number in the array and largerValueIdx to the last number in the array.
 Initialize a variable, called i. i is going to index the correct location in the sortedSquares that
 we should put the square into. Initially, i equals the index of the last element in the input array.
 Loop until i is less than 0, which means all numbers are squared and have been put into the resulting array.
 Compare the absolute value of the integer that smallerValueIdx points to with the absolute value of
 the integer that largerValueIdx points to, if the value of the smaller number is greater than or
 equal to the larger number, square the smaller number and place the result into sortedSquares[i];
 increase smallerValueIdx by 1, otherwise, square the larger number and put the square into
 sortedSquares[i], decrease largerValueIdx by 1.
 Decrease i by 1.
 Time & Space Complexity
 O(n) time | O(n) space, where n is the length of the input array.
 */
public class SortedSquareArray {
    public static void main (String[] args) {
        int [] array = new int[]{-4, -2, 0, 1, 3};
        int[] sortedSquares = sortedSquaredArraySol1(array);
        for (int i=0;i<sortedSquares.length; i++) {
            System.out.println("Sorted Sqaures  " + sortedSquares[i]);
        }
        int[] sortedSquares2 = sortedSquaredArraySol2(array);
        for (int i=0;i<sortedSquares2.length; i++) {
            System.out.println("Sorted Sqaures  " + sortedSquares2[i]);
        }
    }
    /** O(nlogn) Time Complexity and O(n) Space complexity **/
    public static int[] sortedSquaredArraySol1 (int[] array) {
        int[] sortedSquares = new int[array.length];
        for ( int i = 0; i < array.length ; i++) {
            int value = array[i];
            sortedSquares[i] = value * value;
        }
        Arrays.sort(sortedSquares);
        return sortedSquares;
    }

    /**
     * O(n) Time and O(n) Space
     *
     */
    public static int[] sortedSquaredArraySol2 (int[] array) {
        int[] sortedSquares = new int[array.length];
        int smallerIdx = 0;
        int largerIdx = array.length - 1;
        for (int idx = array.length - 1 ; idx >= 0; idx--) {
            int smallerIdxValue = array[smallerIdx];
            int largerIdxValue = array[largerIdx];
            if(Math.abs(smallerIdxValue) > Math.abs(largerIdxValue)) {
                sortedSquares[idx] = smallerIdxValue * smallerIdxValue;
                smallerIdx++;
            }
            else{
                sortedSquares[idx] = largerIdxValue * largerIdxValue;
                largerIdx--;
            }
        }
        return sortedSquares;
    }
}
