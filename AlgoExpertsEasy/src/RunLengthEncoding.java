/*
Given an input string, write a function that returns the Run Length Encoded string for the input string.
Run-length encoding (RLE) is a form of lossless data compression in which runs of data (sequences in which
the same data value occurs in many consecutive data elements) are stored as a single data value and count,
rather than as the original run
For example, if the input string is “wwwwaaadexxxxxx”, then the function should return “4w3a1d1e6x”
ComplicatedCases like if input string is "AAAAAAAAAAAA", then the function cant naively encode and
should not return "12A" instead it should return "9A3A" as output.(10 or more runs should be in split fashion)
 */

public class RunLengthEncoding {
    public static void main (String[] args) {
        String inputString = "wwwwaaadexxxxxx";
        System.out.println("Encoded String is  :" +runLengthEncoding(inputString) );
    }

    public static String runLengthEncoding(String string) {
        StringBuilder encodedString = new StringBuilder();
        int currentRunLength = 1;
        for (int i = 1; i < string.length(); i++) {
            char currentCharacter = string.charAt(i);
            char previousCharacter = string.charAt(i - 1);
            if (currentCharacter != previousCharacter || currentRunLength == 9) {
                encodedString.append(Integer.valueOf(currentRunLength));
                encodedString.append(previousCharacter);
                currentRunLength = 0;
            }
            currentRunLength += 1;
        }
        encodedString.append(Integer.valueOf(currentRunLength));
        encodedString.append(string.charAt(string.length() - 1));
        return encodedString.toString();
    }

}
