/*
You are given array of integers and another array of three distinct integers. First Array is guaranteed to
contain the integers that are in second array.
The second array represents the desired order of the first array. For example second array of [x, y, z]
represents the desired order of [x,x,..x,y, y, y..y,z,z,....z} in the first array.
Write a function that sorts the first array according to the desired order in the second array.
The function should perform this in Place.
array = [1, 0, 0, -1, -1, 0, 1, 1]
order = [0, 1, -1]

Sample Output : [0,0,0,1,1,1,-1,-1]
Time Complexity - O(n) and Space Complexity - O(1)
 */

public class ThreeNumberSort {
    public static void main (String[] args) {
        int[] array = {1, 0, 0, -1, -1, 0, 1, 1};
        int[] order = {0, 1, -1};
        int[] output = threeNumberSort(array, order);
        for (int i = 0 ; i < output.length; i++) {
            System.out.println("Result is  :" +output[i]);
        }
    }
    public static int[] threeNumberSort(int[] array, int[] order) {
        int firstValue = order[0];
        int thirdValue = order[2];

        int firstIdx = 0;
        for (int idx = 0 ; idx < array.length; idx++) {
            if (array[idx] == firstValue) {
                swap(firstIdx, idx, array);
                firstIdx += 1;
            }
        }
        int thirdIdx = array.length - 1;
        for (int idx = array.length - 1; idx >= 0; idx--) {
            if (array[idx] == thirdValue) {
                swap(thirdIdx, idx, array);
                thirdIdx -= 1;
            }
        }
        return array;
    }
    public static void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
