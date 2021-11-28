/*
Write a program to check if the String is polindrome or not
 */
public class PolindromeCheck {
    public static void main (String[] args) {
        System.out.println("Checking if the given String is Polindrome is "
                +checkPolindrome1("abcdcba"));
        System.out.println("Checking if the given String is Polindrome is "
                +checkPolindrome2("abcdcba"));
    }

    //O(n^2) Time and O(n) Space

    public static boolean checkPolindrome1(String string) {
        StringBuilder reversedString = new StringBuilder();
        for (int i = string.length() - 1; i >= 0; i--) {
            reversedString.append(string.charAt(i));
        }
        return string.equals(reversedString.toString());
    }

    public static boolean checkPolindrome2(String string) {
        int leftIdx = 0;
        int rightIdx = string.length() - 1;
        while (leftIdx < rightIdx) {
            if (string.charAt(leftIdx) != string.charAt(rightIdx)) {
                return false;
            }
            leftIdx++;
            rightIdx--;
        }
        return true;
    }
}
