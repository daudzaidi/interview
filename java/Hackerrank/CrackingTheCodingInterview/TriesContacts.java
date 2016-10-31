package Hackerrank.CrackingTheCodingInterview;

import Trie.TrieNode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by shalvi on 29/09/16.
 */
public class TriesContacts {
    public  class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    private final TrieNode root;
    TriesContacts(){
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

    public int search (String word){
        TrieNode current = root;
        for(int i = 0 ; i < word.length();i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null){
                return 0;
            }
            current = node;
        }
        if(current.endOfWord == true && current.children.size() == 0)
            return 1;
        else{
            return getCountRecursive(current);
        }
    }

    public static int getCountRecursive(TrieNode node){
        int sum = 0;
        if (node.endOfWord == true)
            sum = sum + 1;

        Iterator it = node.children.entrySet().iterator();

        while(it.hasNext()){
            Map.Entry entry = (Map.Entry)it.next();
            TrieNode n = (TrieNode)entry.getValue();
            sum = sum + getCountRecursive(n);
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        TriesContacts solution = new TriesContacts();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if(op.equals("add")){
                solution.insert(contact);
            }
            if(op.equals("find")){
                System.out.println(solution.search(contact));
            }
        }
    }

}