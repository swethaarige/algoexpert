/*
Given a sorted array of integers and a target integer, I am asked to write a function that uses Binary Search
to find out if the target integer is in the array. If the target is in the array, the function should return
its index; otherwise return -1.

Iterative Approach
The overarching logic of Binary Search is:
Find the middle number in the sorted array.
Compare the middle number to the target. Eliminate half of the array, depending on where the target
would be located compared to the middle number:
If the target is equal to the middle number, then we have found the target.
If the target is smaller than the middle number, then it means the target would be located in the left half
of the array, because all the integers to the right of the middle number are for sure greater than the middle
number, and so even greater than the target.
If the target is greater than the middle number, then the target would be located in the right half of the
array, because all the numbers to the left of the middle number must be smaller than the middle number,
and thus even smaller than the target.

Find the middle number in the remaining half of the array and continue as in step 2.
Eventually, we will find the target or there is no more array to explore, which means the target
is not found in the array.

I am going to initialize two pointers left and right to keep track of the current subarray
that remains to be explored. Initially, the left pointer is going to point at the start of the array and the right pointer at the end of the array. While the left pointer doesn't surpass the right pointer, keep finding the middle number in the current subarray; if the target is equal to the middle number, then I have found the target, so return the index of the middle number; otherwise update either the left pointer or the right pointer based on the comparison, eliminating half of the current subarray. Finally, if I get out of the while loop without returning the result, then it means the target has not been found and it can not be found, return -1.

Time & Space Complexity
O(log(n)) time | O(1) space, where n is the number of integers in the input array.

 */

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main (String[] args) {
        List<Integer> list = new ArrayList<Integer>(5);
        list.add(1); list.add(2); list.add(3); list.add(4); list.add(5);
        System.out.println("Checking if 4 is available in list using BinarySearch is "
                +binarySearch(list, 4));
        System.out.println("Checking if 4 is available in list using BinarySearch is "
                +binarySearch(list, 7));
    }

    public static int binarySearch(List<Integer> list, int target) {
        return binarySearch(list, target,0, list.size()-1);
    }

    public static int binarySearch(List<Integer> list, int target, int left, int right) {
        while (left <= right) {
            int middle = (left + right) / 2;
            int potentialMatch = list.get(middle);
            if (target == potentialMatch) {
                return middle;
            }
            else if (target < potentialMatch) {
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
