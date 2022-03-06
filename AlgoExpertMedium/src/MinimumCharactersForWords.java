import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/*
Time Complexity - O(n * L) n is number of words and L is the length of the big word in the given input words
Space Complexity - O(c) c is the number of the unique characters across all the given words
 */
public class MinimumCharactersForWords {

    public static void main (String[] args) {
        String[] words = {"this", "that", "did", "deed", "them!", "a"};
        char[] result = minimumCharactersForWords(words);
        for (int i = 0; i < result.length; i++) {
            System.out.println("Result of minimum characters for words iss   " + result[i]);
        }
    }

    public static char[] minimumCharactersForWords(String[] words) {
        HashMap<Character, Integer> maximumFrequencies = new HashMap<>();
        for (String word : words) {
            HashMap<Character, Integer> characterFrequencies = countCharacterFrequencies(word);
            updateMaximumChaarcterFrequencies(characterFrequencies, maximumFrequencies);
        }
        return makeArrayFromCharacterFrequencies(maximumFrequencies);
    }
    public static HashMap<Character, Integer> countCharacterFrequencies(String word) {
        HashMap<Character, Integer> characterFrequencies = new HashMap<>();
        char[] charArray = word.toCharArray();
        for (char character : charArray) {
            characterFrequencies.put(character,
                    characterFrequencies.getOrDefault(character, 0) + 1);
        }
        return characterFrequencies;
    }
    public static void updateMaximumChaarcterFrequencies(HashMap<Character, Integer> characterFrequencies,
                                                         HashMap<Character, Integer> maximumFrequencies) {
        for (Map.Entry<Character, Integer> frequency : characterFrequencies.entrySet()) {
            char character = frequency.getKey();
            int characterFrequency = frequency.getValue();
            if (maximumFrequencies.containsKey(character)) {
                maximumFrequencies.put(character, Math.max(characterFrequency,
                        maximumFrequencies.get(character)));
            } else {
                maximumFrequencies.put(character, characterFrequency);
            }
        }
    }
    public static char[] makeArrayFromCharacterFrequencies(HashMap<Character, Integer> maximumFrequencies) {
        ArrayList<Character> characters = new ArrayList<>();
        for (Map.Entry<Character, Integer> frequency : maximumFrequencies.entrySet()) {
            char character = frequency.getKey();
            int characterFrequency = frequency.getValue();
            for (int idx = 0 ; idx < characterFrequency; idx++) {
                characters.add(character);
            }
        }
        char[] charArray = new char[characters.size()];
        for (int i = 0; i < characters.size(); i++) {
            charArray[i] = characters.get(i);
        }
        return charArray;
    }

}
