import java.util.HashMap;
/*
Given a string, find the first non-repeating character in it.
For example, if the input string is “GeeksforGeeks”, then the output should be ‘5’
and if the input string is “GeeksQuiz”, then the output should be ‘0’.
 */
public class NonRepeatingCharacter {
    public static void main(String[] args) {
        String str = "GeeksQuiz";
        System.out.println("Non Repeating character for the given string is " +firstNonRepeatingCharacter(str));
    }

    public static int firstNonRepeatingCharacter(String string) {
        HashMap<Character, Integer> characterFrequencies = new HashMap<>();

        for (int idx = 0; idx < string.length(); idx++) {
            char character = string.charAt(idx);
            characterFrequencies.put(character,
                    characterFrequencies.getOrDefault(character, 0) + 1);
        }

        for ( int idx = 0; idx < string.length(); idx++) {
            char character = string.charAt(idx);
           // System.out.println("Each character frequencey is "  +characterFrequencies.get(character));
            if (characterFrequencies.get(character) == 1) {
                return idx;
            }
        }
        return -1;

    }
}
