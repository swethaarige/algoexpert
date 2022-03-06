import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Check for Balanced Brackets in an expression
Given an expression string exp, write a program to examine whether the pairs and the orders of “{“, “}”, “(“, “)”, “[“, “]” are correct in exp.
Example:
Input: exp = “[()]{}{[()()]()}”
Output: Balanced
Input: exp = “[(])”
Output: Not Balanced
Algorithm:
1. Declare a character stack S.
 2, Now traverse the expression string exp.
3. If the current character is a starting bracket (‘(‘ or ‘{‘ or ‘[‘) then push it to stack.
If the current character is a closing bracket (‘)’ or ‘}’ or ‘]’) then pop from stack and if
the popped character is the matching starting bracket then fine else brackets are not balanced.
After complete traversal, if there is some starting bracket left in stack then “not balanced”
O(n) Time and O(n) Space
 */
public class BalancedBrackets {
    public static void main (String [] args) {
        String input = "[()]{}{[()()]()}";
        System.out.println("Balanced Brackets in the given string is " +balancedBrackets(input));
    }
    public static boolean balancedBrackets(String str) {
        String openingBrackets = "([{";
        String closingBrackets = ")]}";
        Map<Character, Character> matchingBrackets = new HashMap<>();
        matchingBrackets.put(')', '(');
        matchingBrackets.put(']', '[');
        matchingBrackets.put('}', '{');
        List<Character> stack = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            if (openingBrackets.indexOf(letter) != -1) {
                stack.add(letter);
            } else if (closingBrackets.indexOf(letter) != -1) {
                if (stack.size() == 0) {
                    return false;
                }
                if (stack.get(stack.size() - 1) == matchingBrackets.get(letter)) {
                    stack.remove(stack.size() - 1);
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
