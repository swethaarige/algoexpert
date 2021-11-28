/*
Understanding the problem
Given an array of numbers, I am asked to sort the array in ascending order with the Selection Sort.

Approach
The Selection Sort works by virtually splitting the array into a sorted and an unsorted part,
keep finding the smallest value in the remaining unsorted part and appending it to the sorted part,
in other words, moving it to the beginning of the unsorted part, until all of the values are in the
correct order. At the beginning, the sorted part is empty and the unsorted part is the entire array.

Suppose we have the following array of integers:[40, 35, 90, 2, 10, 7]
First we iterate through the entire array and find the smallest number, which is 2. We move it to the
beginning of the array:
[2, 35, 90, 40, 10, 7]
 -
Now the sorted part is 2 and the unsorted part becomes 35, 90, 40, 10, 7. We loop through the unsorted
part and find the smallest number, which is 7, and place it at the beginning of the unsorted part.
[2, 7, 90, 40, 10, 35]
 ----
Find the smallest number in 90, 40, 10, 35 and move it to the beginning.
[2, 7, 10, 40, 90, 35]
 --------
Find the smallest number in 40, 90, 35 and put it to the beginning.
[2, 7, 10, 35, 90, 40]
 ------------
Find the smallest number in 90, 40 and move it to the beginning.
[2, 7, 10, 35, 40, 90]
 ----------------
Now the unsorted part consists just of 90, so we are done.
Time & Space Complexity
O(n^2) time | O(1) space, where n is length of the input array.
 */

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};
        int[] resultedSelectionSortedArray = selectionSort(array);
        for (int num : resultedSelectionSortedArray) {
            System.out.println("Insertion Selection Sorted Array for the given array is :" + num);
        }
    }

    public static int[] selectionSort(int[] array) {
        if (array.length == 0) {
            return new int[]{};
        }
        int startIdx = 0;
        while (startIdx < array.length - 1) {
            int smallestIdx = startIdx;
            for (int i = startIdx + 1; i < array.length; i++) {
                if (array[smallestIdx] > array[i]) {
                    smallestIdx = i;
                }
            }
            swap(startIdx, smallestIdx, array);
            startIdx++;
        }
        return array;
    }

    private static void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
