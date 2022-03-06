/*
Given the head pointers of two linked lists where each linked list represents an integer number
(each node is a digit), add them and return the resulting linked list.
Intuition: Keep track of the carry using a variable and simulate digits-by-digits sum
starting from the head of the list, which contains the least significant digit.

Visualization of the addition of two numbers:
342 + 465 = 807
342+465=807.
Each node contains a single digit and the digits are stored in reverse order.
Just like how you would sum two numbers on a piece of paper, we begin by summing the least significant
digits, which is the head of l1 and l2. Since each digit is in the range of 0…9, summing two digits may
“overflow”. For example
5 + 7 = 12. In this case, we set the current digit to 2 and bring over the carry=1 to the next iteration.
carry must be either 0 or 1 because the largest possible sum of two digits (including the carry) is
9 + 9 + 1 = 19.
Psuedocode:
Create a dummy node which is the head of new linked list.
Create a node temp, initialise it with dummy.
Initialize carry to 0.
Loop through lists l1 and l2 until you reach both ends, and until carry is present.
Set sum=l1.val+ l2.val + carry.
Update carry=sum/10.
Create a new node with the digit value of (sum%10) and set it to temp node’s next,
then advance temp node to next.
Advance both l1 and l2.
Return dummy’s next node.
Note that we use a dummy head to simplify the code. Without a dummy head, you would have to
write extra conditional statements to initialize the head’s value.
Take extra caution in the following cases:

Test case	Explanation
l1=[0,1], l2=[0,1,2]	When one list is longer than the other.
l1=[], l2=[0,1]	When one list is null, which means an empty list.
l1=[9,9], l2=[1]	The sum could have an extra carry of one at the end, which is easy to forget.
Time Complexity: O(max(m,n)). Assume that m and n represent the length of l1 and l2 respectively,
the algorithm above iterates at most max(m,n) times.
Space Complexity: O(max(m,n)). The length of the new list is at most max(m,n)+1.
 */

public class SumOfLinkedInLists {
    // Driver Code
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList(7);
        list1.next = new LinkedList(5);
        list1.next.next = new LinkedList(9);
        list1.next.next.next = new LinkedList(4);
        list1.next.next.next.next = new LinkedList(6);
        System.out.print("First List is ");
        printList(list1);

        // creating second list
        LinkedList list2 = new LinkedList(8);
        list2.next = new LinkedList(4);
        System.out.print("Second List is ");
        printList(list2);

        System.out.print("Resultant List is ");
        // add the two lists and see the result
        LinkedList result = sumOfLinkedLists(list1, list2);
        printList(result);
    }

    /* Utility function to print a linked list */
    static void printList(LinkedList head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println("");
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList (int value) {
            this.value = value;
            this.next = null;
        }
    }
    public static LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        LinkedList newLinkedListHeadPointer = new LinkedList(0);
        LinkedList currentNode = newLinkedListHeadPointer;
        int carry = 0;
        while (linkedListOne != null || linkedListTwo != null || carry!= 0) {
            int valueOne = (linkedListOne != null) ? linkedListOne.value : 0;
            int valueTwo = (linkedListTwo != null) ? linkedListTwo.value : 0;
            int sumOfValues = valueOne + valueTwo + carry;
            int newValue = sumOfValues % 10;
            LinkedList newNode = new LinkedList(newValue);
            currentNode.next = newNode;
            currentNode = newNode;

            carry = sumOfValues / 10;

            linkedListOne = (linkedListOne != null) ? linkedListOne.next : null;
            linkedListTwo = (linkedListTwo != null) ? linkedListTwo.next : null;
        }
        return newLinkedListHeadPointer.next;
    }
}
