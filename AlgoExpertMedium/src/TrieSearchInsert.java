import java.util.Scanner;

public class TrieSearchInsert {
    private static TrieNode root;

    public static void main (String[] args) {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

        String output[] = {"Not present in trie", "Present in trie"};

       root = new TrieNode();

        // Construct trie
        int i;
        for (i = 0; i < keys.length ; i++)
            insert(keys[i]);

        // Search for different keys
        if(search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        if(search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);

        if(search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);

        if(search("thaw") == true)
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);

    }
    
    static final int ALPHABET_SIZE = 26;
    //trie Node

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        //isEndOfWord is True if node represents end of the word
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                children[i] = null;
            }
        }
    }

    //function to insert String into JAVA
    static void insert(String key) {

        TrieNode curr = root;
        int n = key.length();
        for (int i = 0; i < n; i++) {
            if (curr.children[key.charAt(i) - 'a'] == null) {
                curr.children[key.charAt(i) - 'a'] = new TrieNode();
            }
            curr = curr.children[key.charAt(i) - 'a'];
        }
        curr.isEndOfWord = true;
    }

    //function to use TRIE data structure and search the given string

    static boolean search(String key) {
        TrieNode curr = root;
        for (int i = 0; i < key.length(); i++) {
            if (curr.children[key.charAt(i) - 'a'] == null)
                return false;
            curr = curr.children[key.charAt(i) - 'a'];
        }
        if (curr.isEndOfWord)
            return true;
        return false;
    }
}
