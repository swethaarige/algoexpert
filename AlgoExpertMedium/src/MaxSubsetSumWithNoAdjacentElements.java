/*
Write a function that takes in an array of positive integers and returns the maximum sum
of non-adjacent elements in the array. If the input array is empty, the function should return 0.
Concept
A few things to remember about the problem:
The input array includes only positive integers (negative integers would change the solution)
You can not add any two elements to the sum if they are next to each other
Dynamic programming is both a mathematical optimization method and a computer programming method.
In both contexts it refers to simplifying a complicated problem by breaking it down into simpler
sub-problems in a recursive manner. While some decision problems cannot be taken apart this way,
decisions that span several points in time do often break apart recursively. Likewise, in computer
science, if a problem can be solved optimally by breaking it into sub-problems and then recursively
finding the optimal solutions to the sub-problems, then it is said to have optimal substructure.
If sub-problems can be nested recursively inside larger problems, so that dynamic programming methods
are applicable, then there is a relation between the value of the larger problem and the values of
the sub-problems.[1] In the optimization literature this relationship is called the Bellman equation.

The important point here is simply that we find the solution by breaking the larger problem into
smaller problems in order to solve the larger problem! That’s it!
Index 0: the only option at this point is the value at index 0 itself so we store 7 in the auxiliary array.

Index 1: Next, we look at 10, and the max sum at that point is just the maximum value of 7 and 10.
 We can not add them together because they are next to each other.

Index 2: At this point, we can add 7 and 12 together because they are not next to each other so
the max sum is 19.

Index 3: Now we have a few options!
7+12 = 19
10+7 = 17
7+7 = 14
Obviously, 19 is the maximum sum so we will store 19 in the auxiliary array. An important point
is illustrated here: we do not necessarily have to use the value at the index we are currently on.

Index 4: As the input array grows, the number of options that are possible to choose from grows a lot!
7+12+9 = 28
10+7 = 17
10+9 = 19
7 + 12 = 19
7+7 = 14
7+9 = 16
12+9 = 21
And as we move up in indices, the options will go on and on and on and on… For this index,
the max sum is 28 so we add that to the auxiliary array.

There’s a pattern here! At each point, the list of options will include the list of options from
the previous index. Let’s look at the last index to see the pattern more clearly.
Index 5: I am not going to list all of the options for sums here and instead look at the pattern.
 The maximum sum at the last index will be the answer and in this case, is 33.

But how does it relate to the rest of the array? At any point, there are really only two choices!
The max sum is either the previous max sum and the index before (i-1), or it's the max sum at the index
 before that (i-2) plus the value of the index you are on! Don’t believe me? Try it out!
If we look to the index at i-1, we can’t add the value because i is adjacent to i-1. If we look at
the index at i-2, we already have the max sum of the array to that point, and then we can add the
value at i to that max sum. After considering both of these options, we will clearly choose the max
value out of those two.
So let’s make a formula for that:

There are two base cases we need to be able to use this formula. We need to know maxSums[0] and
maxSums[1]. The maxSums[0] is easy because it will always be itself. The maxSums[1] is also easy
because it will always be the max value out of the first two numbers. With that knowledge,
we can start to loop through the rest of the array and use the formula.

 */
public class MaxSubsetSumWithNoAdjacentElements {
    public static void main (String[] args) {
        int[] array = {75, 105, 120, 75, 90, 135};
        System.out.println("Maximum Subset Sum with no adjacent elements is :"
                + maxSubsetSumNoAdjacent(array));
        System.out.println("Maximum Subset Sum with no adjacent elements is :"
                + maxSubsetSumNoAdjacent2(array));
    }
    //O(n) Time and O(n) Space
    public static int maxSubsetSumNoAdjacent(int[] array) {
        if (array.length == 0) {
            return 0;
        } else if (array.length == 1) {
            return array[0];
        }
        int[] maxSums = array.clone();
        maxSums[1] = Math.max(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            maxSums[i] = Math.max(maxSums[i - 1], maxSums[i - 2] + array[i]);
        }
        return maxSums[array.length - 1];
    }
    /*
    The above solution uses extra space. We can also solve this problem without using any extra space.
    If we analyze the solution, we can see that the maximum sum until any index i can be found by
    knowing the maximum sum of the previous index i-1 and index i-2. Instead of storing the complete
    array, we can maintain two variables that store the maximum sum until the previous index and
    before the previous index.
    Time Complexity is O(n) and Space compelxity is O(1)
     */
    public static int maxSubsetSumNoAdjacent2(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int second = array[0];
        int first = Math.max(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            int current = Math.max(first, second + array[i]);
            second = first;
            first = current;
        }
        return first;
    }

}
