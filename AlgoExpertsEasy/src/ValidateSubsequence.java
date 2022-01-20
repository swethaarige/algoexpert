import java.util.ArrayList;
import java.util.List;



/**
 * Understanding the problem
 * Implement a function that takes two arrays of integers as input and finds
 * whether all the numbers in the sequence array appear in the first array
 * and they appear in the same order. In other words, the function need to
 * find out if we can get the sequence array, when we delete some or no elements
 * in the first array without changing the order of the remaining elements.
 *
 * For example:
 *
 * array = [5, 1, 22, 25, 6, -1, 8, 10];
 * sequence = [1, 6, -1, 10];
 * The output should be true.
 *
Approach
Use a pointer to keep track of the position we are at in the sequence array.
Iterate through every integer in the first array. At each iteration, compare
the integer in the first array with the value in the sequence array that the
pointer currently points to, if they are equal, then we found the value in
the first array, move the pointer forward by 1. If the pointer is equal to
the length of the sequence array, then it means all the numbers in the sequence
 array are found in the first array and they are in the same order, return true.
 After the loop finishes, if the pointer is not equal to the length of the
 sequence array, return false.
 */
// O(n) Time and O(1) Space
public class ValidateSubsequence {

    public static void main(String[] args) {
       List<Integer> array = new ArrayList<>(8);
       array.add(3);array.add(1);array.add(7);array.add(5);array.add(10);array.add(2);
       List<Integer> sequence = new ArrayList<>(3);
       sequence.add(1);sequence.add(5);sequence.add(2);
       System.out.println("Validate Subsequence  "+isValidSubsequence(array, sequence));
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int arrIdx = 0;
        int seqIdx = 0;
        while (arrIdx < array.size() && seqIdx < sequence.size()) {
            if (array.get(arrIdx).equals(sequence.get(seqIdx))) {
                seqIdx ++;
            }
            arrIdx ++;
        }
        return seqIdx == sequence.size();
    }

}
