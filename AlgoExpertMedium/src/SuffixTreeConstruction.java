/*
Suffix tree is a compressed trie of all the suffixes of a given string. Suffix trees help in
solving a lot of string related problems like pattern matching, finding distinct substrings
in a given string, finding longest palindrome etc.
How to build a Suffix Tree for a given text?
As discussed above, Suffix Tree is compressed trie of all suffixes, so following are very
abstract steps to build a suffix tree from given text.
1) Generate all suffixes of given text.
2) Consider all suffixes as individual words and build a compressed trie.

Let us consider an example text “banana\0” where ‘\0’ is string termination character.
Following are all suffixes of “banana\0”

banana\0
anana\0
nana\0
ana\0
na\0
a\0
\0
 */

import java.util.HashMap;
import java.util.Map;

public class SuffixTreeConstruction {
   static class TrieNode {
       Map<Character, TrieNode> children = new HashMap<>();
   }
   static class SuffixTrie {
       static TrieNode root = new TrieNode();
       static char endSymbol = '*';

       public SuffixTrie(String str) {
           populateSuffixTrieFrom(str);
       }
       public void populateSuffixTrieFrom(String str) {
          for (int i = 0; i < str.length(); i++) {
              insertSubStringStartingAt(i, str);
          }
       }
       public static void insertSubStringStartingAt(int i, String str) {
           TrieNode node = root;
           for (int j = i; j < str.length(); j++) {
               char letter = str.charAt(j);
               if (!node.children.containsKey(letter)) {
                   TrieNode newNode = new TrieNode();
                   node.children.put(letter,newNode);
               }
               node.children.put(endSymbol, null);
           }

       }
       public boolean contains(String str) {
          TrieNode node = root;
          for (int i = 0; i < str.length(); i++) {
              char letter = str.charAt(i);
              if (!node.children.containsKey(letter)) {
                  return false;
              }
              node = node.children.get(letter);
          }
           return node.children.containsKey(endSymbol);
       }
   }
}
