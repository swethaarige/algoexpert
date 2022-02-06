import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence
of the given array such that the integers in the subsequence are sorted in increasing order.
For example, if input is {1, 101, 2, 3, 100, 4, 5}, then output should be 106 (1 + 2 + 3 + 100),
if the input array is {3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10)
 */
public class MaxSumIncreasingSubsequence {
    public static void main (String[] args) {
       int[] array = {10, 70, 20, 30, 50, 11, 30};
       List<List<Integer>> result = maxSumIncreasingSubsequence(array);
       System.out.println("First Sum value " + result.get(0));
       System.out.println("Numbers   " + result.get(1));
    }
    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        int[] sequences = new int[array.length];
        Arrays.fill(sequences, Integer.MIN_VALUE);
        int[] sums = array.clone();
        int maxSumIdx = 0;
        for (int i = 0; i < array.length; i++) {
            int currentNum = array[i];
            for (int j = 0; j < i; j++) {
                int otherNum = array[j];
                if (otherNum < currentNum && currentNum + sums[j] >= sums[i]) {
                    sums[i] = currentNum + sums[j];
                    sequences[i] = j;
                }
            }
            if (sums[i] >= sums[maxSumIdx]) {
                maxSumIdx = i;
            }
        }
        return buildSequence(array, sequences, maxSumIdx, sums[maxSumIdx]);
    }

    public static List<List<Integer>> buildSequence(int[] array, int[] sequences, int currentIdx, int sums) {
        List<List<Integer>> sequence = new ArrayList<>();
        sequence.add(new ArrayList<>());
        sequence.add(new ArrayList<>());
        sequence.get(0).add(sums);
        while (currentIdx != Integer.MIN_VALUE) {
            sequence.get(1).add(0, array[currentIdx]);
            currentIdx = sequences[currentIdx];
        }
        return sequence;
    }
}
