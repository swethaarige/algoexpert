/*
You are given a string of available characters and a string representing a document that you need to generate.
Write a function that determines if you can generate the document using the available characters. If you can
generate the document your function should return true otherwise it should return false.

You are only able to generate the document if the frequency of unique characters in the characters string
is greater than or equal to the frequency of unique characters in the characters in the document string.
For example if you are given characters = "abcabc" and document = "aabbccc" you cant generate the document
because you are missing one c.

The document that you need to create may contain any characters, including special characters, capital letters,
numbers, and spaces.

Note:you can always generate the empty string ("")
Sample Input :
characters = "Bste!hetsi ogEAxpelrt x "
document = "AlgoExpert is the Best!"
Sample Output :
true
 */
//O(n + m) time | O(c) space
//where n is the number of the characters , m is the length of the document
//and c is the number of unique characters in the characters string

import java.util.HashMap;

public class GenerateDocument {
    public static void main (String[] args) {
        String characters = "Bste!hetsi ogEAxpelrt x ";
        String document = "AlgoExpert is the Best!";
        System.out.println("Generated document can be possible " +
                generateDocument(characters, document));
    }
    public static boolean generateDocument(String characters, String document) {
        HashMap<Character, Integer> characterCounts = new HashMap<>();
        for (int idx = 0; idx < characters.length(); idx++) {
            char character = characters.charAt(idx);
            characterCounts.put(character, characterCounts.getOrDefault(character, 0) + 1);
        }
        for (int idx = 0; idx < document.length(); idx++) {
            char character = document.charAt(idx);
            if (!characterCounts.containsKey(character) || characterCounts.get(character) == 0) {
                return false;
            }
            characterCounts.put(character, characterCounts.get(character) - 1);
        }
        return true;
    }
}
