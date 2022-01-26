
//O(n^2) Time  and O(n) space
/*
The idea is again the same. For every substring, we will check if it is a palindrome or not, and if it is then we will take the longest among them. The only change is that now we will store if a substring is a palindrome or not in the “dp” array.

Now to check if a substring with starting index as “i” and ending index as “j” is a palindrome or not, we just have to check two conditions,

 If the ith and jth characters of the string are equal, and
If substring with starting index as i+1 and ending index as j-1, is a palindrome.
If both the above conditions are true, then it means this substring is also a palindrome.
 */
public class LongestPolidromicSubstring {
    public static void main (String[] args) {
        String input = "abaxyzzyxf";
        System.out.println("Longest Polindromic Substring is :" +longestPalindromicSubstring(input));
    }
    /*public static String longestPalindromicSubstring(String str) {
        int[] currentLongest = {0, 1};
        for (int i = 1; i < str.length(); i++) {
            int[] odd = getLongestPolindromicString(str, i - 1, i + 1);
            int[] even = getLongestPolindromicString(str, i - 1, i);
            int[] longest = odd[1] - odd [0] > even[1] - even[0] ? odd : even;
            currentLongest = currentLongest[1] - currentLongest[0] > longest[1] - longest[0] ?
                    currentLongest : longest;
        }
        return str.substring(currentLongest[0], currentLongest[1]);
    }
    public static int[] getLongestPolindromicString(String str, int startIdx, int endIdx) {
         while (startIdx >= 0 && endIdx < str.length()) {
             if (str.charAt(startIdx) != str.charAt(endIdx)) {
                 break;
             }
             startIdx++;
             endIdx--;
         }
         return new int[] {startIdx + 1, endIdx};
    }*/
    public static String longestPalindromicSubstring(String str) {
        int[] currentLongest = {0, 1};
        for (int i = 1; i < str.length(); i++) {
            int[] odd = getLongestPolindromeFrom(str, i - 1, i + 1);
            int[] even = getLongestPolindromeFrom(str, i - 1, i);
            int[] longest = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
            currentLongest =
                    currentLongest[1] - currentLongest[0] > longest[1] - longest[0]
                            ? currentLongest : longest;
        }
        return str.substring(currentLongest[0], currentLongest[1]);
    }

    public static int[] getLongestPolindromeFrom(String str, int leftIdx, int rightIdx) {
        while (leftIdx >= 0 && rightIdx < str.length()) {
            if (str.charAt(leftIdx) != str.charAt(rightIdx)) {
                break;
            }
            leftIdx--;
            rightIdx++;
        }
        return new int[] {leftIdx + 1, rightIdx};
    }
}
