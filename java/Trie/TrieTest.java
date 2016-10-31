package Trie;

/**
 * Created by shalvi on 29/08/16.
 */
public class TrieTest {
    public static void main(String... args){
        Trie trie = new Trie();

        trie.insert("abcd");
        trie.insert("abgl");
        trie.insertRecursive("lmn");
        trie.insertRecursive("lmnpq");
        trie.insert("cdeg");
        trie.insert("ghijk");

        System.out.println(trie.search("ab"));
        System.out.println(trie.search("abc"));
        System.out.println(trie.search("abcd"));
        System.out.println(trie.search("abg"));
        System.out.println(trie.search("abgl"));
        System.out.println(trie.search("lm"));
        System.out.println(trie.search("lmn"));
        System.out.println(trie.search("lmnp"));
        System.out.println(trie.search("lmnpq"));

        trie.delete("abcd");
        System.out.println(trie.search("abgl"));
        System.out.println(trie.search("abcd"));

        trie.delete("lmn");
        System.out.println(trie.search("lmn"));
        System.out.println(trie.search("lmnpq"));

        trie.delete("lmnpq");
        System.out.println(trie.search("lmnpq"));


    }
}
