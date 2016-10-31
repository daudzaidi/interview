package Trie;

/**
 * Created by shalvi on 29/08/16.
 */
public class Trie {
    private final TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode current = root;
        for(int i = 0 ;i<word.length();i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null){
                node = new TrieNode();
                current.children.put(ch,node);
            }
            current = node;
        }
        current.endOfWord = true;
    }

    public void insertRecursive(String word){
        insertRecursive(root,word,0);
    }

    private void insertRecursive(TrieNode current, String word, int index){
        if(index == word.length()){
            current.endOfWord = true;
            return;
        }

        char ch = word.charAt(index);
        TrieNode node = current.children.get(index);

        if(node == null){
            node = new TrieNode();
            current.children.put(ch,node);
        }

        insertRecursive(node,word,index+1);
    }

    public boolean search (String word){
        TrieNode current = root;
        for(int i = 0 ; i < word.length();i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null){
                return false;
            }

            current = node;
        }
        return current.endOfWord;
    }

    public boolean searchRecursive(String word){
        return searchRecursive(root,word,0);
    }

    public boolean searchRecursive(TrieNode current, String word, int index){
        if (index == word.length()) {
            //return true of current's endOfWord is true else return false.
            return current.endOfWord;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        //if node does not exist for given char then return false
        if (node == null) {
            return false;
        }
        return searchRecursive(node, word, index + 1);
    }

    public void delete(String word){
        delete(root,word,0);
    }

    private boolean delete(TrieNode current, String word, int index) {
        if(index == word.length()){
            if(!current.endOfWord){
                return false;
            }

            current.endOfWord = false;
            return current.children.size() == 0;
        }

        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if(node == null)
            return false;

        boolean shouldDeleteCurrentNode = delete(node,word,index+1);

        if(shouldDeleteCurrentNode){
            current.children.remove(ch);
            return current.children.size() == 0;
        }
        return false;
    }
}
