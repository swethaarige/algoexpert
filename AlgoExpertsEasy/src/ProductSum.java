/*
Understanding the problem
I am given a "special" array, which is a non-empty array that consists of integers and optionally other
"special" arrays. I am asked to write a function that is going to return the sum of the elements in the
"special" array. Inside the "special" array, if I get to another "special" array, I need to sum up the
elements of that "special" array and then multiply the sum by the depth of that "special" array.
For instance, if the input array is [3, [4, 5]], then the result should be 3 + 2 * (4 + 5) = 21;
if the input array is [6, [4, [5]]], then the result should be 6 + 2 * (4 + 3 * 5) = 44.
APPROACH###
I am going to solve this problem recursively, and the function productSum is going to be my recursive
function. To solve the problem recursively, I would pass in another parameter, the depth of the input array,
to the recursive function. The depth of the initial input array is going to be 1.
At the beginning of the recursive function, I am going to initialize a variable to 0 and store the sum
of the elements in the current input array in that variable. I will then loop through all of the elements
in the input array. For each element, I am going to check if it is an array; if it is not,
I am going to just add the element to the sum; otherwise I am going to call the recursive function
on the element, passing in the array and the depth of the array, which is the depth of the parent array,
the current input array, plus one; then I will add the returned value of the recursive function,
which is the sum of elements in the subarray, to the sum. After I get through all of the elements inside
the array, I am going to multiply the sum by the depth of the current input array and return the result.

Time & Space Complexity
O(n) time | O(d) space, where n is the total number of elements in the array, including the sub-elements,
and d is the maximum depth of subarrays in the array.

For instance, if the input array is [6, [4, [5]]], then n is equal to 2 + 2 + 1 = 5, where the first 2
is the number of the elements in the outermost array: [6, [...]], the second 2 is the number of the
elements in the subarray [4, [...]] and 1 is the number of the elements in the subarray [5].
 */

import java.util.ArrayList;
import java.util.List;

public class ProductSum {
    public static void main(String[] args) {
        List<Object> array1 = new ArrayList<>();
        array1.add(3);
        List<Object> array2 = new ArrayList<>();
        array2.add(4);
        array2.add(5);
        array1.add(array2);
        System.out.println("Product Sum Helper of the given array is  :" + productSum(array1));
    }

    //O(n) Time n is number of elements including sub elements
    //O(d) Space d is the greatest depth of special arrays in the array
    public static int productSum(List<Object> array) {
        return productSumHelper(array, 1);
    }

    public static int productSumHelper(List<Object> array, int multiplier) {
        int sum = 0;
        for (Object el : array) {
            System.out.println(" el is :" + el);
            if (el instanceof ArrayList) {
                ArrayList<Object> ls = (ArrayList<Object>) el;
                sum += productSumHelper(ls, multiplier + 1);
            } else {
                sum += (int) el;
            }
        }
        return sum * multiplier;
    }

}