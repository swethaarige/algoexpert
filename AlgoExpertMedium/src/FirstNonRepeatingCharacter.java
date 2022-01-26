import java.util.HashMap;

public class FirstNonRepeatingCharacter {
    public static void main (String[] args) {
        String input = "abcdcaf";
        System.out.println("First Non Repeating Character " +firstNonRepeatingCharacter(input));
    }
    public static int firstNonRepeatingCharacter(String string) {
        HashMap<Character, Integer> characterFrequencies = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            characterFrequencies.put(character,
                    characterFrequencies.getOrDefault(character, 0) + 1);
        }
        for (int i = 0; i < string.length(); i++) {
            if (characterFrequencies.get(string.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
