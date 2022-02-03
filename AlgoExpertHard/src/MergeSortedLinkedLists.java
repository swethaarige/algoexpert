/*
Understanding the Problem
Problem Description: Merge two sorted linked lists and return the head of the new sorted list.
Iterative Approch In Place
Instead of making the new dummy node, just store the reference of the node of A and B.
Solution Step
1.If one of the lists is empty return the other.
2.Create variable output and initialize it with whichever list has the smaller first element.
3.Initialize curr = output, which we will use to iterate the output list,
store the reference to the last element in output.
5. Iterate until any of the lists reaches its end.
6. Compare the values of current nodes in both lists
If A.val < B.val, set curr.next = A and set A = A.next.
Else, set curr.next = B and set B = B.next.
7. Set curr = curr.next
8. Now append the remaining nodes of the list which has not been fully iterated.
if A != NULL, set curr.next = A.
if B != NULL, set curr.next = B.
9. Return output.


1. create one p1Prev = null and assign p1 and p2 for two linkedlists
2.Iterate until any of the lists reaches its end.
3. if p1.value < p2.value  then p1prev = p1 and p1 = p1.next;
4. Else if p1prev != null p1.prev.next = p2; else p1prev = p2; p2 = p2.next and p1prev.next = p1;
5. if p1 == null p1prev.next = p2; return headone if headone is less than headtwo

 */

public class MergeSortedLinkedLists {

    static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        LinkedList p1 = headOne;
        LinkedList p2 = headTwo;
        LinkedList p1Prev = null;
        while (p1 != null && p2 != null) {
            if (p1.value < p2.value) {
                p1Prev = p1;
                p1 = p1.next;
            } else {
                if (p1Prev != null)
                    p1Prev.next = p2;
                else {
                    p1Prev = p2;
                    p2 = p2.next;
                    p1Prev.next = p1;
                }
            }
        }
        if (p1 == null) p1Prev.next = p2;
        return headOne.value < headTwo.value ? headOne : headTwo;
    }

}
