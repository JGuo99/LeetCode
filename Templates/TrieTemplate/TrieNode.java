package TrieTemplate;

public class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
        for (int i = 0; i < 26; i++)
            children[i] = null;
    }
}