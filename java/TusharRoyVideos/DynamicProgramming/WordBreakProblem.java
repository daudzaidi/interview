package TusharRoyVideos.DynamicProgramming;

import java.util.HashMap;

/**
 * Created by shalvi on 10/10/16.
 * Given an input string and a dictionary of words, find out if the input string can be segmented into a space-separated sequence of dictionary words. See following examples for more details.
 This is a famous Google interview question, also being asked by many other companies now a days.

 Consider the following dictionary
 { i, like, sam, sung, samsung, mobile, ice,
 cream, icecream, man, go, mango}

 Input:  ilike
 Output: Yes
 The string can be segmented as "i like".

 Input:  ilikesamsung
 Output: Yes
 The string can be segmented as "i like samsung" or "i like sam sung".
 */


public class WordBreakProblem {

    public static boolean dictionaryContains(String word) {
        String dictionary[] = {"mobile","samsung","sam","sung","man","mango",
                "icecream","and","go","i","like","ice","cream"};
        int size = dictionary.length;
        for (int i = 0; i < size; i++) {
            if (dictionary[i].equals(word))
                return true;
        }
        return false;
    }

    //recursive way
    public static boolean wordBreak (String str){
        if(str == null)
            return false;
        int len = str.length();
        if(len == 0)
            return true;

        for(int i = 1 ; i<= len ; i++){
            String prefix = str.substring(0,i);
            boolean dic = dictionaryContains(prefix);
            String substr = str.substring(i,len);

            if( dic && wordBreak(substr))
                return true;
        }

        return false;

    }

    //DP Solution
    static HashMap<String,Boolean> map = new HashMap<>();
    public static boolean wordBreakDP (String str){
        if(str == null)
            return false;
        int len = str.length();
        if(len == 0 )
            return true;

        for(int i = 1 ; i<= len ; i++){
            String prefix = str.substring(0,i);
            boolean dic = dictionaryContains(prefix);
            String substr = str.substring(i,len);
            boolean isSubStr = false;
            if (map.containsKey(substr)){
                isSubStr = map.get(substr);
            }
            if( dic && (isSubStr || wordBreak(substr)))
                return true;
        }

        return false;
    }

    public static void main(String... args){
        System.out.println(System.currentTimeMillis());
        System.out.println(wordBreak("ilikesamsung"));
        System.out.println(wordBreak("iiiiiiii"));
        System.out.println(wordBreak(""));
        System.out.println(wordBreak("ilikelikeimangoiii"));
        System.out.println(wordBreak("samsungandmango"));
        System.out.println(wordBreak("samsungandmangok"));
        System.out.println(wordBreak("ilikesamsung"));
        System.out.println(wordBreak("iiiiiiii"));
        System.out.println(wordBreak(""));
        System.out.println(wordBreak("ilikelikeimangoiii"));
        System.out.println(wordBreak("samsungandmango"));
        System.out.println(wordBreak("samsungandmangok"));

        System.out.println(System.currentTimeMillis());

        System.out.println(System.currentTimeMillis());

        System.out.println("DP SOLUTION");
        System.out.println(wordBreak("ilikesamsung"));
        System.out.println(wordBreak("iiiiiiii"));
        System.out.println(wordBreak(""));
        System.out.println(wordBreak("ilikelikeimangoiii"));
        System.out.println(wordBreak("samsungandmango"));
        System.out.println(wordBreak("samsungandmangok"));
        System.out.println(wordBreak("ilikesamsung"));
        System.out.println(wordBreak("iiiiiiii"));
        System.out.println(wordBreak(""));
        System.out.println(wordBreak("ilikelikeimangoiii"));
        System.out.println(wordBreak("samsungandmango"));
        System.out.println(wordBreak("samsungandmangok"));

        System.out.println(System.currentTimeMillis());
    }
}
