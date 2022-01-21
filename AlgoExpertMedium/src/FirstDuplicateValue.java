import java.util.HashSet;

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
