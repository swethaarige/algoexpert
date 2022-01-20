import java.util.Arrays;

/*
Understanding the problem
I am given an array of positive integers, where each integer represents the duration of a query that
needs to be executed. Only one query can be executed at a time, but the queries can be executed in
any order. I am asked to write a function that returns the minimum amount of total waiting time for
all of the queries, and I am allowed to mutate the input array.
Suppose the input array is going to be [1, 3, 2]. The first query can be executed immediately,
therefore the waiting time of the first query is 0. The second query have to wait until the first one
finishes before it can execute, so the waiting time of the second query is going to be 1 second,
the duration of the first query. The third query has to wait for both the first query and the
second query to finish executing before it can start. Since the second query takes 3 seconds
to execute, the waiting time of the third query is going to be 1 + 3 seconds.
So if the queries are executed in that order, then the total awaiting time for all of the
queries is going to be (0) + (1) + (1 + 3) = 5.

Approach 2
Suppose the input array is [8, 9, 10, 11]. If the queries are executed in that order,
the total waiting time is going to be 0 + 8 + (8 + 9) + (8 + 9 + 10) = 52.

query time:  [8, 9,  10,      11]
              ^  ^   ^        ^
waiting time: 0, 8, (8 + 9), (8 + 9 + 10)
0 + 8 + (8 + 9) + (8 + 9 + 10) can also be written as 0 + 8 * 3 + 9 * 2 + 10 * 1.
It can be noticed that 3 is equal to the number of the queries that are after 8 in the array,
so are 2 and 3. Therefore, if there are n queries in the input array queries,
the total waiting time is going to be
duration of queries[0] * (n - 1) + duration of queries[1] * (n - 2) ... + duration of queries[n - 3] * 2
+ duration of queries[n - 2] * 1

Or

duration of queries[0] * (n - 1) + duration of queries[1] * (n - 2) ... + duration of queries[n - 2] * 1
+ duration of queries[n - 1] * 0.
The reason is that all queries after a query need to wait the duration of that query.
So to compute the total waiting time, I would initialize a variable that is going to keep
track of the total waiting time so far, then iterate through every query in the input array,
keeping track of the index each query is at, since I need to know how many queries are remaining
in the array; at each query, multiply the duration of the query by the number of queries that are left,
and add the result to the total waiting time.

Since the function needs to return the minimum amount of total waiting time,
it would sort the input array at the very beginning.

Time & Space Complexity
O(nlog(n)) time | O(1) space, where n is the number of queries.

 */
public class MinimumWaitingTime {

    public static void main(String[] args) {
        int queries[] = {3,2,1,2,6};
        System.out.println("Minimum Waiting Time is  :" +minimumWaitingTime(queries));
    }
    public static int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int totalWaitingTime = 0;

        for (int idx = 0; idx < queries.length; idx++) {
            int duration = queries[idx];
            int queriesLeft = queries.length -(idx + 1);
            totalWaitingTime += duration * queriesLeft;
        }
        return totalWaitingTime;
    }
}
