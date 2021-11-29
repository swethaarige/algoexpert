/*
Given a non empty string of lower case letters and non negative integer reprsenting a key,
write a function that returns a new string obtained by shifting every letter in the input staring
by k positions in the alphabet where k is the key.

Note that letters should wrap around the alphabet in other words letter z shifted by one returns
the letter a

Sample Input : String ="xyz" and key = 2
Sample Output : "zab"
 */

public class CaesarCipherEncryptor {
    public static void main(String[] args) {
        System.out.println("Caesar Cipher Encryptor for the given string :"
                +caesarCypherEncryptor("xyz", 2));
    }

    public static String caesarCypherEncryptor(String string, int key) {
        char[] newLetters = new char[string.length()];
        int newKey = key % 26;
        for (int i = 0; i < string.length(); i++) {
            newLetters[i] = getNewLetter(string.charAt(i), key);
        }
        return new String(newLetters);
    }

    public static char getNewLetter(char letter, int key) {
        int newLetterCode = letter + key;
        return newLetterCode <= 122 ? (char)newLetterCode : (char) (96 + newLetterCode % 122);
    }
}
