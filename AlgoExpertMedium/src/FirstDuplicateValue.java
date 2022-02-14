import java.util.HashSet;
/*Given an array of integers between 1 and n inclusive where n is the length of the array.
Write the function that returns the first integer that appears more than once(when array is read from
left and right)
In other words out of all the integers that might occur more than once in the input array
your function should return the one whose first duplicate value has the minimum index
If no integer appears more than once, your function should return -1
 */
public class FirstDuplicateValue {
    public static void main(String[] args) {
        int[] array = {2, 1, 5, 2, 3, 3, 4};
        int result = firstDuplicateValue(array);
        System.out.println(" First Duplicate Value  :" +result);
    }
    //O(n^2) Time and O(1) Space
    public static int firstDuplicateValue(int[] array) {
        int minimumLength = array.length;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                if (array[i] == array[j]) {
                    minimumLength = Math.min(minimumLength, j);
                }
            }
        }
        if (minimumLength == array.length) {
            return -1;
        }
        return array[minimumLength];
    }
    //O(n) time and O(n) Space
    public static int firstDuplicateValue2(int[] array) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : array) {
            if (seen.contains(num)) return num;
            seen.add(num);
        }
        return -1;
    }
    //O(n) time and O(1) Space
    public static int firstDuplicateValue3(int[] array) {
        for (int num : array) {
            int absValue = Math.abs(num);
            if (array[absValue - 1] < 0) return absValue;
            array[absValue - 1] *= -1;
        }
        return -1;
    }
}
