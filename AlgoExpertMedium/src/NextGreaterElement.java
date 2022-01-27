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
public class NextGreaterElement {
}
