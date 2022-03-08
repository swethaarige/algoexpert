/*
Given an array of n elements, where each element is at most k away from its target position, devise an algorithm
that sorts in O(n log k) time. For example, let us consider k is 2, an element at index 7 in the sorted array,
can be at indexes 5, 6, 7, 8, 9 in the given array.
Examples: Input : arr[] = {6, 5, 3, 2, 8, 10, 9}  k = 3
Output : arr[] = {2, 3, 5, 6, 8, 9, 10}
Input : arr[] = {10, 9, 8, 7, 4, 70, 60, 50}  k = 4
Output : arr[] = {4, 7, 8, 9, 10, 50, 60, 70}

 */

import java.util.Iterator;
import java.util.PriorityQueue;

public class KSortedArray {

    /*
    Solution 1: We can use Insertion Sort to sort the elements efficiently.
    The inner loop will run at most k times. To move every element to its correct place,
    at most k elements need to be moved. So overall complexity will be O(nk)
     */

    public static void insertionSort1(int A[], int size) {
        int i, key, j;
        for (i = 1; i < size; i++) {
            key = A[i];
            j = i - 1;

            while (j > 0 && A[j] > key) {
                  A[j + 1] = A[j];
                  j = j - 1;
            }
            A[j + 1] = key;
        }
    }
    /*
     Solution 2: We can sort such arrays more efficiently with the help of Heap data structure. Following is the detailed process that uses Heap.
   1) Create a Min Heap of size k+1 with first k+1 elements. This will take O(k) time (See this GFact)
   2) One by one remove min element from heap, put it in result array, and add a new element to heap from remaining elements.
   Removing an element and adding a new element to min heap will take log k time. So overall complexity will be O(k) + O((n-k) * log(k)).
     */

    public static void kSort(int[] arr, int n , int k) {
        //min heap
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        // Add first k + 1 items to the min Heap

        for (int i = 0; i < k + 1; i++) {
            priorityQueue.add(arr[i]);
        }

        int index = 0;
        for (int i = k + 1; i  < n; i++) {
            arr[index++] = priorityQueue.peek();
            priorityQueue.poll();
            priorityQueue.add(arr[i]);
        }

        Iterator<Integer> itr = priorityQueue.iterator();

        while (itr.hasNext()) {
            arr[index++] = priorityQueue.peek();
            priorityQueue.poll();
        }
    }
}
