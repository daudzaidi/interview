package CrackingTheCodingInterview.ArraysAndStrings.Question3;

import java.util.HashMap;

/**
 * Created by shalvi on 24/04/16.
 */
public class RemoveDuplicateFromString {

    public static String removeDuplicateChars(StringBuilder str){

        if(str == null) return null;

        if(str.length() <2) return null;

        int tail =1;

        for(int i =1;i<str.length();i++){
            int j;
            for(j=0;j<tail;j++){
                if(str.charAt(i) == str.charAt(j))
                    break;
            }

            if(j==tail){
                char a = str.charAt(tail);
                char b = str.charAt(i);
                str.setCharAt(tail,b);
                str.setCharAt(i,a);
                tail++;
            }
        }
        //str.setCharAt(tail,'\0');
        //str.setLength(tail);
        str.delete(tail,str.length());
        System.out.println(str.toString());
    return str.toString();
    }


    public static String removeDuplicatesUsingHashMap(StringBuilder str){

        if(str == null) return null;

        if(str.length() <2) return null;

        int tail =0 ;

        HashMap<Character,Integer> map = new HashMap<>();
        for(int i =0;i<str.length();i++){
            if(!(map.containsKey(str.charAt(i)))){
                map.put(str.charAt(i),1);

                if(i == str.length() -1){
                    char a = str.charAt(tail);
                    char b = str.charAt(i);
                    str.setCharAt(tail,b);
                    str.setCharAt(i,a);
                }
                tail++;
            }
            else{
                if(i == tail){
                    i++;
                    while(map.containsKey(str.charAt(i))){
                        i++;
                    }
                    map.put(str.charAt(i),1);
                    char a = str.charAt(tail);
                    char b = str.charAt(i);
                    str.setCharAt(tail,b);
                    str.setCharAt(i,a);
                    tail++;
                }
            }
        }
        str.delete(tail,str.length());
        return str.toString();
    }


    public static void main(String[] args){
        StringBuilder string = new StringBuilder();
        string.append('a');
        string.append('b');
        string.append('a');
        string.append('c');
        string.append('c');
        string.append('a');
        string.append('d');
        string.append('a');
        String res = RemoveDuplicateFromString.removeDuplicatesUsingHashMap(string);
        System.out.println("String : "+res+" Length: "+res.length());

        StringBuilder string2 = new StringBuilder();
        string2.append('a');
        string2.append('a');
        string2.append('a');
        string2.append('b');
        string2.append('b');
        string2.append('b');
        res = RemoveDuplicateFromString.removeDuplicatesUsingHashMap(string2);
        System.out.println("String : "+res+" Length: "+res.length());

        string2 = new StringBuilder();
        string2.append('a');
        string2.append('b');
        res = RemoveDuplicateFromString.removeDuplicatesUsingHashMap(string2);
        System.out.println("String : "+res+" Length: "+res.length());
    }
}
