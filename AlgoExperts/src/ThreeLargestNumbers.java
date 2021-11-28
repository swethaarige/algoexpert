/*
Understanding the problem :
Given an array that contains at least three integers, I am asked to write a function that is going to
find the three largest numbers in the input array without sorting and return them in an array sorted
in ascending order.
BETTER APPROACH :
I am going to keep track of the three largest numbers as I traverse the entire input array.
First I am going to initialize an array of length 3 filled with -Infinity values and it is
going to keep track of the three largest numbers that I have currently seen. Then I would loop
through the input array. For each number, I am going to compare it to the current third largest number,
the number at index 0 in the array of the three largest numbers, if it is smaller than that number,
move on to the next number in the input array; otherwise compare it to the current largest number,
the number at index 2 in the array of the three largest numbers, and then depending on the comparison
compare it to the current second largest number, the number at index 1 in the array of the three
largest numbers:

If the number is greater than the current largest number, shift the current largest number and the
current second largest number to the left by one, then place the new largest number into index 2.
If the number is smaller than the current largest number but greater than the current second largest
number, move the current second largest number to index 0, and store the number in index 1.
Else set it as the current third largest number by placing it into index 0.
Once I get out of the loop, return the array of the three largest numbers.

Time & Space Complexity
O(n) time | O(1) space, where n is the length of the input array.
 */

public class ThreeLargestNumbers {
    public static void main(String[] args) {
        int[] array = {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7 };
        int[] resultArray = threeLargestNumbers(array);
        System.out.println("Three largest Numbers in the given array are : "
                +resultArray[0]+resultArray[1]+resultArray[2]);
    }

    public static int[] threeLargestNumbers (int[] array) {
        int[] threeLargest = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int num : array) {
            updateLargest(threeLargest, num);
        }
       return threeLargest;
    }

    public static void updateLargest(int[] threeLargest, int num) {
       if (num > threeLargest[2]) {
           updateAndShift(threeLargest, num, 2);
       }
       else if (num > threeLargest[1]) {
           updateAndShift(threeLargest, num, 1);
       }
       else if (num > threeLargest[0]) {
           updateAndShift(threeLargest, num , 0);
       }
    }

    public static void updateAndShift(int[] array, int num, int index) {
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                array[i] = num;
            }
            else {
                array[i] = array[i + 1];
            }
        }
    }
}
