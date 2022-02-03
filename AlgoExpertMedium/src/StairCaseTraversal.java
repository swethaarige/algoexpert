/*
You are two positive integers representing the height of a staircase and the maximum number of Steps that you can
advance up the staircase at a time. Write a function that returns the number of ways in which you can climb the staircase.
For example if you were given a staircase of height = 3 and maxSteps = 2 you can climb the staircase in 3 ways. You could take
1 step, 1 step and 1 step and you could also take 1 step and then 2 steps and you could take 2 steps and then 1 step
Note that maxSteps <= height will always be true.
Sample Input height = 4 maxSteps = 2
Sample OutPut :  5
 */

import java.util.ArrayList;
import java.util.HashMap;

public class StairCaseTraversal {
    public static void main (String[] args) {
        System.out.println("Number Of Ways To Traverse the staircase is "+stairCaseTraversal1(4, 2));
        System.out.println("Number Of Ways To Traverse the staircase is "+stairCaseTraversal2(4, 2));
    }
    //Solution 1 Recursive Approach
    //O(k^n)time and O(n) space where n is the height of the staircase and k is the number of allowed steps
    public static int stairCaseTraversal1(int height, int maxSteps) {
        return numberOfWaysToTop1(height, maxSteps);
    }

    public static int numberOfWaysToTop1(int height, int maxSteps) {
        if (height <= 1) {
            return 1;
        }
        int numberOfWays = 0;
        for (int step = 1 ; step <= Math.min(height, maxSteps); step++) {
            numberOfWays += numberOfWaysToTop1(height - step, maxSteps);
        }
        return numberOfWays;
    }

    //O(n * k) time and O(n) space where n is the height of the stair case and k is the number of allowed steps
    public static int stairCaseTraversal2(int height, int maxSteps) {
        HashMap<Integer, Integer> memoize = new HashMap<>();
        memoize.put(0, 1);
        memoize.put(1, 1);
        return numberOfWaysToTop2(memoize, height, maxSteps);
    }
    public static int numberOfWaysToTop2(HashMap<Integer, Integer> map, int height, int maxSteps) {
        if (map.containsKey(height)) {
            return map.get(height);
        }
        int numberOfWays = 0;
        for (int step = 1; step <= Math.min(height, maxSteps); step++) {
            numberOfWays += numberOfWaysToTop1(height - step, maxSteps);
        }
        return numberOfWays;
    }

    //Solution 3 Dynamic Programming
    //O(n * k) time and O(n) space where n is the height of the stair case and k is the number of allowed steps
    public static int stairCaseTraversal3(int height, int maxSteps) {
        int[] waysToTop = new int[height + 1];
        waysToTop[0] = 1;
        waysToTop[1] = 1;
        for (int currentHeight = 2; currentHeight < height + 1; currentHeight++) {
             int step = 1;
             while (step <= maxSteps && step <= currentHeight) {
                 waysToTop[currentHeight] = waysToTop[currentHeight] + waysToTop[currentHeight - step];
                 step += 1;
             }
        }
        return waysToTop[height];
    }
    //Solution 4 Sliding Window Approach
    //O(n) and O(n) Time and Space

    public static int stairCaseTraversal4(int height, int maxSteps) {
        int currentNumberOfWays = 0;
        ArrayList<Integer> waysToTop = new ArrayList<>();
        waysToTop.add(1);

        for (int currentHeight = 1; currentHeight < height + 1; currentHeight++) {
            int startOfWindow = currentHeight - maxSteps - 1;
            int endOfWindow = currentHeight - 1;

            if (startOfWindow >= 0) {
                currentNumberOfWays -= waysToTop.get(startOfWindow);
            }
            currentNumberOfWays += waysToTop.get(endOfWindow);
            waysToTop.add(currentNumberOfWays);
        }
        return currentNumberOfWays;
    }





}
