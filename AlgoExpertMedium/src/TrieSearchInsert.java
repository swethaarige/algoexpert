/*

Trie is an efficient information reTrieval data structure.
Using Trie, search complexities can be brought to optimal limit (key length).
If we store keys in binary search tree, a well balanced BST will need time proportional to M * log N,
where M is maximum string length and N is number of keys in tree. Using Trie, we can search the key in O(M) time.
However the penalty is on Trie storage requirements
Tries is a tree that stores strings. The maximum number of children of a node is equal to the size of the alphabet.
Trie supports search, insert and delete operations in O(L) time where L is the length of the key.
Why Trie? :-

With Trie, we can insert and find strings in O(L) time where L represent the length of a single word.
This is obviously faster than BST. This is also faster than Hashing because of the ways it is implemented.
We do not need to compute any hash function. No collision handling is required (like we do in open addressing and separate chaining)
Another advantage of Trie is, we can easily print all words in alphabetical order which is not easily possible with hashing.
We can efficiently do prefix search (or auto-complete) with Trie.
 tries data structure is that they are faster but require huge memory for storing the strings.
 */

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
