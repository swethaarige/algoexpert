/*
You’re given an array of integers where each integer represents a jump of its value in an array.
For instance, the integer 2 represents a jump of two indices forward in the array; the integer -3
represents a jump of three indices backward in the array.
If a jump spills past the array’s bounds, it wraps over to the other side. For instance, a jump of -1
at index 0 brings us to the last index in the array. Similarly, a jump of 1 at the past index in the
array brings us to index 0.
Write a function that returns a boolean representing whether the jumps in the array form a single cycle.
A single cycle occurs if, starting at any index in the array and following the jumps, every element is
visited exactly once before landing back on the starting index.
At first glance this doesn’t seem all that complex. Optimal time complexity is O(n) and optimal
space is O(1). This fact makes it a little harder, but let’s see the challenges as they arise.
Optimal Solution
If we think about the input data, the array, we can know exactly how many items we have to visit to
complete a cycle. If you consider this, if at any point in time, we end up back at the element we
started with, without visiting array.length number of elements, the conditions set in the problem
are not satisfied. Alternatively, if we have visited array.length number of elements, and we do not
end up back at the element on which we started, again, we know the conditions set in the problem
are not satisfied.
Considering this, there are three conditions we need to track.
We need to visit n number of elements where n = array.length
If, after we have visited every element, we are not back at the starting point, we have a problem
If we have visited more than one element, and not yet visited every other element (1<n<array.length),
and we find ourselves back at the starting point, we have a problem
With this solution, we are aiming for O(n) time complexity because either we are visiting every element
in the input array once, or short-circuiting before then because the data did not meet the criteria.
Space complexity will be O(1) because we are not creating any additional arrays or structures that
are dependent on the input size, only some variables to keep track of conditions.

1. we start with writing the algorithm by declaring the variables to keep track of the number of elements
we have visited and the current index that we are visiting and initialize them to equal zero.
2. The next step is to create a loop that will run as long as the number of elements that we have visited
is less than the length of the input array. We can start by short-circuiting the loop if we ever get back
to the starting index before visiting each element.
3.So what do we need to do in the loop? As we are looping through, we need to increment the number of items
visited, figure out which index we need to visit next, and figure out whether or not we end on the index
that we started on. We can do most of this easily and then abstract finding the next index into a helper
method and pass the current index and the array as arguments.
4.Ok so, finding the next index is the hardest part. We have to find how far forward or backward we need
to move and handle some edge cases. We can start by declaring a variable that finds the value at the
current index, because that tells us where we need to go next. Then we can declare another variable
5.Great! … but wait… we need to be able to circle back around and start at the beginning to keep going
if we reach the end of the array, or circle back to the end if we reach the beginning when leaping to the
next index. So if my array.length is equal to 5, and I am at the 4th index, and the value is 5, I would
go out of bounds. So what can we do?The easiest way to solve this problem is to use the modulo operator.
We can find the remainder of the currentIndex + leap divided by the length of the array. This remainder
will always give us exactly where we need to be, even if the value loops us through the array a gazillion
times.that adds the “leap” to the current index to find the next index.
6.So you might think Great! Let’s just return the next index! We’re done! But, not quite.
This is because the values that tell us the size of the leap can be positive or negative, so we need to
account for both cases. If the next index is positive we are good to go, but if it is negative we have to
do some work. We can add the next index to the length of the array to find the array position we will
end up on if the leap is negative.


 */
public class SingleCycleCheck {

    public static void main(String[] args) {
        int[] array = {2, 3, 1, -4, -4, 2};
        System.out.println("Has Single Cycle in the given input array  " +
                "" + hasSingleCycle(array));
    }

    public static boolean hasSingleCycle(int[] array) {
        int numOfElementsVisited = 0;
        int currentIdx = 0;
        while (numOfElementsVisited < array.length) {
            if (numOfElementsVisited > 0 && currentIdx == 0) return false;
            numOfElementsVisited++;
            currentIdx = getNextIdx(currentIdx, array);
        }
        return currentIdx == 0;
    }
    public static int getNextIdx(int currentIdx, int[] array) {
        int jump = array[currentIdx];
        int nextIdx = (currentIdx + jump) % array.length;
        return nextIdx >= 0 ? nextIdx : nextIdx + array.length;
    }
}
