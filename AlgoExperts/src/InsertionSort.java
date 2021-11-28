/*
Understanding the problem
Given an array of integers, I am asked to write a function that is going to sort the array using the
Insertion Sort and return the sorted array.

Approach
In the Insertion Sort, we virtually split the array into a sorted and an unsorted part, and we keep
inserting values from the unsorted part at the correct position into the sorted part. At the beginning,
the sorted part consists just of the first value in the array.
Suppose we have the following array of integers:[5, 4, 8, 2, 6]
We start at index 1. The sorted part consists just of 5.
[5, 4, 8, 2, 6]
 -
    i
We want to insert 4 into the sorted part. We compare 4 to 5, the very last number in the sorted part.
4 is smaller than 5, so we swap 4 with 5.

[4, 5, 8, 2, 6]
    i
We reach the very beginning of the sorted part, so we are done. Now the sorted part is 4, 5.
We move on to index 2.

[4, 5, 8, 2, 6]
 ----
       i
Compare 8 to 5. They are in the correct order, so we just expand the sorted part and move on to index 3.

[4, 5, 8, 2, 6]
 -------
          i
Compare 2, to the last number in the sorted part, which is 8. 2 is smaller than 8, so we swap them:

[4, 5, 2, 8, 6]
          i
We then compare 2 to 5. Since they are out of order, we swap 2 and 5:

[4, 2, 5, 8, 6]
          i
Then compare 2 to 4. 2 is smaller than 4, so we swap them again.

[2, 4, 5, 8, 6]
          i
We reach the very beginning of the sorted part, so we move on to index 4 and the sorted part becomes 2, 4, 5, 8.

[2, 4, 5, 8, 6]
 ----------
             i
Compare 6 to 8. 6 is smaller than 8, so we swap these two numbers.

[2, 4, 5, 6, 8]
             i
Then we compare 6 to 5, they are in the correct order, so we don't need to touch them.
Since we are already at the end of the array, the array is now sorted.

To implement the insertion sort,

First, we use a for loop to iterate through the array starting at index 1.
At each iteration,initialize a variable, called j, which is going to keep track of the position of the value
we are trying to insert.
Initially, set it to be equal to the index of the for loop, since the value we're trying to insert is the
value at the current index of the for loop.
while the value is smaller than its predecessor and we haven't reach the very beginning of the sorted part,
swap the value with its predecessor and decrement j by 1.
Time & Space Complexity
Best: O(n) time | O(1) space, where n is the length of the input array.

Average: O(n^2) time | O(1) space, where n is the length of the input array.

Worst: O(n^2) time | O(1) space, where n is the length of the input array.
 */

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};
        int[] resultedInsertionSortedArray = insertionSort(array);
        for (int num : resultedInsertionSortedArray) {
            System.out.println("Insertion Sorted Array for the given array is :" + num);
        }
    }
        public static int[] insertionSort(int[] array){
            if (array.length == 0) {
                return new int[]{};
            }
            for (int i = 1; i < array.length; i++) {
                int j = i;
                while (j > 0 && array[j] < array[j - 1]) {
                    swap(j, j - 1, array);
                    j -= 1;
                }

            }
            return array;
        }

        public static void swap(int i, int j, int[] array){
            int temp = array[j];
            array[j] = array[i];
            array[i] = temp;
        }
    }
