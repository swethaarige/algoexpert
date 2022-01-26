import java.util.HashMap;
import java.util.Map;

/*
As we travel through the string in the loop, there are only two possibilities, the given character
 in the string is either part of the longest substring or it is not. How do we determine that?
 If that character already appeared in the substring we are building, we break it there and store
 the length till that point and start a new substring from that character.
 Finding the longest substring without repeating characters:
 Input: S = “abcabcbb”
 “abc” is the longest substring without repeating characters among all the substrings.
 Time Complexity - O(n) Space Complexity O(min(n, a))
 */
public class LongestSubstringWithoutDuplicates {
    public static String longestSubstringWithoutDuplication(String str) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int[] longest = {0, 1};
        int startIdx = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (lastSeen.containsKey(c)) {
                startIdx = Math.max(startIdx, lastSeen.get(c) + 1);
            }
            lastSeen.put(c, i);
            if (longest[1] - longest[0] < i + 1 - startIdx) {
                longest = new int[]{startIdx, (i + 1)};
            }
        }
        String result = str.substring(longest[0], longest[1]);
        return result;
    }
}
