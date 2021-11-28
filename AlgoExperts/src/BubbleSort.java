/*
Given an array of integers, I am asked to write a function that is going to sort the array in ascending order
using Bubble Sort and return the sorted array.
Approach
The main idea of Bubble Sort is repeatedly iterate through an array and in each pass swap the adjacent
elements if they are in wrong order.

Suppose we have the following array of numbers:[8, 5, 2, 9, 6, 1]
We start at index 0, compare 8 to the number right next to it, which is 5.
[8, 5, 2, 9, 6, 1]
 ^8 is greater than 5, we swap these two numbers:
[5, 8, 2, 9, 6, 1]
 ^
We then move on to index 1, compare 8 to the number comes after it.
[5, 8, 2, 9, 6, 1]
    ^
Since 8 is greater than 2, put them in order:
[5, 2, 8, 9, 6, 1]
    ^
We move on to index 2.

[5, 2, 8, 9, 6, 1]
       ^
8 is smaller than 9, they are in correct order, so we move on to index 3.

[5, 2, 8, 9, 6, 1]
          ^
9 is larger than 6, swap them:

[5, 2, 8, 6, 9, 1]
          ^
Move on to index 4.

[5, 2, 8, 6, 9, 1]
             ^
9 is greater than 1, we swap the two numbers:

[5, 2, 8, 6, 1, 9]
             ^
We can notice that the largest number in the array, which is 9, is now in the final correct order. The reason for that is whenever we get to the largest number in the array, the number is going to be swapped all the way to the end of the array. And since it is in the final position, we don't need to check it again.

We then start at index 0 again, compare 5 to 2.

[5, 2, 8, 6, 1, 9]
 ^
5 is greater than 2, so we swap the two numbers.

[2, 5, 8, 6, 1, 9]
 ^
Move on to index 1.

[2, 5, 8, 6, 1, 9]
    ^
5 is smaller than 8, we don't need to touch these two numbers and we move on to index 2, and compare 8 to 6.

[2, 5, 8, 6, 1, 9]
       ^
8 is greater than 6, we swap these two numbers:

[2, 5, 6, 8, 1, 9]
       ^
Move on to index 3.

[2, 5, 6, 8, 1, 9]
          ^
8 is larger than 1, swap them:

[2, 5, 6, 1, 8, 9]
          ^
Now the second largest element in the array, 8, is in the final position.
We go all the way back to index 0, loop through the array again and perform the same logic.
We keep doing this until no swaps were made, which indicates the array is sorted.
So I am going to declare a variable isSorted which is going to keep track of whether or not the array
is sorted. Initially, set it to false. In addition, I am going to use a counter to keep track of how many
numbers still need to be sorted; initially, set it to the length of the array.
While isSorted is false,
first, set isSorted to true - we assume the array is now sorted;
then, use a for loop to iterate through the remaining unsorted array, compare pairs of neighboring numbers.
If they are out of order, swap them and set isSorted to false.
when the for loop is finished, decrement the counter by 1.
Time & Space Complexity
Best: O(n) time | O(1) space, where n is the length of the input array.
Average: O(n^2) time | O(1) space, where n is the length of the input array.
Worst: O(n^2) time | O(1) space, where n is the length of the input array.

 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};
        int[] resultedBubbleSortedArray = bubbleSort(array);
        for (int num : resultedBubbleSortedArray) {
            System.out.println("Bubble Sorted Array for the given array is :" + num);
        }
    }

    public static int[] bubbleSort(int[] array) {
        boolean isSorted = false;
        int counter = 0;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1 - counter; i++) {
                if (array[i] > array[i + 1]) {
                    swap(i, i + 1, array);
                    isSorted = false;
                }
            }
            counter++;
        }
        return array;
    }

    public static void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
