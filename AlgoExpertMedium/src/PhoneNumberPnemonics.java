import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
If you open up your phone, the keypad looks like this:
Almost every digit is associated with some letters in the alphabet; this allows certain phone numbers to spell out actual words.
For example, the phone number 627–974–7328 can be written as marysgreat.
It’s important to note that a phone number doesn’t represent a single sequence of letters, but rather multiple combinations of letters.
For instance, 2 can represent three different letters (a, b, or c).
A mnemonic is defined as a pattern of letters, ideas, or associations that assist in remembering something. Companies oftentimes use a
 mnemonic for their phone number to make it easier to remember.
Given a stringified phone number of any non-zero length, write a function that returns all mnemonics for this phone number, in any order.
For this problem, a valid mnemonic may only contain letters and the digits 0 and 1. In other words, if a digit is able to be represented
by a letter, then it must be. Digits 0 and 1 are the only two digits that don’t have letter representations on the keypad.
Note that you should rely on the keypad illustrated above for digit-letter associations.

Concept
First we should consider the input and note that it is a string and it can be any length, but will always have at least one digit.
It is also important to note that the number of letters a number can represent is variable (0 and 1 have no letters but 7 has four letters).
Let’s walk through a simple example that we can solve mentally to solidify understanding.
Because 1 and 0 have no letters associated with them, they have to be represented as themselves.
5 can only be represented by the letters associated with it which are j, k, and l. So we have to come up with all possible
combinations and output as an array of strings. Ok so we know, the output can get REALLY big REALLLLLYYYYY fast as the
input grows with numbers 2 through 9.

SOLUTION:
1.Let’s start to implement the algorithm.This appears to be an extremely good use case for a hash map to
represent the possible letters associated with each number. So the first thing to do is to build that out.

2.We start by creating an array to hold the current mnemonic we are creating, that is the same length of the input,
and fill it with all zeros. We also create an empty array to store all of the possible completed mnemonics as we go.
We know that this is the array we will need to return, so we return that at the end.

3.Now we can create a recursive function call that will go through each index of the input phone number and recursively
keep calling until all possible combinations are created. We pass in zero as the first index to kick it off, because we
will always start with the first character of the phone number, and pass along the phone number itself with the
currentCombo and allMnemonics variables.
With recursion, we need a base case to prevent a stack overflow, so we add that first.

4.If we are not in this base case, we need to look through all potential characters that represent the current digit
and then recursively call the recursive helper function on those to generate the next digits. The next digit will be
the phone number at the index we are currently on. We can then find the array of letters representing the digit we are
working with.

5.After this, we can iterate through each letter in the lettersArray. For each of the letters in the array, we set the letter
of the currentCombo at the current index to the letter we find in the letter array. Then we are ready to recursively call the function,
but this time passing in i+1 to move on to the next index.

Time and Space Complexity
The time complexity for this algorithm is O(4^n * n). This is because at most, there are 4 letters associated with any
number,so at most, there will be 4 recursive calls per number. This is then multiplied by the length of the input array
(n) because of what happens when we hit the base case. We have to take the array holding each individual possible letter
and change it into a string for every possible combination, taking O(n) time. Worst case, we will hit the base case 4^n
times so we multiply by n.The space complexity is also O(4^n * n) because we have at most 4^n mnemonics each of which is of length n.
Time Complexity and Space Complexity - O(4^n * n)

 */
public class PhoneNumberPnemonics {

    public static void main (String[] args) {
        String phoneNumber = "1905";
        ArrayList<String> mnemonics = phoneNumberMnemonics(phoneNumber);
        for (String nmnmonic : mnemonics) {
            System.out.println(nmnmonic);
        }
    }
    public static Map<Character, String[]> DIGIT_LETTERS = new HashMap<>();

    static {
        DIGIT_LETTERS.put('0', new String[] {"0"});
        DIGIT_LETTERS.put('1', new String[] {"1"});
        DIGIT_LETTERS.put('2', new String[] {"a", "b", "c"});
        DIGIT_LETTERS.put('3', new String[] {"d", "e", "f"});
        DIGIT_LETTERS.put('4', new String[] {"g", "h", "i"});
        DIGIT_LETTERS.put('5', new String[] {"j", "k", "l"});
        DIGIT_LETTERS.put('6', new String[] {"m", "n", "o"});
        DIGIT_LETTERS.put('7', new String[] {"p", "q", "r", "s"});
        DIGIT_LETTERS.put('8', new String[] {"t", "u", "v"});
        DIGIT_LETTERS.put('9', new String[] {"w", "x", "y", "z"});
    }
    public static ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        String[] currentMnemonic = new String[phoneNumber.length()];
        Arrays.fill(currentMnemonic, "0");

        ArrayList<String> mnemonicsFound = new ArrayList<>();
        phoneNumberMnemonicsHelper(0, phoneNumber, currentMnemonic, mnemonicsFound);
        return mnemonicsFound;
    }
    public static void phoneNumberMnemonicsHelper(int idx, String phoneNumber, String[] currentMnemonic,
                                                  ArrayList<String> mnemonicsFound) {
        if (idx == phoneNumber.length()) {
            String mnemonic = String.join("", currentMnemonic);
            mnemonicsFound.add(mnemonic);
        } else {
            char digit = phoneNumber.charAt(idx);
            String[] letters = DIGIT_LETTERS.get(digit);
            for (String letter : letters) {
                currentMnemonic[idx] = letter;
                phoneNumberMnemonicsHelper(idx + 1, phoneNumber, currentMnemonic, mnemonicsFound);
            }
        }
    }
}
