/*
Kadane’s Algorithm is an iterative dynamic programming algorithm.
It calculates the maximum sum subarray ending at a particular position by using the
maximum sum subarray ending at the previous position.
Follow the below steps to solve the problem.
The simple idea of Kadane’s algorithm is to look for all positive contiguous segments of the array
(max_ending_here is used for this).
And keep track of maximum sum contiguous segment among all positive segments
(max_so_far is used for this). Each time we get a positive-sum compare it with
max_so_far and update max_so_far if it is greater than max_so_far
O(n) time O(1) space
Maximum Contigous Sum

 */
public class KadaneAlgorithm {
    public static void main (String[] args) {
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(" Kadane Algorithm result for given array is :" +kadanesAlgorithm(a));
    }
    public static int kadanesAlgorithm(int[] array) {
        int maxEndingHere = array[0];
        int maxSoFar = array[0];
        for (int i = 1; i < array.length; i++) {
            int num = array[i];
            maxEndingHere = Math.max(maxEndingHere + num , num);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
            System.out.println("MaxEnding and MaxSoFar " +maxEndingHere + ", "  +maxSoFar);
        }
        return maxSoFar;
    }
}
