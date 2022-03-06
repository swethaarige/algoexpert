/*
Smallest Difference pair of values between two unsorted Arrays
Given two arrays of integers, compute the pair of values (one value in each array) with the smallest
(non-negative) difference. Return the difference.
Input : A[] = {l, 3, 15, 11, 2}
        B[] = {23, 127, 235, 19, 8}
Output : 3
That is, the pair (11, 8)
A simple solution is to Brute Force using two loops with Time Complexity O(n2).
A better solution is to sort the arrays. Once the arrays are sorted, we can find the minimum
difference by iterating through the arrays using the approach discussed below.
Consider the following two arrays:
A: {l, 2, 11, 15}
B: {4, 12, 19, 23, 127, 235}
1. Suppose a pointer a points to the beginning of A and a pointer b points to the beginning of B.
The current difference between a and bis 3. Store this as the min.
2. How can we (potentially) make this difference smaller? Well, the value at bis bigger than
the value at a, so moving b will only make the difference larger. Therefore, we want to move a.
3. Now a points to 2 and b (still) points to 4. This difference is 2, so we should update min.
Move a, since it is smaller.
4. Now a points to 11 and b points to 4. Move b.
5. Now a points to 11 and b points to 12. Update min to 1. Move b. And so on.
 */
//Time Complexity is O(nlogn)+O(mlogm) n is length of A array and m is length of B array.
//Space Complexity is O(1)
public class SmallestDifference {
    public static void main (String[] args) {
        int[] arrayOne = {1, 2, 11, 15};
        int[] arrayTwo = {4, 12, 19, 23, 127, 235};
        int[] A = {10, 5, 40};
        int[] B = {50, 90, 80};
        int[] twoPairsSe1 = smallestDifference(arrayOne, arrayTwo);
        int[] twoPairsSe2 = smallestDifference(A, B);
        System.out.println("Smallest Difference between 2 arrays is : "
                +twoPairsSe1[0] + ", " +twoPairsSe1[1]);
        System.out.println("Smallest Difference between 2 arrays is : "
                +twoPairsSe2[0] + ", " +twoPairsSe2[1]);
    }
    public static int[] smallestDifference (int[] arrayOne, int[] arrayTwo) {
        int idxOne = 0;
        int idxTwo = 0;
        int smallestNum = Integer.MAX_VALUE;
        int currentSum;
        int[] smallestPair = new int[2] ;
        while (idxOne < arrayOne.length && idxTwo < arrayTwo.length) {
            int firstNum = arrayOne[idxOne];
            int secondNum = arrayTwo[idxTwo];
            if (firstNum < secondNum) {
                currentSum = secondNum - firstNum;
                idxOne ++;
            }
            else if (secondNum < firstNum) {
                currentSum = firstNum - secondNum;
                idxTwo++;
            }
            else {
                return new int[] {firstNum, secondNum};
            }
            if (smallestNum > currentSum) {
                smallestNum = currentSum;
                smallestPair = new int[]{firstNum, secondNum};
            }
        }
        return smallestPair;
    }
}
