import java.util.ArrayList;
import java.util.Collections;
//O(n) Time and O(1) Space
public class ReverseWordsInString {
    public static void main (String args[]) {
        String str = "Algoexpert is the best!";
        String result = reverseWordsInString(str);
        System.out.println(" Result of the given problem is " + result);
    }
    public static String reverseWordsInString(String string) {
        ArrayList<String> words = new ArrayList<>();
        int startOfWord = 0;
         for (int idx = 0; idx < string.length(); idx++) {
             if (string.charAt(idx) == ' ') {
                 words.add(string.substring(startOfWord, idx));
                 startOfWord = idx;
             } else if (string.charAt(startOfWord) == ' ') {
                 words.add(" ");
                 startOfWord = idx;
             }
         }
         words.add(string.substring(startOfWord));
        Collections.reverse(words);
        return String.join("", words);
    }
}
