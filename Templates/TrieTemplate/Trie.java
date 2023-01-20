package TrieTemplate;

public class Trie {
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
    static TrieNode root;
    Trie() {
        root = new TrieNode();
    }

    public void insert(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode current = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (current.children[index] == null)
                current.children[index] = new TrieNode();
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public boolean search(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode current = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';

            if (current.children[index] == null)
                return false;

            current = current.children[index];
        }

        return (current != null && current.isEndOfWord);
    }
}