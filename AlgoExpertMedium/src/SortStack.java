/*
Given a stack, sort it using recursion. Use of any loop constructs like while,
for..etc is not allowed. We can only use the following ADT functions on Stack S:
is_empty(S)  : Tests whether stack is empty or not.
push(S)         : Adds new element to the stack.
pop(S)         : Removes top element from the stack.
top(S)         : Returns value of the top element. Note that this
               function does not remove element from the stack.
Input : {-5,2,-2,4,3,1}
Output : {-5, -2, 1, 2, 3, 4}

Algorithm
We can use below algorithm to sort stack elements:

sortStack(stack S)
    if stack is not empty:
        temp = pop(S);
        sortStack(S);
        sortedInsert(S, temp);
Below algorithm is to insert element is sorted order:

sortedInsert(Stack S, element)
    if stack is empty OR element > top element
        push(S, elem)
    else
        temp = pop(S)
        sortedInsert(S, element)
        push(S, temp)
 */

import java.util.ArrayList;

public class SortStack {
    public static void main (String[] args) {
       ArrayList<Integer> input = new ArrayList<>();
       input.add(-5); input.add(2); input.add(-2); input.add(4); input.add(3); input.add(1);
       ArrayList<Integer> output = sortStack(input);
       for (int i = 0; i < output.size(); i++) {
           System.out.println(" Sorted Stack :" +output.get(i));
       }

    }
    public static ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        if (stack.size() == 0) {
            return stack;
        }
        int top = stack.remove(stack.size() - 1);

        sortStack(stack);

        insertInSortedOrder(stack, top);

        return stack;
    }
    public static void insertInSortedOrder(ArrayList<Integer> stack, int value) {
        if (stack.size() == 0 || (stack.get(stack.size() - 1) <= value)) {
            stack.add(value);
            return;
        }
        int top = stack.remove(stack.size() - 1);
        insertInSortedOrder(stack, value);
        stack.add(top);
    }
}
