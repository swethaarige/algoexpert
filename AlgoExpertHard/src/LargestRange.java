import java.util.HashMap;
import java.util.Map;

//O(n) Time and O(n) Space
public class LargestRange {
    public static void main (String[] args) {
        int[] array = {1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6};
        int[] result = largestRange(array);
        System.out.println("Largest Range is " + result[0] + "  " +result[1]);
    }
    public static int[] largestRange(int[] array) {
        Map<Integer, Boolean> nums = new HashMap<>();
        int longest = 0;
        int[] longestRange = new int[2];
        for (int num : array) {
            nums.put(num, true);
        }
        for (int num : array) {
            if (!nums.containsKey(num)) {
                continue;
            }
            nums.put(num, false);
            int currentLength = 1;
            int left = num - 1;
            int right = num + 1;

            while (nums.containsKey(left)) {
                nums.put(left, false);
                currentLength += 1;
                left = left - 1;

            }
            while (nums.containsKey(right)) {
                nums.put(right, false);
                currentLength += 1;
                right = right + 1;
            }
            if (longest < currentLength) {
                longest = currentLength;
                longestRange = new int[] {left + 1, right - 1};
            }
        }
        return longestRange;
    }
}
