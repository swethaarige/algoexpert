import java.util.ArrayList;

/*
Program to generate all possible valid IP addresses from given string.
Given a string containing only digits, restore it by returning all possible valid IP address combinations.
A valid IP address must be in the form of A.B.C.D, where A, B, C, and D are numbers from 0-255.
The numbers cannot be 0 prefixed unless they are 0.
Examples :
Input: 25525511135
Output: [“255.255.11.135”, “255.255.111.35”]
 */
public class ValidIPAddresses {
    public static void main(String[] args) {
        String input = "25525511135";
        ArrayList<String> resultOfIPAddress = new ArrayList<>();
        resultOfIPAddress = validIPAddresses(input);
        for (int i = 0; i < resultOfIPAddress.size(); i++) {
            System.out.println("IPAddress  " +resultOfIPAddress.get(i));
        }

    }
    public static ArrayList<String> validIPAddresses(String string) {
        ArrayList<String> addressesFound = new ArrayList<>();
        for (int i = 1; i < Math.min((int) string.length(), 4); i++) {
            String[] currentIPAddressParts = new String[] {"", "", "", ""};
            currentIPAddressParts[0] = string.substring(0, i);
            if (!isValidIPPart(currentIPAddressParts[0])) {
                continue;
            }
            for (int j = i + 1; j < i + Math.min((int) string.length() - i, 4); j++) {
                currentIPAddressParts[1] = string.substring(i, j);
                if (!isValidIPPart(currentIPAddressParts[1])) {
                    continue;
                }
                for (int k = j + 1; k < j + Math.min((int) string.length() - j, 4); k++) {
                    currentIPAddressParts[2] = string.substring(j, k);
                    currentIPAddressParts[3] = string.substring(k);
                    if (isValidIPPart(currentIPAddressParts[2]) && isValidIPPart(currentIPAddressParts[3])) {
                        addressesFound.add(join(currentIPAddressParts));
                    }
                }
            }
        }
        return addressesFound;
    }

    public static  boolean isValidIPPart(String string) {
      int stringToInt = Integer.parseInt(string);
      if (stringToInt > 255) {
          return false;
      }
      return string.length() == Integer.toString(stringToInt).length();
    }

    public static String join(String[] strings) {
       StringBuilder sb = new StringBuilder();
       for (int i = 0; i < strings.length; i++) {
           sb.append(strings[i]);
           if (i < strings.length - 1) {
               sb.append(".");
           }
       }
       return sb.toString();

    }

}
