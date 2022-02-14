/*
Making Change Problem using Dynamic Programming
Time Complexity - O( n * d ) and Space Complexity - O(n) Space
 */
public class NumberOfWaysToMakeChange {
    public static void main(String[] args) {
        int[] denoms = {1, 5};
        System.out.println("Number of Ways to Make Change are  :"
                +numberOfWaysToMakeChange(6, denoms));
    }
   public static int numberOfWaysToMakeChange(int n, int[] denoms) {
       int[] ways = new int[n + 1];
       ways[0] = 1;
       for (int denom : denoms) {
           for (int amount = 1; amount < n + 1; amount++) {
               if (denom <= amount) {
                   ways[amount] += ways[amount - denom];
               }
           }
       }
       return ways[n];
   }
}
