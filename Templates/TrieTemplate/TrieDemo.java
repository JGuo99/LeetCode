package TrieTemplate;

import TrieTemplate.Trie;

import java.util.*;
class TrieDemo {
    // For Testing Purposes ================================================
    public static String replaceWords(List<String> dictionary, String sentence) {
        Trie words = new Trie();
        for (String dic : dictionary)
            words.insert(dic);

        StringBuilder result = new StringBuilder();
        String[] sentArray = sentence.split("\\s+");

        StringBuilder tmp = new StringBuilder();
        for (String sent : sentArray) {
            boolean flag = true;
            for (char c : sent.toCharArray()) {
                tmp.append(c);
                if (words.search(tmp.toString())) {
                    result.append(tmp + " ");
                    flag = false;
                    tmp = new StringBuilder();
                    break;
                }
            }
            if (flag) {
                result.append(sent + " ");
                tmp = new StringBuilder();
            }
        }
        return result.deleteCharAt(result.length()-1).toString();
    }

    public static void main(String[] args) {
        List<String> list = List.of(new String[]{"cat", "bat", "rat"});
        String sent = "the cattle was rattled by the battery";
        // "the cat was rat by the bat"
        System.out.println(replaceWords(list, sent));
    }
}