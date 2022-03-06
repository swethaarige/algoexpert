import java.util.Arrays;
import java.util.Stack;

/*
Find next greater elements in an array
1. Brute-Force Approach
The idea is to use two nested loops. The outer loop takes each array element from left to right.
The inner loop considers all elements to the “right” of the element picked by the outer loop.
Terminate the inner loop as soon as the first larger element is found, which would be the
next greater element for the element picked by the outer loop.
The time complexity of this approach is O(n2), where n is the size of the input
 2. Using Stack
 O(n) Time and O(n) Space
The time complexity can be easily reduced to linear by using extra space.
The idea is to use the stack data structure.
For each element x in the array, pop all elements from the stack smaller than x, and set
their next greater element to x.
Loop till we have a greater element on top of the stack or stack becomes empty.
Then push the current element x on top of the stack.
Repeat the process for every array element.
https://www.enjoyalgorithms.com/blog/find-next-greater-element
 */
// O(n) Time and O(n) Space
public class NextGreaterElement {
    public static void main (String[] args) {
        int[] inputArray = {2, 5, -3, -4, 6, 7, 2};
        int[] outputArray = nextGreaterElement(inputArray);
        for (int i = 0; i < outputArray.length; i++) {
            System.out.println("Next Greater elements result array is " + outputArray[i]);
        }

    }
    public static int[] nextGreaterElement(int[] array) {
        int[] result = new int[array.length];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * array.length; i++) {
             int circularIdx = i % array.length;
             while (stack.size() > 0 && array[stack.peek()] < array[circularIdx]) {
                 int top = stack.pop();
                 result[top] = array[circularIdx];
             }
             stack.push(circularIdx);
        }
        return result;
    }
}
