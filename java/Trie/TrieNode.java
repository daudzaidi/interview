package Trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shalvi on 28/08/16.
 */
public class TrieNode {
    Map<Character,TrieNode> children;
    boolean endOfWord;

    public TrieNode(){
        children = new HashMap<>();
        endOfWord = false;
    }
}
