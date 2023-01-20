package TrieTemplate;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.*;
public class test {
     // For Testing Purposes ================================================
    private String replaceWords(List<String> dictionary, String sentence) {
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

    @Test
    public void Trie() {
        List<String> dictionary = List.of(new String[]{"cat", "bat", "rat"});
        String sentence = "the cattle was rattled by the battery";
        assertEquals("the cat was rat by the bat", replaceWords(dictionary, sentence));
    }
}