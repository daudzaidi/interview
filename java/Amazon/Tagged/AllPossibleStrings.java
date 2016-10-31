package Amazon.Tagged;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shyamsunderpandita on 24/10/16.
 */
public class AllPossibleStrings {

    public static List<String> result = new ArrayList<>();

    public static String addSpace(String str1, String str2){
        return str1+" "+str2;
    }

    public static void group(int i, int j , String str){

        String str1 = str.substring(0,i);
        String str2 = str.substring(i,i+j);
        result.add(addSpace(str1,str2));
    }

    public static void printAllCombinations(String str){
        if(str == null || str.length() == 0)
            return;


        int size = str.length();
        for(int i = 1 ; i<=size ; i++){
             group(i,size-i,str);
        }

        for(String elem : result)
            System.out.println(elem);
    }

    public static void main(String... args){
//        printAllCombinations("abcd");
        StringBuffer s = new StringBuffer("ABCD");
        System.out.println(s);
        func(s,1,s.length());
    }

    static void func(StringBuffer s,int b,int e){
        for(int i=b;i<e;i++){
            s.insert(i," ");
            System.out.println(s);
            func(s,i+2,s.length());
            s.delete(i,i+1);
        }
    }
}
