import java.util.Arrays;

/**
 * We will be given an array of positive integers, which represent the values of coins
 * that we have in our possession. The array could have duplicates. We are asked to
 * write a function that returns the minimum amount of change that we cannot create
 * with our coins. For instance, if the input array is [1, 2, 5], the minimum amount
 * of change that we cannot create is 4, since we can create 1, 2, 3 (1 + 2) and 5.
 * https://github.com/pinglu85/algoExpert/blob/main/Easy/non-constructible-change.md
 *
 */

public class NonConstructibleChange {

    public static void main (String [] args) {
        int [] coins = {5, 7, 1, 1, 2, 3, 22};
        System.out.println("Non Contrutible Change for the given coins is :"
                +nonConstrutibleChange(coins));
    }

    public static int nonConstrutibleChange(int [] coins) {
        Arrays.sort(coins);

        int currentChangeCreated = 0;
         for (int coin : coins) {
             if (coin > currentChangeCreated + 1) {
                 return currentChangeCreated + 1;
             }
             currentChangeCreated += coin;
         }
        return currentChangeCreated + 1;
    }
}
