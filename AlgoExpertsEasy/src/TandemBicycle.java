/*
Understanding the problem
I am given two arrays of positive integers, one containing the speeds of riders with red shirts and
another one containing the speeds of riders with blue shirt. The number of red-shirt riders and the
number of blue-shirt riders are equal. I will also receive a third input parameter called fastest
and it is going to be a Boolean value. I am asked to write a function that is going to pair every
red-shirt rider with a blue-shirt rider to ride a tandem bicycle; and if the Boolean is true, the
function will return the total maximum speed of all tandem bicycles being ridden; otherwise it will
return the total minimum speed.
A tandem bicycle is a bicycle operated by two people. The speed of the bicycle is dictated by the rider
who pedals faster, for instance, if the speed of one rider is 5 and the speed of the other rider is 3,
then the speed of the bicycle is 5.

🙋‍♀️🙋‍♂️ In a coding interview, I can ask the interviewer what does the minimum possible total speed mean
to eliminate ambiguity.


 */

import java.util.Arrays;

public class TandemBicycle {
    public static void main (String[] args) {
        int[] redShirtSpeeds = {5, 5, 3, 9, 2};
        int[] blueShirtSpeeds = {3, 6, 7, 2, 1};

        System.out.println("Tandem Bicycle Maximum result of the program is :"
                +tandemBicycle(redShirtSpeeds, blueShirtSpeeds, true));
        System.out.println("Tandem Bicycle Maximum result of the program is :"
                +tandemBicycle(redShirtSpeeds, blueShirtSpeeds, false));
    }
    public static int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);

        if (!fastest) {
            reverseArrayInPlace(redShirtSpeeds);
        }

        int totalRunningSpeed = 0;
        for (int idx = 0; idx < redShirtSpeeds.length; idx++) {
            int rider1 = redShirtSpeeds[idx];
            int rider2 = blueShirtSpeeds[redShirtSpeeds.length - idx -1];
            totalRunningSpeed += Math.max(rider1, rider2);
        }
        return totalRunningSpeed;
    }

    public static int[] reverseArrayInPlace(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start += 1;
            end -= 1;
        }
        return array;
    }
}
