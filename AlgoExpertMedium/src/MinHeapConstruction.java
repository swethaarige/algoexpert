/*
Min Heap Binary Tree
A Min Heap Binary Tree is a Binary Tree where the root node has the minimum key in the tree.
The above definition holds true for all sub-trees in the tree. This is called the Min Heap property.
A Min Heap Binary Tree is commonly represented as an array, which is indexed according to the below format:
Current Node	arr[i]
Parent Node	arr[(i-1)/2]
Left Child	arr[(2*i) + 1]
Right Child	arr[(2*i )+ 2]
The root of the whole tree is at arr[0].
int parent(int i) {
    // Get the index of the parent
    return (i - 1) / 2;
}

int left_child(int i) {
    return (2*i + 1);
}

int right_child(int i) {
    return (2*i + 2);
}

int get_min(MinHeap* heap) {
    // Return the root node element,
    // since that's the minimum, by the min-heap
    // property
    return heap->arr[0];
}
How to build a min Heap
Intuitively, we can say that elements in a min heap follow the min heap property, as this is opposite to max heaps.
The key at the parent node is always less than the key at both child nodes. To build a min heap we:

Create a new child node at the end of the heap (last level).
Add the new key to that node (append it to the array).
Move the child up until you reach the root node and the heap property is satisfied.
To remove/delete a root node in a min heap:

Delete the root node.
Move the key of the last child to root.
Compare the parent node with its children.
If the value of the parent is greater than child nodes, swap them, and repeat until the heap property is satisfied.

Inserting onto the Min Heap
The insertion algorithm is simple. This inserts an element into the tree.

Breaking down the algorithm:

First, always insert at the bottom of the tree. The initial position of the inserted element is at the last level.
We will now need to update the position of this element so that the min-heap property is satisfied.
Since the root node of every sub-tree must be the minimum, check the sub-tree of its immediate parent.
If the parent is greater than this inserted element, we need to update its position by swapping it.
But we are not yet done, since the min-heap property may be violated of the updated node’s sub-tree!
We need to keep swapping until we reach the root node, after which we are done.

Delete from the Min Heap
Before we look at deleting an element any index, since the min-heap is very closely associated with the root,
 we will look at deleting the root first.

To delete the minimum element (i.e the root), we will do the following:

Update the root as the last element of the array (tree)
We will now remove the last element at the bottom. This is similar to swapping and deleting at the end! Only because
we don’t care about the root value anymore, we simply update it instead.
 */

public class MinHeapConstruction {
}
