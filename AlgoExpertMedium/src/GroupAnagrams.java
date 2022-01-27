import java.util.*;

/*
Given a sequence of words, print all anagrams together.
Given an array of words, print all anagrams together.
For example, if the given array is {“cat”, “dog”, “tac”, “god”, “act”},
then output may be “cat tac act dog god”.

Using hashmap
Here, we first sort each word, use sorted word as key and then put original word in a map.
The value of the map will be a list containing all the words which have same word after sorting.
Time O(w * n * log(n)) Space O(wn) where w is the number of words and n is the length of longest word.
 */
public class GroupAnagrams {
    public static void main(String args[]) {
        List<String> words = new ArrayList<>();
        words.add("cat");words.add("dog");words.add("tac");words.add("god");words.add("act");
        List<List<String>> groupAnagrams = groupAnagrams(words);
        for (List<String> anagrams : groupAnagrams) {
            System.out.println("First List size" +anagrams.size() + anagrams.get(0) + anagrams.get(1));
            for (String word : anagrams) {
                System.out.println(" Each word is : "+word);
            }
        }
    }
    public static List<List<String>> groupAnagrams(List<String> words) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String word : words) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);
            if (anagrams.containsKey(sortedWord)) {
                anagrams.get(sortedWord).add(word);
            } else {
                anagrams.put(sortedWord, new ArrayList<>(Arrays.asList(word)));
            }
        }
        return new ArrayList<>(anagrams.values());
    }
}
