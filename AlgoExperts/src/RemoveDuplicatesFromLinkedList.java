import java.util.LinkedList;

/*
Understanding the problem I am given the head of a singly linked list. The nodes of the linked list
are going to be sorted in ascending order with respect to their values and the values are going to be
integers. I am asked to write a function that is going to remove all the nodes with duplicate values
and return the modified linked list. The linked list should be modified in place and the nodes should
remain in their original order.
 */
public class RemoveDuplicatesFromLinkedList {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        LinkedList currentNode = linkedList;

        while (currentNode != null) {
            LinkedList nextDistinctNode = currentNode.next;

            while (nextDistinctNode != null && nextDistinctNode.value == currentNode.value) {
                nextDistinctNode = nextDistinctNode.next;
            }
            currentNode.next = nextDistinctNode;
            currentNode = nextDistinctNode;
        }
        return linkedList;
    }
}
